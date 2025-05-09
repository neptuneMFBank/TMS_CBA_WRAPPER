// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: easypay.proto

package com.neptune.cba.transaction.easy_pay;

/**
 * Protobuf type {@code com.neptune.cba.EasyPayStatusRequest}
 */
public final class EasyPayStatusRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.neptune.cba.EasyPayStatusRequest)
    EasyPayStatusRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use EasyPayStatusRequest.newBuilder() to construct.
  private EasyPayStatusRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private EasyPayStatusRequest() {
    transactionRef_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new EasyPayStatusRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private EasyPayStatusRequest(
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

            transactionRef_ = s;
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
    return com.neptune.cba.transaction.easy_pay.Easypay.internal_static_com_neptune_cba_EasyPayStatusRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.neptune.cba.transaction.easy_pay.Easypay.internal_static_com_neptune_cba_EasyPayStatusRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest.class, com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest.Builder.class);
  }

  public static final int TRANSACTIONREF_FIELD_NUMBER = 1;
  private volatile java.lang.Object transactionRef_;
  /**
   * <code>string transactionRef = 1;</code>
   * @return The transactionRef.
   */
  @java.lang.Override
  public java.lang.String getTransactionRef() {
    java.lang.Object ref = transactionRef_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      transactionRef_ = s;
      return s;
    }
  }
  /**
   * <code>string transactionRef = 1;</code>
   * @return The bytes for transactionRef.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getTransactionRefBytes() {
    java.lang.Object ref = transactionRef_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      transactionRef_ = b;
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
    if (!getTransactionRefBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, transactionRef_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getTransactionRefBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, transactionRef_);
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
    if (!(obj instanceof com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest)) {
      return super.equals(obj);
    }
    com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest other = (com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest) obj;

    if (!getTransactionRef()
        .equals(other.getTransactionRef())) return false;
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
    hash = (37 * hash) + TRANSACTIONREF_FIELD_NUMBER;
    hash = (53 * hash) + getTransactionRef().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest parseFrom(
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
  public static Builder newBuilder(com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest prototype) {
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
   * Protobuf type {@code com.neptune.cba.EasyPayStatusRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.neptune.cba.EasyPayStatusRequest)
      com.neptune.cba.transaction.easy_pay.EasyPayStatusRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.neptune.cba.transaction.easy_pay.Easypay.internal_static_com_neptune_cba_EasyPayStatusRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.neptune.cba.transaction.easy_pay.Easypay.internal_static_com_neptune_cba_EasyPayStatusRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest.class, com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest.Builder.class);
    }

    // Construct using com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest.newBuilder()
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
      transactionRef_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.neptune.cba.transaction.easy_pay.Easypay.internal_static_com_neptune_cba_EasyPayStatusRequest_descriptor;
    }

    @java.lang.Override
    public com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest getDefaultInstanceForType() {
      return com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest build() {
      com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest buildPartial() {
      com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest result = new com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest(this);
      result.transactionRef_ = transactionRef_;
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
      if (other instanceof com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest) {
        return mergeFrom((com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest other) {
      if (other == com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest.getDefaultInstance()) return this;
      if (!other.getTransactionRef().isEmpty()) {
        transactionRef_ = other.transactionRef_;
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
      com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object transactionRef_ = "";
    /**
     * <code>string transactionRef = 1;</code>
     * @return The transactionRef.
     */
    public java.lang.String getTransactionRef() {
      java.lang.Object ref = transactionRef_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        transactionRef_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string transactionRef = 1;</code>
     * @return The bytes for transactionRef.
     */
    public com.google.protobuf.ByteString
        getTransactionRefBytes() {
      java.lang.Object ref = transactionRef_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        transactionRef_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string transactionRef = 1;</code>
     * @param value The transactionRef to set.
     * @return This builder for chaining.
     */
    public Builder setTransactionRef(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      transactionRef_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string transactionRef = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearTransactionRef() {
      
      transactionRef_ = getDefaultInstance().getTransactionRef();
      onChanged();
      return this;
    }
    /**
     * <code>string transactionRef = 1;</code>
     * @param value The bytes for transactionRef to set.
     * @return This builder for chaining.
     */
    public Builder setTransactionRefBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      transactionRef_ = value;
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


    // @@protoc_insertion_point(builder_scope:com.neptune.cba.EasyPayStatusRequest)
  }

  // @@protoc_insertion_point(class_scope:com.neptune.cba.EasyPayStatusRequest)
  private static final com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest();
  }

  public static com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<EasyPayStatusRequest>
      PARSER = new com.google.protobuf.AbstractParser<EasyPayStatusRequest>() {
    @java.lang.Override
    public EasyPayStatusRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new EasyPayStatusRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<EasyPayStatusRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<EasyPayStatusRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

