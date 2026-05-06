package com.neptune.cba.transaction.easy_pay;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: easypay.proto")
public final class EasyPayServiceGrpc {

  private EasyPayServiceGrpc() {}

  public static final String SERVICE_NAME = "com.neptune.cba.EasyPayService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.neptune.cba.transaction.easy_pay.EasyPayRequest,
      com.neptune.cba.transaction.easy_pay.EasyPayResponse> getEasyPayMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "easy_pay",
      requestType = com.neptune.cba.transaction.easy_pay.EasyPayRequest.class,
      responseType = com.neptune.cba.transaction.easy_pay.EasyPayResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.neptune.cba.transaction.easy_pay.EasyPayRequest,
      com.neptune.cba.transaction.easy_pay.EasyPayResponse> getEasyPayMethod() {
    io.grpc.MethodDescriptor<com.neptune.cba.transaction.easy_pay.EasyPayRequest, com.neptune.cba.transaction.easy_pay.EasyPayResponse> getEasyPayMethod;
    if ((getEasyPayMethod = EasyPayServiceGrpc.getEasyPayMethod) == null) {
      synchronized (EasyPayServiceGrpc.class) {
        if ((getEasyPayMethod = EasyPayServiceGrpc.getEasyPayMethod) == null) {
          EasyPayServiceGrpc.getEasyPayMethod = getEasyPayMethod =
              io.grpc.MethodDescriptor.<com.neptune.cba.transaction.easy_pay.EasyPayRequest, com.neptune.cba.transaction.easy_pay.EasyPayResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "easy_pay"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.easy_pay.EasyPayRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.easy_pay.EasyPayResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EasyPayServiceMethodDescriptorSupplier("easy_pay"))
              .build();
        }
      }
    }
    return getEasyPayMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.neptune.cba.transaction.easy_pay.getInstEmpty,
      com.neptune.cba.transaction.easy_pay.Institutions> getInstitutionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "institutions",
      requestType = com.neptune.cba.transaction.easy_pay.getInstEmpty.class,
      responseType = com.neptune.cba.transaction.easy_pay.Institutions.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.neptune.cba.transaction.easy_pay.getInstEmpty,
      com.neptune.cba.transaction.easy_pay.Institutions> getInstitutionsMethod() {
    io.grpc.MethodDescriptor<com.neptune.cba.transaction.easy_pay.getInstEmpty, com.neptune.cba.transaction.easy_pay.Institutions> getInstitutionsMethod;
    if ((getInstitutionsMethod = EasyPayServiceGrpc.getInstitutionsMethod) == null) {
      synchronized (EasyPayServiceGrpc.class) {
        if ((getInstitutionsMethod = EasyPayServiceGrpc.getInstitutionsMethod) == null) {
          EasyPayServiceGrpc.getInstitutionsMethod = getInstitutionsMethod =
              io.grpc.MethodDescriptor.<com.neptune.cba.transaction.easy_pay.getInstEmpty, com.neptune.cba.transaction.easy_pay.Institutions>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "institutions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.easy_pay.getInstEmpty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.easy_pay.Institutions.getDefaultInstance()))
              .setSchemaDescriptor(new EasyPayServiceMethodDescriptorSupplier("institutions"))
              .build();
        }
      }
    }
    return getInstitutionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.neptune.cba.transaction.easy_pay.NameEnquiryRpcRequest,
      com.neptune.cba.transaction.easy_pay.NameEnquiryResponse> getNameEnquiryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "nameEnquiry",
      requestType = com.neptune.cba.transaction.easy_pay.NameEnquiryRpcRequest.class,
      responseType = com.neptune.cba.transaction.easy_pay.NameEnquiryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.neptune.cba.transaction.easy_pay.NameEnquiryRpcRequest,
      com.neptune.cba.transaction.easy_pay.NameEnquiryResponse> getNameEnquiryMethod() {
    io.grpc.MethodDescriptor<com.neptune.cba.transaction.easy_pay.NameEnquiryRpcRequest, com.neptune.cba.transaction.easy_pay.NameEnquiryResponse> getNameEnquiryMethod;
    if ((getNameEnquiryMethod = EasyPayServiceGrpc.getNameEnquiryMethod) == null) {
      synchronized (EasyPayServiceGrpc.class) {
        if ((getNameEnquiryMethod = EasyPayServiceGrpc.getNameEnquiryMethod) == null) {
          EasyPayServiceGrpc.getNameEnquiryMethod = getNameEnquiryMethod =
              io.grpc.MethodDescriptor.<com.neptune.cba.transaction.easy_pay.NameEnquiryRpcRequest, com.neptune.cba.transaction.easy_pay.NameEnquiryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "nameEnquiry"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.easy_pay.NameEnquiryRpcRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.easy_pay.NameEnquiryResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EasyPayServiceMethodDescriptorSupplier("nameEnquiry"))
              .build();
        }
      }
    }
    return getNameEnquiryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.neptune.cba.transaction.easy_pay.EasyPayListRequest,
      com.neptune.cba.transaction.easy_pay.EasyPayListResponse> getListEasyPayMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "list_easy_pay",
      requestType = com.neptune.cba.transaction.easy_pay.EasyPayListRequest.class,
      responseType = com.neptune.cba.transaction.easy_pay.EasyPayListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.neptune.cba.transaction.easy_pay.EasyPayListRequest,
      com.neptune.cba.transaction.easy_pay.EasyPayListResponse> getListEasyPayMethod() {
    io.grpc.MethodDescriptor<com.neptune.cba.transaction.easy_pay.EasyPayListRequest, com.neptune.cba.transaction.easy_pay.EasyPayListResponse> getListEasyPayMethod;
    if ((getListEasyPayMethod = EasyPayServiceGrpc.getListEasyPayMethod) == null) {
      synchronized (EasyPayServiceGrpc.class) {
        if ((getListEasyPayMethod = EasyPayServiceGrpc.getListEasyPayMethod) == null) {
          EasyPayServiceGrpc.getListEasyPayMethod = getListEasyPayMethod =
              io.grpc.MethodDescriptor.<com.neptune.cba.transaction.easy_pay.EasyPayListRequest, com.neptune.cba.transaction.easy_pay.EasyPayListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "list_easy_pay"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.easy_pay.EasyPayListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.easy_pay.EasyPayListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EasyPayServiceMethodDescriptorSupplier("list_easy_pay"))
              .build();
        }
      }
    }
    return getListEasyPayMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.neptune.cba.transaction.easy_pay.ReverseRequest,
      com.neptune.cba.transaction.easy_pay.ReverseResponse> getReverseEasyPayMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "reverse_easy_pay",
      requestType = com.neptune.cba.transaction.easy_pay.ReverseRequest.class,
      responseType = com.neptune.cba.transaction.easy_pay.ReverseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.neptune.cba.transaction.easy_pay.ReverseRequest,
      com.neptune.cba.transaction.easy_pay.ReverseResponse> getReverseEasyPayMethod() {
    io.grpc.MethodDescriptor<com.neptune.cba.transaction.easy_pay.ReverseRequest, com.neptune.cba.transaction.easy_pay.ReverseResponse> getReverseEasyPayMethod;
    if ((getReverseEasyPayMethod = EasyPayServiceGrpc.getReverseEasyPayMethod) == null) {
      synchronized (EasyPayServiceGrpc.class) {
        if ((getReverseEasyPayMethod = EasyPayServiceGrpc.getReverseEasyPayMethod) == null) {
          EasyPayServiceGrpc.getReverseEasyPayMethod = getReverseEasyPayMethod =
              io.grpc.MethodDescriptor.<com.neptune.cba.transaction.easy_pay.ReverseRequest, com.neptune.cba.transaction.easy_pay.ReverseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "reverse_easy_pay"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.easy_pay.ReverseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.easy_pay.ReverseResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EasyPayServiceMethodDescriptorSupplier("reverse_easy_pay"))
              .build();
        }
      }
    }
    return getReverseEasyPayMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest,
      com.neptune.cba.transaction.easy_pay.EasyPayStatusResponse> getEasyPayStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "easy_pay_status",
      requestType = com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest.class,
      responseType = com.neptune.cba.transaction.easy_pay.EasyPayStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest,
      com.neptune.cba.transaction.easy_pay.EasyPayStatusResponse> getEasyPayStatusMethod() {
    io.grpc.MethodDescriptor<com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest, com.neptune.cba.transaction.easy_pay.EasyPayStatusResponse> getEasyPayStatusMethod;
    if ((getEasyPayStatusMethod = EasyPayServiceGrpc.getEasyPayStatusMethod) == null) {
      synchronized (EasyPayServiceGrpc.class) {
        if ((getEasyPayStatusMethod = EasyPayServiceGrpc.getEasyPayStatusMethod) == null) {
          EasyPayServiceGrpc.getEasyPayStatusMethod = getEasyPayStatusMethod =
              io.grpc.MethodDescriptor.<com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest, com.neptune.cba.transaction.easy_pay.EasyPayStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "easy_pay_status"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.easy_pay.EasyPayStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EasyPayServiceMethodDescriptorSupplier("easy_pay_status"))
              .build();
        }
      }
    }
    return getEasyPayStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EasyPayServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EasyPayServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EasyPayServiceStub>() {
        @java.lang.Override
        public EasyPayServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EasyPayServiceStub(channel, callOptions);
        }
      };
    return EasyPayServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EasyPayServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EasyPayServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EasyPayServiceBlockingStub>() {
        @java.lang.Override
        public EasyPayServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EasyPayServiceBlockingStub(channel, callOptions);
        }
      };
    return EasyPayServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EasyPayServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EasyPayServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EasyPayServiceFutureStub>() {
        @java.lang.Override
        public EasyPayServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EasyPayServiceFutureStub(channel, callOptions);
        }
      };
    return EasyPayServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class EasyPayServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void easyPay(com.neptune.cba.transaction.easy_pay.EasyPayRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.easy_pay.EasyPayResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEasyPayMethod(), responseObserver);
    }

    /**
     */
    public void institutions(com.neptune.cba.transaction.easy_pay.getInstEmpty request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.easy_pay.Institutions> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getInstitutionsMethod(), responseObserver);
    }

    /**
     */
    public void nameEnquiry(com.neptune.cba.transaction.easy_pay.NameEnquiryRpcRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.easy_pay.NameEnquiryResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getNameEnquiryMethod(), responseObserver);
    }

    /**
     */
    public void listEasyPay(com.neptune.cba.transaction.easy_pay.EasyPayListRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.easy_pay.EasyPayListResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListEasyPayMethod(), responseObserver);
    }

    /**
     */
    public void reverseEasyPay(com.neptune.cba.transaction.easy_pay.ReverseRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.easy_pay.ReverseResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReverseEasyPayMethod(), responseObserver);
    }

    /**
     */
    public void easyPayStatus(com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.easy_pay.EasyPayStatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEasyPayStatusMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getEasyPayMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.neptune.cba.transaction.easy_pay.EasyPayRequest,
                com.neptune.cba.transaction.easy_pay.EasyPayResponse>(
                  this, METHODID_EASY_PAY)))
          .addMethod(
            getInstitutionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.neptune.cba.transaction.easy_pay.getInstEmpty,
                com.neptune.cba.transaction.easy_pay.Institutions>(
                  this, METHODID_INSTITUTIONS)))
          .addMethod(
            getNameEnquiryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.neptune.cba.transaction.easy_pay.NameEnquiryRpcRequest,
                com.neptune.cba.transaction.easy_pay.NameEnquiryResponse>(
                  this, METHODID_NAME_ENQUIRY)))
          .addMethod(
            getListEasyPayMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.neptune.cba.transaction.easy_pay.EasyPayListRequest,
                com.neptune.cba.transaction.easy_pay.EasyPayListResponse>(
                  this, METHODID_LIST_EASY_PAY)))
          .addMethod(
            getReverseEasyPayMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.neptune.cba.transaction.easy_pay.ReverseRequest,
                com.neptune.cba.transaction.easy_pay.ReverseResponse>(
                  this, METHODID_REVERSE_EASY_PAY)))
          .addMethod(
            getEasyPayStatusMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest,
                com.neptune.cba.transaction.easy_pay.EasyPayStatusResponse>(
                  this, METHODID_EASY_PAY_STATUS)))
          .build();
    }
  }

  /**
   */
  public static final class EasyPayServiceStub extends io.grpc.stub.AbstractAsyncStub<EasyPayServiceStub> {
    private EasyPayServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EasyPayServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EasyPayServiceStub(channel, callOptions);
    }

    /**
     */
    public void easyPay(com.neptune.cba.transaction.easy_pay.EasyPayRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.easy_pay.EasyPayResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEasyPayMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void institutions(com.neptune.cba.transaction.easy_pay.getInstEmpty request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.easy_pay.Institutions> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInstitutionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void nameEnquiry(com.neptune.cba.transaction.easy_pay.NameEnquiryRpcRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.easy_pay.NameEnquiryResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getNameEnquiryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listEasyPay(com.neptune.cba.transaction.easy_pay.EasyPayListRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.easy_pay.EasyPayListResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEasyPayMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void reverseEasyPay(com.neptune.cba.transaction.easy_pay.ReverseRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.easy_pay.ReverseResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReverseEasyPayMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void easyPayStatus(com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.easy_pay.EasyPayStatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEasyPayStatusMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class EasyPayServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<EasyPayServiceBlockingStub> {
    private EasyPayServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EasyPayServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EasyPayServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.neptune.cba.transaction.easy_pay.EasyPayResponse easyPay(com.neptune.cba.transaction.easy_pay.EasyPayRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEasyPayMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.neptune.cba.transaction.easy_pay.Institutions institutions(com.neptune.cba.transaction.easy_pay.getInstEmpty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInstitutionsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.neptune.cba.transaction.easy_pay.NameEnquiryResponse nameEnquiry(com.neptune.cba.transaction.easy_pay.NameEnquiryRpcRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getNameEnquiryMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.neptune.cba.transaction.easy_pay.EasyPayListResponse listEasyPay(com.neptune.cba.transaction.easy_pay.EasyPayListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEasyPayMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.neptune.cba.transaction.easy_pay.ReverseResponse reverseEasyPay(com.neptune.cba.transaction.easy_pay.ReverseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReverseEasyPayMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.neptune.cba.transaction.easy_pay.EasyPayStatusResponse easyPayStatus(com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEasyPayStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class EasyPayServiceFutureStub extends io.grpc.stub.AbstractFutureStub<EasyPayServiceFutureStub> {
    private EasyPayServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EasyPayServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EasyPayServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.neptune.cba.transaction.easy_pay.EasyPayResponse> easyPay(
        com.neptune.cba.transaction.easy_pay.EasyPayRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEasyPayMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.neptune.cba.transaction.easy_pay.Institutions> institutions(
        com.neptune.cba.transaction.easy_pay.getInstEmpty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInstitutionsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.neptune.cba.transaction.easy_pay.NameEnquiryResponse> nameEnquiry(
        com.neptune.cba.transaction.easy_pay.NameEnquiryRpcRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getNameEnquiryMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.neptune.cba.transaction.easy_pay.EasyPayListResponse> listEasyPay(
        com.neptune.cba.transaction.easy_pay.EasyPayListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEasyPayMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.neptune.cba.transaction.easy_pay.ReverseResponse> reverseEasyPay(
        com.neptune.cba.transaction.easy_pay.ReverseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReverseEasyPayMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.neptune.cba.transaction.easy_pay.EasyPayStatusResponse> easyPayStatus(
        com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEasyPayStatusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_EASY_PAY = 0;
  private static final int METHODID_INSTITUTIONS = 1;
  private static final int METHODID_NAME_ENQUIRY = 2;
  private static final int METHODID_LIST_EASY_PAY = 3;
  private static final int METHODID_REVERSE_EASY_PAY = 4;
  private static final int METHODID_EASY_PAY_STATUS = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EasyPayServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EasyPayServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_EASY_PAY:
          serviceImpl.easyPay((com.neptune.cba.transaction.easy_pay.EasyPayRequest) request,
              (io.grpc.stub.StreamObserver<com.neptune.cba.transaction.easy_pay.EasyPayResponse>) responseObserver);
          break;
        case METHODID_INSTITUTIONS:
          serviceImpl.institutions((com.neptune.cba.transaction.easy_pay.getInstEmpty) request,
              (io.grpc.stub.StreamObserver<com.neptune.cba.transaction.easy_pay.Institutions>) responseObserver);
          break;
        case METHODID_NAME_ENQUIRY:
          serviceImpl.nameEnquiry((com.neptune.cba.transaction.easy_pay.NameEnquiryRpcRequest) request,
              (io.grpc.stub.StreamObserver<com.neptune.cba.transaction.easy_pay.NameEnquiryResponse>) responseObserver);
          break;
        case METHODID_LIST_EASY_PAY:
          serviceImpl.listEasyPay((com.neptune.cba.transaction.easy_pay.EasyPayListRequest) request,
              (io.grpc.stub.StreamObserver<com.neptune.cba.transaction.easy_pay.EasyPayListResponse>) responseObserver);
          break;
        case METHODID_REVERSE_EASY_PAY:
          serviceImpl.reverseEasyPay((com.neptune.cba.transaction.easy_pay.ReverseRequest) request,
              (io.grpc.stub.StreamObserver<com.neptune.cba.transaction.easy_pay.ReverseResponse>) responseObserver);
          break;
        case METHODID_EASY_PAY_STATUS:
          serviceImpl.easyPayStatus((com.neptune.cba.transaction.easy_pay.EasyPayStatusRequest) request,
              (io.grpc.stub.StreamObserver<com.neptune.cba.transaction.easy_pay.EasyPayStatusResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class EasyPayServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EasyPayServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.neptune.cba.transaction.easy_pay.Easypay.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EasyPayService");
    }
  }

  private static final class EasyPayServiceFileDescriptorSupplier
      extends EasyPayServiceBaseDescriptorSupplier {
    EasyPayServiceFileDescriptorSupplier() {}
  }

  private static final class EasyPayServiceMethodDescriptorSupplier
      extends EasyPayServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EasyPayServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (EasyPayServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EasyPayServiceFileDescriptorSupplier())
              .addMethod(getEasyPayMethod())
              .addMethod(getInstitutionsMethod())
              .addMethod(getNameEnquiryMethod())
              .addMethod(getListEasyPayMethod())
              .addMethod(getReverseEasyPayMethod())
              .addMethod(getEasyPayStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}
