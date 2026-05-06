package notification_service;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: Notifications.proto")
public final class NotificationServiceGrpc {

  private NotificationServiceGrpc() {}

  public static final String SERVICE_NAME = "notification_service.NotificationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<notification_service.Notifications.NotificationRequest,
      notification_service.Notifications.NotificationResponse> getNotifyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Notify",
      requestType = notification_service.Notifications.NotificationRequest.class,
      responseType = notification_service.Notifications.NotificationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<notification_service.Notifications.NotificationRequest,
      notification_service.Notifications.NotificationResponse> getNotifyMethod() {
    io.grpc.MethodDescriptor<notification_service.Notifications.NotificationRequest, notification_service.Notifications.NotificationResponse> getNotifyMethod;
    if ((getNotifyMethod = NotificationServiceGrpc.getNotifyMethod) == null) {
      synchronized (NotificationServiceGrpc.class) {
        if ((getNotifyMethod = NotificationServiceGrpc.getNotifyMethod) == null) {
          NotificationServiceGrpc.getNotifyMethod = getNotifyMethod =
              io.grpc.MethodDescriptor.<notification_service.Notifications.NotificationRequest, notification_service.Notifications.NotificationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Notify"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  notification_service.Notifications.NotificationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  notification_service.Notifications.NotificationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new NotificationServiceMethodDescriptorSupplier("Notify"))
              .build();
        }
      }
    }
    return getNotifyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<notification_service.Notifications.Empty,
      notification_service.Notifications.GetAllNotificationResponse> getGetAllNotificationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllNotification",
      requestType = notification_service.Notifications.Empty.class,
      responseType = notification_service.Notifications.GetAllNotificationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<notification_service.Notifications.Empty,
      notification_service.Notifications.GetAllNotificationResponse> getGetAllNotificationMethod() {
    io.grpc.MethodDescriptor<notification_service.Notifications.Empty, notification_service.Notifications.GetAllNotificationResponse> getGetAllNotificationMethod;
    if ((getGetAllNotificationMethod = NotificationServiceGrpc.getGetAllNotificationMethod) == null) {
      synchronized (NotificationServiceGrpc.class) {
        if ((getGetAllNotificationMethod = NotificationServiceGrpc.getGetAllNotificationMethod) == null) {
          NotificationServiceGrpc.getGetAllNotificationMethod = getGetAllNotificationMethod =
              io.grpc.MethodDescriptor.<notification_service.Notifications.Empty, notification_service.Notifications.GetAllNotificationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllNotification"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  notification_service.Notifications.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  notification_service.Notifications.GetAllNotificationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new NotificationServiceMethodDescriptorSupplier("GetAllNotification"))
              .build();
        }
      }
    }
    return getGetAllNotificationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<notification_service.Notifications.UserNotificationRequest,
      notification_service.Notifications.UserNotificationResponse> getGetUserNotificationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUserNotifications",
      requestType = notification_service.Notifications.UserNotificationRequest.class,
      responseType = notification_service.Notifications.UserNotificationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<notification_service.Notifications.UserNotificationRequest,
      notification_service.Notifications.UserNotificationResponse> getGetUserNotificationsMethod() {
    io.grpc.MethodDescriptor<notification_service.Notifications.UserNotificationRequest, notification_service.Notifications.UserNotificationResponse> getGetUserNotificationsMethod;
    if ((getGetUserNotificationsMethod = NotificationServiceGrpc.getGetUserNotificationsMethod) == null) {
      synchronized (NotificationServiceGrpc.class) {
        if ((getGetUserNotificationsMethod = NotificationServiceGrpc.getGetUserNotificationsMethod) == null) {
          NotificationServiceGrpc.getGetUserNotificationsMethod = getGetUserNotificationsMethod =
              io.grpc.MethodDescriptor.<notification_service.Notifications.UserNotificationRequest, notification_service.Notifications.UserNotificationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUserNotifications"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  notification_service.Notifications.UserNotificationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  notification_service.Notifications.UserNotificationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new NotificationServiceMethodDescriptorSupplier("GetUserNotifications"))
              .build();
        }
      }
    }
    return getGetUserNotificationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<notification_service.Notifications.GetNotificationByDateRequest,
      notification_service.Notifications.GetAllNotificationResponse> getGetNotificationByDateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetNotificationByDate",
      requestType = notification_service.Notifications.GetNotificationByDateRequest.class,
      responseType = notification_service.Notifications.GetAllNotificationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<notification_service.Notifications.GetNotificationByDateRequest,
      notification_service.Notifications.GetAllNotificationResponse> getGetNotificationByDateMethod() {
    io.grpc.MethodDescriptor<notification_service.Notifications.GetNotificationByDateRequest, notification_service.Notifications.GetAllNotificationResponse> getGetNotificationByDateMethod;
    if ((getGetNotificationByDateMethod = NotificationServiceGrpc.getGetNotificationByDateMethod) == null) {
      synchronized (NotificationServiceGrpc.class) {
        if ((getGetNotificationByDateMethod = NotificationServiceGrpc.getGetNotificationByDateMethod) == null) {
          NotificationServiceGrpc.getGetNotificationByDateMethod = getGetNotificationByDateMethod =
              io.grpc.MethodDescriptor.<notification_service.Notifications.GetNotificationByDateRequest, notification_service.Notifications.GetAllNotificationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetNotificationByDate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  notification_service.Notifications.GetNotificationByDateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  notification_service.Notifications.GetAllNotificationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new NotificationServiceMethodDescriptorSupplier("GetNotificationByDate"))
              .build();
        }
      }
    }
    return getGetNotificationByDateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<notification_service.Notifications.CustomNotificationRequest,
      notification_service.Notifications.CustomNotificationResponse> getCustomNotificationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CustomNotification",
      requestType = notification_service.Notifications.CustomNotificationRequest.class,
      responseType = notification_service.Notifications.CustomNotificationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<notification_service.Notifications.CustomNotificationRequest,
      notification_service.Notifications.CustomNotificationResponse> getCustomNotificationMethod() {
    io.grpc.MethodDescriptor<notification_service.Notifications.CustomNotificationRequest, notification_service.Notifications.CustomNotificationResponse> getCustomNotificationMethod;
    if ((getCustomNotificationMethod = NotificationServiceGrpc.getCustomNotificationMethod) == null) {
      synchronized (NotificationServiceGrpc.class) {
        if ((getCustomNotificationMethod = NotificationServiceGrpc.getCustomNotificationMethod) == null) {
          NotificationServiceGrpc.getCustomNotificationMethod = getCustomNotificationMethod =
              io.grpc.MethodDescriptor.<notification_service.Notifications.CustomNotificationRequest, notification_service.Notifications.CustomNotificationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CustomNotification"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  notification_service.Notifications.CustomNotificationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  notification_service.Notifications.CustomNotificationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new NotificationServiceMethodDescriptorSupplier("CustomNotification"))
              .build();
        }
      }
    }
    return getCustomNotificationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static NotificationServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NotificationServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NotificationServiceStub>() {
        @java.lang.Override
        public NotificationServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NotificationServiceStub(channel, callOptions);
        }
      };
    return NotificationServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static NotificationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NotificationServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NotificationServiceBlockingStub>() {
        @java.lang.Override
        public NotificationServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NotificationServiceBlockingStub(channel, callOptions);
        }
      };
    return NotificationServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static NotificationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NotificationServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NotificationServiceFutureStub>() {
        @java.lang.Override
        public NotificationServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NotificationServiceFutureStub(channel, callOptions);
        }
      };
    return NotificationServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class NotificationServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void notify(notification_service.Notifications.NotificationRequest request,
        io.grpc.stub.StreamObserver<notification_service.Notifications.NotificationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getNotifyMethod(), responseObserver);
    }

    /**
     */
    public void getAllNotification(notification_service.Notifications.Empty request,
        io.grpc.stub.StreamObserver<notification_service.Notifications.GetAllNotificationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllNotificationMethod(), responseObserver);
    }

    /**
     */
    public void getUserNotifications(notification_service.Notifications.UserNotificationRequest request,
        io.grpc.stub.StreamObserver<notification_service.Notifications.UserNotificationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetUserNotificationsMethod(), responseObserver);
    }

    /**
     */
    public void getNotificationByDate(notification_service.Notifications.GetNotificationByDateRequest request,
        io.grpc.stub.StreamObserver<notification_service.Notifications.GetAllNotificationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetNotificationByDateMethod(), responseObserver);
    }

    /**
     */
    public void customNotification(notification_service.Notifications.CustomNotificationRequest request,
        io.grpc.stub.StreamObserver<notification_service.Notifications.CustomNotificationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCustomNotificationMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getNotifyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                notification_service.Notifications.NotificationRequest,
                notification_service.Notifications.NotificationResponse>(
                  this, METHODID_NOTIFY)))
          .addMethod(
            getGetAllNotificationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                notification_service.Notifications.Empty,
                notification_service.Notifications.GetAllNotificationResponse>(
                  this, METHODID_GET_ALL_NOTIFICATION)))
          .addMethod(
            getGetUserNotificationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                notification_service.Notifications.UserNotificationRequest,
                notification_service.Notifications.UserNotificationResponse>(
                  this, METHODID_GET_USER_NOTIFICATIONS)))
          .addMethod(
            getGetNotificationByDateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                notification_service.Notifications.GetNotificationByDateRequest,
                notification_service.Notifications.GetAllNotificationResponse>(
                  this, METHODID_GET_NOTIFICATION_BY_DATE)))
          .addMethod(
            getCustomNotificationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                notification_service.Notifications.CustomNotificationRequest,
                notification_service.Notifications.CustomNotificationResponse>(
                  this, METHODID_CUSTOM_NOTIFICATION)))
          .build();
    }
  }

  /**
   */
  public static final class NotificationServiceStub extends io.grpc.stub.AbstractAsyncStub<NotificationServiceStub> {
    private NotificationServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NotificationServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NotificationServiceStub(channel, callOptions);
    }

    /**
     */
    public void notify(notification_service.Notifications.NotificationRequest request,
        io.grpc.stub.StreamObserver<notification_service.Notifications.NotificationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getNotifyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllNotification(notification_service.Notifications.Empty request,
        io.grpc.stub.StreamObserver<notification_service.Notifications.GetAllNotificationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllNotificationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUserNotifications(notification_service.Notifications.UserNotificationRequest request,
        io.grpc.stub.StreamObserver<notification_service.Notifications.UserNotificationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUserNotificationsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getNotificationByDate(notification_service.Notifications.GetNotificationByDateRequest request,
        io.grpc.stub.StreamObserver<notification_service.Notifications.GetAllNotificationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetNotificationByDateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void customNotification(notification_service.Notifications.CustomNotificationRequest request,
        io.grpc.stub.StreamObserver<notification_service.Notifications.CustomNotificationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCustomNotificationMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class NotificationServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<NotificationServiceBlockingStub> {
    private NotificationServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NotificationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NotificationServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public notification_service.Notifications.NotificationResponse notify(notification_service.Notifications.NotificationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getNotifyMethod(), getCallOptions(), request);
    }

    /**
     */
    public notification_service.Notifications.GetAllNotificationResponse getAllNotification(notification_service.Notifications.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllNotificationMethod(), getCallOptions(), request);
    }

    /**
     */
    public notification_service.Notifications.UserNotificationResponse getUserNotifications(notification_service.Notifications.UserNotificationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUserNotificationsMethod(), getCallOptions(), request);
    }

    /**
     */
    public notification_service.Notifications.GetAllNotificationResponse getNotificationByDate(notification_service.Notifications.GetNotificationByDateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetNotificationByDateMethod(), getCallOptions(), request);
    }

    /**
     */
    public notification_service.Notifications.CustomNotificationResponse customNotification(notification_service.Notifications.CustomNotificationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCustomNotificationMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class NotificationServiceFutureStub extends io.grpc.stub.AbstractFutureStub<NotificationServiceFutureStub> {
    private NotificationServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NotificationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NotificationServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<notification_service.Notifications.NotificationResponse> notify(
        notification_service.Notifications.NotificationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getNotifyMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<notification_service.Notifications.GetAllNotificationResponse> getAllNotification(
        notification_service.Notifications.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllNotificationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<notification_service.Notifications.UserNotificationResponse> getUserNotifications(
        notification_service.Notifications.UserNotificationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUserNotificationsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<notification_service.Notifications.GetAllNotificationResponse> getNotificationByDate(
        notification_service.Notifications.GetNotificationByDateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetNotificationByDateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<notification_service.Notifications.CustomNotificationResponse> customNotification(
        notification_service.Notifications.CustomNotificationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCustomNotificationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_NOTIFY = 0;
  private static final int METHODID_GET_ALL_NOTIFICATION = 1;
  private static final int METHODID_GET_USER_NOTIFICATIONS = 2;
  private static final int METHODID_GET_NOTIFICATION_BY_DATE = 3;
  private static final int METHODID_CUSTOM_NOTIFICATION = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final NotificationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(NotificationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_NOTIFY:
          serviceImpl.notify((notification_service.Notifications.NotificationRequest) request,
              (io.grpc.stub.StreamObserver<notification_service.Notifications.NotificationResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_NOTIFICATION:
          serviceImpl.getAllNotification((notification_service.Notifications.Empty) request,
              (io.grpc.stub.StreamObserver<notification_service.Notifications.GetAllNotificationResponse>) responseObserver);
          break;
        case METHODID_GET_USER_NOTIFICATIONS:
          serviceImpl.getUserNotifications((notification_service.Notifications.UserNotificationRequest) request,
              (io.grpc.stub.StreamObserver<notification_service.Notifications.UserNotificationResponse>) responseObserver);
          break;
        case METHODID_GET_NOTIFICATION_BY_DATE:
          serviceImpl.getNotificationByDate((notification_service.Notifications.GetNotificationByDateRequest) request,
              (io.grpc.stub.StreamObserver<notification_service.Notifications.GetAllNotificationResponse>) responseObserver);
          break;
        case METHODID_CUSTOM_NOTIFICATION:
          serviceImpl.customNotification((notification_service.Notifications.CustomNotificationRequest) request,
              (io.grpc.stub.StreamObserver<notification_service.Notifications.CustomNotificationResponse>) responseObserver);
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

  private static abstract class NotificationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    NotificationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return notification_service.Notifications.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("NotificationService");
    }
  }

  private static final class NotificationServiceFileDescriptorSupplier
      extends NotificationServiceBaseDescriptorSupplier {
    NotificationServiceFileDescriptorSupplier() {}
  }

  private static final class NotificationServiceMethodDescriptorSupplier
      extends NotificationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    NotificationServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (NotificationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new NotificationServiceFileDescriptorSupplier())
              .addMethod(getNotifyMethod())
              .addMethod(getGetAllNotificationMethod())
              .addMethod(getGetUserNotificationsMethod())
              .addMethod(getGetNotificationByDateMethod())
              .addMethod(getCustomNotificationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
