// Generated by com.stripe.generator.entity.SdkBuilder

package com.stripe.model;

import com.google.gson.annotations.SerializedName;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.net.ApiResource;
import com.stripe.net.RequestOptions;
import com.stripe.param.SubscriptionCancelParams;
import com.stripe.param.SubscriptionCreateParams;
import com.stripe.param.SubscriptionListParams;
import com.stripe.param.SubscriptionRetrieveParams;
import com.stripe.param.SubscriptionUpdateParams;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Subscription extends ApiResource implements HasId, MetadataStore<Subscription> {
  /**
   * A non-negative decimal between 0 and 100, with at most two decimal places. This represents the
   * percentage of the subscription invoice subtotal that will be transferred to the application
   * owner's Stripe account.
   */
  @SerializedName("application_fee_percent")
  BigDecimal applicationFeePercent;

  /**
   * Either `charge_automatically`, or `send_invoice`. When charging automatically, Stripe will
   * attempt to pay this subscription at the end of the cycle using the default source attached to
   * the customer. When sending an invoice, Stripe will email your customer an invoice with payment
   * instructions.
   */
  @SerializedName("billing")
  String billing;

  /**
   * Determines the date of the first full invoice, and, for plans with `month` or `year` intervals,
   * the day of the month for subsequent invoices.
   */
  @SerializedName("billing_cycle_anchor")
  Long billingCycleAnchor;

  /**
   * Define thresholds at which an invoice will be sent, and the subscription advanced to a new
   * billing period.
   */
  @SerializedName("billing_thresholds")
  BillingThresholds billingThresholds;

  /** A date in the future at which the subscription will automatically get canceled. */
  @SerializedName("cancel_at")
  Long cancelAt;

  /**
   * If the subscription has been canceled with the `at_period_end` flag set to `true`,
   * `cancel_at_period_end` on the subscription will be true. You can use this attribute to
   * determine whether a subscription that has a status of active is scheduled to be canceled at the
   * end of the current period.
   */
  @SerializedName("cancel_at_period_end")
  Boolean cancelAtPeriodEnd;

  /**
   * If the subscription has been canceled, the date of that cancellation. If the subscription was
   * canceled with `cancel_at_period_end`, `canceled_at` will still reflect the date of the initial
   * cancellation request, not the end of the subscription period when the subscription is
   * automatically moved to a canceled state.
   */
  @SerializedName("canceled_at")
  Long canceledAt;

  /** Time at which the object was created. Measured in seconds since the Unix epoch. */
  @SerializedName("created")
  Long created;

  /**
   * End of the current period that the subscription has been invoiced for. At the end of this
   * period, a new invoice will be created.
   */
  @SerializedName("current_period_end")
  Long currentPeriodEnd;

  /** Start of the current period that the subscription has been invoiced for. */
  @SerializedName("current_period_start")
  Long currentPeriodStart;

  /** ID of the customer who owns the subscription. */
  @SerializedName("customer")
  @Getter(lombok.AccessLevel.NONE)
  @Setter(lombok.AccessLevel.NONE)
  ExpandableField<Customer> customer;

  /**
   * Number of days a customer has to pay invoices generated by this subscription. This value will
   * be `null` for subscriptions where `billing=charge_automatically`.
   */
  @SerializedName("days_until_due")
  Long daysUntilDue;

  /**
   * ID of the default payment method for the subscription. It must belong to the customer
   * associated with the subscription. If not set, invoices will use the default payment method in
   * the customer's invoice settings.
   */
  @SerializedName("default_payment_method")
  @Getter(lombok.AccessLevel.NONE)
  @Setter(lombok.AccessLevel.NONE)
  ExpandableField<PaymentMethod> defaultPaymentMethod;

  /**
   * ID of the default payment source for the subscription. It must belong to the customer
   * associated with the subscription and be in a chargeable state. If not set, defaults to the
   * customer's default source.
   */
  @SerializedName("default_source")
  @Getter(lombok.AccessLevel.NONE)
  @Setter(lombok.AccessLevel.NONE)
  ExpandableField<PaymentSource> defaultSource;

  /**
   * The tax rates that will apply to any subscription item that does not have `tax_rates` set.
   * Invoices created will have their `default_tax_rates` populated from the subscription.
   */
  @SerializedName("default_tax_rates")
  List<TaxRate> defaultTaxRates;

  /**
   * Describes the current discount applied to this subscription, if there is one. When billing, a
   * discount applied to a subscription overrides a discount applied on a customer-wide basis.
   */
  @SerializedName("discount")
  Discount discount;

  /** If the subscription has ended, the date the subscription ended. */
  @SerializedName("ended_at")
  Long endedAt;

  /** Unique identifier for the object. */
  @Getter(onMethod_ = {@Override})
  @SerializedName("id")
  String id;

  /** List of subscription items, each with an attached plan. */
  @SerializedName("items")
  SubscriptionItemCollection items;

  /** The most recent invoice this subscription has generated. */
  @SerializedName("latest_invoice")
  @Getter(lombok.AccessLevel.NONE)
  @Setter(lombok.AccessLevel.NONE)
  ExpandableField<Invoice> latestInvoice;

  /**
   * Has the value `true` if the object exists in live mode or the value `false` if the object
   * exists in test mode.
   */
  @SerializedName("livemode")
  Boolean livemode;

  /**
   * Set of key-value pairs that you can attach to an object. This can be useful for storing
   * additional information about the object in a structured format.
   */
  @Getter(onMethod_ = {@Override})
  @SerializedName("metadata")
  Map<String, String> metadata;

  /** String representing the object's type. Objects of the same type share the same value. */
  @SerializedName("object")
  String object;

  /**
   * Hash describing the plan the customer is subscribed to. Only set if the subscription contains a
   * single plan.
   */
  @SerializedName("plan")
  Plan plan;

  /**
   * The quantity of the plan to which the customer is subscribed. For example, if your plan is
   * $10/user/month, and your customer has 5 users, you could pass 5 as the quantity to have the
   * customer charged $50 (5 x $10) monthly. Only set if the subscription contains a single plan.
   */
  @SerializedName("quantity")
  Long quantity;

  /**
   * Date of the last substantial change to this subscription. For example, a change to the items
   * array, or a change of status, will reset this timestamp.
   */
  @SerializedName("start")
  Long start;

  /**
   * Possible values are `incomplete`, `incomplete_expired`, `trialing`, `active`, `past_due`,
   * `canceled`, or `unpaid`.
   *
   * <p>For `billing=charge_automatically` a subscription moves into `incomplete` if the initial
   * payment attempt fails. A subscription in this state can only have metadata and default_source
   * updated. Once the first invoice is paid, the subscription moves into an `active` state. If the
   * first invoice is not paid within 23 hours, the subscription transitions to
   * `incomplete_expired`. This is a terminal state, the open invoice will be voided and no further
   * invoices will be generated.
   *
   * <p>A subscription that is currently in a trial period is `trialing` and moves to `active` when
   * the trial period is over.
   *
   * <p>If subscription `billing=charge_automatically` it becomes `past_due` when payment to renew
   * it fails and `canceled` or `unpaid` (depending on your subscriptions settings) when Stripe has
   * exhausted all payment retry attempts.
   *
   * <p>If subscription `billing=send_invoice` it becomes `past_due` when its invoice is not paid by
   * the due date, and `canceled` or `unpaid` if it is still not paid by an additional deadline
   * after that. Note that when a subscription has a status of `unpaid`, no subsequent invoices will
   * be attempted (invoices will be created, but then immediately automatically closed). After
   * receiving updated payment information from a customer, you may choose to reopen and pay their
   * closed invoices.
   */
  @SerializedName("status")
  String status;

  /**
   * If provided, each invoice created by this subscription will apply the tax rate, increasing the
   * amount billed to the customer.
   */
  @SerializedName("tax_percent")
  BigDecimal taxPercent;

  /**
   * If specified, the funds from the subscription's invoices will be transferred to the destination
   * and the ID of the resulting transfers will be found on the resulting charges.
   */
  @SerializedName("transfer_data")
  Invoice.TransferData transferData;

  /** If the subscription has a trial, the end of that trial. */
  @SerializedName("trial_end")
  Long trialEnd;

  /** If the subscription has a trial, the beginning of that trial. */
  @SerializedName("trial_start")
  Long trialStart;

  /** Get id of expandable `customer` object. */
  public String getCustomer() {
    return (this.customer != null) ? this.customer.getId() : null;
  }

  public void setCustomer(String id) {
    this.customer = ApiResource.setExpandableFieldId(id, this.customer);
  }

  /** Get expanded `customer`. */
  public Customer getCustomerObject() {
    return (this.customer != null) ? this.customer.getExpanded() : null;
  }

  public void setCustomerObject(Customer expandableObject) {
    this.customer = new ExpandableField<Customer>(expandableObject.getId(), expandableObject);
  }

  /** Get id of expandable `defaultPaymentMethod` object. */
  public String getDefaultPaymentMethod() {
    return (this.defaultPaymentMethod != null) ? this.defaultPaymentMethod.getId() : null;
  }

  public void setDefaultPaymentMethod(String id) {
    this.defaultPaymentMethod = ApiResource.setExpandableFieldId(id, this.defaultPaymentMethod);
  }

  /** Get expanded `defaultPaymentMethod`. */
  public PaymentMethod getDefaultPaymentMethodObject() {
    return (this.defaultPaymentMethod != null) ? this.defaultPaymentMethod.getExpanded() : null;
  }

  public void setDefaultPaymentMethodObject(PaymentMethod expandableObject) {
    this.defaultPaymentMethod =
        new ExpandableField<PaymentMethod>(expandableObject.getId(), expandableObject);
  }

  /** Get id of expandable `defaultSource` object. */
  public String getDefaultSource() {
    return (this.defaultSource != null) ? this.defaultSource.getId() : null;
  }

  public void setDefaultSource(String id) {
    this.defaultSource = ApiResource.setExpandableFieldId(id, this.defaultSource);
  }

  /** Get expanded `defaultSource`. */
  public PaymentSource getDefaultSourceObject() {
    return (this.defaultSource != null) ? this.defaultSource.getExpanded() : null;
  }

  public void setDefaultSourceObject(PaymentSource expandableObject) {
    this.defaultSource =
        new ExpandableField<PaymentSource>(expandableObject.getId(), expandableObject);
  }

  /** Get id of expandable `latestInvoice` object. */
  public String getLatestInvoice() {
    return (this.latestInvoice != null) ? this.latestInvoice.getId() : null;
  }

  public void setLatestInvoice(String id) {
    this.latestInvoice = ApiResource.setExpandableFieldId(id, this.latestInvoice);
  }

  /** Get expanded `latestInvoice`. */
  public Invoice getLatestInvoiceObject() {
    return (this.latestInvoice != null) ? this.latestInvoice.getExpanded() : null;
  }

  public void setLatestInvoiceObject(Invoice expandableObject) {
    this.latestInvoice = new ExpandableField<Invoice>(expandableObject.getId(), expandableObject);
  }

  /**
   * By default, returns a list of subscriptions that have not been canceled. In order to list
   * canceled subscriptions, specify <code>status=canceled</code>.
   */
  public static SubscriptionCollection list(Map<String, Object> params) throws StripeException {
    return list(params, (RequestOptions) null);
  }

  /**
   * By default, returns a list of subscriptions that have not been canceled. In order to list
   * canceled subscriptions, specify <code>status=canceled</code>.
   */
  public static SubscriptionCollection list(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url = String.format("%s%s", Stripe.getApiBase(), "/v1/subscriptions");
    return requestCollection(url, params, SubscriptionCollection.class, options);
  }

  /**
   * By default, returns a list of subscriptions that have not been canceled. In order to list
   * canceled subscriptions, specify <code>status=canceled</code>.
   */
  public static SubscriptionCollection list(SubscriptionListParams params) throws StripeException {
    return list(params, (RequestOptions) null);
  }

  /**
   * By default, returns a list of subscriptions that have not been canceled. In order to list
   * canceled subscriptions, specify <code>status=canceled</code>.
   */
  public static SubscriptionCollection list(SubscriptionListParams params, RequestOptions options)
      throws StripeException {
    String url = String.format("%s%s", Stripe.getApiBase(), "/v1/subscriptions");
    return requestCollection(url, params, SubscriptionCollection.class, options);
  }

  /** Creates a new subscription on an existing customer. */
  public static Subscription create(Map<String, Object> params) throws StripeException {
    return create(params, (RequestOptions) null);
  }

  /** Creates a new subscription on an existing customer. */
  public static Subscription create(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url = String.format("%s%s", Stripe.getApiBase(), "/v1/subscriptions");
    return request(ApiResource.RequestMethod.POST, url, params, Subscription.class, options);
  }

  /** Creates a new subscription on an existing customer. */
  public static Subscription create(SubscriptionCreateParams params) throws StripeException {
    return create(params, (RequestOptions) null);
  }

  /** Creates a new subscription on an existing customer. */
  public static Subscription create(SubscriptionCreateParams params, RequestOptions options)
      throws StripeException {
    String url = String.format("%s%s", Stripe.getApiBase(), "/v1/subscriptions");
    return request(ApiResource.RequestMethod.POST, url, params, Subscription.class, options);
  }

  /**
   * Updates an existing subscription on a customer to match the specified parameters. When changing
   * plans or quantities, we will optionally prorate the price we charge next month to make up for
   * any price changes. To preview how the proration will be calculated, use the <a
   * href="#upcoming_invoice">upcoming invoice</a> endpoint.
   */
  @Override
  public Subscription update(Map<String, Object> params) throws StripeException {
    return update(params, (RequestOptions) null);
  }

  /**
   * Updates an existing subscription on a customer to match the specified parameters. When changing
   * plans or quantities, we will optionally prorate the price we charge next month to make up for
   * any price changes. To preview how the proration will be calculated, use the <a
   * href="#upcoming_invoice">upcoming invoice</a> endpoint.
   */
  @Override
  public Subscription update(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url =
        String.format(
            "%s%s",
            Stripe.getApiBase(),
            String.format("/v1/subscriptions/%s", ApiResource.urlEncodeId(this.getId())));
    return request(ApiResource.RequestMethod.POST, url, params, Subscription.class, options);
  }

  /**
   * Updates an existing subscription on a customer to match the specified parameters. When changing
   * plans or quantities, we will optionally prorate the price we charge next month to make up for
   * any price changes. To preview how the proration will be calculated, use the <a
   * href="#upcoming_invoice">upcoming invoice</a> endpoint.
   */
  public Subscription update(SubscriptionUpdateParams params) throws StripeException {
    return update(params, (RequestOptions) null);
  }

  /**
   * Updates an existing subscription on a customer to match the specified parameters. When changing
   * plans or quantities, we will optionally prorate the price we charge next month to make up for
   * any price changes. To preview how the proration will be calculated, use the <a
   * href="#upcoming_invoice">upcoming invoice</a> endpoint.
   */
  public Subscription update(SubscriptionUpdateParams params, RequestOptions options)
      throws StripeException {
    String url =
        String.format(
            "%s%s",
            Stripe.getApiBase(),
            String.format("/v1/subscriptions/%s", ApiResource.urlEncodeId(this.getId())));
    return request(ApiResource.RequestMethod.POST, url, params, Subscription.class, options);
  }

  /** Retrieves the subscription with the given ID. */
  public static Subscription retrieve(String subscriptionExposedId) throws StripeException {
    return retrieve(subscriptionExposedId, (Map<String, Object>) null, (RequestOptions) null);
  }

  /** Retrieves the subscription with the given ID. */
  public static Subscription retrieve(String subscriptionExposedId, RequestOptions options)
      throws StripeException {
    return retrieve(subscriptionExposedId, (Map<String, Object>) null, options);
  }

  /** Retrieves the subscription with the given ID. */
  public static Subscription retrieve(
      String subscriptionExposedId, Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url =
        String.format(
            "%s%s",
            Stripe.getApiBase(),
            String.format("/v1/subscriptions/%s", ApiResource.urlEncodeId(subscriptionExposedId)));
    return request(ApiResource.RequestMethod.GET, url, params, Subscription.class, options);
  }

  /** Retrieves the subscription with the given ID. */
  public static Subscription retrieve(
      String subscriptionExposedId, SubscriptionRetrieveParams params, RequestOptions options)
      throws StripeException {
    String url =
        String.format(
            "%s%s",
            Stripe.getApiBase(),
            String.format("/v1/subscriptions/%s", ApiResource.urlEncodeId(subscriptionExposedId)));
    return request(ApiResource.RequestMethod.GET, url, params, Subscription.class, options);
  }

  /**
   * Cancels a customer’s subscription immediately. The customer will not be charged again for the
   * subscription.
   *
   * <p>Note, however, that any pending invoice items that you’ve created will still be charged for
   * at the end of the period, unless manually <a href="#delete_invoiceitem">deleted</a>. If you’ve
   * set the subscription to cancel at the end of the period, any pending prorations will also be
   * left in place and collected at the end of the period. But if the subscription is set to cancel
   * immediately, pending prorations will be removed.
   *
   * <p>By default, upon subscription cancellation, Stripe will stop automatic collection of all
   * finalized invoices for the customer. This is intended to prevent unexpected payment attempts
   * after the customer has canceled a subscription. However, you can resume automatic collection of
   * the invoices manually after subscription cancellation to have us proceed. Or, you could check
   * for unpaid invoices before allowing the customer to cancel the subscription at all.
   */
  public Subscription cancel() throws StripeException {
    return cancel((Map<String, Object>) null, (RequestOptions) null);
  }

  /**
   * Cancels a customer’s subscription immediately. The customer will not be charged again for the
   * subscription.
   *
   * <p>Note, however, that any pending invoice items that you’ve created will still be charged for
   * at the end of the period, unless manually <a href="#delete_invoiceitem">deleted</a>. If you’ve
   * set the subscription to cancel at the end of the period, any pending prorations will also be
   * left in place and collected at the end of the period. But if the subscription is set to cancel
   * immediately, pending prorations will be removed.
   *
   * <p>By default, upon subscription cancellation, Stripe will stop automatic collection of all
   * finalized invoices for the customer. This is intended to prevent unexpected payment attempts
   * after the customer has canceled a subscription. However, you can resume automatic collection of
   * the invoices manually after subscription cancellation to have us proceed. Or, you could check
   * for unpaid invoices before allowing the customer to cancel the subscription at all.
   */
  public Subscription cancel(Map<String, Object> params) throws StripeException {
    return cancel(params, (RequestOptions) null);
  }

  /**
   * Cancels a customer’s subscription immediately. The customer will not be charged again for the
   * subscription.
   *
   * <p>Note, however, that any pending invoice items that you’ve created will still be charged for
   * at the end of the period, unless manually <a href="#delete_invoiceitem">deleted</a>. If you’ve
   * set the subscription to cancel at the end of the period, any pending prorations will also be
   * left in place and collected at the end of the period. But if the subscription is set to cancel
   * immediately, pending prorations will be removed.
   *
   * <p>By default, upon subscription cancellation, Stripe will stop automatic collection of all
   * finalized invoices for the customer. This is intended to prevent unexpected payment attempts
   * after the customer has canceled a subscription. However, you can resume automatic collection of
   * the invoices manually after subscription cancellation to have us proceed. Or, you could check
   * for unpaid invoices before allowing the customer to cancel the subscription at all.
   */
  public Subscription cancel(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url =
        String.format(
            "%s%s",
            Stripe.getApiBase(),
            String.format("/v1/subscriptions/%s", ApiResource.urlEncodeId(this.getId())));
    return request(ApiResource.RequestMethod.DELETE, url, params, Subscription.class, options);
  }

  /**
   * Cancels a customer’s subscription immediately. The customer will not be charged again for the
   * subscription.
   *
   * <p>Note, however, that any pending invoice items that you’ve created will still be charged for
   * at the end of the period, unless manually <a href="#delete_invoiceitem">deleted</a>. If you’ve
   * set the subscription to cancel at the end of the period, any pending prorations will also be
   * left in place and collected at the end of the period. But if the subscription is set to cancel
   * immediately, pending prorations will be removed.
   *
   * <p>By default, upon subscription cancellation, Stripe will stop automatic collection of all
   * finalized invoices for the customer. This is intended to prevent unexpected payment attempts
   * after the customer has canceled a subscription. However, you can resume automatic collection of
   * the invoices manually after subscription cancellation to have us proceed. Or, you could check
   * for unpaid invoices before allowing the customer to cancel the subscription at all.
   */
  public Subscription cancel(SubscriptionCancelParams params) throws StripeException {
    return cancel(params, (RequestOptions) null);
  }

  /**
   * Cancels a customer’s subscription immediately. The customer will not be charged again for the
   * subscription.
   *
   * <p>Note, however, that any pending invoice items that you’ve created will still be charged for
   * at the end of the period, unless manually <a href="#delete_invoiceitem">deleted</a>. If you’ve
   * set the subscription to cancel at the end of the period, any pending prorations will also be
   * left in place and collected at the end of the period. But if the subscription is set to cancel
   * immediately, pending prorations will be removed.
   *
   * <p>By default, upon subscription cancellation, Stripe will stop automatic collection of all
   * finalized invoices for the customer. This is intended to prevent unexpected payment attempts
   * after the customer has canceled a subscription. However, you can resume automatic collection of
   * the invoices manually after subscription cancellation to have us proceed. Or, you could check
   * for unpaid invoices before allowing the customer to cancel the subscription at all.
   */
  public Subscription cancel(SubscriptionCancelParams params, RequestOptions options)
      throws StripeException {
    String url =
        String.format(
            "%s%s",
            Stripe.getApiBase(),
            String.format("/v1/subscriptions/%s", ApiResource.urlEncodeId(this.getId())));
    return request(ApiResource.RequestMethod.DELETE, url, params, Subscription.class, options);
  }

  /** Removes the currently applied discount on a subscription. */
  public Discount deleteDiscount() throws StripeException {
    return deleteDiscount((Map<String, Object>) null, (RequestOptions) null);
  }

  /** Removes the currently applied discount on a subscription. */
  public Discount deleteDiscount(Map<String, Object> params) throws StripeException {
    return deleteDiscount(params, (RequestOptions) null);
  }

  /** Removes the currently applied discount on a subscription. */
  public Discount deleteDiscount(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url =
        String.format(
            "%s%s",
            Stripe.getApiBase(),
            String.format("/v1/subscriptions/%s/discount", ApiResource.urlEncodeId(this.getId())));
    return request(ApiResource.RequestMethod.DELETE, url, params, Discount.class, options);
  }

  @Getter
  @Setter
  @EqualsAndHashCode(callSuper = false)
  public static class BillingThresholds extends StripeObject {
    /** Monetary threshold that triggers the subscription to create an invoice. */
    @SerializedName("amount_gte")
    Long amountGte;

    /**
     * Indicates if the `billing_cycle_anchor` should be reset when a threshold is reached. If true,
     * `billing_cycle_anchor` will be updated to the date/time the threshold was last reached;
     * otherwise, the value will remain unchanged. This value may not be `true` if the subscription
     * contains items with plans that have `aggregate_usage=last_ever`.
     */
    @SerializedName("reset_billing_cycle_anchor")
    Boolean resetBillingCycleAnchor;
  }
}
