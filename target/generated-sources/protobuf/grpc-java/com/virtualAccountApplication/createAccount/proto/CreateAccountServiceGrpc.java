package com.virtualAccountApplication.createAccount.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: virtualAccount.proto")
public final class CreateAccountServiceGrpc {

  private CreateAccountServiceGrpc() {}

  public static final String SERVICE_NAME = "CreateAccountService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.virtualAccountApplication.createAccount.proto.CreateAccountRequest,
      com.virtualAccountApplication.createAccount.proto.CreateAccountResponse> getCreateAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAccount",
      requestType = com.virtualAccountApplication.createAccount.proto.CreateAccountRequest.class,
      responseType = com.virtualAccountApplication.createAccount.proto.CreateAccountResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.virtualAccountApplication.createAccount.proto.CreateAccountRequest,
      com.virtualAccountApplication.createAccount.proto.CreateAccountResponse> getCreateAccountMethod() {
    io.grpc.MethodDescriptor<com.virtualAccountApplication.createAccount.proto.CreateAccountRequest, com.virtualAccountApplication.createAccount.proto.CreateAccountResponse> getCreateAccountMethod;
    if ((getCreateAccountMethod = CreateAccountServiceGrpc.getCreateAccountMethod) == null) {
      synchronized (CreateAccountServiceGrpc.class) {
        if ((getCreateAccountMethod = CreateAccountServiceGrpc.getCreateAccountMethod) == null) {
          CreateAccountServiceGrpc.getCreateAccountMethod = getCreateAccountMethod =
              io.grpc.MethodDescriptor.<com.virtualAccountApplication.createAccount.proto.CreateAccountRequest, com.virtualAccountApplication.createAccount.proto.CreateAccountResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAccount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.virtualAccountApplication.createAccount.proto.CreateAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.virtualAccountApplication.createAccount.proto.CreateAccountResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CreateAccountServiceMethodDescriptorSupplier("CreateAccount"))
              .build();
        }
      }
    }
    return getCreateAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.virtualAccountApplication.createAccount.proto.CreateBulkAccountRequest,
      com.virtualAccountApplication.createAccount.proto.CreateBulkAccResponse> getCreateBulkAccMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBulkAcc",
      requestType = com.virtualAccountApplication.createAccount.proto.CreateBulkAccountRequest.class,
      responseType = com.virtualAccountApplication.createAccount.proto.CreateBulkAccResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.virtualAccountApplication.createAccount.proto.CreateBulkAccountRequest,
      com.virtualAccountApplication.createAccount.proto.CreateBulkAccResponse> getCreateBulkAccMethod() {
    io.grpc.MethodDescriptor<com.virtualAccountApplication.createAccount.proto.CreateBulkAccountRequest, com.virtualAccountApplication.createAccount.proto.CreateBulkAccResponse> getCreateBulkAccMethod;
    if ((getCreateBulkAccMethod = CreateAccountServiceGrpc.getCreateBulkAccMethod) == null) {
      synchronized (CreateAccountServiceGrpc.class) {
        if ((getCreateBulkAccMethod = CreateAccountServiceGrpc.getCreateBulkAccMethod) == null) {
          CreateAccountServiceGrpc.getCreateBulkAccMethod = getCreateBulkAccMethod =
              io.grpc.MethodDescriptor.<com.virtualAccountApplication.createAccount.proto.CreateBulkAccountRequest, com.virtualAccountApplication.createAccount.proto.CreateBulkAccResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateBulkAcc"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.virtualAccountApplication.createAccount.proto.CreateBulkAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.virtualAccountApplication.createAccount.proto.CreateBulkAccResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CreateAccountServiceMethodDescriptorSupplier("CreateBulkAcc"))
              .build();
        }
      }
    }
    return getCreateBulkAccMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CreateAccountServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CreateAccountServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CreateAccountServiceStub>() {
        @java.lang.Override
        public CreateAccountServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CreateAccountServiceStub(channel, callOptions);
        }
      };
    return CreateAccountServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CreateAccountServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CreateAccountServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CreateAccountServiceBlockingStub>() {
        @java.lang.Override
        public CreateAccountServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CreateAccountServiceBlockingStub(channel, callOptions);
        }
      };
    return CreateAccountServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CreateAccountServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CreateAccountServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CreateAccountServiceFutureStub>() {
        @java.lang.Override
        public CreateAccountServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CreateAccountServiceFutureStub(channel, callOptions);
        }
      };
    return CreateAccountServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CreateAccountServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createAccount(com.virtualAccountApplication.createAccount.proto.CreateAccountRequest request,
        io.grpc.stub.StreamObserver<com.virtualAccountApplication.createAccount.proto.CreateAccountResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateAccountMethod(), responseObserver);
    }

    /**
     */
    public void createBulkAcc(com.virtualAccountApplication.createAccount.proto.CreateBulkAccountRequest request,
        io.grpc.stub.StreamObserver<com.virtualAccountApplication.createAccount.proto.CreateBulkAccResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateBulkAccMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateAccountMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.virtualAccountApplication.createAccount.proto.CreateAccountRequest,
                com.virtualAccountApplication.createAccount.proto.CreateAccountResponse>(
                  this, METHODID_CREATE_ACCOUNT)))
          .addMethod(
            getCreateBulkAccMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.virtualAccountApplication.createAccount.proto.CreateBulkAccountRequest,
                com.virtualAccountApplication.createAccount.proto.CreateBulkAccResponse>(
                  this, METHODID_CREATE_BULK_ACC)))
          .build();
    }
  }

  /**
   */
  public static final class CreateAccountServiceStub extends io.grpc.stub.AbstractAsyncStub<CreateAccountServiceStub> {
    private CreateAccountServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CreateAccountServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CreateAccountServiceStub(channel, callOptions);
    }

    /**
     */
    public void createAccount(com.virtualAccountApplication.createAccount.proto.CreateAccountRequest request,
        io.grpc.stub.StreamObserver<com.virtualAccountApplication.createAccount.proto.CreateAccountResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAccountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createBulkAcc(com.virtualAccountApplication.createAccount.proto.CreateBulkAccountRequest request,
        io.grpc.stub.StreamObserver<com.virtualAccountApplication.createAccount.proto.CreateBulkAccResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateBulkAccMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CreateAccountServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<CreateAccountServiceBlockingStub> {
    private CreateAccountServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CreateAccountServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CreateAccountServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.virtualAccountApplication.createAccount.proto.CreateAccountResponse createAccount(com.virtualAccountApplication.createAccount.proto.CreateAccountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAccountMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.virtualAccountApplication.createAccount.proto.CreateBulkAccResponse createBulkAcc(com.virtualAccountApplication.createAccount.proto.CreateBulkAccountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateBulkAccMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CreateAccountServiceFutureStub extends io.grpc.stub.AbstractFutureStub<CreateAccountServiceFutureStub> {
    private CreateAccountServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CreateAccountServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CreateAccountServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.virtualAccountApplication.createAccount.proto.CreateAccountResponse> createAccount(
        com.virtualAccountApplication.createAccount.proto.CreateAccountRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAccountMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.virtualAccountApplication.createAccount.proto.CreateBulkAccResponse> createBulkAcc(
        com.virtualAccountApplication.createAccount.proto.CreateBulkAccountRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateBulkAccMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_ACCOUNT = 0;
  private static final int METHODID_CREATE_BULK_ACC = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CreateAccountServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CreateAccountServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_ACCOUNT:
          serviceImpl.createAccount((com.virtualAccountApplication.createAccount.proto.CreateAccountRequest) request,
              (io.grpc.stub.StreamObserver<com.virtualAccountApplication.createAccount.proto.CreateAccountResponse>) responseObserver);
          break;
        case METHODID_CREATE_BULK_ACC:
          serviceImpl.createBulkAcc((com.virtualAccountApplication.createAccount.proto.CreateBulkAccountRequest) request,
              (io.grpc.stub.StreamObserver<com.virtualAccountApplication.createAccount.proto.CreateBulkAccResponse>) responseObserver);
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

  private static abstract class CreateAccountServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CreateAccountServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.virtualAccountApplication.createAccount.proto.VirtualAccount.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CreateAccountService");
    }
  }

  private static final class CreateAccountServiceFileDescriptorSupplier
      extends CreateAccountServiceBaseDescriptorSupplier {
    CreateAccountServiceFileDescriptorSupplier() {}
  }

  private static final class CreateAccountServiceMethodDescriptorSupplier
      extends CreateAccountServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CreateAccountServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CreateAccountServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CreateAccountServiceFileDescriptorSupplier())
              .addMethod(getCreateAccountMethod())
              .addMethod(getCreateBulkAccMethod())
              .build();
        }
      }
    }
    return result;
  }
}
