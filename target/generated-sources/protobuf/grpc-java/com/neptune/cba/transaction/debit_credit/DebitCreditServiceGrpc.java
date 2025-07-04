package com.neptune.cba.transaction.debit_credit;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: debitcredit.proto")
public final class DebitCreditServiceGrpc {

  private DebitCreditServiceGrpc() {}

  public static final String SERVICE_NAME = "com.neptune.cba.DebitCreditService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.neptune.cba.transaction.debit_credit.DebitCreditRequest,
      com.neptune.cba.transaction.debit_credit.DebitCreditResponse> getDebitCreditMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "debit_credit",
      requestType = com.neptune.cba.transaction.debit_credit.DebitCreditRequest.class,
      responseType = com.neptune.cba.transaction.debit_credit.DebitCreditResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.neptune.cba.transaction.debit_credit.DebitCreditRequest,
      com.neptune.cba.transaction.debit_credit.DebitCreditResponse> getDebitCreditMethod() {
    io.grpc.MethodDescriptor<com.neptune.cba.transaction.debit_credit.DebitCreditRequest, com.neptune.cba.transaction.debit_credit.DebitCreditResponse> getDebitCreditMethod;
    if ((getDebitCreditMethod = DebitCreditServiceGrpc.getDebitCreditMethod) == null) {
      synchronized (DebitCreditServiceGrpc.class) {
        if ((getDebitCreditMethod = DebitCreditServiceGrpc.getDebitCreditMethod) == null) {
          DebitCreditServiceGrpc.getDebitCreditMethod = getDebitCreditMethod =
              io.grpc.MethodDescriptor.<com.neptune.cba.transaction.debit_credit.DebitCreditRequest, com.neptune.cba.transaction.debit_credit.DebitCreditResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "debit_credit"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.debit_credit.DebitCreditRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.debit_credit.DebitCreditResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DebitCreditServiceMethodDescriptorSupplier("debit_credit"))
              .build();
        }
      }
    }
    return getDebitCreditMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.neptune.cba.transaction.debit_credit.DebitCreditStatusRequest,
      com.neptune.cba.transaction.debit_credit.DebitCreditStatusResponse> getDebitCreditStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "debit_credit_status",
      requestType = com.neptune.cba.transaction.debit_credit.DebitCreditStatusRequest.class,
      responseType = com.neptune.cba.transaction.debit_credit.DebitCreditStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.neptune.cba.transaction.debit_credit.DebitCreditStatusRequest,
      com.neptune.cba.transaction.debit_credit.DebitCreditStatusResponse> getDebitCreditStatusMethod() {
    io.grpc.MethodDescriptor<com.neptune.cba.transaction.debit_credit.DebitCreditStatusRequest, com.neptune.cba.transaction.debit_credit.DebitCreditStatusResponse> getDebitCreditStatusMethod;
    if ((getDebitCreditStatusMethod = DebitCreditServiceGrpc.getDebitCreditStatusMethod) == null) {
      synchronized (DebitCreditServiceGrpc.class) {
        if ((getDebitCreditStatusMethod = DebitCreditServiceGrpc.getDebitCreditStatusMethod) == null) {
          DebitCreditServiceGrpc.getDebitCreditStatusMethod = getDebitCreditStatusMethod =
              io.grpc.MethodDescriptor.<com.neptune.cba.transaction.debit_credit.DebitCreditStatusRequest, com.neptune.cba.transaction.debit_credit.DebitCreditStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "debit_credit_status"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.debit_credit.DebitCreditStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.debit_credit.DebitCreditStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DebitCreditServiceMethodDescriptorSupplier("debit_credit_status"))
              .build();
        }
      }
    }
    return getDebitCreditStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.neptune.cba.transaction.debit_credit.DebitCreditApprovalRequest,
      com.neptune.cba.transaction.debit_credit.DebitCreditApprovalResponse> getDebitCreditApprovalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "debit_credit_approval",
      requestType = com.neptune.cba.transaction.debit_credit.DebitCreditApprovalRequest.class,
      responseType = com.neptune.cba.transaction.debit_credit.DebitCreditApprovalResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.neptune.cba.transaction.debit_credit.DebitCreditApprovalRequest,
      com.neptune.cba.transaction.debit_credit.DebitCreditApprovalResponse> getDebitCreditApprovalMethod() {
    io.grpc.MethodDescriptor<com.neptune.cba.transaction.debit_credit.DebitCreditApprovalRequest, com.neptune.cba.transaction.debit_credit.DebitCreditApprovalResponse> getDebitCreditApprovalMethod;
    if ((getDebitCreditApprovalMethod = DebitCreditServiceGrpc.getDebitCreditApprovalMethod) == null) {
      synchronized (DebitCreditServiceGrpc.class) {
        if ((getDebitCreditApprovalMethod = DebitCreditServiceGrpc.getDebitCreditApprovalMethod) == null) {
          DebitCreditServiceGrpc.getDebitCreditApprovalMethod = getDebitCreditApprovalMethod =
              io.grpc.MethodDescriptor.<com.neptune.cba.transaction.debit_credit.DebitCreditApprovalRequest, com.neptune.cba.transaction.debit_credit.DebitCreditApprovalResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "debit_credit_approval"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.debit_credit.DebitCreditApprovalRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.debit_credit.DebitCreditApprovalResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DebitCreditServiceMethodDescriptorSupplier("debit_credit_approval"))
              .build();
        }
      }
    }
    return getDebitCreditApprovalMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DebitCreditServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DebitCreditServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DebitCreditServiceStub>() {
        @java.lang.Override
        public DebitCreditServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DebitCreditServiceStub(channel, callOptions);
        }
      };
    return DebitCreditServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DebitCreditServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DebitCreditServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DebitCreditServiceBlockingStub>() {
        @java.lang.Override
        public DebitCreditServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DebitCreditServiceBlockingStub(channel, callOptions);
        }
      };
    return DebitCreditServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DebitCreditServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DebitCreditServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DebitCreditServiceFutureStub>() {
        @java.lang.Override
        public DebitCreditServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DebitCreditServiceFutureStub(channel, callOptions);
        }
      };
    return DebitCreditServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class DebitCreditServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void debitCredit(com.neptune.cba.transaction.debit_credit.DebitCreditRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.debit_credit.DebitCreditResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDebitCreditMethod(), responseObserver);
    }

    /**
     */
    public void debitCreditStatus(com.neptune.cba.transaction.debit_credit.DebitCreditStatusRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.debit_credit.DebitCreditStatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDebitCreditStatusMethod(), responseObserver);
    }

    /**
     */
    public void debitCreditApproval(com.neptune.cba.transaction.debit_credit.DebitCreditApprovalRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.debit_credit.DebitCreditApprovalResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDebitCreditApprovalMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getDebitCreditMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.neptune.cba.transaction.debit_credit.DebitCreditRequest,
                com.neptune.cba.transaction.debit_credit.DebitCreditResponse>(
                  this, METHODID_DEBIT_CREDIT)))
          .addMethod(
            getDebitCreditStatusMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.neptune.cba.transaction.debit_credit.DebitCreditStatusRequest,
                com.neptune.cba.transaction.debit_credit.DebitCreditStatusResponse>(
                  this, METHODID_DEBIT_CREDIT_STATUS)))
          .addMethod(
            getDebitCreditApprovalMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.neptune.cba.transaction.debit_credit.DebitCreditApprovalRequest,
                com.neptune.cba.transaction.debit_credit.DebitCreditApprovalResponse>(
                  this, METHODID_DEBIT_CREDIT_APPROVAL)))
          .build();
    }
  }

  /**
   */
  public static final class DebitCreditServiceStub extends io.grpc.stub.AbstractAsyncStub<DebitCreditServiceStub> {
    private DebitCreditServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DebitCreditServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DebitCreditServiceStub(channel, callOptions);
    }

    /**
     */
    public void debitCredit(com.neptune.cba.transaction.debit_credit.DebitCreditRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.debit_credit.DebitCreditResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDebitCreditMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void debitCreditStatus(com.neptune.cba.transaction.debit_credit.DebitCreditStatusRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.debit_credit.DebitCreditStatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDebitCreditStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void debitCreditApproval(com.neptune.cba.transaction.debit_credit.DebitCreditApprovalRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.debit_credit.DebitCreditApprovalResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDebitCreditApprovalMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DebitCreditServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<DebitCreditServiceBlockingStub> {
    private DebitCreditServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DebitCreditServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DebitCreditServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.neptune.cba.transaction.debit_credit.DebitCreditResponse debitCredit(com.neptune.cba.transaction.debit_credit.DebitCreditRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDebitCreditMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.neptune.cba.transaction.debit_credit.DebitCreditStatusResponse debitCreditStatus(com.neptune.cba.transaction.debit_credit.DebitCreditStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDebitCreditStatusMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.neptune.cba.transaction.debit_credit.DebitCreditApprovalResponse debitCreditApproval(com.neptune.cba.transaction.debit_credit.DebitCreditApprovalRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDebitCreditApprovalMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DebitCreditServiceFutureStub extends io.grpc.stub.AbstractFutureStub<DebitCreditServiceFutureStub> {
    private DebitCreditServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DebitCreditServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DebitCreditServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.neptune.cba.transaction.debit_credit.DebitCreditResponse> debitCredit(
        com.neptune.cba.transaction.debit_credit.DebitCreditRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDebitCreditMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.neptune.cba.transaction.debit_credit.DebitCreditStatusResponse> debitCreditStatus(
        com.neptune.cba.transaction.debit_credit.DebitCreditStatusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDebitCreditStatusMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.neptune.cba.transaction.debit_credit.DebitCreditApprovalResponse> debitCreditApproval(
        com.neptune.cba.transaction.debit_credit.DebitCreditApprovalRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDebitCreditApprovalMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DEBIT_CREDIT = 0;
  private static final int METHODID_DEBIT_CREDIT_STATUS = 1;
  private static final int METHODID_DEBIT_CREDIT_APPROVAL = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DebitCreditServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DebitCreditServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DEBIT_CREDIT:
          serviceImpl.debitCredit((com.neptune.cba.transaction.debit_credit.DebitCreditRequest) request,
              (io.grpc.stub.StreamObserver<com.neptune.cba.transaction.debit_credit.DebitCreditResponse>) responseObserver);
          break;
        case METHODID_DEBIT_CREDIT_STATUS:
          serviceImpl.debitCreditStatus((com.neptune.cba.transaction.debit_credit.DebitCreditStatusRequest) request,
              (io.grpc.stub.StreamObserver<com.neptune.cba.transaction.debit_credit.DebitCreditStatusResponse>) responseObserver);
          break;
        case METHODID_DEBIT_CREDIT_APPROVAL:
          serviceImpl.debitCreditApproval((com.neptune.cba.transaction.debit_credit.DebitCreditApprovalRequest) request,
              (io.grpc.stub.StreamObserver<com.neptune.cba.transaction.debit_credit.DebitCreditApprovalResponse>) responseObserver);
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

  private static abstract class DebitCreditServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DebitCreditServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.neptune.cba.transaction.debit_credit.Debitcredit.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DebitCreditService");
    }
  }

  private static final class DebitCreditServiceFileDescriptorSupplier
      extends DebitCreditServiceBaseDescriptorSupplier {
    DebitCreditServiceFileDescriptorSupplier() {}
  }

  private static final class DebitCreditServiceMethodDescriptorSupplier
      extends DebitCreditServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DebitCreditServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DebitCreditServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DebitCreditServiceFileDescriptorSupplier())
              .addMethod(getDebitCreditMethod())
              .addMethod(getDebitCreditStatusMethod())
              .addMethod(getDebitCreditApprovalMethod())
              .build();
        }
      }
    }
    return result;
  }
}
