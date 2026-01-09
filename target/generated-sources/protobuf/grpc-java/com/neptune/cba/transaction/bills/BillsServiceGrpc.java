package com.neptune.cba.transaction.bills;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: bills.proto")
public final class BillsServiceGrpc {

  private BillsServiceGrpc() {}

  public static final String SERVICE_NAME = "com.neptune.cba.BillsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.neptune.cba.transaction.bills.MakePaymentRequest,
      com.neptune.cba.transaction.bills.MakePaymentResponse> getMakePaymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "make_payment",
      requestType = com.neptune.cba.transaction.bills.MakePaymentRequest.class,
      responseType = com.neptune.cba.transaction.bills.MakePaymentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.neptune.cba.transaction.bills.MakePaymentRequest,
      com.neptune.cba.transaction.bills.MakePaymentResponse> getMakePaymentMethod() {
    io.grpc.MethodDescriptor<com.neptune.cba.transaction.bills.MakePaymentRequest, com.neptune.cba.transaction.bills.MakePaymentResponse> getMakePaymentMethod;
    if ((getMakePaymentMethod = BillsServiceGrpc.getMakePaymentMethod) == null) {
      synchronized (BillsServiceGrpc.class) {
        if ((getMakePaymentMethod = BillsServiceGrpc.getMakePaymentMethod) == null) {
          BillsServiceGrpc.getMakePaymentMethod = getMakePaymentMethod =
              io.grpc.MethodDescriptor.<com.neptune.cba.transaction.bills.MakePaymentRequest, com.neptune.cba.transaction.bills.MakePaymentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "make_payment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.bills.MakePaymentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.bills.MakePaymentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BillsServiceMethodDescriptorSupplier("make_payment"))
              .build();
        }
      }
    }
    return getMakePaymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.neptune.cba.transaction.bills.BillsTsqRequest,
      com.neptune.cba.transaction.bills.BillsTsqResponse> getBillsTsqMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "bills_tsq",
      requestType = com.neptune.cba.transaction.bills.BillsTsqRequest.class,
      responseType = com.neptune.cba.transaction.bills.BillsTsqResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.neptune.cba.transaction.bills.BillsTsqRequest,
      com.neptune.cba.transaction.bills.BillsTsqResponse> getBillsTsqMethod() {
    io.grpc.MethodDescriptor<com.neptune.cba.transaction.bills.BillsTsqRequest, com.neptune.cba.transaction.bills.BillsTsqResponse> getBillsTsqMethod;
    if ((getBillsTsqMethod = BillsServiceGrpc.getBillsTsqMethod) == null) {
      synchronized (BillsServiceGrpc.class) {
        if ((getBillsTsqMethod = BillsServiceGrpc.getBillsTsqMethod) == null) {
          BillsServiceGrpc.getBillsTsqMethod = getBillsTsqMethod =
              io.grpc.MethodDescriptor.<com.neptune.cba.transaction.bills.BillsTsqRequest, com.neptune.cba.transaction.bills.BillsTsqResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "bills_tsq"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.bills.BillsTsqRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.bills.BillsTsqResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BillsServiceMethodDescriptorSupplier("bills_tsq"))
              .build();
        }
      }
    }
    return getBillsTsqMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.neptune.cba.transaction.bills.AllBillsRequest,
      com.neptune.cba.transaction.bills.AllBillsResponse> getAllBillsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "all_bills",
      requestType = com.neptune.cba.transaction.bills.AllBillsRequest.class,
      responseType = com.neptune.cba.transaction.bills.AllBillsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.neptune.cba.transaction.bills.AllBillsRequest,
      com.neptune.cba.transaction.bills.AllBillsResponse> getAllBillsMethod() {
    io.grpc.MethodDescriptor<com.neptune.cba.transaction.bills.AllBillsRequest, com.neptune.cba.transaction.bills.AllBillsResponse> getAllBillsMethod;
    if ((getAllBillsMethod = BillsServiceGrpc.getAllBillsMethod) == null) {
      synchronized (BillsServiceGrpc.class) {
        if ((getAllBillsMethod = BillsServiceGrpc.getAllBillsMethod) == null) {
          BillsServiceGrpc.getAllBillsMethod = getAllBillsMethod =
              io.grpc.MethodDescriptor.<com.neptune.cba.transaction.bills.AllBillsRequest, com.neptune.cba.transaction.bills.AllBillsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "all_bills"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.bills.AllBillsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.bills.AllBillsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BillsServiceMethodDescriptorSupplier("all_bills"))
              .build();
        }
      }
    }
    return getAllBillsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.neptune.cba.transaction.bills.BillReverseRequest,
      com.neptune.cba.transaction.bills.BillReverseResponse> getReverseBillsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "reverse_bills",
      requestType = com.neptune.cba.transaction.bills.BillReverseRequest.class,
      responseType = com.neptune.cba.transaction.bills.BillReverseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.neptune.cba.transaction.bills.BillReverseRequest,
      com.neptune.cba.transaction.bills.BillReverseResponse> getReverseBillsMethod() {
    io.grpc.MethodDescriptor<com.neptune.cba.transaction.bills.BillReverseRequest, com.neptune.cba.transaction.bills.BillReverseResponse> getReverseBillsMethod;
    if ((getReverseBillsMethod = BillsServiceGrpc.getReverseBillsMethod) == null) {
      synchronized (BillsServiceGrpc.class) {
        if ((getReverseBillsMethod = BillsServiceGrpc.getReverseBillsMethod) == null) {
          BillsServiceGrpc.getReverseBillsMethod = getReverseBillsMethod =
              io.grpc.MethodDescriptor.<com.neptune.cba.transaction.bills.BillReverseRequest, com.neptune.cba.transaction.bills.BillReverseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "reverse_bills"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.bills.BillReverseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.bills.BillReverseResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BillsServiceMethodDescriptorSupplier("reverse_bills"))
              .build();
        }
      }
    }
    return getReverseBillsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BillsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BillsServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BillsServiceStub>() {
        @java.lang.Override
        public BillsServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BillsServiceStub(channel, callOptions);
        }
      };
    return BillsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BillsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BillsServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BillsServiceBlockingStub>() {
        @java.lang.Override
        public BillsServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BillsServiceBlockingStub(channel, callOptions);
        }
      };
    return BillsServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BillsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BillsServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BillsServiceFutureStub>() {
        @java.lang.Override
        public BillsServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BillsServiceFutureStub(channel, callOptions);
        }
      };
    return BillsServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class BillsServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void makePayment(com.neptune.cba.transaction.bills.MakePaymentRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.bills.MakePaymentResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMakePaymentMethod(), responseObserver);
    }

    /**
     */
    public void billsTsq(com.neptune.cba.transaction.bills.BillsTsqRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.bills.BillsTsqResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBillsTsqMethod(), responseObserver);
    }

    /**
     */
    public void allBills(com.neptune.cba.transaction.bills.AllBillsRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.bills.AllBillsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAllBillsMethod(), responseObserver);
    }

    /**
     */
    public void reverseBills(com.neptune.cba.transaction.bills.BillReverseRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.bills.BillReverseResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReverseBillsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getMakePaymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.neptune.cba.transaction.bills.MakePaymentRequest,
                com.neptune.cba.transaction.bills.MakePaymentResponse>(
                  this, METHODID_MAKE_PAYMENT)))
          .addMethod(
            getBillsTsqMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.neptune.cba.transaction.bills.BillsTsqRequest,
                com.neptune.cba.transaction.bills.BillsTsqResponse>(
                  this, METHODID_BILLS_TSQ)))
          .addMethod(
            getAllBillsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.neptune.cba.transaction.bills.AllBillsRequest,
                com.neptune.cba.transaction.bills.AllBillsResponse>(
                  this, METHODID_ALL_BILLS)))
          .addMethod(
            getReverseBillsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.neptune.cba.transaction.bills.BillReverseRequest,
                com.neptune.cba.transaction.bills.BillReverseResponse>(
                  this, METHODID_REVERSE_BILLS)))
          .build();
    }
  }

  /**
   */
  public static final class BillsServiceStub extends io.grpc.stub.AbstractAsyncStub<BillsServiceStub> {
    private BillsServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BillsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BillsServiceStub(channel, callOptions);
    }

    /**
     */
    public void makePayment(com.neptune.cba.transaction.bills.MakePaymentRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.bills.MakePaymentResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMakePaymentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void billsTsq(com.neptune.cba.transaction.bills.BillsTsqRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.bills.BillsTsqResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBillsTsqMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void allBills(com.neptune.cba.transaction.bills.AllBillsRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.bills.AllBillsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAllBillsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void reverseBills(com.neptune.cba.transaction.bills.BillReverseRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.bills.BillReverseResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReverseBillsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BillsServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<BillsServiceBlockingStub> {
    private BillsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BillsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BillsServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.neptune.cba.transaction.bills.MakePaymentResponse makePayment(com.neptune.cba.transaction.bills.MakePaymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMakePaymentMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.neptune.cba.transaction.bills.BillsTsqResponse billsTsq(com.neptune.cba.transaction.bills.BillsTsqRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBillsTsqMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.neptune.cba.transaction.bills.AllBillsResponse allBills(com.neptune.cba.transaction.bills.AllBillsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAllBillsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.neptune.cba.transaction.bills.BillReverseResponse reverseBills(com.neptune.cba.transaction.bills.BillReverseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReverseBillsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BillsServiceFutureStub extends io.grpc.stub.AbstractFutureStub<BillsServiceFutureStub> {
    private BillsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BillsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BillsServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.neptune.cba.transaction.bills.MakePaymentResponse> makePayment(
        com.neptune.cba.transaction.bills.MakePaymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMakePaymentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.neptune.cba.transaction.bills.BillsTsqResponse> billsTsq(
        com.neptune.cba.transaction.bills.BillsTsqRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBillsTsqMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.neptune.cba.transaction.bills.AllBillsResponse> allBills(
        com.neptune.cba.transaction.bills.AllBillsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAllBillsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.neptune.cba.transaction.bills.BillReverseResponse> reverseBills(
        com.neptune.cba.transaction.bills.BillReverseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReverseBillsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_MAKE_PAYMENT = 0;
  private static final int METHODID_BILLS_TSQ = 1;
  private static final int METHODID_ALL_BILLS = 2;
  private static final int METHODID_REVERSE_BILLS = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BillsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BillsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_MAKE_PAYMENT:
          serviceImpl.makePayment((com.neptune.cba.transaction.bills.MakePaymentRequest) request,
              (io.grpc.stub.StreamObserver<com.neptune.cba.transaction.bills.MakePaymentResponse>) responseObserver);
          break;
        case METHODID_BILLS_TSQ:
          serviceImpl.billsTsq((com.neptune.cba.transaction.bills.BillsTsqRequest) request,
              (io.grpc.stub.StreamObserver<com.neptune.cba.transaction.bills.BillsTsqResponse>) responseObserver);
          break;
        case METHODID_ALL_BILLS:
          serviceImpl.allBills((com.neptune.cba.transaction.bills.AllBillsRequest) request,
              (io.grpc.stub.StreamObserver<com.neptune.cba.transaction.bills.AllBillsResponse>) responseObserver);
          break;
        case METHODID_REVERSE_BILLS:
          serviceImpl.reverseBills((com.neptune.cba.transaction.bills.BillReverseRequest) request,
              (io.grpc.stub.StreamObserver<com.neptune.cba.transaction.bills.BillReverseResponse>) responseObserver);
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

  private static abstract class BillsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BillsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.neptune.cba.transaction.bills.Bills.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BillsService");
    }
  }

  private static final class BillsServiceFileDescriptorSupplier
      extends BillsServiceBaseDescriptorSupplier {
    BillsServiceFileDescriptorSupplier() {}
  }

  private static final class BillsServiceMethodDescriptorSupplier
      extends BillsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BillsServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (BillsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BillsServiceFileDescriptorSupplier())
              .addMethod(getMakePaymentMethod())
              .addMethod(getBillsTsqMethod())
              .addMethod(getAllBillsMethod())
              .addMethod(getReverseBillsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
