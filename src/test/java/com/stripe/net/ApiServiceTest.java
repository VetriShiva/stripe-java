package com.stripe.net;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.stripe.Stripe;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.StripeException;
import com.stripe.model.HasId;
import com.stripe.model.StripeCollection;

import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

class ApiServiceTest {
  private static final String FOO_ID = "foo_123";
  private static final String BAR_ID = "bar_123";

  private static class Foo extends ApiResource implements HasId {
    @Override
    public String getId() {
      return FOO_ID;
    }
  }

  private static class FooCollection extends StripeCollection<Foo> {
  }

  private static class FooParams extends ApiRequestParams {
  }

  private static class FooOnBarParams extends ApiRequestParams {
  }

  private static class FooService extends ApiService {
    String createUrl = "/v1/foos";
    String customOperationUrl = "/v1/foos/%s/custom_operation";
    String deleteUrl = "/v1/foos/%s";
    String listUrl = "/v1/foos";
    String retrieveUrl = "/v1/foos/%s";
    String updateUrl = "/v1/foos/%s";
    String updateOnBarUrl = "/v1/bars/%s/foos/%s";

    public Foo create(FooParams params, RequestOptions options)
        throws StripeException {
      String url = resourceUrl(this.createUrl);
      return request(ApiResource.RequestMethod.POST, url, params, Foo.class, options);
    }

    public Foo customOperation(String foo, FooParams params, RequestOptions options)
        throws StripeException {
      String url = resourceUrl(this.customOperationUrl, foo);
      return request(ApiResource.RequestMethod.POST, url, params, Foo.class, options);
    }

    public Foo delete(String foo, FooParams params, RequestOptions options)
        throws StripeException {
      String url = resourceUrl(this.deleteUrl, foo);
      return request(ApiResource.RequestMethod.DELETE, url, params, Foo.class, options);
    }

    public FooCollection list(FooParams params, RequestOptions options)
        throws StripeException {
      String url = resourceUrl(this.listUrl);
      return requestCollection(url, params, FooCollection.class, options);
    }

    public Foo retrieve(String foo, FooParams params, RequestOptions options)
        throws StripeException {
      String url = resourceUrl(this.retrieveUrl, foo);
      return request(ApiResource.RequestMethod.GET, url, params, Foo.class, options);
    }

    public Foo update(String foo, FooParams params, RequestOptions options)
        throws StripeException {
      String url = resourceUrl(this.updateUrl, foo);
      return request(ApiResource.RequestMethod.POST, url, params, Foo.class, options);
    }

    public Foo update(String bar, String foo, FooOnBarParams params, RequestOptions options)
        throws StripeException {
      String url = resourceUrl(this.updateOnBarUrl, bar, foo);
      return request(ApiResource.RequestMethod.POST, url, params, Foo.class, options);
    }

    public Foo updateWithInvalidFormatting(String foo, FooParams params, RequestOptions options)
        throws StripeException {
      String url = resourceUrl("/v1/foos/%s/bars/%s", foo);
      return request(ApiResource.RequestMethod.POST, url, params, Foo.class, options);
    }
  }

  @AfterAll
  public static void restoreNetwork() {
    ApiResource.setStripeResponseGetter(new LiveStripeResponseGetter());
  }

  private LiveStripeResponseGetter networkMock;
  private FooService fooService;

  /**
   * This service test does not rely on stripe-mock, and intended verifications
   * are at the invocation of the {@code LiveStripeResponseGetter} not the deep-layer
   * of API request stacks. Therefore, it uses `mock` of the response getter instead of
   * spy which still does actual invocation in {@link com.stripe.BaseStripeTest}.
   */
  @BeforeEach
  public void setUpNetworkMock() {
    fooService = new FooService();
    networkMock = Mockito.mock(LiveStripeResponseGetter.class);
    ApiResource.setStripeResponseGetter(networkMock);
  }

  @Test
  public void testCreate() throws StripeException {
    fooService.create(new FooParams(), RequestOptions.getDefault());

    verifyRequest(ApiResource.RequestMethod.POST,
        "/v1/foos", Foo.class);
  }

  @Test
  public void testCustomOperation() throws StripeException {
    fooService.customOperation(FOO_ID, new FooParams(), RequestOptions.getDefault());

    verifyRequest(ApiResource.RequestMethod.POST,
        String.format("/v1/foos/%s/custom_operation", FOO_ID), Foo.class);
  }

  @Test
  public void testDelete() throws StripeException {
    fooService.delete(FOO_ID, new FooParams(), RequestOptions.getDefault());

    verifyRequest(ApiResource.RequestMethod.DELETE,
        String.format("/v1/foos/%s", FOO_ID),
        Foo.class
    );
  }

  @Test
  public void testDeleteWithNullParams() throws StripeException {
    fooService.delete(FOO_ID, null, RequestOptions.getDefault());

    verifyRequest(ApiResource.RequestMethod.DELETE,
        String.format("/v1/foos/%s", FOO_ID),
        Foo.class
    );
  }

  @Test
  public void testList() throws StripeException {
    fooService.list(new FooParams(), RequestOptions.getDefault());

    verifyRequest(ApiResource.RequestMethod.GET,
        "/v1/foos",
        FooCollection.class);
  }

  @Test
  public void testRetrieve() throws StripeException {
    fooService.retrieve(FOO_ID, new FooParams(), RequestOptions.getDefault());

    verifyRequest(ApiResource.RequestMethod.GET,
        String.format("/v1/foos/%s", FOO_ID),
        Foo.class
    );
  }

  @Test
  public void testUpdate() throws StripeException {
    fooService.update(FOO_ID, new FooParams(), RequestOptions.getDefault());

    verifyRequest(ApiResource.RequestMethod.POST,
        String.format("/v1/foos/%s", FOO_ID), Foo.class);
  }

  @Test
  public void testUpdateOnParent() throws StripeException {
    fooService.update(BAR_ID, FOO_ID, new FooOnBarParams(), RequestOptions.getDefault());

    verifyRequest(ApiResource.RequestMethod.POST,
        String.format("/v1/bars/%s/foos/%s", BAR_ID, FOO_ID),
        Foo.class);
  }

  @Test
  public void testUpdateThrowingUrlFormatting() {
    assertThrows(InvalidRequestException.class, () -> {
      fooService.updateWithInvalidFormatting(FOO_ID, new FooParams(), RequestOptions.getDefault());
    });
  }

  @Test
  public void testUpdateEnsureEncodedVariable() throws StripeException {
    fooService.update("Plan 100$/month",
        "Plan 200$/month",
        new FooOnBarParams(), RequestOptions.getDefault());

    verifyRequest(ApiResource.RequestMethod.POST,
        String.format("/v1/bars/%s/foos/%s",
            "Plan+100%24%2Fmonth",
            "Plan+200%24%2Fmonth"),
        Foo.class);
  }

  private void verifyRequest(ApiResource.RequestMethod method,
                             String path,
                             Class<?> clazz) throws StripeException {
    Mockito.verify(networkMock).request(
        Mockito.eq(method),
        Mockito.eq(String.format("%s%s", Stripe.getApiBase(), path)),
        Mockito.any(Map.class),
        Mockito.eq(clazz),
        Mockito.eq(ApiResource.RequestType.NORMAL),
        Mockito.any(RequestOptions.class)
    );
  }
}