package auth;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: auth.proto")
public final class AuthServiceGrpc {

  private AuthServiceGrpc() {}

  public static final String SERVICE_NAME = "auth.AuthService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<auth.Auth.Create3ppUserRequest,
      auth.Auth.CreateUserResponse> getCreate3ppUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Create3ppUser",
      requestType = auth.Auth.Create3ppUserRequest.class,
      responseType = auth.Auth.CreateUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<auth.Auth.Create3ppUserRequest,
      auth.Auth.CreateUserResponse> getCreate3ppUserMethod() {
    io.grpc.MethodDescriptor<auth.Auth.Create3ppUserRequest, auth.Auth.CreateUserResponse> getCreate3ppUserMethod;
    if ((getCreate3ppUserMethod = AuthServiceGrpc.getCreate3ppUserMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getCreate3ppUserMethod = AuthServiceGrpc.getCreate3ppUserMethod) == null) {
          AuthServiceGrpc.getCreate3ppUserMethod = getCreate3ppUserMethod =
              io.grpc.MethodDescriptor.<auth.Auth.Create3ppUserRequest, auth.Auth.CreateUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Create3ppUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.Create3ppUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.CreateUserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("Create3ppUser"))
              .build();
        }
      }
    }
    return getCreate3ppUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<auth.Auth.LoginRequest,
      auth.Auth.LoginResponse> getLogin3ppUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Login3ppUser",
      requestType = auth.Auth.LoginRequest.class,
      responseType = auth.Auth.LoginResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<auth.Auth.LoginRequest,
      auth.Auth.LoginResponse> getLogin3ppUserMethod() {
    io.grpc.MethodDescriptor<auth.Auth.LoginRequest, auth.Auth.LoginResponse> getLogin3ppUserMethod;
    if ((getLogin3ppUserMethod = AuthServiceGrpc.getLogin3ppUserMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getLogin3ppUserMethod = AuthServiceGrpc.getLogin3ppUserMethod) == null) {
          AuthServiceGrpc.getLogin3ppUserMethod = getLogin3ppUserMethod =
              io.grpc.MethodDescriptor.<auth.Auth.LoginRequest, auth.Auth.LoginResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Login3ppUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.LoginResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("Login3ppUser"))
              .build();
        }
      }
    }
    return getLogin3ppUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<auth.Auth.ResendVerifyEmailOtpRequest,
      auth.Auth.OtpResponse> getResend3ppVerifyEmailOtpMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Resend3ppVerifyEmailOtp",
      requestType = auth.Auth.ResendVerifyEmailOtpRequest.class,
      responseType = auth.Auth.OtpResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<auth.Auth.ResendVerifyEmailOtpRequest,
      auth.Auth.OtpResponse> getResend3ppVerifyEmailOtpMethod() {
    io.grpc.MethodDescriptor<auth.Auth.ResendVerifyEmailOtpRequest, auth.Auth.OtpResponse> getResend3ppVerifyEmailOtpMethod;
    if ((getResend3ppVerifyEmailOtpMethod = AuthServiceGrpc.getResend3ppVerifyEmailOtpMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getResend3ppVerifyEmailOtpMethod = AuthServiceGrpc.getResend3ppVerifyEmailOtpMethod) == null) {
          AuthServiceGrpc.getResend3ppVerifyEmailOtpMethod = getResend3ppVerifyEmailOtpMethod =
              io.grpc.MethodDescriptor.<auth.Auth.ResendVerifyEmailOtpRequest, auth.Auth.OtpResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Resend3ppVerifyEmailOtp"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.ResendVerifyEmailOtpRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.OtpResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("Resend3ppVerifyEmailOtp"))
              .build();
        }
      }
    }
    return getResend3ppVerifyEmailOtpMethod;
  }

  private static volatile io.grpc.MethodDescriptor<auth.Auth.VerifyPhoneNumberOtpRequest,
      auth.Auth.Empty> getVerify3ppPhoneNumberOtpMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Verify3ppPhoneNumberOtp",
      requestType = auth.Auth.VerifyPhoneNumberOtpRequest.class,
      responseType = auth.Auth.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<auth.Auth.VerifyPhoneNumberOtpRequest,
      auth.Auth.Empty> getVerify3ppPhoneNumberOtpMethod() {
    io.grpc.MethodDescriptor<auth.Auth.VerifyPhoneNumberOtpRequest, auth.Auth.Empty> getVerify3ppPhoneNumberOtpMethod;
    if ((getVerify3ppPhoneNumberOtpMethod = AuthServiceGrpc.getVerify3ppPhoneNumberOtpMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getVerify3ppPhoneNumberOtpMethod = AuthServiceGrpc.getVerify3ppPhoneNumberOtpMethod) == null) {
          AuthServiceGrpc.getVerify3ppPhoneNumberOtpMethod = getVerify3ppPhoneNumberOtpMethod =
              io.grpc.MethodDescriptor.<auth.Auth.VerifyPhoneNumberOtpRequest, auth.Auth.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Verify3ppPhoneNumberOtp"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.VerifyPhoneNumberOtpRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("Verify3ppPhoneNumberOtp"))
              .build();
        }
      }
    }
    return getVerify3ppPhoneNumberOtpMethod;
  }

  private static volatile io.grpc.MethodDescriptor<auth.Auth.VerifyEmailOtpRequest,
      auth.Auth.Empty> getVerify3ppEmailOtpMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Verify3ppEmailOtp",
      requestType = auth.Auth.VerifyEmailOtpRequest.class,
      responseType = auth.Auth.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<auth.Auth.VerifyEmailOtpRequest,
      auth.Auth.Empty> getVerify3ppEmailOtpMethod() {
    io.grpc.MethodDescriptor<auth.Auth.VerifyEmailOtpRequest, auth.Auth.Empty> getVerify3ppEmailOtpMethod;
    if ((getVerify3ppEmailOtpMethod = AuthServiceGrpc.getVerify3ppEmailOtpMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getVerify3ppEmailOtpMethod = AuthServiceGrpc.getVerify3ppEmailOtpMethod) == null) {
          AuthServiceGrpc.getVerify3ppEmailOtpMethod = getVerify3ppEmailOtpMethod =
              io.grpc.MethodDescriptor.<auth.Auth.VerifyEmailOtpRequest, auth.Auth.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Verify3ppEmailOtp"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.VerifyEmailOtpRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("Verify3ppEmailOtp"))
              .build();
        }
      }
    }
    return getVerify3ppEmailOtpMethod;
  }

  private static volatile io.grpc.MethodDescriptor<auth.Auth.ForgotPasswordOtpRequest,
      auth.Auth.OtpResponse> getForgot3ppPasswordOtpMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Forgot3ppPasswordOtp",
      requestType = auth.Auth.ForgotPasswordOtpRequest.class,
      responseType = auth.Auth.OtpResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<auth.Auth.ForgotPasswordOtpRequest,
      auth.Auth.OtpResponse> getForgot3ppPasswordOtpMethod() {
    io.grpc.MethodDescriptor<auth.Auth.ForgotPasswordOtpRequest, auth.Auth.OtpResponse> getForgot3ppPasswordOtpMethod;
    if ((getForgot3ppPasswordOtpMethod = AuthServiceGrpc.getForgot3ppPasswordOtpMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getForgot3ppPasswordOtpMethod = AuthServiceGrpc.getForgot3ppPasswordOtpMethod) == null) {
          AuthServiceGrpc.getForgot3ppPasswordOtpMethod = getForgot3ppPasswordOtpMethod =
              io.grpc.MethodDescriptor.<auth.Auth.ForgotPasswordOtpRequest, auth.Auth.OtpResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Forgot3ppPasswordOtp"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.ForgotPasswordOtpRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.OtpResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("Forgot3ppPasswordOtp"))
              .build();
        }
      }
    }
    return getForgot3ppPasswordOtpMethod;
  }

  private static volatile io.grpc.MethodDescriptor<auth.Auth.VerifyResetPasswordOtpRequest,
      auth.Auth.Empty> getVerify3ppResetPasswordOtpMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Verify3ppResetPasswordOtp",
      requestType = auth.Auth.VerifyResetPasswordOtpRequest.class,
      responseType = auth.Auth.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<auth.Auth.VerifyResetPasswordOtpRequest,
      auth.Auth.Empty> getVerify3ppResetPasswordOtpMethod() {
    io.grpc.MethodDescriptor<auth.Auth.VerifyResetPasswordOtpRequest, auth.Auth.Empty> getVerify3ppResetPasswordOtpMethod;
    if ((getVerify3ppResetPasswordOtpMethod = AuthServiceGrpc.getVerify3ppResetPasswordOtpMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getVerify3ppResetPasswordOtpMethod = AuthServiceGrpc.getVerify3ppResetPasswordOtpMethod) == null) {
          AuthServiceGrpc.getVerify3ppResetPasswordOtpMethod = getVerify3ppResetPasswordOtpMethod =
              io.grpc.MethodDescriptor.<auth.Auth.VerifyResetPasswordOtpRequest, auth.Auth.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Verify3ppResetPasswordOtp"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.VerifyResetPasswordOtpRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("Verify3ppResetPasswordOtp"))
              .build();
        }
      }
    }
    return getVerify3ppResetPasswordOtpMethod;
  }

  private static volatile io.grpc.MethodDescriptor<auth.Auth.AuthenticateUserRequest,
      auth.Auth.AuthenticateUserResponse> getAuthenticate3ppAccessMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Authenticate3ppAccess",
      requestType = auth.Auth.AuthenticateUserRequest.class,
      responseType = auth.Auth.AuthenticateUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<auth.Auth.AuthenticateUserRequest,
      auth.Auth.AuthenticateUserResponse> getAuthenticate3ppAccessMethod() {
    io.grpc.MethodDescriptor<auth.Auth.AuthenticateUserRequest, auth.Auth.AuthenticateUserResponse> getAuthenticate3ppAccessMethod;
    if ((getAuthenticate3ppAccessMethod = AuthServiceGrpc.getAuthenticate3ppAccessMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getAuthenticate3ppAccessMethod = AuthServiceGrpc.getAuthenticate3ppAccessMethod) == null) {
          AuthServiceGrpc.getAuthenticate3ppAccessMethod = getAuthenticate3ppAccessMethod =
              io.grpc.MethodDescriptor.<auth.Auth.AuthenticateUserRequest, auth.Auth.AuthenticateUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Authenticate3ppAccess"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.AuthenticateUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.AuthenticateUserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("Authenticate3ppAccess"))
              .build();
        }
      }
    }
    return getAuthenticate3ppAccessMethod;
  }

  private static volatile io.grpc.MethodDescriptor<auth.Auth.GenerateApiKeyRequest,
      auth.Auth.GenerateApiKeyResponse> getGenerateApiKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateApiKey",
      requestType = auth.Auth.GenerateApiKeyRequest.class,
      responseType = auth.Auth.GenerateApiKeyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<auth.Auth.GenerateApiKeyRequest,
      auth.Auth.GenerateApiKeyResponse> getGenerateApiKeyMethod() {
    io.grpc.MethodDescriptor<auth.Auth.GenerateApiKeyRequest, auth.Auth.GenerateApiKeyResponse> getGenerateApiKeyMethod;
    if ((getGenerateApiKeyMethod = AuthServiceGrpc.getGenerateApiKeyMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getGenerateApiKeyMethod = AuthServiceGrpc.getGenerateApiKeyMethod) == null) {
          AuthServiceGrpc.getGenerateApiKeyMethod = getGenerateApiKeyMethod =
              io.grpc.MethodDescriptor.<auth.Auth.GenerateApiKeyRequest, auth.Auth.GenerateApiKeyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateApiKey"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.GenerateApiKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.GenerateApiKeyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("GenerateApiKey"))
              .build();
        }
      }
    }
    return getGenerateApiKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<auth.Auth.RegenerateApiKeyRequest,
      auth.Auth.RegenerateApiKeyResponse> getRegenerateApiKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RegenerateApiKey",
      requestType = auth.Auth.RegenerateApiKeyRequest.class,
      responseType = auth.Auth.RegenerateApiKeyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<auth.Auth.RegenerateApiKeyRequest,
      auth.Auth.RegenerateApiKeyResponse> getRegenerateApiKeyMethod() {
    io.grpc.MethodDescriptor<auth.Auth.RegenerateApiKeyRequest, auth.Auth.RegenerateApiKeyResponse> getRegenerateApiKeyMethod;
    if ((getRegenerateApiKeyMethod = AuthServiceGrpc.getRegenerateApiKeyMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getRegenerateApiKeyMethod = AuthServiceGrpc.getRegenerateApiKeyMethod) == null) {
          AuthServiceGrpc.getRegenerateApiKeyMethod = getRegenerateApiKeyMethod =
              io.grpc.MethodDescriptor.<auth.Auth.RegenerateApiKeyRequest, auth.Auth.RegenerateApiKeyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RegenerateApiKey"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.RegenerateApiKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.RegenerateApiKeyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("RegenerateApiKey"))
              .build();
        }
      }
    }
    return getRegenerateApiKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<auth.Auth.AuthenticateApiKeyRequest,
      auth.Auth.AuthenticateApiKeyResponse> getAuthenticateApiKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AuthenticateApiKey",
      requestType = auth.Auth.AuthenticateApiKeyRequest.class,
      responseType = auth.Auth.AuthenticateApiKeyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<auth.Auth.AuthenticateApiKeyRequest,
      auth.Auth.AuthenticateApiKeyResponse> getAuthenticateApiKeyMethod() {
    io.grpc.MethodDescriptor<auth.Auth.AuthenticateApiKeyRequest, auth.Auth.AuthenticateApiKeyResponse> getAuthenticateApiKeyMethod;
    if ((getAuthenticateApiKeyMethod = AuthServiceGrpc.getAuthenticateApiKeyMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getAuthenticateApiKeyMethod = AuthServiceGrpc.getAuthenticateApiKeyMethod) == null) {
          AuthServiceGrpc.getAuthenticateApiKeyMethod = getAuthenticateApiKeyMethod =
              io.grpc.MethodDescriptor.<auth.Auth.AuthenticateApiKeyRequest, auth.Auth.AuthenticateApiKeyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AuthenticateApiKey"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.AuthenticateApiKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.AuthenticateApiKeyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("AuthenticateApiKey"))
              .build();
        }
      }
    }
    return getAuthenticateApiKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<auth.Auth.TwoFactorAuthRequest,
      auth.Auth.TwoFactorAuthResponse> getTwoFactorAuthMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TwoFactorAuth",
      requestType = auth.Auth.TwoFactorAuthRequest.class,
      responseType = auth.Auth.TwoFactorAuthResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<auth.Auth.TwoFactorAuthRequest,
      auth.Auth.TwoFactorAuthResponse> getTwoFactorAuthMethod() {
    io.grpc.MethodDescriptor<auth.Auth.TwoFactorAuthRequest, auth.Auth.TwoFactorAuthResponse> getTwoFactorAuthMethod;
    if ((getTwoFactorAuthMethod = AuthServiceGrpc.getTwoFactorAuthMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getTwoFactorAuthMethod = AuthServiceGrpc.getTwoFactorAuthMethod) == null) {
          AuthServiceGrpc.getTwoFactorAuthMethod = getTwoFactorAuthMethod =
              io.grpc.MethodDescriptor.<auth.Auth.TwoFactorAuthRequest, auth.Auth.TwoFactorAuthResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TwoFactorAuth"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.TwoFactorAuthRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.TwoFactorAuthResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("TwoFactorAuth"))
              .build();
        }
      }
    }
    return getTwoFactorAuthMethod;
  }

  private static volatile io.grpc.MethodDescriptor<auth.Auth.GetPhoneNumberOtpRequest,
      auth.Auth.OtpResponse> getGet3ppPhoneNumberOtpMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Get3ppPhoneNumberOtp",
      requestType = auth.Auth.GetPhoneNumberOtpRequest.class,
      responseType = auth.Auth.OtpResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<auth.Auth.GetPhoneNumberOtpRequest,
      auth.Auth.OtpResponse> getGet3ppPhoneNumberOtpMethod() {
    io.grpc.MethodDescriptor<auth.Auth.GetPhoneNumberOtpRequest, auth.Auth.OtpResponse> getGet3ppPhoneNumberOtpMethod;
    if ((getGet3ppPhoneNumberOtpMethod = AuthServiceGrpc.getGet3ppPhoneNumberOtpMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getGet3ppPhoneNumberOtpMethod = AuthServiceGrpc.getGet3ppPhoneNumberOtpMethod) == null) {
          AuthServiceGrpc.getGet3ppPhoneNumberOtpMethod = getGet3ppPhoneNumberOtpMethod =
              io.grpc.MethodDescriptor.<auth.Auth.GetPhoneNumberOtpRequest, auth.Auth.OtpResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Get3ppPhoneNumberOtp"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.GetPhoneNumberOtpRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.OtpResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("Get3ppPhoneNumberOtp"))
              .build();
        }
      }
    }
    return getGet3ppPhoneNumberOtpMethod;
  }

  private static volatile io.grpc.MethodDescriptor<auth.Auth.Create3ppWebhookRequest,
      auth.Auth.Empty> getCreate3ppWebhookDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Create3ppWebhookData",
      requestType = auth.Auth.Create3ppWebhookRequest.class,
      responseType = auth.Auth.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<auth.Auth.Create3ppWebhookRequest,
      auth.Auth.Empty> getCreate3ppWebhookDataMethod() {
    io.grpc.MethodDescriptor<auth.Auth.Create3ppWebhookRequest, auth.Auth.Empty> getCreate3ppWebhookDataMethod;
    if ((getCreate3ppWebhookDataMethod = AuthServiceGrpc.getCreate3ppWebhookDataMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getCreate3ppWebhookDataMethod = AuthServiceGrpc.getCreate3ppWebhookDataMethod) == null) {
          AuthServiceGrpc.getCreate3ppWebhookDataMethod = getCreate3ppWebhookDataMethod =
              io.grpc.MethodDescriptor.<auth.Auth.Create3ppWebhookRequest, auth.Auth.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Create3ppWebhookData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.Create3ppWebhookRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("Create3ppWebhookData"))
              .build();
        }
      }
    }
    return getCreate3ppWebhookDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<auth.Auth.Get3ppWebhookRequest,
      auth.Auth.Get3ppWebhookResponse> getGet3ppWebhookDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Get3ppWebhookData",
      requestType = auth.Auth.Get3ppWebhookRequest.class,
      responseType = auth.Auth.Get3ppWebhookResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<auth.Auth.Get3ppWebhookRequest,
      auth.Auth.Get3ppWebhookResponse> getGet3ppWebhookDataMethod() {
    io.grpc.MethodDescriptor<auth.Auth.Get3ppWebhookRequest, auth.Auth.Get3ppWebhookResponse> getGet3ppWebhookDataMethod;
    if ((getGet3ppWebhookDataMethod = AuthServiceGrpc.getGet3ppWebhookDataMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getGet3ppWebhookDataMethod = AuthServiceGrpc.getGet3ppWebhookDataMethod) == null) {
          AuthServiceGrpc.getGet3ppWebhookDataMethod = getGet3ppWebhookDataMethod =
              io.grpc.MethodDescriptor.<auth.Auth.Get3ppWebhookRequest, auth.Auth.Get3ppWebhookResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Get3ppWebhookData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.Get3ppWebhookRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.Get3ppWebhookResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("Get3ppWebhookData"))
              .build();
        }
      }
    }
    return getGet3ppWebhookDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<auth.Auth.Update3ppWebhookRequest,
      auth.Auth.Empty> getUpdate3ppWebhookDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Update3ppWebhookData",
      requestType = auth.Auth.Update3ppWebhookRequest.class,
      responseType = auth.Auth.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<auth.Auth.Update3ppWebhookRequest,
      auth.Auth.Empty> getUpdate3ppWebhookDataMethod() {
    io.grpc.MethodDescriptor<auth.Auth.Update3ppWebhookRequest, auth.Auth.Empty> getUpdate3ppWebhookDataMethod;
    if ((getUpdate3ppWebhookDataMethod = AuthServiceGrpc.getUpdate3ppWebhookDataMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getUpdate3ppWebhookDataMethod = AuthServiceGrpc.getUpdate3ppWebhookDataMethod) == null) {
          AuthServiceGrpc.getUpdate3ppWebhookDataMethod = getUpdate3ppWebhookDataMethod =
              io.grpc.MethodDescriptor.<auth.Auth.Update3ppWebhookRequest, auth.Auth.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Update3ppWebhookData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.Update3ppWebhookRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("Update3ppWebhookData"))
              .build();
        }
      }
    }
    return getUpdate3ppWebhookDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<auth.Auth.Get3ppUserDataRequest,
      auth.Auth.Get3ppUserDataResponse> getGet3ppUserDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Get3ppUserData",
      requestType = auth.Auth.Get3ppUserDataRequest.class,
      responseType = auth.Auth.Get3ppUserDataResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<auth.Auth.Get3ppUserDataRequest,
      auth.Auth.Get3ppUserDataResponse> getGet3ppUserDataMethod() {
    io.grpc.MethodDescriptor<auth.Auth.Get3ppUserDataRequest, auth.Auth.Get3ppUserDataResponse> getGet3ppUserDataMethod;
    if ((getGet3ppUserDataMethod = AuthServiceGrpc.getGet3ppUserDataMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getGet3ppUserDataMethod = AuthServiceGrpc.getGet3ppUserDataMethod) == null) {
          AuthServiceGrpc.getGet3ppUserDataMethod = getGet3ppUserDataMethod =
              io.grpc.MethodDescriptor.<auth.Auth.Get3ppUserDataRequest, auth.Auth.Get3ppUserDataResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Get3ppUserData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.Get3ppUserDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.Get3ppUserDataResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("Get3ppUserData"))
              .build();
        }
      }
    }
    return getGet3ppUserDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<auth.Auth.Get2faQrCodeUrlRequest,
      auth.Auth.Get2faQrCodeUrlResponse> getGet2faQrCodeUrlMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Get2faQrCodeUrl",
      requestType = auth.Auth.Get2faQrCodeUrlRequest.class,
      responseType = auth.Auth.Get2faQrCodeUrlResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<auth.Auth.Get2faQrCodeUrlRequest,
      auth.Auth.Get2faQrCodeUrlResponse> getGet2faQrCodeUrlMethod() {
    io.grpc.MethodDescriptor<auth.Auth.Get2faQrCodeUrlRequest, auth.Auth.Get2faQrCodeUrlResponse> getGet2faQrCodeUrlMethod;
    if ((getGet2faQrCodeUrlMethod = AuthServiceGrpc.getGet2faQrCodeUrlMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getGet2faQrCodeUrlMethod = AuthServiceGrpc.getGet2faQrCodeUrlMethod) == null) {
          AuthServiceGrpc.getGet2faQrCodeUrlMethod = getGet2faQrCodeUrlMethod =
              io.grpc.MethodDescriptor.<auth.Auth.Get2faQrCodeUrlRequest, auth.Auth.Get2faQrCodeUrlResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Get2faQrCodeUrl"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.Get2faQrCodeUrlRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.Get2faQrCodeUrlResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("Get2faQrCodeUrl"))
              .build();
        }
      }
    }
    return getGet2faQrCodeUrlMethod;
  }

  private static volatile io.grpc.MethodDescriptor<auth.Auth.GetByUniqueDataRequest,
      auth.Auth.GetByUniqueDataResponse> getGet3ppByUniqueDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Get3ppByUniqueData",
      requestType = auth.Auth.GetByUniqueDataRequest.class,
      responseType = auth.Auth.GetByUniqueDataResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<auth.Auth.GetByUniqueDataRequest,
      auth.Auth.GetByUniqueDataResponse> getGet3ppByUniqueDataMethod() {
    io.grpc.MethodDescriptor<auth.Auth.GetByUniqueDataRequest, auth.Auth.GetByUniqueDataResponse> getGet3ppByUniqueDataMethod;
    if ((getGet3ppByUniqueDataMethod = AuthServiceGrpc.getGet3ppByUniqueDataMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getGet3ppByUniqueDataMethod = AuthServiceGrpc.getGet3ppByUniqueDataMethod) == null) {
          AuthServiceGrpc.getGet3ppByUniqueDataMethod = getGet3ppByUniqueDataMethod =
              io.grpc.MethodDescriptor.<auth.Auth.GetByUniqueDataRequest, auth.Auth.GetByUniqueDataResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Get3ppByUniqueData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.GetByUniqueDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.GetByUniqueDataResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("Get3ppByUniqueData"))
              .build();
        }
      }
    }
    return getGet3ppByUniqueDataMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AuthServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AuthServiceStub>() {
        @java.lang.Override
        public AuthServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AuthServiceStub(channel, callOptions);
        }
      };
    return AuthServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AuthServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AuthServiceBlockingStub>() {
        @java.lang.Override
        public AuthServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AuthServiceBlockingStub(channel, callOptions);
        }
      };
    return AuthServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AuthServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AuthServiceFutureStub>() {
        @java.lang.Override
        public AuthServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AuthServiceFutureStub(channel, callOptions);
        }
      };
    return AuthServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class AuthServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void create3ppUser(auth.Auth.Create3ppUserRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.CreateUserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreate3ppUserMethod(), responseObserver);
    }

    /**
     */
    public void login3ppUser(auth.Auth.LoginRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.LoginResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLogin3ppUserMethod(), responseObserver);
    }

    /**
     */
    public void resend3ppVerifyEmailOtp(auth.Auth.ResendVerifyEmailOtpRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.OtpResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getResend3ppVerifyEmailOtpMethod(), responseObserver);
    }

    /**
     */
    public void verify3ppPhoneNumberOtp(auth.Auth.VerifyPhoneNumberOtpRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getVerify3ppPhoneNumberOtpMethod(), responseObserver);
    }

    /**
     */
    public void verify3ppEmailOtp(auth.Auth.VerifyEmailOtpRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getVerify3ppEmailOtpMethod(), responseObserver);
    }

    /**
     */
    public void forgot3ppPasswordOtp(auth.Auth.ForgotPasswordOtpRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.OtpResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getForgot3ppPasswordOtpMethod(), responseObserver);
    }

    /**
     */
    public void verify3ppResetPasswordOtp(auth.Auth.VerifyResetPasswordOtpRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getVerify3ppResetPasswordOtpMethod(), responseObserver);
    }

    /**
     */
    public void authenticate3ppAccess(auth.Auth.AuthenticateUserRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.AuthenticateUserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAuthenticate3ppAccessMethod(), responseObserver);
    }

    /**
     */
    public void generateApiKey(auth.Auth.GenerateApiKeyRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.GenerateApiKeyResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenerateApiKeyMethod(), responseObserver);
    }

    /**
     */
    public void regenerateApiKey(auth.Auth.RegenerateApiKeyRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.RegenerateApiKeyResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRegenerateApiKeyMethod(), responseObserver);
    }

    /**
     */
    public void authenticateApiKey(auth.Auth.AuthenticateApiKeyRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.AuthenticateApiKeyResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAuthenticateApiKeyMethod(), responseObserver);
    }

    /**
     */
    public void twoFactorAuth(auth.Auth.TwoFactorAuthRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.TwoFactorAuthResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTwoFactorAuthMethod(), responseObserver);
    }

    /**
     */
    public void get3ppPhoneNumberOtp(auth.Auth.GetPhoneNumberOtpRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.OtpResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGet3ppPhoneNumberOtpMethod(), responseObserver);
    }

    /**
     */
    public void create3ppWebhookData(auth.Auth.Create3ppWebhookRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreate3ppWebhookDataMethod(), responseObserver);
    }

    /**
     */
    public void get3ppWebhookData(auth.Auth.Get3ppWebhookRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.Get3ppWebhookResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGet3ppWebhookDataMethod(), responseObserver);
    }

    /**
     */
    public void update3ppWebhookData(auth.Auth.Update3ppWebhookRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdate3ppWebhookDataMethod(), responseObserver);
    }

    /**
     */
    public void get3ppUserData(auth.Auth.Get3ppUserDataRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.Get3ppUserDataResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGet3ppUserDataMethod(), responseObserver);
    }

    /**
     */
    public void get2faQrCodeUrl(auth.Auth.Get2faQrCodeUrlRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.Get2faQrCodeUrlResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGet2faQrCodeUrlMethod(), responseObserver);
    }

    /**
     * <pre>
     * rpc GetRolePrivileges(GetRolePrivilegesRequest) returns (GetPrivilegesResponse){}
     * rpc GetEmployeeRoles(GetEmployeeRolesRequest) returns (GetEmployeeRolesResponse){}
     * </pre>
     */
    public void get3ppByUniqueData(auth.Auth.GetByUniqueDataRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.GetByUniqueDataResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGet3ppByUniqueDataMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreate3ppUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                auth.Auth.Create3ppUserRequest,
                auth.Auth.CreateUserResponse>(
                  this, METHODID_CREATE3PP_USER)))
          .addMethod(
            getLogin3ppUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                auth.Auth.LoginRequest,
                auth.Auth.LoginResponse>(
                  this, METHODID_LOGIN3PP_USER)))
          .addMethod(
            getResend3ppVerifyEmailOtpMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                auth.Auth.ResendVerifyEmailOtpRequest,
                auth.Auth.OtpResponse>(
                  this, METHODID_RESEND3PP_VERIFY_EMAIL_OTP)))
          .addMethod(
            getVerify3ppPhoneNumberOtpMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                auth.Auth.VerifyPhoneNumberOtpRequest,
                auth.Auth.Empty>(
                  this, METHODID_VERIFY3PP_PHONE_NUMBER_OTP)))
          .addMethod(
            getVerify3ppEmailOtpMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                auth.Auth.VerifyEmailOtpRequest,
                auth.Auth.Empty>(
                  this, METHODID_VERIFY3PP_EMAIL_OTP)))
          .addMethod(
            getForgot3ppPasswordOtpMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                auth.Auth.ForgotPasswordOtpRequest,
                auth.Auth.OtpResponse>(
                  this, METHODID_FORGOT3PP_PASSWORD_OTP)))
          .addMethod(
            getVerify3ppResetPasswordOtpMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                auth.Auth.VerifyResetPasswordOtpRequest,
                auth.Auth.Empty>(
                  this, METHODID_VERIFY3PP_RESET_PASSWORD_OTP)))
          .addMethod(
            getAuthenticate3ppAccessMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                auth.Auth.AuthenticateUserRequest,
                auth.Auth.AuthenticateUserResponse>(
                  this, METHODID_AUTHENTICATE3PP_ACCESS)))
          .addMethod(
            getGenerateApiKeyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                auth.Auth.GenerateApiKeyRequest,
                auth.Auth.GenerateApiKeyResponse>(
                  this, METHODID_GENERATE_API_KEY)))
          .addMethod(
            getRegenerateApiKeyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                auth.Auth.RegenerateApiKeyRequest,
                auth.Auth.RegenerateApiKeyResponse>(
                  this, METHODID_REGENERATE_API_KEY)))
          .addMethod(
            getAuthenticateApiKeyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                auth.Auth.AuthenticateApiKeyRequest,
                auth.Auth.AuthenticateApiKeyResponse>(
                  this, METHODID_AUTHENTICATE_API_KEY)))
          .addMethod(
            getTwoFactorAuthMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                auth.Auth.TwoFactorAuthRequest,
                auth.Auth.TwoFactorAuthResponse>(
                  this, METHODID_TWO_FACTOR_AUTH)))
          .addMethod(
            getGet3ppPhoneNumberOtpMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                auth.Auth.GetPhoneNumberOtpRequest,
                auth.Auth.OtpResponse>(
                  this, METHODID_GET3PP_PHONE_NUMBER_OTP)))
          .addMethod(
            getCreate3ppWebhookDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                auth.Auth.Create3ppWebhookRequest,
                auth.Auth.Empty>(
                  this, METHODID_CREATE3PP_WEBHOOK_DATA)))
          .addMethod(
            getGet3ppWebhookDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                auth.Auth.Get3ppWebhookRequest,
                auth.Auth.Get3ppWebhookResponse>(
                  this, METHODID_GET3PP_WEBHOOK_DATA)))
          .addMethod(
            getUpdate3ppWebhookDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                auth.Auth.Update3ppWebhookRequest,
                auth.Auth.Empty>(
                  this, METHODID_UPDATE3PP_WEBHOOK_DATA)))
          .addMethod(
            getGet3ppUserDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                auth.Auth.Get3ppUserDataRequest,
                auth.Auth.Get3ppUserDataResponse>(
                  this, METHODID_GET3PP_USER_DATA)))
          .addMethod(
            getGet2faQrCodeUrlMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                auth.Auth.Get2faQrCodeUrlRequest,
                auth.Auth.Get2faQrCodeUrlResponse>(
                  this, METHODID_GET2FA_QR_CODE_URL)))
          .addMethod(
            getGet3ppByUniqueDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                auth.Auth.GetByUniqueDataRequest,
                auth.Auth.GetByUniqueDataResponse>(
                  this, METHODID_GET3PP_BY_UNIQUE_DATA)))
          .build();
    }
  }

  /**
   */
  public static final class AuthServiceStub extends io.grpc.stub.AbstractAsyncStub<AuthServiceStub> {
    private AuthServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthServiceStub(channel, callOptions);
    }

    /**
     */
    public void create3ppUser(auth.Auth.Create3ppUserRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.CreateUserResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreate3ppUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void login3ppUser(auth.Auth.LoginRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.LoginResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLogin3ppUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void resend3ppVerifyEmailOtp(auth.Auth.ResendVerifyEmailOtpRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.OtpResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResend3ppVerifyEmailOtpMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void verify3ppPhoneNumberOtp(auth.Auth.VerifyPhoneNumberOtpRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getVerify3ppPhoneNumberOtpMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void verify3ppEmailOtp(auth.Auth.VerifyEmailOtpRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getVerify3ppEmailOtpMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void forgot3ppPasswordOtp(auth.Auth.ForgotPasswordOtpRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.OtpResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getForgot3ppPasswordOtpMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void verify3ppResetPasswordOtp(auth.Auth.VerifyResetPasswordOtpRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getVerify3ppResetPasswordOtpMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void authenticate3ppAccess(auth.Auth.AuthenticateUserRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.AuthenticateUserResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAuthenticate3ppAccessMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void generateApiKey(auth.Auth.GenerateApiKeyRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.GenerateApiKeyResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateApiKeyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void regenerateApiKey(auth.Auth.RegenerateApiKeyRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.RegenerateApiKeyResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRegenerateApiKeyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void authenticateApiKey(auth.Auth.AuthenticateApiKeyRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.AuthenticateApiKeyResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAuthenticateApiKeyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void twoFactorAuth(auth.Auth.TwoFactorAuthRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.TwoFactorAuthResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTwoFactorAuthMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void get3ppPhoneNumberOtp(auth.Auth.GetPhoneNumberOtpRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.OtpResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGet3ppPhoneNumberOtpMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void create3ppWebhookData(auth.Auth.Create3ppWebhookRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreate3ppWebhookDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void get3ppWebhookData(auth.Auth.Get3ppWebhookRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.Get3ppWebhookResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGet3ppWebhookDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void update3ppWebhookData(auth.Auth.Update3ppWebhookRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdate3ppWebhookDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void get3ppUserData(auth.Auth.Get3ppUserDataRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.Get3ppUserDataResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGet3ppUserDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void get2faQrCodeUrl(auth.Auth.Get2faQrCodeUrlRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.Get2faQrCodeUrlResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGet2faQrCodeUrlMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * rpc GetRolePrivileges(GetRolePrivilegesRequest) returns (GetPrivilegesResponse){}
     * rpc GetEmployeeRoles(GetEmployeeRolesRequest) returns (GetEmployeeRolesResponse){}
     * </pre>
     */
    public void get3ppByUniqueData(auth.Auth.GetByUniqueDataRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.GetByUniqueDataResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGet3ppByUniqueDataMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AuthServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<AuthServiceBlockingStub> {
    private AuthServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public auth.Auth.CreateUserResponse create3ppUser(auth.Auth.Create3ppUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreate3ppUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public auth.Auth.LoginResponse login3ppUser(auth.Auth.LoginRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLogin3ppUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public auth.Auth.OtpResponse resend3ppVerifyEmailOtp(auth.Auth.ResendVerifyEmailOtpRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResend3ppVerifyEmailOtpMethod(), getCallOptions(), request);
    }

    /**
     */
    public auth.Auth.Empty verify3ppPhoneNumberOtp(auth.Auth.VerifyPhoneNumberOtpRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getVerify3ppPhoneNumberOtpMethod(), getCallOptions(), request);
    }

    /**
     */
    public auth.Auth.Empty verify3ppEmailOtp(auth.Auth.VerifyEmailOtpRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getVerify3ppEmailOtpMethod(), getCallOptions(), request);
    }

    /**
     */
    public auth.Auth.OtpResponse forgot3ppPasswordOtp(auth.Auth.ForgotPasswordOtpRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getForgot3ppPasswordOtpMethod(), getCallOptions(), request);
    }

    /**
     */
    public auth.Auth.Empty verify3ppResetPasswordOtp(auth.Auth.VerifyResetPasswordOtpRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getVerify3ppResetPasswordOtpMethod(), getCallOptions(), request);
    }

    /**
     */
    public auth.Auth.AuthenticateUserResponse authenticate3ppAccess(auth.Auth.AuthenticateUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAuthenticate3ppAccessMethod(), getCallOptions(), request);
    }

    /**
     */
    public auth.Auth.GenerateApiKeyResponse generateApiKey(auth.Auth.GenerateApiKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateApiKeyMethod(), getCallOptions(), request);
    }

    /**
     */
    public auth.Auth.RegenerateApiKeyResponse regenerateApiKey(auth.Auth.RegenerateApiKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRegenerateApiKeyMethod(), getCallOptions(), request);
    }

    /**
     */
    public auth.Auth.AuthenticateApiKeyResponse authenticateApiKey(auth.Auth.AuthenticateApiKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAuthenticateApiKeyMethod(), getCallOptions(), request);
    }

    /**
     */
    public auth.Auth.TwoFactorAuthResponse twoFactorAuth(auth.Auth.TwoFactorAuthRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTwoFactorAuthMethod(), getCallOptions(), request);
    }

    /**
     */
    public auth.Auth.OtpResponse get3ppPhoneNumberOtp(auth.Auth.GetPhoneNumberOtpRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGet3ppPhoneNumberOtpMethod(), getCallOptions(), request);
    }

    /**
     */
    public auth.Auth.Empty create3ppWebhookData(auth.Auth.Create3ppWebhookRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreate3ppWebhookDataMethod(), getCallOptions(), request);
    }

    /**
     */
    public auth.Auth.Get3ppWebhookResponse get3ppWebhookData(auth.Auth.Get3ppWebhookRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGet3ppWebhookDataMethod(), getCallOptions(), request);
    }

    /**
     */
    public auth.Auth.Empty update3ppWebhookData(auth.Auth.Update3ppWebhookRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdate3ppWebhookDataMethod(), getCallOptions(), request);
    }

    /**
     */
    public auth.Auth.Get3ppUserDataResponse get3ppUserData(auth.Auth.Get3ppUserDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGet3ppUserDataMethod(), getCallOptions(), request);
    }

    /**
     */
    public auth.Auth.Get2faQrCodeUrlResponse get2faQrCodeUrl(auth.Auth.Get2faQrCodeUrlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGet2faQrCodeUrlMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * rpc GetRolePrivileges(GetRolePrivilegesRequest) returns (GetPrivilegesResponse){}
     * rpc GetEmployeeRoles(GetEmployeeRolesRequest) returns (GetEmployeeRolesResponse){}
     * </pre>
     */
    public auth.Auth.GetByUniqueDataResponse get3ppByUniqueData(auth.Auth.GetByUniqueDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGet3ppByUniqueDataMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AuthServiceFutureStub extends io.grpc.stub.AbstractFutureStub<AuthServiceFutureStub> {
    private AuthServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<auth.Auth.CreateUserResponse> create3ppUser(
        auth.Auth.Create3ppUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreate3ppUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<auth.Auth.LoginResponse> login3ppUser(
        auth.Auth.LoginRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLogin3ppUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<auth.Auth.OtpResponse> resend3ppVerifyEmailOtp(
        auth.Auth.ResendVerifyEmailOtpRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResend3ppVerifyEmailOtpMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<auth.Auth.Empty> verify3ppPhoneNumberOtp(
        auth.Auth.VerifyPhoneNumberOtpRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getVerify3ppPhoneNumberOtpMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<auth.Auth.Empty> verify3ppEmailOtp(
        auth.Auth.VerifyEmailOtpRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getVerify3ppEmailOtpMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<auth.Auth.OtpResponse> forgot3ppPasswordOtp(
        auth.Auth.ForgotPasswordOtpRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getForgot3ppPasswordOtpMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<auth.Auth.Empty> verify3ppResetPasswordOtp(
        auth.Auth.VerifyResetPasswordOtpRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getVerify3ppResetPasswordOtpMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<auth.Auth.AuthenticateUserResponse> authenticate3ppAccess(
        auth.Auth.AuthenticateUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAuthenticate3ppAccessMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<auth.Auth.GenerateApiKeyResponse> generateApiKey(
        auth.Auth.GenerateApiKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateApiKeyMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<auth.Auth.RegenerateApiKeyResponse> regenerateApiKey(
        auth.Auth.RegenerateApiKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRegenerateApiKeyMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<auth.Auth.AuthenticateApiKeyResponse> authenticateApiKey(
        auth.Auth.AuthenticateApiKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAuthenticateApiKeyMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<auth.Auth.TwoFactorAuthResponse> twoFactorAuth(
        auth.Auth.TwoFactorAuthRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTwoFactorAuthMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<auth.Auth.OtpResponse> get3ppPhoneNumberOtp(
        auth.Auth.GetPhoneNumberOtpRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGet3ppPhoneNumberOtpMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<auth.Auth.Empty> create3ppWebhookData(
        auth.Auth.Create3ppWebhookRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreate3ppWebhookDataMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<auth.Auth.Get3ppWebhookResponse> get3ppWebhookData(
        auth.Auth.Get3ppWebhookRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGet3ppWebhookDataMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<auth.Auth.Empty> update3ppWebhookData(
        auth.Auth.Update3ppWebhookRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdate3ppWebhookDataMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<auth.Auth.Get3ppUserDataResponse> get3ppUserData(
        auth.Auth.Get3ppUserDataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGet3ppUserDataMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<auth.Auth.Get2faQrCodeUrlResponse> get2faQrCodeUrl(
        auth.Auth.Get2faQrCodeUrlRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGet2faQrCodeUrlMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * rpc GetRolePrivileges(GetRolePrivilegesRequest) returns (GetPrivilegesResponse){}
     * rpc GetEmployeeRoles(GetEmployeeRolesRequest) returns (GetEmployeeRolesResponse){}
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<auth.Auth.GetByUniqueDataResponse> get3ppByUniqueData(
        auth.Auth.GetByUniqueDataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGet3ppByUniqueDataMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE3PP_USER = 0;
  private static final int METHODID_LOGIN3PP_USER = 1;
  private static final int METHODID_RESEND3PP_VERIFY_EMAIL_OTP = 2;
  private static final int METHODID_VERIFY3PP_PHONE_NUMBER_OTP = 3;
  private static final int METHODID_VERIFY3PP_EMAIL_OTP = 4;
  private static final int METHODID_FORGOT3PP_PASSWORD_OTP = 5;
  private static final int METHODID_VERIFY3PP_RESET_PASSWORD_OTP = 6;
  private static final int METHODID_AUTHENTICATE3PP_ACCESS = 7;
  private static final int METHODID_GENERATE_API_KEY = 8;
  private static final int METHODID_REGENERATE_API_KEY = 9;
  private static final int METHODID_AUTHENTICATE_API_KEY = 10;
  private static final int METHODID_TWO_FACTOR_AUTH = 11;
  private static final int METHODID_GET3PP_PHONE_NUMBER_OTP = 12;
  private static final int METHODID_CREATE3PP_WEBHOOK_DATA = 13;
  private static final int METHODID_GET3PP_WEBHOOK_DATA = 14;
  private static final int METHODID_UPDATE3PP_WEBHOOK_DATA = 15;
  private static final int METHODID_GET3PP_USER_DATA = 16;
  private static final int METHODID_GET2FA_QR_CODE_URL = 17;
  private static final int METHODID_GET3PP_BY_UNIQUE_DATA = 18;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AuthServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AuthServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE3PP_USER:
          serviceImpl.create3ppUser((auth.Auth.Create3ppUserRequest) request,
              (io.grpc.stub.StreamObserver<auth.Auth.CreateUserResponse>) responseObserver);
          break;
        case METHODID_LOGIN3PP_USER:
          serviceImpl.login3ppUser((auth.Auth.LoginRequest) request,
              (io.grpc.stub.StreamObserver<auth.Auth.LoginResponse>) responseObserver);
          break;
        case METHODID_RESEND3PP_VERIFY_EMAIL_OTP:
          serviceImpl.resend3ppVerifyEmailOtp((auth.Auth.ResendVerifyEmailOtpRequest) request,
              (io.grpc.stub.StreamObserver<auth.Auth.OtpResponse>) responseObserver);
          break;
        case METHODID_VERIFY3PP_PHONE_NUMBER_OTP:
          serviceImpl.verify3ppPhoneNumberOtp((auth.Auth.VerifyPhoneNumberOtpRequest) request,
              (io.grpc.stub.StreamObserver<auth.Auth.Empty>) responseObserver);
          break;
        case METHODID_VERIFY3PP_EMAIL_OTP:
          serviceImpl.verify3ppEmailOtp((auth.Auth.VerifyEmailOtpRequest) request,
              (io.grpc.stub.StreamObserver<auth.Auth.Empty>) responseObserver);
          break;
        case METHODID_FORGOT3PP_PASSWORD_OTP:
          serviceImpl.forgot3ppPasswordOtp((auth.Auth.ForgotPasswordOtpRequest) request,
              (io.grpc.stub.StreamObserver<auth.Auth.OtpResponse>) responseObserver);
          break;
        case METHODID_VERIFY3PP_RESET_PASSWORD_OTP:
          serviceImpl.verify3ppResetPasswordOtp((auth.Auth.VerifyResetPasswordOtpRequest) request,
              (io.grpc.stub.StreamObserver<auth.Auth.Empty>) responseObserver);
          break;
        case METHODID_AUTHENTICATE3PP_ACCESS:
          serviceImpl.authenticate3ppAccess((auth.Auth.AuthenticateUserRequest) request,
              (io.grpc.stub.StreamObserver<auth.Auth.AuthenticateUserResponse>) responseObserver);
          break;
        case METHODID_GENERATE_API_KEY:
          serviceImpl.generateApiKey((auth.Auth.GenerateApiKeyRequest) request,
              (io.grpc.stub.StreamObserver<auth.Auth.GenerateApiKeyResponse>) responseObserver);
          break;
        case METHODID_REGENERATE_API_KEY:
          serviceImpl.regenerateApiKey((auth.Auth.RegenerateApiKeyRequest) request,
              (io.grpc.stub.StreamObserver<auth.Auth.RegenerateApiKeyResponse>) responseObserver);
          break;
        case METHODID_AUTHENTICATE_API_KEY:
          serviceImpl.authenticateApiKey((auth.Auth.AuthenticateApiKeyRequest) request,
              (io.grpc.stub.StreamObserver<auth.Auth.AuthenticateApiKeyResponse>) responseObserver);
          break;
        case METHODID_TWO_FACTOR_AUTH:
          serviceImpl.twoFactorAuth((auth.Auth.TwoFactorAuthRequest) request,
              (io.grpc.stub.StreamObserver<auth.Auth.TwoFactorAuthResponse>) responseObserver);
          break;
        case METHODID_GET3PP_PHONE_NUMBER_OTP:
          serviceImpl.get3ppPhoneNumberOtp((auth.Auth.GetPhoneNumberOtpRequest) request,
              (io.grpc.stub.StreamObserver<auth.Auth.OtpResponse>) responseObserver);
          break;
        case METHODID_CREATE3PP_WEBHOOK_DATA:
          serviceImpl.create3ppWebhookData((auth.Auth.Create3ppWebhookRequest) request,
              (io.grpc.stub.StreamObserver<auth.Auth.Empty>) responseObserver);
          break;
        case METHODID_GET3PP_WEBHOOK_DATA:
          serviceImpl.get3ppWebhookData((auth.Auth.Get3ppWebhookRequest) request,
              (io.grpc.stub.StreamObserver<auth.Auth.Get3ppWebhookResponse>) responseObserver);
          break;
        case METHODID_UPDATE3PP_WEBHOOK_DATA:
          serviceImpl.update3ppWebhookData((auth.Auth.Update3ppWebhookRequest) request,
              (io.grpc.stub.StreamObserver<auth.Auth.Empty>) responseObserver);
          break;
        case METHODID_GET3PP_USER_DATA:
          serviceImpl.get3ppUserData((auth.Auth.Get3ppUserDataRequest) request,
              (io.grpc.stub.StreamObserver<auth.Auth.Get3ppUserDataResponse>) responseObserver);
          break;
        case METHODID_GET2FA_QR_CODE_URL:
          serviceImpl.get2faQrCodeUrl((auth.Auth.Get2faQrCodeUrlRequest) request,
              (io.grpc.stub.StreamObserver<auth.Auth.Get2faQrCodeUrlResponse>) responseObserver);
          break;
        case METHODID_GET3PP_BY_UNIQUE_DATA:
          serviceImpl.get3ppByUniqueData((auth.Auth.GetByUniqueDataRequest) request,
              (io.grpc.stub.StreamObserver<auth.Auth.GetByUniqueDataResponse>) responseObserver);
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

  private static abstract class AuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AuthServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return auth.Auth.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AuthService");
    }
  }

  private static final class AuthServiceFileDescriptorSupplier
      extends AuthServiceBaseDescriptorSupplier {
    AuthServiceFileDescriptorSupplier() {}
  }

  private static final class AuthServiceMethodDescriptorSupplier
      extends AuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AuthServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AuthServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AuthServiceFileDescriptorSupplier())
              .addMethod(getCreate3ppUserMethod())
              .addMethod(getLogin3ppUserMethod())
              .addMethod(getResend3ppVerifyEmailOtpMethod())
              .addMethod(getVerify3ppPhoneNumberOtpMethod())
              .addMethod(getVerify3ppEmailOtpMethod())
              .addMethod(getForgot3ppPasswordOtpMethod())
              .addMethod(getVerify3ppResetPasswordOtpMethod())
              .addMethod(getAuthenticate3ppAccessMethod())
              .addMethod(getGenerateApiKeyMethod())
              .addMethod(getRegenerateApiKeyMethod())
              .addMethod(getAuthenticateApiKeyMethod())
              .addMethod(getTwoFactorAuthMethod())
              .addMethod(getGet3ppPhoneNumberOtpMethod())
              .addMethod(getCreate3ppWebhookDataMethod())
              .addMethod(getGet3ppWebhookDataMethod())
              .addMethod(getUpdate3ppWebhookDataMethod())
              .addMethod(getGet3ppUserDataMethod())
              .addMethod(getGet2faQrCodeUrlMethod())
              .addMethod(getGet3ppByUniqueDataMethod())
              .build();
        }
      }
    }
    return result;
  }
}
