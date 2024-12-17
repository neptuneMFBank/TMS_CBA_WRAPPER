package com.virtualAccountApplication.createAccount.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: virtualAccount.proto")
public final class GetAccountServiceGrpc {

  private GetAccountServiceGrpc() {}

  public static final String SERVICE_NAME = "GetAccountService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.virtualAccountApplication.createAccount.proto.GetAccountRequest,
      com.virtualAccountApplication.createAccount.proto.GetAccountResponse> getGetAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAccount",
      requestType = com.virtualAccountApplication.createAccount.proto.GetAccountRequest.class,
      responseType = com.virtualAccountApplication.createAccount.proto.GetAccountResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.virtualAccountApplication.createAccount.proto.GetAccountRequest,
      com.virtualAccountApplication.createAccount.proto.GetAccountResponse> getGetAccountMethod() {
    io.grpc.MethodDescriptor<com.virtualAccountApplication.createAccount.proto.GetAccountRequest, com.virtualAccountApplication.createAccount.proto.GetAccountResponse> getGetAccountMethod;
    if ((getGetAccountMethod = GetAccountServiceGrpc.getGetAccountMethod) == null) {
      synchronized (GetAccountServiceGrpc.class) {
        if ((getGetAccountMethod = GetAccountServiceGrpc.getGetAccountMethod) == null) {
          GetAccountServiceGrpc.getGetAccountMethod = getGetAccountMethod =
              io.grpc.MethodDescriptor.<com.virtualAccountApplication.createAccount.proto.GetAccountRequest, com.virtualAccountApplication.createAccount.proto.GetAccountResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAccount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.virtualAccountApplication.createAccount.proto.GetAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.virtualAccountApplication.createAccount.proto.GetAccountResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GetAccountServiceMethodDescriptorSupplier("GetAccount"))
              .build();
        }
      }
    }
    return getGetAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.virtualAccountApplication.createAccount.proto.GetAccountsRequest,
      com.virtualAccountApplication.createAccount.proto.GetAccountsResponse> getGetAccountsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAccounts",
      requestType = com.virtualAccountApplication.createAccount.proto.GetAccountsRequest.class,
      responseType = com.virtualAccountApplication.createAccount.proto.GetAccountsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.virtualAccountApplication.createAccount.proto.GetAccountsRequest,
      com.virtualAccountApplication.createAccount.proto.GetAccountsResponse> getGetAccountsMethod() {
    io.grpc.MethodDescriptor<com.virtualAccountApplication.createAccount.proto.GetAccountsRequest, com.virtualAccountApplication.createAccount.proto.GetAccountsResponse> getGetAccountsMethod;
    if ((getGetAccountsMethod = GetAccountServiceGrpc.getGetAccountsMethod) == null) {
      synchronized (GetAccountServiceGrpc.class) {
        if ((getGetAccountsMethod = GetAccountServiceGrpc.getGetAccountsMethod) == null) {
          GetAccountServiceGrpc.getGetAccountsMethod = getGetAccountsMethod =
              io.grpc.MethodDescriptor.<com.virtualAccountApplication.createAccount.proto.GetAccountsRequest, com.virtualAccountApplication.createAccount.proto.GetAccountsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAccounts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.virtualAccountApplication.createAccount.proto.GetAccountsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.virtualAccountApplication.createAccount.proto.GetAccountsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GetAccountServiceMethodDescriptorSupplier("GetAccounts"))
              .build();
        }
      }
    }
    return getGetAccountsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.virtualAccountApplication.createAccount.proto.Get3ppAccountsRequest,
      com.virtualAccountApplication.createAccount.proto.Get3ppAccountsResponse> getGet3ppAccountsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Get3ppAccounts",
      requestType = com.virtualAccountApplication.createAccount.proto.Get3ppAccountsRequest.class,
      responseType = com.virtualAccountApplication.createAccount.proto.Get3ppAccountsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.virtualAccountApplication.createAccount.proto.Get3ppAccountsRequest,
      com.virtualAccountApplication.createAccount.proto.Get3ppAccountsResponse> getGet3ppAccountsMethod() {
    io.grpc.MethodDescriptor<com.virtualAccountApplication.createAccount.proto.Get3ppAccountsRequest, com.virtualAccountApplication.createAccount.proto.Get3ppAccountsResponse> getGet3ppAccountsMethod;
    if ((getGet3ppAccountsMethod = GetAccountServiceGrpc.getGet3ppAccountsMethod) == null) {
      synchronized (GetAccountServiceGrpc.class) {
        if ((getGet3ppAccountsMethod = GetAccountServiceGrpc.getGet3ppAccountsMethod) == null) {
          GetAccountServiceGrpc.getGet3ppAccountsMethod = getGet3ppAccountsMethod =
              io.grpc.MethodDescriptor.<com.virtualAccountApplication.createAccount.proto.Get3ppAccountsRequest, com.virtualAccountApplication.createAccount.proto.Get3ppAccountsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Get3ppAccounts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.virtualAccountApplication.createAccount.proto.Get3ppAccountsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.virtualAccountApplication.createAccount.proto.Get3ppAccountsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GetAccountServiceMethodDescriptorSupplier("Get3ppAccounts"))
              .build();
        }
      }
    }
    return getGet3ppAccountsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.virtualAccountApplication.createAccount.proto.NameEnquiryRequest,
      com.virtualAccountApplication.createAccount.proto.NameEnquiryResponse> getNameEnquiryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "NameEnquiry",
      requestType = com.virtualAccountApplication.createAccount.proto.NameEnquiryRequest.class,
      responseType = com.virtualAccountApplication.createAccount.proto.NameEnquiryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.virtualAccountApplication.createAccount.proto.NameEnquiryRequest,
      com.virtualAccountApplication.createAccount.proto.NameEnquiryResponse> getNameEnquiryMethod() {
    io.grpc.MethodDescriptor<com.virtualAccountApplication.createAccount.proto.NameEnquiryRequest, com.virtualAccountApplication.createAccount.proto.NameEnquiryResponse> getNameEnquiryMethod;
    if ((getNameEnquiryMethod = GetAccountServiceGrpc.getNameEnquiryMethod) == null) {
      synchronized (GetAccountServiceGrpc.class) {
        if ((getNameEnquiryMethod = GetAccountServiceGrpc.getNameEnquiryMethod) == null) {
          GetAccountServiceGrpc.getNameEnquiryMethod = getNameEnquiryMethod =
              io.grpc.MethodDescriptor.<com.virtualAccountApplication.createAccount.proto.NameEnquiryRequest, com.virtualAccountApplication.createAccount.proto.NameEnquiryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "NameEnquiry"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.virtualAccountApplication.createAccount.proto.NameEnquiryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.virtualAccountApplication.createAccount.proto.NameEnquiryResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GetAccountServiceMethodDescriptorSupplier("NameEnquiry"))
              .build();
        }
      }
    }
    return getNameEnquiryMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GetAccountServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GetAccountServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GetAccountServiceStub>() {
        @java.lang.Override
        public GetAccountServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GetAccountServiceStub(channel, callOptions);
        }
      };
    return GetAccountServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GetAccountServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GetAccountServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GetAccountServiceBlockingStub>() {
        @java.lang.Override
        public GetAccountServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GetAccountServiceBlockingStub(channel, callOptions);
        }
      };
    return GetAccountServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GetAccountServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GetAccountServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GetAccountServiceFutureStub>() {
        @java.lang.Override
        public GetAccountServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GetAccountServiceFutureStub(channel, callOptions);
        }
      };
    return GetAccountServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class GetAccountServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getAccount(com.virtualAccountApplication.createAccount.proto.GetAccountRequest request,
        io.grpc.stub.StreamObserver<com.virtualAccountApplication.createAccount.proto.GetAccountResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAccountMethod(), responseObserver);
    }

    /**
     */
    public void getAccounts(com.virtualAccountApplication.createAccount.proto.GetAccountsRequest request,
        io.grpc.stub.StreamObserver<com.virtualAccountApplication.createAccount.proto.GetAccountsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAccountsMethod(), responseObserver);
    }

    /**
     */
    public void get3ppAccounts(com.virtualAccountApplication.createAccount.proto.Get3ppAccountsRequest request,
        io.grpc.stub.StreamObserver<com.virtualAccountApplication.createAccount.proto.Get3ppAccountsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGet3ppAccountsMethod(), responseObserver);
    }

    /**
     */
    public void nameEnquiry(com.virtualAccountApplication.createAccount.proto.NameEnquiryRequest request,
        io.grpc.stub.StreamObserver<com.virtualAccountApplication.createAccount.proto.NameEnquiryResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getNameEnquiryMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetAccountMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.virtualAccountApplication.createAccount.proto.GetAccountRequest,
                com.virtualAccountApplication.createAccount.proto.GetAccountResponse>(
                  this, METHODID_GET_ACCOUNT)))
          .addMethod(
            getGetAccountsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.virtualAccountApplication.createAccount.proto.GetAccountsRequest,
                com.virtualAccountApplication.createAccount.proto.GetAccountsResponse>(
                  this, METHODID_GET_ACCOUNTS)))
          .addMethod(
            getGet3ppAccountsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.virtualAccountApplication.createAccount.proto.Get3ppAccountsRequest,
                com.virtualAccountApplication.createAccount.proto.Get3ppAccountsResponse>(
                  this, METHODID_GET3PP_ACCOUNTS)))
          .addMethod(
            getNameEnquiryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.virtualAccountApplication.createAccount.proto.NameEnquiryRequest,
                com.virtualAccountApplication.createAccount.proto.NameEnquiryResponse>(
                  this, METHODID_NAME_ENQUIRY)))
          .build();
    }
  }

  /**
   */
  public static final class GetAccountServiceStub extends io.grpc.stub.AbstractAsyncStub<GetAccountServiceStub> {
    private GetAccountServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GetAccountServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GetAccountServiceStub(channel, callOptions);
    }

    /**
     */
    public void getAccount(com.virtualAccountApplication.createAccount.proto.GetAccountRequest request,
        io.grpc.stub.StreamObserver<com.virtualAccountApplication.createAccount.proto.GetAccountResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAccountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAccounts(com.virtualAccountApplication.createAccount.proto.GetAccountsRequest request,
        io.grpc.stub.StreamObserver<com.virtualAccountApplication.createAccount.proto.GetAccountsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAccountsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void get3ppAccounts(com.virtualAccountApplication.createAccount.proto.Get3ppAccountsRequest request,
        io.grpc.stub.StreamObserver<com.virtualAccountApplication.createAccount.proto.Get3ppAccountsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGet3ppAccountsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void nameEnquiry(com.virtualAccountApplication.createAccount.proto.NameEnquiryRequest request,
        io.grpc.stub.StreamObserver<com.virtualAccountApplication.createAccount.proto.NameEnquiryResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getNameEnquiryMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class GetAccountServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<GetAccountServiceBlockingStub> {
    private GetAccountServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GetAccountServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GetAccountServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.virtualAccountApplication.createAccount.proto.GetAccountResponse getAccount(com.virtualAccountApplication.createAccount.proto.GetAccountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAccountMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.virtualAccountApplication.createAccount.proto.GetAccountsResponse getAccounts(com.virtualAccountApplication.createAccount.proto.GetAccountsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAccountsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.virtualAccountApplication.createAccount.proto.Get3ppAccountsResponse get3ppAccounts(com.virtualAccountApplication.createAccount.proto.Get3ppAccountsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGet3ppAccountsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.virtualAccountApplication.createAccount.proto.NameEnquiryResponse nameEnquiry(com.virtualAccountApplication.createAccount.proto.NameEnquiryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getNameEnquiryMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class GetAccountServiceFutureStub extends io.grpc.stub.AbstractFutureStub<GetAccountServiceFutureStub> {
    private GetAccountServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GetAccountServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GetAccountServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.virtualAccountApplication.createAccount.proto.GetAccountResponse> getAccount(
        com.virtualAccountApplication.createAccount.proto.GetAccountRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAccountMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.virtualAccountApplication.createAccount.proto.GetAccountsResponse> getAccounts(
        com.virtualAccountApplication.createAccount.proto.GetAccountsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAccountsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.virtualAccountApplication.createAccount.proto.Get3ppAccountsResponse> get3ppAccounts(
        com.virtualAccountApplication.createAccount.proto.Get3ppAccountsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGet3ppAccountsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.virtualAccountApplication.createAccount.proto.NameEnquiryResponse> nameEnquiry(
        com.virtualAccountApplication.createAccount.proto.NameEnquiryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getNameEnquiryMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ACCOUNT = 0;
  private static final int METHODID_GET_ACCOUNTS = 1;
  private static final int METHODID_GET3PP_ACCOUNTS = 2;
  private static final int METHODID_NAME_ENQUIRY = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GetAccountServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GetAccountServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ACCOUNT:
          serviceImpl.getAccount((com.virtualAccountApplication.createAccount.proto.GetAccountRequest) request,
              (io.grpc.stub.StreamObserver<com.virtualAccountApplication.createAccount.proto.GetAccountResponse>) responseObserver);
          break;
        case METHODID_GET_ACCOUNTS:
          serviceImpl.getAccounts((com.virtualAccountApplication.createAccount.proto.GetAccountsRequest) request,
              (io.grpc.stub.StreamObserver<com.virtualAccountApplication.createAccount.proto.GetAccountsResponse>) responseObserver);
          break;
        case METHODID_GET3PP_ACCOUNTS:
          serviceImpl.get3ppAccounts((com.virtualAccountApplication.createAccount.proto.Get3ppAccountsRequest) request,
              (io.grpc.stub.StreamObserver<com.virtualAccountApplication.createAccount.proto.Get3ppAccountsResponse>) responseObserver);
          break;
        case METHODID_NAME_ENQUIRY:
          serviceImpl.nameEnquiry((com.virtualAccountApplication.createAccount.proto.NameEnquiryRequest) request,
              (io.grpc.stub.StreamObserver<com.virtualAccountApplication.createAccount.proto.NameEnquiryResponse>) responseObserver);
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

  private static abstract class GetAccountServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GetAccountServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.virtualAccountApplication.createAccount.proto.VirtualAccount.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GetAccountService");
    }
  }

  private static final class GetAccountServiceFileDescriptorSupplier
      extends GetAccountServiceBaseDescriptorSupplier {
    GetAccountServiceFileDescriptorSupplier() {}
  }

  private static final class GetAccountServiceMethodDescriptorSupplier
      extends GetAccountServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GetAccountServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (GetAccountServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GetAccountServiceFileDescriptorSupplier())
              .addMethod(getGetAccountMethod())
              .addMethod(getGetAccountsMethod())
              .addMethod(getGet3ppAccountsMethod())
              .addMethod(getNameEnquiryMethod())
              .build();
        }
      }
    }
    return result;
  }
}
