package com.neptune.cba.transaction.history;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: history.proto")
public final class HistoryServiceGrpc {

  private HistoryServiceGrpc() {}

  public static final String SERVICE_NAME = "com.neptune.cba.HistoryService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.neptune.cba.transaction.history.HistoryRequest,
      com.neptune.cba.transaction.history.HistoryResponse> getHistoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "history",
      requestType = com.neptune.cba.transaction.history.HistoryRequest.class,
      responseType = com.neptune.cba.transaction.history.HistoryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.neptune.cba.transaction.history.HistoryRequest,
      com.neptune.cba.transaction.history.HistoryResponse> getHistoryMethod() {
    io.grpc.MethodDescriptor<com.neptune.cba.transaction.history.HistoryRequest, com.neptune.cba.transaction.history.HistoryResponse> getHistoryMethod;
    if ((getHistoryMethod = HistoryServiceGrpc.getHistoryMethod) == null) {
      synchronized (HistoryServiceGrpc.class) {
        if ((getHistoryMethod = HistoryServiceGrpc.getHistoryMethod) == null) {
          HistoryServiceGrpc.getHistoryMethod = getHistoryMethod =
              io.grpc.MethodDescriptor.<com.neptune.cba.transaction.history.HistoryRequest, com.neptune.cba.transaction.history.HistoryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "history"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.history.HistoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.history.HistoryResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HistoryServiceMethodDescriptorSupplier("history"))
              .build();
        }
      }
    }
    return getHistoryMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HistoryServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HistoryServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HistoryServiceStub>() {
        @java.lang.Override
        public HistoryServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HistoryServiceStub(channel, callOptions);
        }
      };
    return HistoryServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HistoryServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HistoryServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HistoryServiceBlockingStub>() {
        @java.lang.Override
        public HistoryServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HistoryServiceBlockingStub(channel, callOptions);
        }
      };
    return HistoryServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HistoryServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HistoryServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HistoryServiceFutureStub>() {
        @java.lang.Override
        public HistoryServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HistoryServiceFutureStub(channel, callOptions);
        }
      };
    return HistoryServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class HistoryServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void history(com.neptune.cba.transaction.history.HistoryRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.history.HistoryResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getHistoryMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getHistoryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.neptune.cba.transaction.history.HistoryRequest,
                com.neptune.cba.transaction.history.HistoryResponse>(
                  this, METHODID_HISTORY)))
          .build();
    }
  }

  /**
   */
  public static final class HistoryServiceStub extends io.grpc.stub.AbstractAsyncStub<HistoryServiceStub> {
    private HistoryServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HistoryServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HistoryServiceStub(channel, callOptions);
    }

    /**
     */
    public void history(com.neptune.cba.transaction.history.HistoryRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.history.HistoryResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getHistoryMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class HistoryServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<HistoryServiceBlockingStub> {
    private HistoryServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HistoryServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HistoryServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.neptune.cba.transaction.history.HistoryResponse history(com.neptune.cba.transaction.history.HistoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getHistoryMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class HistoryServiceFutureStub extends io.grpc.stub.AbstractFutureStub<HistoryServiceFutureStub> {
    private HistoryServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HistoryServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HistoryServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.neptune.cba.transaction.history.HistoryResponse> history(
        com.neptune.cba.transaction.history.HistoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getHistoryMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_HISTORY = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HistoryServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HistoryServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_HISTORY:
          serviceImpl.history((com.neptune.cba.transaction.history.HistoryRequest) request,
              (io.grpc.stub.StreamObserver<com.neptune.cba.transaction.history.HistoryResponse>) responseObserver);
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

  private static abstract class HistoryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HistoryServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.neptune.cba.transaction.history.History.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HistoryService");
    }
  }

  private static final class HistoryServiceFileDescriptorSupplier
      extends HistoryServiceBaseDescriptorSupplier {
    HistoryServiceFileDescriptorSupplier() {}
  }

  private static final class HistoryServiceMethodDescriptorSupplier
      extends HistoryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HistoryServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (HistoryServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HistoryServiceFileDescriptorSupplier())
              .addMethod(getHistoryMethod())
              .build();
        }
      }
    }
    return result;
  }
}
