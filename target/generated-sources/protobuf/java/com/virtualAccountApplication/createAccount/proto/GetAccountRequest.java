// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: virtualAccount.proto

package com.virtualAccountApplication.createAccount.proto;

/**
 * Protobuf type {@code GetAccountRequest}
 */
public final class GetAccountRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:GetAccountRequest)
    GetAccountRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GetAccountRequest.newBuilder() to construct.
  private GetAccountRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetAccountRequest() {
    uniqueData_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new GetAccountRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GetAccountRequest(
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

            uniqueData_ = s;
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
    return com.virtualAccountApplication.createAccount.proto.VirtualAccount.internal_static_GetAccountRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.virtualAccountApplication.createAccount.proto.VirtualAccount.internal_static_GetAccountRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.virtualAccountApplication.createAccount.proto.GetAccountRequest.class, com.virtualAccountApplication.createAccount.proto.GetAccountRequest.Builder.class);
  }

  public static final int UNIQUE_DATA_FIELD_NUMBER = 1;
  private volatile java.lang.Object uniqueData_;
  /**
   * <code>string unique_data = 1;</code>
   * @return The uniqueData.
   */
  @java.lang.Override
  public java.lang.String getUniqueData() {
    java.lang.Object ref = uniqueData_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      uniqueData_ = s;
      return s;
    }
  }
  /**
   * <code>string unique_data = 1;</code>
   * @return The bytes for uniqueData.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getUniqueDataBytes() {
    java.lang.Object ref = uniqueData_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      uniqueData_ = b;
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
    if (!getUniqueDataBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, uniqueData_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getUniqueDataBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, uniqueData_);
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
    if (!(obj instanceof com.virtualAccountApplication.createAccount.proto.GetAccountRequest)) {
      return super.equals(obj);
    }
    com.virtualAccountApplication.createAccount.proto.GetAccountRequest other = (com.virtualAccountApplication.createAccount.proto.GetAccountRequest) obj;

    if (!getUniqueData()
        .equals(other.getUniqueData())) return false;
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
    hash = (37 * hash) + UNIQUE_DATA_FIELD_NUMBER;
    hash = (53 * hash) + getUniqueData().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.virtualAccountApplication.createAccount.proto.GetAccountRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.virtualAccountApplication.createAccount.proto.GetAccountRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.virtualAccountApplication.createAccount.proto.GetAccountRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.virtualAccountApplication.createAccount.proto.GetAccountRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.virtualAccountApplication.createAccount.proto.GetAccountRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.virtualAccountApplication.createAccount.proto.GetAccountRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.virtualAccountApplication.createAccount.proto.GetAccountRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.virtualAccountApplication.createAccount.proto.GetAccountRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.virtualAccountApplication.createAccount.proto.GetAccountRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.virtualAccountApplication.createAccount.proto.GetAccountRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.virtualAccountApplication.createAccount.proto.GetAccountRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.virtualAccountApplication.createAccount.proto.GetAccountRequest parseFrom(
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
  public static Builder newBuilder(com.virtualAccountApplication.createAccount.proto.GetAccountRequest prototype) {
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
   * Protobuf type {@code GetAccountRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:GetAccountRequest)
      com.virtualAccountApplication.createAccount.proto.GetAccountRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.virtualAccountApplication.createAccount.proto.VirtualAccount.internal_static_GetAccountRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.virtualAccountApplication.createAccount.proto.VirtualAccount.internal_static_GetAccountRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.virtualAccountApplication.createAccount.proto.GetAccountRequest.class, com.virtualAccountApplication.createAccount.proto.GetAccountRequest.Builder.class);
    }

    // Construct using com.virtualAccountApplication.createAccount.proto.GetAccountRequest.newBuilder()
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
      uniqueData_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.virtualAccountApplication.createAccount.proto.VirtualAccount.internal_static_GetAccountRequest_descriptor;
    }

    @java.lang.Override
    public com.virtualAccountApplication.createAccount.proto.GetAccountRequest getDefaultInstanceForType() {
      return com.virtualAccountApplication.createAccount.proto.GetAccountRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.virtualAccountApplication.createAccount.proto.GetAccountRequest build() {
      com.virtualAccountApplication.createAccount.proto.GetAccountRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.virtualAccountApplication.createAccount.proto.GetAccountRequest buildPartial() {
      com.virtualAccountApplication.createAccount.proto.GetAccountRequest result = new com.virtualAccountApplication.createAccount.proto.GetAccountRequest(this);
      result.uniqueData_ = uniqueData_;
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
      if (other instanceof com.virtualAccountApplication.createAccount.proto.GetAccountRequest) {
        return mergeFrom((com.virtualAccountApplication.createAccount.proto.GetAccountRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.virtualAccountApplication.createAccount.proto.GetAccountRequest other) {
      if (other == com.virtualAccountApplication.createAccount.proto.GetAccountRequest.getDefaultInstance()) return this;
      if (!other.getUniqueData().isEmpty()) {
        uniqueData_ = other.uniqueData_;
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
      com.virtualAccountApplication.createAccount.proto.GetAccountRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.virtualAccountApplication.createAccount.proto.GetAccountRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object uniqueData_ = "";
    /**
     * <code>string unique_data = 1;</code>
     * @return The uniqueData.
     */
    public java.lang.String getUniqueData() {
      java.lang.Object ref = uniqueData_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        uniqueData_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string unique_data = 1;</code>
     * @return The bytes for uniqueData.
     */
    public com.google.protobuf.ByteString
        getUniqueDataBytes() {
      java.lang.Object ref = uniqueData_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        uniqueData_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string unique_data = 1;</code>
     * @param value The uniqueData to set.
     * @return This builder for chaining.
     */
    public Builder setUniqueData(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      uniqueData_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string unique_data = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearUniqueData() {
      
      uniqueData_ = getDefaultInstance().getUniqueData();
      onChanged();
      return this;
    }
    /**
     * <code>string unique_data = 1;</code>
     * @param value The bytes for uniqueData to set.
     * @return This builder for chaining.
     */
    public Builder setUniqueDataBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      uniqueData_ = value;
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


    // @@protoc_insertion_point(builder_scope:GetAccountRequest)
  }

  // @@protoc_insertion_point(class_scope:GetAccountRequest)
  private static final com.virtualAccountApplication.createAccount.proto.GetAccountRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.virtualAccountApplication.createAccount.proto.GetAccountRequest();
  }

  public static com.virtualAccountApplication.createAccount.proto.GetAccountRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetAccountRequest>
      PARSER = new com.google.protobuf.AbstractParser<GetAccountRequest>() {
    @java.lang.Override
    public GetAccountRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GetAccountRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GetAccountRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GetAccountRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.virtualAccountApplication.createAccount.proto.GetAccountRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

