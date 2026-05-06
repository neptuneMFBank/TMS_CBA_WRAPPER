package com.neptune.cba.transaction.intra_transfer;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: intratransfer.proto")
public final class IntraTransferServiceGrpc {

  private IntraTransferServiceGrpc() {}

  public static final String SERVICE_NAME = "com.neptune.cba.IntraTransferService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.neptune.cba.transaction.intra_transfer.IntraTransferRequest,
      com.neptune.cba.transaction.intra_transfer.IntraTransferResponse> getIntraTransferMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "intra_transfer",
      requestType = com.neptune.cba.transaction.intra_transfer.IntraTransferRequest.class,
      responseType = com.neptune.cba.transaction.intra_transfer.IntraTransferResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.neptune.cba.transaction.intra_transfer.IntraTransferRequest,
      com.neptune.cba.transaction.intra_transfer.IntraTransferResponse> getIntraTransferMethod() {
    io.grpc.MethodDescriptor<com.neptune.cba.transaction.intra_transfer.IntraTransferRequest, com.neptune.cba.transaction.intra_transfer.IntraTransferResponse> getIntraTransferMethod;
    if ((getIntraTransferMethod = IntraTransferServiceGrpc.getIntraTransferMethod) == null) {
      synchronized (IntraTransferServiceGrpc.class) {
        if ((getIntraTransferMethod = IntraTransferServiceGrpc.getIntraTransferMethod) == null) {
          IntraTransferServiceGrpc.getIntraTransferMethod = getIntraTransferMethod =
              io.grpc.MethodDescriptor.<com.neptune.cba.transaction.intra_transfer.IntraTransferRequest, com.neptune.cba.transaction.intra_transfer.IntraTransferResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "intra_transfer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.intra_transfer.IntraTransferRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.intra_transfer.IntraTransferResponse.getDefaultInstance()))
              .setSchemaDescriptor(new IntraTransferServiceMethodDescriptorSupplier("intra_transfer"))
              .build();
        }
      }
    }
    return getIntraTransferMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.neptune.cba.transaction.intra_transfer.IntraTransferApprovalRequest,
      com.neptune.cba.transaction.intra_transfer.IntraTransferApprovalResponse> getIntraTransferApprovalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "intra_transfer_approval",
      requestType = com.neptune.cba.transaction.intra_transfer.IntraTransferApprovalRequest.class,
      responseType = com.neptune.cba.transaction.intra_transfer.IntraTransferApprovalResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.neptune.cba.transaction.intra_transfer.IntraTransferApprovalRequest,
      com.neptune.cba.transaction.intra_transfer.IntraTransferApprovalResponse> getIntraTransferApprovalMethod() {
    io.grpc.MethodDescriptor<com.neptune.cba.transaction.intra_transfer.IntraTransferApprovalRequest, com.neptune.cba.transaction.intra_transfer.IntraTransferApprovalResponse> getIntraTransferApprovalMethod;
    if ((getIntraTransferApprovalMethod = IntraTransferServiceGrpc.getIntraTransferApprovalMethod) == null) {
      synchronized (IntraTransferServiceGrpc.class) {
        if ((getIntraTransferApprovalMethod = IntraTransferServiceGrpc.getIntraTransferApprovalMethod) == null) {
          IntraTransferServiceGrpc.getIntraTransferApprovalMethod = getIntraTransferApprovalMethod =
              io.grpc.MethodDescriptor.<com.neptune.cba.transaction.intra_transfer.IntraTransferApprovalRequest, com.neptune.cba.transaction.intra_transfer.IntraTransferApprovalResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "intra_transfer_approval"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.intra_transfer.IntraTransferApprovalRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.intra_transfer.IntraTransferApprovalResponse.getDefaultInstance()))
              .setSchemaDescriptor(new IntraTransferServiceMethodDescriptorSupplier("intra_transfer_approval"))
              .build();
        }
      }
    }
    return getIntraTransferApprovalMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static IntraTransferServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IntraTransferServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IntraTransferServiceStub>() {
        @java.lang.Override
        public IntraTransferServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IntraTransferServiceStub(channel, callOptions);
        }
      };
    return IntraTransferServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static IntraTransferServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IntraTransferServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IntraTransferServiceBlockingStub>() {
        @java.lang.Override
        public IntraTransferServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IntraTransferServiceBlockingStub(channel, callOptions);
        }
      };
    return IntraTransferServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static IntraTransferServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IntraTransferServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IntraTransferServiceFutureStub>() {
        @java.lang.Override
        public IntraTransferServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IntraTransferServiceFutureStub(channel, callOptions);
        }
      };
    return IntraTransferServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class IntraTransferServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void intraTransfer(com.neptune.cba.transaction.intra_transfer.IntraTransferRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.intra_transfer.IntraTransferResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getIntraTransferMethod(), responseObserver);
    }

    /**
     */
    public void intraTransferApproval(com.neptune.cba.transaction.intra_transfer.IntraTransferApprovalRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.intra_transfer.IntraTransferApprovalResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getIntraTransferApprovalMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getIntraTransferMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.neptune.cba.transaction.intra_transfer.IntraTransferRequest,
                com.neptune.cba.transaction.intra_transfer.IntraTransferResponse>(
                  this, METHODID_INTRA_TRANSFER)))
          .addMethod(
            getIntraTransferApprovalMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.neptune.cba.transaction.intra_transfer.IntraTransferApprovalRequest,
                com.neptune.cba.transaction.intra_transfer.IntraTransferApprovalResponse>(
                  this, METHODID_INTRA_TRANSFER_APPROVAL)))
          .build();
    }
  }

  /**
   */
  public static final class IntraTransferServiceStub extends io.grpc.stub.AbstractAsyncStub<IntraTransferServiceStub> {
    private IntraTransferServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IntraTransferServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IntraTransferServiceStub(channel, callOptions);
    }

    /**
     */
    public void intraTransfer(com.neptune.cba.transaction.intra_transfer.IntraTransferRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.intra_transfer.IntraTransferResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getIntraTransferMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void intraTransferApproval(com.neptune.cba.transaction.intra_transfer.IntraTransferApprovalRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.intra_transfer.IntraTransferApprovalResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getIntraTransferApprovalMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class IntraTransferServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<IntraTransferServiceBlockingStub> {
    private IntraTransferServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IntraTransferServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IntraTransferServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.neptune.cba.transaction.intra_transfer.IntraTransferResponse intraTransfer(com.neptune.cba.transaction.intra_transfer.IntraTransferRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getIntraTransferMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.neptune.cba.transaction.intra_transfer.IntraTransferApprovalResponse intraTransferApproval(com.neptune.cba.transaction.intra_transfer.IntraTransferApprovalRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getIntraTransferApprovalMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class IntraTransferServiceFutureStub extends io.grpc.stub.AbstractFutureStub<IntraTransferServiceFutureStub> {
    private IntraTransferServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IntraTransferServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IntraTransferServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.neptune.cba.transaction.intra_transfer.IntraTransferResponse> intraTransfer(
        com.neptune.cba.transaction.intra_transfer.IntraTransferRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getIntraTransferMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.neptune.cba.transaction.intra_transfer.IntraTransferApprovalResponse> intraTransferApproval(
        com.neptune.cba.transaction.intra_transfer.IntraTransferApprovalRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getIntraTransferApprovalMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_INTRA_TRANSFER = 0;
  private static final int METHODID_INTRA_TRANSFER_APPROVAL = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final IntraTransferServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(IntraTransferServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_INTRA_TRANSFER:
          serviceImpl.intraTransfer((com.neptune.cba.transaction.intra_transfer.IntraTransferRequest) request,
              (io.grpc.stub.StreamObserver<com.neptune.cba.transaction.intra_transfer.IntraTransferResponse>) responseObserver);
          break;
        case METHODID_INTRA_TRANSFER_APPROVAL:
          serviceImpl.intraTransferApproval((com.neptune.cba.transaction.intra_transfer.IntraTransferApprovalRequest) request,
              (io.grpc.stub.StreamObserver<com.neptune.cba.transaction.intra_transfer.IntraTransferApprovalResponse>) responseObserver);
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

  private static abstract class IntraTransferServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    IntraTransferServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.neptune.cba.transaction.intra_transfer.Intratransfer.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("IntraTransferService");
    }
  }

  private static final class IntraTransferServiceFileDescriptorSupplier
      extends IntraTransferServiceBaseDescriptorSupplier {
    IntraTransferServiceFileDescriptorSupplier() {}
  }

  private static final class IntraTransferServiceMethodDescriptorSupplier
      extends IntraTransferServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    IntraTransferServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (IntraTransferServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new IntraTransferServiceFileDescriptorSupplier())
              .addMethod(getIntraTransferMethod())
              .addMethod(getIntraTransferApprovalMethod())
              .build();
        }
      }
    }
    return result;
  }
}
