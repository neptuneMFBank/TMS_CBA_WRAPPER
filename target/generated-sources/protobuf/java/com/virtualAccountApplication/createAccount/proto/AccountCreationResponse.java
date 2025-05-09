// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: virtualAccount.proto

package com.virtualAccountApplication.createAccount.proto;

/**
 * Protobuf type {@code AccountCreationResponse}
 */
public final class AccountCreationResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:AccountCreationResponse)
    AccountCreationResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use AccountCreationResponse.newBuilder() to construct.
  private AccountCreationResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private AccountCreationResponse() {
    accountName_ = "";
    accountNumber_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new AccountCreationResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private AccountCreationResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            accountName_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            accountNumber_ = s;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.virtualAccountApplication.createAccount.proto.VirtualAccount.internal_static_AccountCreationResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.virtualAccountApplication.createAccount.proto.VirtualAccount.internal_static_AccountCreationResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.virtualAccountApplication.createAccount.proto.AccountCreationResponse.class, com.virtualAccountApplication.createAccount.proto.AccountCreationResponse.Builder.class);
  }

  public static final int ACCOUNT_NAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object accountName_;
  /**
   * <code>string account_name = 1;</code>
   * @return The accountName.
   */
  @java.lang.Override
  public java.lang.String getAccountName() {
    java.lang.Object ref = accountName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      accountName_ = s;
      return s;
    }
  }
  /**
   * <code>string account_name = 1;</code>
   * @return The bytes for accountName.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getAccountNameBytes() {
    java.lang.Object ref = accountName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      accountName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ACCOUNT_NUMBER_FIELD_NUMBER = 2;
  private volatile java.lang.Object accountNumber_;
  /**
   * <code>string account_number = 2;</code>
   * @return The accountNumber.
   */
  @java.lang.Override
  public java.lang.String getAccountNumber() {
    java.lang.Object ref = accountNumber_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      accountNumber_ = s;
      return s;
    }
  }
  /**
   * <code>string account_number = 2;</code>
   * @return The bytes for accountNumber.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getAccountNumberBytes() {
    java.lang.Object ref = accountNumber_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      accountNumber_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getAccountNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, accountName_);
    }
    if (!getAccountNumberBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, accountNumber_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getAccountNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, accountName_);
    }
    if (!getAccountNumberBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, accountNumber_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.virtualAccountApplication.createAccount.proto.AccountCreationResponse)) {
      return super.equals(obj);
    }
    com.virtualAccountApplication.createAccount.proto.AccountCreationResponse other = (com.virtualAccountApplication.createAccount.proto.AccountCreationResponse) obj;

    if (!getAccountName()
        .equals(other.getAccountName())) return false;
    if (!getAccountNumber()
        .equals(other.getAccountNumber())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ACCOUNT_NAME_FIELD_NUMBER;
    hash = (53 * hash) + getAccountName().hashCode();
    hash = (37 * hash) + ACCOUNT_NUMBER_FIELD_NUMBER;
    hash = (53 * hash) + getAccountNumber().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.virtualAccountApplication.createAccount.proto.AccountCreationResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.virtualAccountApplication.createAccount.proto.AccountCreationResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.virtualAccountApplication.createAccount.proto.AccountCreationResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.virtualAccountApplication.createAccount.proto.AccountCreationResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.virtualAccountApplication.createAccount.proto.AccountCreationResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.virtualAccountApplication.createAccount.proto.AccountCreationResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.virtualAccountApplication.createAccount.proto.AccountCreationResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.virtualAccountApplication.createAccount.proto.AccountCreationResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.virtualAccountApplication.createAccount.proto.AccountCreationResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.virtualAccountApplication.createAccount.proto.AccountCreationResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.virtualAccountApplication.createAccount.proto.AccountCreationResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.virtualAccountApplication.createAccount.proto.AccountCreationResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.virtualAccountApplication.createAccount.proto.AccountCreationResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code AccountCreationResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:AccountCreationResponse)
      com.virtualAccountApplication.createAccount.proto.AccountCreationResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.virtualAccountApplication.createAccount.proto.VirtualAccount.internal_static_AccountCreationResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.virtualAccountApplication.createAccount.proto.VirtualAccount.internal_static_AccountCreationResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.virtualAccountApplication.createAccount.proto.AccountCreationResponse.class, com.virtualAccountApplication.createAccount.proto.AccountCreationResponse.Builder.class);
    }

    // Construct using com.virtualAccountApplication.createAccount.proto.AccountCreationResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      accountName_ = "";

      accountNumber_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.virtualAccountApplication.createAccount.proto.VirtualAccount.internal_static_AccountCreationResponse_descriptor;
    }

    @java.lang.Override
    public com.virtualAccountApplication.createAccount.proto.AccountCreationResponse getDefaultInstanceForType() {
      return com.virtualAccountApplication.createAccount.proto.AccountCreationResponse.getDefaultInstance();
    }

    @java.lang.Override
    public com.virtualAccountApplication.createAccount.proto.AccountCreationResponse build() {
      com.virtualAccountApplication.createAccount.proto.AccountCreationResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.virtualAccountApplication.createAccount.proto.AccountCreationResponse buildPartial() {
      com.virtualAccountApplication.createAccount.proto.AccountCreationResponse result = new com.virtualAccountApplication.createAccount.proto.AccountCreationResponse(this);
      result.accountName_ = accountName_;
      result.accountNumber_ = accountNumber_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.virtualAccountApplication.createAccount.proto.AccountCreationResponse) {
        return mergeFrom((com.virtualAccountApplication.createAccount.proto.AccountCreationResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.virtualAccountApplication.createAccount.proto.AccountCreationResponse other) {
      if (other == com.virtualAccountApplication.createAccount.proto.AccountCreationResponse.getDefaultInstance()) return this;
      if (!other.getAccountName().isEmpty()) {
        accountName_ = other.accountName_;
        onChanged();
      }
      if (!other.getAccountNumber().isEmpty()) {
        accountNumber_ = other.accountNumber_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.virtualAccountApplication.createAccount.proto.AccountCreationResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.virtualAccountApplication.createAccount.proto.AccountCreationResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object accountName_ = "";
    /**
     * <code>string account_name = 1;</code>
     * @return The accountName.
     */
    public java.lang.String getAccountName() {
      java.lang.Object ref = accountName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        accountName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string account_name = 1;</code>
     * @return The bytes for accountName.
     */
    public com.google.protobuf.ByteString
        getAccountNameBytes() {
      java.lang.Object ref = accountName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        accountName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string account_name = 1;</code>
     * @param value The accountName to set.
     * @return This builder for chaining.
     */
    public Builder setAccountName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      accountName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string account_name = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearAccountName() {
      
      accountName_ = getDefaultInstance().getAccountName();
      onChanged();
      return this;
    }
    /**
     * <code>string account_name = 1;</code>
     * @param value The bytes for accountName to set.
     * @return This builder for chaining.
     */
    public Builder setAccountNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      accountName_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object accountNumber_ = "";
    /**
     * <code>string account_number = 2;</code>
     * @return The accountNumber.
     */
    public java.lang.String getAccountNumber() {
      java.lang.Object ref = accountNumber_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        accountNumber_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string account_number = 2;</code>
     * @return The bytes for accountNumber.
     */
    public com.google.protobuf.ByteString
        getAccountNumberBytes() {
      java.lang.Object ref = accountNumber_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        accountNumber_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string account_number = 2;</code>
     * @param value The accountNumber to set.
     * @return This builder for chaining.
     */
    public Builder setAccountNumber(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      accountNumber_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string account_number = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearAccountNumber() {
      
      accountNumber_ = getDefaultInstance().getAccountNumber();
      onChanged();
      return this;
    }
    /**
     * <code>string account_number = 2;</code>
     * @param value The bytes for accountNumber to set.
     * @return This builder for chaining.
     */
    public Builder setAccountNumberBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      accountNumber_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:AccountCreationResponse)
  }

  // @@protoc_insertion_point(class_scope:AccountCreationResponse)
  private static final com.virtualAccountApplication.createAccount.proto.AccountCreationResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.virtualAccountApplication.createAccount.proto.AccountCreationResponse();
  }

  public static com.virtualAccountApplication.createAccount.proto.AccountCreationResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AccountCreationResponse>
      PARSER = new com.google.protobuf.AbstractParser<AccountCreationResponse>() {
    @java.lang.Override
    public AccountCreationResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new AccountCreationResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<AccountCreationResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<AccountCreationResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.virtualAccountApplication.createAccount.proto.AccountCreationResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

