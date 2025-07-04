package com.neptune.cba.transaction.type;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: transactionType.proto")
public final class TransactionTypeServiceGrpc {

  private TransactionTypeServiceGrpc() {}

  public static final String SERVICE_NAME = "com.neptune.cba.TransactionTypeService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.neptune.cba.transaction.type.Empty,
      com.neptune.cba.transaction.type.TransactionTypeResponse> getTransactionTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "transaction_type",
      requestType = com.neptune.cba.transaction.type.Empty.class,
      responseType = com.neptune.cba.transaction.type.TransactionTypeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.neptune.cba.transaction.type.Empty,
      com.neptune.cba.transaction.type.TransactionTypeResponse> getTransactionTypeMethod() {
    io.grpc.MethodDescriptor<com.neptune.cba.transaction.type.Empty, com.neptune.cba.transaction.type.TransactionTypeResponse> getTransactionTypeMethod;
    if ((getTransactionTypeMethod = TransactionTypeServiceGrpc.getTransactionTypeMethod) == null) {
      synchronized (TransactionTypeServiceGrpc.class) {
        if ((getTransactionTypeMethod = TransactionTypeServiceGrpc.getTransactionTypeMethod) == null) {
          TransactionTypeServiceGrpc.getTransactionTypeMethod = getTransactionTypeMethod =
              io.grpc.MethodDescriptor.<com.neptune.cba.transaction.type.Empty, com.neptune.cba.transaction.type.TransactionTypeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "transaction_type"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.type.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.type.TransactionTypeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TransactionTypeServiceMethodDescriptorSupplier("transaction_type"))
              .build();
        }
      }
    }
    return getTransactionTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.neptune.cba.transaction.type.TransactionType,
      com.neptune.cba.transaction.type.CreateTransactionResponse> getCreateTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "create_type",
      requestType = com.neptune.cba.transaction.type.TransactionType.class,
      responseType = com.neptune.cba.transaction.type.CreateTransactionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.neptune.cba.transaction.type.TransactionType,
      com.neptune.cba.transaction.type.CreateTransactionResponse> getCreateTypeMethod() {
    io.grpc.MethodDescriptor<com.neptune.cba.transaction.type.TransactionType, com.neptune.cba.transaction.type.CreateTransactionResponse> getCreateTypeMethod;
    if ((getCreateTypeMethod = TransactionTypeServiceGrpc.getCreateTypeMethod) == null) {
      synchronized (TransactionTypeServiceGrpc.class) {
        if ((getCreateTypeMethod = TransactionTypeServiceGrpc.getCreateTypeMethod) == null) {
          TransactionTypeServiceGrpc.getCreateTypeMethod = getCreateTypeMethod =
              io.grpc.MethodDescriptor.<com.neptune.cba.transaction.type.TransactionType, com.neptune.cba.transaction.type.CreateTransactionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "create_type"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.type.TransactionType.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.type.CreateTransactionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TransactionTypeServiceMethodDescriptorSupplier("create_type"))
              .build();
        }
      }
    }
    return getCreateTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.neptune.cba.transaction.type.DeleteTypeRequest,
      com.neptune.cba.transaction.type.DeleteTypeResponse> getDeleteTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "delete_type",
      requestType = com.neptune.cba.transaction.type.DeleteTypeRequest.class,
      responseType = com.neptune.cba.transaction.type.DeleteTypeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.neptune.cba.transaction.type.DeleteTypeRequest,
      com.neptune.cba.transaction.type.DeleteTypeResponse> getDeleteTypeMethod() {
    io.grpc.MethodDescriptor<com.neptune.cba.transaction.type.DeleteTypeRequest, com.neptune.cba.transaction.type.DeleteTypeResponse> getDeleteTypeMethod;
    if ((getDeleteTypeMethod = TransactionTypeServiceGrpc.getDeleteTypeMethod) == null) {
      synchronized (TransactionTypeServiceGrpc.class) {
        if ((getDeleteTypeMethod = TransactionTypeServiceGrpc.getDeleteTypeMethod) == null) {
          TransactionTypeServiceGrpc.getDeleteTypeMethod = getDeleteTypeMethod =
              io.grpc.MethodDescriptor.<com.neptune.cba.transaction.type.DeleteTypeRequest, com.neptune.cba.transaction.type.DeleteTypeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "delete_type"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.type.DeleteTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.type.DeleteTypeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TransactionTypeServiceMethodDescriptorSupplier("delete_type"))
              .build();
        }
      }
    }
    return getDeleteTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.neptune.cba.transaction.type.UpdateTypeRequest,
      com.neptune.cba.transaction.type.UpdateTypeResponse> getUpdateTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "update_type",
      requestType = com.neptune.cba.transaction.type.UpdateTypeRequest.class,
      responseType = com.neptune.cba.transaction.type.UpdateTypeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.neptune.cba.transaction.type.UpdateTypeRequest,
      com.neptune.cba.transaction.type.UpdateTypeResponse> getUpdateTypeMethod() {
    io.grpc.MethodDescriptor<com.neptune.cba.transaction.type.UpdateTypeRequest, com.neptune.cba.transaction.type.UpdateTypeResponse> getUpdateTypeMethod;
    if ((getUpdateTypeMethod = TransactionTypeServiceGrpc.getUpdateTypeMethod) == null) {
      synchronized (TransactionTypeServiceGrpc.class) {
        if ((getUpdateTypeMethod = TransactionTypeServiceGrpc.getUpdateTypeMethod) == null) {
          TransactionTypeServiceGrpc.getUpdateTypeMethod = getUpdateTypeMethod =
              io.grpc.MethodDescriptor.<com.neptune.cba.transaction.type.UpdateTypeRequest, com.neptune.cba.transaction.type.UpdateTypeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "update_type"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.type.UpdateTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.type.UpdateTypeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TransactionTypeServiceMethodDescriptorSupplier("update_type"))
              .build();
        }
      }
    }
    return getUpdateTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.neptune.cba.transaction.type.AddChildRequest,
      com.neptune.cba.transaction.type.AddChildResponse> getAddChildMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "add_child",
      requestType = com.neptune.cba.transaction.type.AddChildRequest.class,
      responseType = com.neptune.cba.transaction.type.AddChildResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.neptune.cba.transaction.type.AddChildRequest,
      com.neptune.cba.transaction.type.AddChildResponse> getAddChildMethod() {
    io.grpc.MethodDescriptor<com.neptune.cba.transaction.type.AddChildRequest, com.neptune.cba.transaction.type.AddChildResponse> getAddChildMethod;
    if ((getAddChildMethod = TransactionTypeServiceGrpc.getAddChildMethod) == null) {
      synchronized (TransactionTypeServiceGrpc.class) {
        if ((getAddChildMethod = TransactionTypeServiceGrpc.getAddChildMethod) == null) {
          TransactionTypeServiceGrpc.getAddChildMethod = getAddChildMethod =
              io.grpc.MethodDescriptor.<com.neptune.cba.transaction.type.AddChildRequest, com.neptune.cba.transaction.type.AddChildResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "add_child"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.type.AddChildRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.type.AddChildResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TransactionTypeServiceMethodDescriptorSupplier("add_child"))
              .build();
        }
      }
    }
    return getAddChildMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.neptune.cba.transaction.type.AddChargeRequest,
      com.neptune.cba.transaction.type.AddChargeResponse> getAddChargeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "add_charge",
      requestType = com.neptune.cba.transaction.type.AddChargeRequest.class,
      responseType = com.neptune.cba.transaction.type.AddChargeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.neptune.cba.transaction.type.AddChargeRequest,
      com.neptune.cba.transaction.type.AddChargeResponse> getAddChargeMethod() {
    io.grpc.MethodDescriptor<com.neptune.cba.transaction.type.AddChargeRequest, com.neptune.cba.transaction.type.AddChargeResponse> getAddChargeMethod;
    if ((getAddChargeMethod = TransactionTypeServiceGrpc.getAddChargeMethod) == null) {
      synchronized (TransactionTypeServiceGrpc.class) {
        if ((getAddChargeMethod = TransactionTypeServiceGrpc.getAddChargeMethod) == null) {
          TransactionTypeServiceGrpc.getAddChargeMethod = getAddChargeMethod =
              io.grpc.MethodDescriptor.<com.neptune.cba.transaction.type.AddChargeRequest, com.neptune.cba.transaction.type.AddChargeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "add_charge"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.type.AddChargeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.type.AddChargeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TransactionTypeServiceMethodDescriptorSupplier("add_charge"))
              .build();
        }
      }
    }
    return getAddChargeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.neptune.cba.transaction.type.RemoveChargeRequest,
      com.neptune.cba.transaction.type.RemoveChargeResponse> getRemoveChargeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "remove_charge",
      requestType = com.neptune.cba.transaction.type.RemoveChargeRequest.class,
      responseType = com.neptune.cba.transaction.type.RemoveChargeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.neptune.cba.transaction.type.RemoveChargeRequest,
      com.neptune.cba.transaction.type.RemoveChargeResponse> getRemoveChargeMethod() {
    io.grpc.MethodDescriptor<com.neptune.cba.transaction.type.RemoveChargeRequest, com.neptune.cba.transaction.type.RemoveChargeResponse> getRemoveChargeMethod;
    if ((getRemoveChargeMethod = TransactionTypeServiceGrpc.getRemoveChargeMethod) == null) {
      synchronized (TransactionTypeServiceGrpc.class) {
        if ((getRemoveChargeMethod = TransactionTypeServiceGrpc.getRemoveChargeMethod) == null) {
          TransactionTypeServiceGrpc.getRemoveChargeMethod = getRemoveChargeMethod =
              io.grpc.MethodDescriptor.<com.neptune.cba.transaction.type.RemoveChargeRequest, com.neptune.cba.transaction.type.RemoveChargeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "remove_charge"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.type.RemoveChargeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.neptune.cba.transaction.type.RemoveChargeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TransactionTypeServiceMethodDescriptorSupplier("remove_charge"))
              .build();
        }
      }
    }
    return getRemoveChargeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TransactionTypeServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TransactionTypeServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TransactionTypeServiceStub>() {
        @java.lang.Override
        public TransactionTypeServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TransactionTypeServiceStub(channel, callOptions);
        }
      };
    return TransactionTypeServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TransactionTypeServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TransactionTypeServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TransactionTypeServiceBlockingStub>() {
        @java.lang.Override
        public TransactionTypeServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TransactionTypeServiceBlockingStub(channel, callOptions);
        }
      };
    return TransactionTypeServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TransactionTypeServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TransactionTypeServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TransactionTypeServiceFutureStub>() {
        @java.lang.Override
        public TransactionTypeServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TransactionTypeServiceFutureStub(channel, callOptions);
        }
      };
    return TransactionTypeServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class TransactionTypeServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void transactionType(com.neptune.cba.transaction.type.Empty request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.type.TransactionTypeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTransactionTypeMethod(), responseObserver);
    }

    /**
     */
    public void createType(com.neptune.cba.transaction.type.TransactionType request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.type.CreateTransactionResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateTypeMethod(), responseObserver);
    }

    /**
     */
    public void deleteType(com.neptune.cba.transaction.type.DeleteTypeRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.type.DeleteTypeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteTypeMethod(), responseObserver);
    }

    /**
     */
    public void updateType(com.neptune.cba.transaction.type.UpdateTypeRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.type.UpdateTypeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateTypeMethod(), responseObserver);
    }

    /**
     */
    public void addChild(com.neptune.cba.transaction.type.AddChildRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.type.AddChildResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddChildMethod(), responseObserver);
    }

    /**
     */
    public void addCharge(com.neptune.cba.transaction.type.AddChargeRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.type.AddChargeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddChargeMethod(), responseObserver);
    }

    /**
     */
    public void removeCharge(com.neptune.cba.transaction.type.RemoveChargeRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.type.RemoveChargeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRemoveChargeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getTransactionTypeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.neptune.cba.transaction.type.Empty,
                com.neptune.cba.transaction.type.TransactionTypeResponse>(
                  this, METHODID_TRANSACTION_TYPE)))
          .addMethod(
            getCreateTypeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.neptune.cba.transaction.type.TransactionType,
                com.neptune.cba.transaction.type.CreateTransactionResponse>(
                  this, METHODID_CREATE_TYPE)))
          .addMethod(
            getDeleteTypeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.neptune.cba.transaction.type.DeleteTypeRequest,
                com.neptune.cba.transaction.type.DeleteTypeResponse>(
                  this, METHODID_DELETE_TYPE)))
          .addMethod(
            getUpdateTypeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.neptune.cba.transaction.type.UpdateTypeRequest,
                com.neptune.cba.transaction.type.UpdateTypeResponse>(
                  this, METHODID_UPDATE_TYPE)))
          .addMethod(
            getAddChildMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.neptune.cba.transaction.type.AddChildRequest,
                com.neptune.cba.transaction.type.AddChildResponse>(
                  this, METHODID_ADD_CHILD)))
          .addMethod(
            getAddChargeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.neptune.cba.transaction.type.AddChargeRequest,
                com.neptune.cba.transaction.type.AddChargeResponse>(
                  this, METHODID_ADD_CHARGE)))
          .addMethod(
            getRemoveChargeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.neptune.cba.transaction.type.RemoveChargeRequest,
                com.neptune.cba.transaction.type.RemoveChargeResponse>(
                  this, METHODID_REMOVE_CHARGE)))
          .build();
    }
  }

  /**
   */
  public static final class TransactionTypeServiceStub extends io.grpc.stub.AbstractAsyncStub<TransactionTypeServiceStub> {
    private TransactionTypeServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransactionTypeServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TransactionTypeServiceStub(channel, callOptions);
    }

    /**
     */
    public void transactionType(com.neptune.cba.transaction.type.Empty request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.type.TransactionTypeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTransactionTypeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createType(com.neptune.cba.transaction.type.TransactionType request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.type.CreateTransactionResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTypeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteType(com.neptune.cba.transaction.type.DeleteTypeRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.type.DeleteTypeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTypeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateType(com.neptune.cba.transaction.type.UpdateTypeRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.type.UpdateTypeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTypeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addChild(com.neptune.cba.transaction.type.AddChildRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.type.AddChildResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddChildMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addCharge(com.neptune.cba.transaction.type.AddChargeRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.type.AddChargeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddChargeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void removeCharge(com.neptune.cba.transaction.type.RemoveChargeRequest request,
        io.grpc.stub.StreamObserver<com.neptune.cba.transaction.type.RemoveChargeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRemoveChargeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TransactionTypeServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<TransactionTypeServiceBlockingStub> {
    private TransactionTypeServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransactionTypeServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TransactionTypeServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.neptune.cba.transaction.type.TransactionTypeResponse transactionType(com.neptune.cba.transaction.type.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTransactionTypeMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.neptune.cba.transaction.type.CreateTransactionResponse createType(com.neptune.cba.transaction.type.TransactionType request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTypeMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.neptune.cba.transaction.type.DeleteTypeResponse deleteType(com.neptune.cba.transaction.type.DeleteTypeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTypeMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.neptune.cba.transaction.type.UpdateTypeResponse updateType(com.neptune.cba.transaction.type.UpdateTypeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTypeMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.neptune.cba.transaction.type.AddChildResponse addChild(com.neptune.cba.transaction.type.AddChildRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddChildMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.neptune.cba.transaction.type.AddChargeResponse addCharge(com.neptune.cba.transaction.type.AddChargeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddChargeMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.neptune.cba.transaction.type.RemoveChargeResponse removeCharge(com.neptune.cba.transaction.type.RemoveChargeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveChargeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TransactionTypeServiceFutureStub extends io.grpc.stub.AbstractFutureStub<TransactionTypeServiceFutureStub> {
    private TransactionTypeServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransactionTypeServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TransactionTypeServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.neptune.cba.transaction.type.TransactionTypeResponse> transactionType(
        com.neptune.cba.transaction.type.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTransactionTypeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.neptune.cba.transaction.type.CreateTransactionResponse> createType(
        com.neptune.cba.transaction.type.TransactionType request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTypeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.neptune.cba.transaction.type.DeleteTypeResponse> deleteType(
        com.neptune.cba.transaction.type.DeleteTypeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTypeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.neptune.cba.transaction.type.UpdateTypeResponse> updateType(
        com.neptune.cba.transaction.type.UpdateTypeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTypeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.neptune.cba.transaction.type.AddChildResponse> addChild(
        com.neptune.cba.transaction.type.AddChildRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddChildMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.neptune.cba.transaction.type.AddChargeResponse> addCharge(
        com.neptune.cba.transaction.type.AddChargeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddChargeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.neptune.cba.transaction.type.RemoveChargeResponse> removeCharge(
        com.neptune.cba.transaction.type.RemoveChargeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRemoveChargeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TRANSACTION_TYPE = 0;
  private static final int METHODID_CREATE_TYPE = 1;
  private static final int METHODID_DELETE_TYPE = 2;
  private static final int METHODID_UPDATE_TYPE = 3;
  private static final int METHODID_ADD_CHILD = 4;
  private static final int METHODID_ADD_CHARGE = 5;
  private static final int METHODID_REMOVE_CHARGE = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TransactionTypeServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TransactionTypeServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_TRANSACTION_TYPE:
          serviceImpl.transactionType((com.neptune.cba.transaction.type.Empty) request,
              (io.grpc.stub.StreamObserver<com.neptune.cba.transaction.type.TransactionTypeResponse>) responseObserver);
          break;
        case METHODID_CREATE_TYPE:
          serviceImpl.createType((com.neptune.cba.transaction.type.TransactionType) request,
              (io.grpc.stub.StreamObserver<com.neptune.cba.transaction.type.CreateTransactionResponse>) responseObserver);
          break;
        case METHODID_DELETE_TYPE:
          serviceImpl.deleteType((com.neptune.cba.transaction.type.DeleteTypeRequest) request,
              (io.grpc.stub.StreamObserver<com.neptune.cba.transaction.type.DeleteTypeResponse>) responseObserver);
          break;
        case METHODID_UPDATE_TYPE:
          serviceImpl.updateType((com.neptune.cba.transaction.type.UpdateTypeRequest) request,
              (io.grpc.stub.StreamObserver<com.neptune.cba.transaction.type.UpdateTypeResponse>) responseObserver);
          break;
        case METHODID_ADD_CHILD:
          serviceImpl.addChild((com.neptune.cba.transaction.type.AddChildRequest) request,
              (io.grpc.stub.StreamObserver<com.neptune.cba.transaction.type.AddChildResponse>) responseObserver);
          break;
        case METHODID_ADD_CHARGE:
          serviceImpl.addCharge((com.neptune.cba.transaction.type.AddChargeRequest) request,
              (io.grpc.stub.StreamObserver<com.neptune.cba.transaction.type.AddChargeResponse>) responseObserver);
          break;
        case METHODID_REMOVE_CHARGE:
          serviceImpl.removeCharge((com.neptune.cba.transaction.type.RemoveChargeRequest) request,
              (io.grpc.stub.StreamObserver<com.neptune.cba.transaction.type.RemoveChargeResponse>) responseObserver);
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

  private static abstract class TransactionTypeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TransactionTypeServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.neptune.cba.transaction.type.TransactionTypeOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TransactionTypeService");
    }
  }

  private static final class TransactionTypeServiceFileDescriptorSupplier
      extends TransactionTypeServiceBaseDescriptorSupplier {
    TransactionTypeServiceFileDescriptorSupplier() {}
  }

  private static final class TransactionTypeServiceMethodDescriptorSupplier
      extends TransactionTypeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TransactionTypeServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TransactionTypeServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TransactionTypeServiceFileDescriptorSupplier())
              .addMethod(getTransactionTypeMethod())
              .addMethod(getCreateTypeMethod())
              .addMethod(getDeleteTypeMethod())
              .addMethod(getUpdateTypeMethod())
              .addMethod(getAddChildMethod())
              .addMethod(getAddChargeMethod())
              .addMethod(getRemoveChargeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
