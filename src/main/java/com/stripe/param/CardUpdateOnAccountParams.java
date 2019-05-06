// Generated by com.stripe.generator.entity.SdkBuilder

package com.stripe.param;

import com.google.gson.annotations.SerializedName;
import com.stripe.net.ApiRequestParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardUpdateOnAccountParams extends ApiRequestParams {
  /** City/District/Suburb/Town/Village. */
  @SerializedName("address_city")
  String addressCity;

  /** Billing address country, if provided when creating card. */
  @SerializedName("address_country")
  String addressCountry;

  /** Address line 1 (Street address/PO Box/Company name). */
  @SerializedName("address_line1")
  String addressLine1;

  /** Address line 2 (Apartment/Suite/Unit/Building). */
  @SerializedName("address_line2")
  String addressLine2;

  /** State/County/Province/Region. */
  @SerializedName("address_state")
  String addressState;

  /** ZIP or postal code. */
  @SerializedName("address_zip")
  String addressZip;

  /** When set to true, this becomes the default external account for its currency. */
  @SerializedName("default_for_currency")
  Boolean defaultForCurrency;

  /** Two digit number representing the card’s expiration month. */
  @SerializedName("exp_month")
  String expMonth;

  /** Four digit number representing the card’s expiration year. */
  @SerializedName("exp_year")
  String expYear;

  /** Specifies which fields in the response should be expanded. */
  @SerializedName("expand")
  List<String> expand;

  /**
   * Map of extra parameters for custom features not available in this client library. The content
   * in this map is not serialized under this field's {@code @SerializedName} value. Instead, each
   * key/value pair is serialized as if the key is a root-level field (serialized) name in this
   * param object. Effectively, this map is flattened to its parent instance.
   */
  @SerializedName(ApiRequestParams.EXTRA_PARAMS_KEY)
  Map<String, Object> extraParams;

  @SerializedName("metadata")
  Map<String, String> metadata;

  /** Cardholder name. */
  @SerializedName("name")
  String name;

  private CardUpdateOnAccountParams(
      String addressCity,
      String addressCountry,
      String addressLine1,
      String addressLine2,
      String addressState,
      String addressZip,
      Boolean defaultForCurrency,
      String expMonth,
      String expYear,
      List<String> expand,
      Map<String, Object> extraParams,
      Map<String, String> metadata,
      String name) {
    this.addressCity = addressCity;
    this.addressCountry = addressCountry;
    this.addressLine1 = addressLine1;
    this.addressLine2 = addressLine2;
    this.addressState = addressState;
    this.addressZip = addressZip;
    this.defaultForCurrency = defaultForCurrency;
    this.expMonth = expMonth;
    this.expYear = expYear;
    this.expand = expand;
    this.extraParams = extraParams;
    this.metadata = metadata;
    this.name = name;
  }

  public static Builder builder() {
    return new com.stripe.param.CardUpdateOnAccountParams.Builder();
  }

  public static class Builder {
    private String addressCity;

    private String addressCountry;

    private String addressLine1;

    private String addressLine2;

    private String addressState;

    private String addressZip;

    private Boolean defaultForCurrency;

    private String expMonth;

    private String expYear;

    private List<String> expand;

    private Map<String, Object> extraParams;

    private Map<String, String> metadata;

    private String name;

    /** Finalize and obtain parameter instance from this builder. */
    public CardUpdateOnAccountParams build() {
      return new CardUpdateOnAccountParams(
          this.addressCity,
          this.addressCountry,
          this.addressLine1,
          this.addressLine2,
          this.addressState,
          this.addressZip,
          this.defaultForCurrency,
          this.expMonth,
          this.expYear,
          this.expand,
          this.extraParams,
          this.metadata,
          this.name);
    }

    /** City/District/Suburb/Town/Village. */
    public Builder setAddressCity(String addressCity) {
      this.addressCity = addressCity;
      return this;
    }

    /** Billing address country, if provided when creating card. */
    public Builder setAddressCountry(String addressCountry) {
      this.addressCountry = addressCountry;
      return this;
    }

    /** Address line 1 (Street address/PO Box/Company name). */
    public Builder setAddressLine1(String addressLine1) {
      this.addressLine1 = addressLine1;
      return this;
    }

    /** Address line 2 (Apartment/Suite/Unit/Building). */
    public Builder setAddressLine2(String addressLine2) {
      this.addressLine2 = addressLine2;
      return this;
    }

    /** State/County/Province/Region. */
    public Builder setAddressState(String addressState) {
      this.addressState = addressState;
      return this;
    }

    /** ZIP or postal code. */
    public Builder setAddressZip(String addressZip) {
      this.addressZip = addressZip;
      return this;
    }

    /** When set to true, this becomes the default external account for its currency. */
    public Builder setDefaultForCurrency(Boolean defaultForCurrency) {
      this.defaultForCurrency = defaultForCurrency;
      return this;
    }

    /** Two digit number representing the card’s expiration month. */
    public Builder setExpMonth(String expMonth) {
      this.expMonth = expMonth;
      return this;
    }

    /** Four digit number representing the card’s expiration year. */
    public Builder setExpYear(String expYear) {
      this.expYear = expYear;
      return this;
    }

    /**
     * Add an element to `expand` list. A list is initialized for the first `add/addAll` call, and
     * subsequent calls adds additional elements to the original list. See {@link
     * CardUpdateOnAccountParams#expand} for the field documentation.
     */
    public Builder addExpand(String element) {
      if (this.expand == null) {
        this.expand = new ArrayList<>();
      }
      this.expand.add(element);
      return this;
    }

    /**
     * Add all elements to `expand` list. A list is initialized for the first `add/addAll` call, and
     * subsequent calls adds additional elements to the original list. See {@link
     * CardUpdateOnAccountParams#expand} for the field documentation.
     */
    public Builder addAllExpand(List<String> elements) {
      if (this.expand == null) {
        this.expand = new ArrayList<>();
      }
      this.expand.addAll(elements);
      return this;
    }

    /**
     * Add a key/value pair to `extraParams` map. A map is initialized for the first `put/putAll`
     * call, and subsequent calls add additional key/value pairs to the original map. See {@link
     * CardUpdateOnAccountParams#extraParams} for the field documentation.
     */
    public Builder putExtraParam(String key, Object value) {
      if (this.extraParams == null) {
        this.extraParams = new HashMap<>();
      }
      this.extraParams.put(key, value);
      return this;
    }

    /**
     * Add all map key/value pairs to `extraParams` map. A map is initialized for the first
     * `put/putAll` call, and subsequent calls add additional key/value pairs to the original map.
     * See {@link CardUpdateOnAccountParams#extraParams} for the field documentation.
     */
    public Builder putAllExtraParam(Map<String, Object> map) {
      if (this.extraParams == null) {
        this.extraParams = new HashMap<>();
      }
      this.extraParams.putAll(map);
      return this;
    }

    /**
     * Add a key/value pair to `metadata` map. A map is initialized for the first `put/putAll` call,
     * and subsequent calls add additional key/value pairs to the original map. See {@link
     * CardUpdateOnAccountParams#metadata} for the field documentation.
     */
    public Builder putMetadata(String key, String value) {
      if (this.metadata == null) {
        this.metadata = new HashMap<>();
      }
      this.metadata.put(key, value);
      return this;
    }

    /**
     * Add all map key/value pairs to `metadata` map. A map is initialized for the first
     * `put/putAll` call, and subsequent calls add additional key/value pairs to the original map.
     * See {@link CardUpdateOnAccountParams#metadata} for the field documentation.
     */
    public Builder putAllMetadata(Map<String, String> map) {
      if (this.metadata == null) {
        this.metadata = new HashMap<>();
      }
      this.metadata.putAll(map);
      return this;
    }

    /** Cardholder name. */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }
  }
}
