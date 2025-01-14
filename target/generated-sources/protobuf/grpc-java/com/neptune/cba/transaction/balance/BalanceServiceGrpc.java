package com.neptune.cba.transaction.balance;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: balance.proto")
public final class BalanceServiceGrpc {

  private BalanceServiceGrpc() {}

  public static final String SERVICE_NAME = "com.neptune.cba.BalanceService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.neptune.cba.transaction.balance.BalanceRequest,
      com.neptune.cba.transaction.balance.BalanceResponse> getBalanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "balance",
      requestType = com.neptune.cba.transaction.balance.BalanceRequest.class,
      responseType = com.neptune.cba.transaction.balance.BalanceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.neptune.cba.transaction.balance.BalanceRequest,
      com.neptune.cba.transaction.balance.BalanceResponse> getBalanceMethod() {
    io.grpc.MethodDescriptor<com.neptune.cba.transaction.balance.BalanceRequest, com.neptune.cba.transaction.balance.BalanceResponse> getBalanceMethod;
    if ((getBalanceMethod = BalanceServiceGrpc.getBalanceMethod) == null) {
      synchronized (BalanceServiceGrpc.class) {
        if ((getBalanceMethod = BalanceServiceGrpc.getBalanceMethod) == null) {
          BalanceServiceGrpc.getBalanceMethod = getBalanceMethod =
              io.grpc.MethodDescriptor.<com.neptune.cba.transaction.balance.BalanceRequest, com.neptune.cba.transaction.balance.BalanceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "balance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.balance.BalanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.balance.BalanceResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BalanceServiceMethodDescriptorSupplier("balance"))
              .build();
        }
      }
    }
    return getBalanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.neptune.cba.transaction.balance.BulkBalanceRequest,
      com.neptune.cba.transaction.balance.BulkBalanceResponse> getBulkBalanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "bulk_balance",
      requestType = com.neptune.cba.transaction.balance.BulkBalanceRequest.class,
      responseType = com.neptune.cba.transaction.balance.BulkBalanceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.neptune.cba.transaction.balance.BulkBalanceRequest,
      com.neptune.cba.transaction.balance.BulkBalanceResponse> getBulkBalanceMethod() {
    io.grpc.MethodDescriptor<com.neptune.cba.transaction.balance.BulkBalanceRequest, com.neptune.cba.transaction.balance.BulkBalanceResponse> getBulkBalanceMethod;
    if ((getBulkBalanceMethod = BalanceServiceGrpc.getBulkBalanceMethod) == null) {
      synchronized (BalanceServiceGrpc.class) {
        if ((getBulkBalanceMethod = BalanceServiceGrpc.getBulkBalanceMethod) == null) {
          BalanceServiceGrpc.getBulkBalanceMethod = getBulkBalanceMethod =
              io.grpc.MethodDescriptor.<com.neptune.cba.transaction.balance.BulkBalanceRequest, com.neptune.cba.transaction.balance.BulkBalanceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "bulk_balance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.balance.BulkBalanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.balance.BulkBalanceResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BalanceServiceMethodDescriptorSupplier("bulk_balance"))
              .build();
        }
      }
    }
    return getBulkBalanceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BalanceServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BalanceServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BalanceServiceStub>() {
        @java.lang.Override
        public BalanceServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BalanceServiceStub(channel, callOptions);
        }
      };
    return BalanceServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BalanceServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BalanceServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BalanceServiceBlockingStub>() {
        @java.lang.Override
        public BalanceServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BalanceServiceBlockingStub(channel, callOptions);
        }
      };
    return BalanceServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BalanceServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BalanceServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BalanceServiceFutureStub>() {
        @java.lang.Override
        public BalanceServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BalanceServiceFutureStub(channel, callOptions);
        }
      };
    return BalanceServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class BalanceServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void balance(com.neptune.cba.transaction.balance.BalanceRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.balance.BalanceResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBalanceMethod(), responseObserver);
    }

    /**
     */
    public void bulkBalance(com.neptune.cba.transaction.balance.BulkBalanceRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.balance.BulkBalanceResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBulkBalanceMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getBalanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.neptune.cba.transaction.balance.BalanceRequest,
                com.neptune.cba.transaction.balance.BalanceResponse>(
                  this, METHODID_BALANCE)))
          .addMethod(
            getBulkBalanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.neptune.cba.transaction.balance.BulkBalanceRequest,
                com.neptune.cba.transaction.balance.BulkBalanceResponse>(
                  this, METHODID_BULK_BALANCE)))
          .build();
    }
  }

  /**
   */
  public static final class BalanceServiceStub extends io.grpc.stub.AbstractAsyncStub<BalanceServiceStub> {
    private BalanceServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BalanceServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BalanceServiceStub(channel, callOptions);
    }

    /**
     */
    public void balance(com.neptune.cba.transaction.balance.BalanceRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.balance.BalanceResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBalanceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void bulkBalance(com.neptune.cba.transaction.balance.BulkBalanceRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.balance.BulkBalanceResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBulkBalanceMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BalanceServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<BalanceServiceBlockingStub> {
    private BalanceServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BalanceServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BalanceServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.neptune.cba.transaction.balance.BalanceResponse balance(com.neptune.cba.transaction.balance.BalanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBalanceMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.neptune.cba.transaction.balance.BulkBalanceResponse bulkBalance(com.neptune.cba.transaction.balance.BulkBalanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBulkBalanceMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BalanceServiceFutureStub extends io.grpc.stub.AbstractFutureStub<BalanceServiceFutureStub> {
    private BalanceServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BalanceServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BalanceServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.neptune.cba.transaction.balance.BalanceResponse> balance(
        com.neptune.cba.transaction.balance.BalanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBalanceMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.neptune.cba.transaction.balance.BulkBalanceResponse> bulkBalance(
        com.neptune.cba.transaction.balance.BulkBalanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBulkBalanceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_BALANCE = 0;
  private static final int METHODID_BULK_BALANCE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BalanceServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BalanceServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_BALANCE:
          serviceImpl.balance((com.neptune.cba.transaction.balance.BalanceRequest) request,
              (io.grpc.stub.StreamObserver<com.neptune.cba.transaction.balance.BalanceResponse>) responseObserver);
          break;
        case METHODID_BULK_BALANCE:
          serviceImpl.bulkBalance((com.neptune.cba.transaction.balance.BulkBalanceRequest) request,
              (io.grpc.stub.StreamObserver<com.neptune.cba.transaction.balance.BulkBalanceResponse>) responseObserver);
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

  private static abstract class BalanceServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BalanceServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.neptune.cba.transaction.balance.Balance.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BalanceService");
    }
  }

  private static final class BalanceServiceFileDescriptorSupplier
      extends BalanceServiceBaseDescriptorSupplier {
    BalanceServiceFileDescriptorSupplier() {}
  }

  private static final class BalanceServiceMethodDescriptorSupplier
      extends BalanceServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BalanceServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (BalanceServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BalanceServiceFileDescriptorSupplier())
              .addMethod(getBalanceMethod())
              .addMethod(getBulkBalanceMethod())
              .build();
        }
      }
    }
    return result;
  }
}
