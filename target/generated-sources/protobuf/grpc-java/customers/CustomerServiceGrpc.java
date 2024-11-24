package customers;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: customer.proto")
public final class CustomerServiceGrpc {

  private CustomerServiceGrpc() {}

  public static final String SERVICE_NAME = "customers.CustomerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<customers.Customer.CreateBulkCorpAccountRequest,
      customers.Customer.CreateBulkCorpCustomerResponse> getCreatBulkCorporateAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatBulkCorporateAccount",
      requestType = customers.Customer.CreateBulkCorpAccountRequest.class,
      responseType = customers.Customer.CreateBulkCorpCustomerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<customers.Customer.CreateBulkCorpAccountRequest,
      customers.Customer.CreateBulkCorpCustomerResponse> getCreatBulkCorporateAccountMethod() {
    io.grpc.MethodDescriptor<customers.Customer.CreateBulkCorpAccountRequest, customers.Customer.CreateBulkCorpCustomerResponse> getCreatBulkCorporateAccountMethod;
    if ((getCreatBulkCorporateAccountMethod = CustomerServiceGrpc.getCreatBulkCorporateAccountMethod) == null) {
      synchronized (CustomerServiceGrpc.class) {
        if ((getCreatBulkCorporateAccountMethod = CustomerServiceGrpc.getCreatBulkCorporateAccountMethod) == null) {
          CustomerServiceGrpc.getCreatBulkCorporateAccountMethod = getCreatBulkCorporateAccountMethod =
              io.grpc.MethodDescriptor.<customers.Customer.CreateBulkCorpAccountRequest, customers.Customer.CreateBulkCorpCustomerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreatBulkCorporateAccount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  customers.Customer.CreateBulkCorpAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  customers.Customer.CreateBulkCorpCustomerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CustomerServiceMethodDescriptorSupplier("CreatBulkCorporateAccount"))
              .build();
        }
      }
    }
    return getCreatBulkCorporateAccountMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CustomerServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CustomerServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CustomerServiceStub>() {
        @java.lang.Override
        public CustomerServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CustomerServiceStub(channel, callOptions);
        }
      };
    return CustomerServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CustomerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CustomerServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CustomerServiceBlockingStub>() {
        @java.lang.Override
        public CustomerServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CustomerServiceBlockingStub(channel, callOptions);
        }
      };
    return CustomerServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CustomerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CustomerServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CustomerServiceFutureStub>() {
        @java.lang.Override
        public CustomerServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CustomerServiceFutureStub(channel, callOptions);
        }
      };
    return CustomerServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CustomerServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void creatBulkCorporateAccount(customers.Customer.CreateBulkCorpAccountRequest request,
        io.grpc.stub.StreamObserver<customers.Customer.CreateBulkCorpCustomerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreatBulkCorporateAccountMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreatBulkCorporateAccountMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                customers.Customer.CreateBulkCorpAccountRequest,
                customers.Customer.CreateBulkCorpCustomerResponse>(
                  this, METHODID_CREAT_BULK_CORPORATE_ACCOUNT)))
          .build();
    }
  }

  /**
   */
  public static final class CustomerServiceStub extends io.grpc.stub.AbstractAsyncStub<CustomerServiceStub> {
    private CustomerServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CustomerServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CustomerServiceStub(channel, callOptions);
    }

    /**
     */
    public void creatBulkCorporateAccount(customers.Customer.CreateBulkCorpAccountRequest request,
        io.grpc.stub.StreamObserver<customers.Customer.CreateBulkCorpCustomerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatBulkCorporateAccountMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CustomerServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<CustomerServiceBlockingStub> {
    private CustomerServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CustomerServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CustomerServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public customers.Customer.CreateBulkCorpCustomerResponse creatBulkCorporateAccount(customers.Customer.CreateBulkCorpAccountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatBulkCorporateAccountMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CustomerServiceFutureStub extends io.grpc.stub.AbstractFutureStub<CustomerServiceFutureStub> {
    private CustomerServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CustomerServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CustomerServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<customers.Customer.CreateBulkCorpCustomerResponse> creatBulkCorporateAccount(
        customers.Customer.CreateBulkCorpAccountRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatBulkCorporateAccountMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREAT_BULK_CORPORATE_ACCOUNT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CustomerServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CustomerServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREAT_BULK_CORPORATE_ACCOUNT:
          serviceImpl.creatBulkCorporateAccount((customers.Customer.CreateBulkCorpAccountRequest) request,
              (io.grpc.stub.StreamObserver<customers.Customer.CreateBulkCorpCustomerResponse>) responseObserver);
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

  private static abstract class CustomerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CustomerServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return customers.Customer.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CustomerService");
    }
  }

  private static final class CustomerServiceFileDescriptorSupplier
      extends CustomerServiceBaseDescriptorSupplier {
    CustomerServiceFileDescriptorSupplier() {}
  }

  private static final class CustomerServiceMethodDescriptorSupplier
      extends CustomerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CustomerServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CustomerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CustomerServiceFileDescriptorSupplier())
              .addMethod(getCreatBulkCorporateAccountMethod())
              .build();
        }
      }
    }
    return result;
  }
}
