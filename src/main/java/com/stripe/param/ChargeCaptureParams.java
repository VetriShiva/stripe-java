// Generated by com.stripe.generator.entity.SdkBuilder

package com.stripe.param;

import com.google.gson.annotations.SerializedName;
import com.stripe.net.ApiRequestParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChargeCaptureParams extends ApiRequestParams {
  /**
   * The amount to capture, which must be less than or equal to the original amount. Any additional
   * amount will be automatically refunded.
   */
  @SerializedName("amount")
  Long amount;

  /** An application fee to add on to this charge. Can only be used with Stripe Connect. */
  @SerializedName("application_fee")
  Long applicationFee;

  /**
   * An application fee amount to add on to this charge, which must be less than or equal to the
   * original amount. Can only be used with Stripe Connect.
   */
  @SerializedName("application_fee_amount")
  Long applicationFeeAmount;

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

  /**
   * The email address to send this charge's receipt to. This will override the previously-specified
   * email address for this charge, if one was set. Receipts will not be sent in test mode.
   */
  @SerializedName("receipt_email")
  String receiptEmail;

  /**
   * An arbitrary string to be used as the dynamic portion of the full descriptor displayed on your
   * customer's credit card statement. This value will be prefixed by your [account's statement
   * descriptor](https://stripe.com/docs/charges#dynamic-statement-descriptor). As an example, if
   * your account's statement descriptor is `RUNCLUB` and the item you're charging for is a race
   * ticket, you may want to specify a `statement_descriptor` of `5K RACE`, so that the resulting
   * full descriptor would be `RUNCLUB* 5K RACE`. The full descriptor may be up to *22 characters*.
   * This value must contain at least one letter, may not include `"'` characters, and will appear
   * on your customer's statement in capital letters. Non-ASCII characters are automatically
   * stripped. Updating this value will overwrite the previous `statement_descriptor` of this
   * charge. While most banks display this information consistently, some may display it incorrectly
   * or not at all.
   */
  @SerializedName("statement_descriptor")
  String statementDescriptor;

  /**
   * An optional dictionary including the account to automatically transfer to as part of a
   * destination charge. [See the Connect
   * documentation](https://stripe.com/docs/connect/destination-charges) for details.
   */
  @SerializedName("transfer_data")
  TransferData transferData;

  /**
   * A string that identifies this transaction as part of a group. `transfer_group` may only be
   * provided if it has not been set. See the [Connect
   * documentation](https://stripe.com/docs/connect/charges-transfers#grouping-transactions) for
   * details.
   */
  @SerializedName("transfer_group")
  String transferGroup;

  private ChargeCaptureParams(
      Long amount,
      Long applicationFee,
      Long applicationFeeAmount,
      List<String> expand,
      Map<String, Object> extraParams,
      String receiptEmail,
      String statementDescriptor,
      TransferData transferData,
      String transferGroup) {
    this.amount = amount;
    this.applicationFee = applicationFee;
    this.applicationFeeAmount = applicationFeeAmount;
    this.expand = expand;
    this.extraParams = extraParams;
    this.receiptEmail = receiptEmail;
    this.statementDescriptor = statementDescriptor;
    this.transferData = transferData;
    this.transferGroup = transferGroup;
  }

  public static Builder builder() {
    return new com.stripe.param.ChargeCaptureParams.Builder();
  }

  public static class Builder {
    private Long amount;

    private Long applicationFee;

    private Long applicationFeeAmount;

    private List<String> expand;

    private Map<String, Object> extraParams;

    private String receiptEmail;

    private String statementDescriptor;

    private TransferData transferData;

    private String transferGroup;

    /** Finalize and obtain parameter instance from this builder. */
    public ChargeCaptureParams build() {
      return new ChargeCaptureParams(
          this.amount,
          this.applicationFee,
          this.applicationFeeAmount,
          this.expand,
          this.extraParams,
          this.receiptEmail,
          this.statementDescriptor,
          this.transferData,
          this.transferGroup);
    }

    /**
     * The amount to capture, which must be less than or equal to the original amount. Any
     * additional amount will be automatically refunded.
     */
    public Builder setAmount(Long amount) {
      this.amount = amount;
      return this;
    }

    /** An application fee to add on to this charge. Can only be used with Stripe Connect. */
    public Builder setApplicationFee(Long applicationFee) {
      this.applicationFee = applicationFee;
      return this;
    }

    /**
     * An application fee amount to add on to this charge, which must be less than or equal to the
     * original amount. Can only be used with Stripe Connect.
     */
    public Builder setApplicationFeeAmount(Long applicationFeeAmount) {
      this.applicationFeeAmount = applicationFeeAmount;
      return this;
    }

    /**
     * Add an element to `expand` list. A list is initialized for the first `add/addAll` call, and
     * subsequent calls adds additional elements to the original list. See {@link
     * ChargeCaptureParams#expand} for the field documentation.
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
     * ChargeCaptureParams#expand} for the field documentation.
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
     * ChargeCaptureParams#extraParams} for the field documentation.
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
     * See {@link ChargeCaptureParams#extraParams} for the field documentation.
     */
    public Builder putAllExtraParam(Map<String, Object> map) {
      if (this.extraParams == null) {
        this.extraParams = new HashMap<>();
      }
      this.extraParams.putAll(map);
      return this;
    }

    /**
     * The email address to send this charge's receipt to. This will override the
     * previously-specified email address for this charge, if one was set. Receipts will not be sent
     * in test mode.
     */
    public Builder setReceiptEmail(String receiptEmail) {
      this.receiptEmail = receiptEmail;
      return this;
    }

    /**
     * An arbitrary string to be used as the dynamic portion of the full descriptor displayed on
     * your customer's credit card statement. This value will be prefixed by your [account's
     * statement descriptor](https://stripe.com/docs/charges#dynamic-statement-descriptor). As an
     * example, if your account's statement descriptor is `RUNCLUB` and the item you're charging for
     * is a race ticket, you may want to specify a `statement_descriptor` of `5K RACE`, so that the
     * resulting full descriptor would be `RUNCLUB* 5K RACE`. The full descriptor may be up to *22
     * characters*. This value must contain at least one letter, may not include `"'` characters,
     * and will appear on your customer's statement in capital letters. Non-ASCII characters are
     * automatically stripped. Updating this value will overwrite the previous
     * `statement_descriptor` of this charge. While most banks display this information
     * consistently, some may display it incorrectly or not at all.
     */
    public Builder setStatementDescriptor(String statementDescriptor) {
      this.statementDescriptor = statementDescriptor;
      return this;
    }

    /**
     * An optional dictionary including the account to automatically transfer to as part of a
     * destination charge. [See the Connect
     * documentation](https://stripe.com/docs/connect/destination-charges) for details.
     */
    public Builder setTransferData(TransferData transferData) {
      this.transferData = transferData;
      return this;
    }

    /**
     * A string that identifies this transaction as part of a group. `transfer_group` may only be
     * provided if it has not been set. See the [Connect
     * documentation](https://stripe.com/docs/connect/charges-transfers#grouping-transactions) for
     * details.
     */
    public Builder setTransferGroup(String transferGroup) {
      this.transferGroup = transferGroup;
      return this;
    }
  }

  public static class TransferData {
    /**
     * The amount transferred to the destination account, if specified. By default, the entire
     * charge amount is transferred to the destination account.
     */
    @SerializedName("amount")
    Long amount;

    /**
     * Map of extra parameters for custom features not available in this client library. The content
     * in this map is not serialized under this field's {@code @SerializedName} value. Instead, each
     * key/value pair is serialized as if the key is a root-level field (serialized) name in this
     * param object. Effectively, this map is flattened to its parent instance.
     */
    @SerializedName(ApiRequestParams.EXTRA_PARAMS_KEY)
    Map<String, Object> extraParams;

    private TransferData(Long amount, Map<String, Object> extraParams) {
      this.amount = amount;
      this.extraParams = extraParams;
    }

    public static Builder builder() {
      return new com.stripe.param.ChargeCaptureParams.TransferData.Builder();
    }

    public static class Builder {
      private Long amount;

      private Map<String, Object> extraParams;

      /** Finalize and obtain parameter instance from this builder. */
      public TransferData build() {
        return new TransferData(this.amount, this.extraParams);
      }

      /**
       * The amount transferred to the destination account, if specified. By default, the entire
       * charge amount is transferred to the destination account.
       */
      public Builder setAmount(Long amount) {
        this.amount = amount;
        return this;
      }

      /**
       * Add a key/value pair to `extraParams` map. A map is initialized for the first `put/putAll`
       * call, and subsequent calls add additional key/value pairs to the original map. See {@link
       * ChargeCaptureParams.TransferData#extraParams} for the field documentation.
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
       * See {@link ChargeCaptureParams.TransferData#extraParams} for the field documentation.
       */
      public Builder putAllExtraParam(Map<String, Object> map) {
        if (this.extraParams == null) {
          this.extraParams = new HashMap<>();
        }
        this.extraParams.putAll(map);
        return this;
      }
    }
  }
}
