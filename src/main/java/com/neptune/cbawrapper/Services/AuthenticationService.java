package com.neptune.cbawrapper.Services;


import auth.Auth;
import auth.AuthServiceGrpc;
import com.neptune.cbawrapper.Exception.ErrorLoggingException;
import com.neptune.cbawrapper.Models.VerifyUser;
import com.neptune.cbawrapper.RequestRessponseSchema.CreateUser;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class AuthenticationService {

    private final ErrorLoggingException errorLoggingException;
    private static final Logger log = LoggerFactory.getLogger(AuthenticationService.class);
    @Value("${grpc.auth.request.url}")
    private String auth_server_ip;

    @Value("${grpc.auth.request.port}")
    private int auth_server_port;

    //todo: step 1
    public auth.Auth.CreateUserResponse createUserAccount(CreateUser create3ppUser){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(auth_server_ip, auth_server_port).usePlaintext().build();
        auth.Auth.CreateUserResponse response = null;
        try {
            auth.Auth.Create3ppUserRequest request = auth.Auth.Create3ppUserRequest
                    .newBuilder()
                    .setEmail(create3ppUser.getEmail())
                    .setPhoneNumber(create3ppUser.getPhone_number())
                    .setCountry(create3ppUser.getCountry())
                    .setAddress(create3ppUser.getAddress())
                    .setPassword(create3ppUser.getPassword())
                    .setBusinessName(create3ppUser.getBusiness_name())
                    .setSettlementAccountNumber(create3ppUser.getSettlement_account_number())
                    .build();

            AuthServiceGrpc.AuthServiceBlockingStub stub = AuthServiceGrpc.newBlockingStub(channel);
            response = stub.create3ppUser(request); //connection().create3ppUser(request);
        }catch (StatusRuntimeException e) {
            System.out.println("error1 = " + e.getMessage());
            errorLoggingException.logError("GET_USER_PHONE_STATUS_RUNTIME_EXCEPTION_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        } catch (Exception e) {
            System.out.println("error2 = " + e.getMessage());
            errorLoggingException.logError("GET_USER_PHONE_EXCEPTION_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        }
        channel.shutdownNow();
        return response;
    }

    //todo: step 2a
    public auth.Auth.OtpResponse getUserPhoneOtp(String phoneNumber){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(auth_server_ip, auth_server_port).usePlaintext().build();
        auth.Auth.OtpResponse response = null;
        try {
            auth.Auth.GetPhoneNumberOtpRequest request = auth.Auth.GetPhoneNumberOtpRequest
                    .newBuilder().setPhoneNumber(phoneNumber).build();
            AuthServiceGrpc.AuthServiceBlockingStub stub = AuthServiceGrpc.newBlockingStub(channel);
            response = stub.get3ppPhoneNumberOtp(request);
        }catch (StatusRuntimeException e) {
            errorLoggingException.logError("GET_USER_PHONE_STATUS_RUNTIME_EXCEPTION_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        } catch (Exception e) {
            errorLoggingException.logError("GET_USER_PHONE_EXCEPTION_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        }finally {
            channel.shutdownNow();
        }
        return response;
    }

    //todo: step 2a(b) resend verification email incase the email after user registration was not received
    public auth.Auth.OtpResponse resendEmailOtp(String email){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(auth_server_ip, auth_server_port).usePlaintext().build();
        auth.Auth.OtpResponse response = null;
        try {
            auth.Auth.ResendVerifyEmailOtpRequest request = auth.Auth.ResendVerifyEmailOtpRequest.newBuilder().setEmail(email).build();
            AuthServiceGrpc.AuthServiceBlockingStub stub = AuthServiceGrpc.newBlockingStub(channel);
            response = stub.resend3ppVerifyEmailOtp(request);
        }catch (StatusRuntimeException e){
            errorLoggingException.logError("RESEND_USER_EMAIL_OTP_STATUS_RUNTIME_EXCEPTION_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        } catch (Exception e) {
            errorLoggingException.logError("RESEND_USER_EMAIL_OTP_EXCEPTION_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        }finally {
            channel.shutdownNow();
        }
        return response;
    }

    //todo: step 2b use the otp sent to your email to verify your email
    public auth.Auth.Empty verifyUserEmail(VerifyUser verifyUser){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(auth_server_ip, auth_server_port).usePlaintext().build();
        auth.Auth.Empty response = null;
        try {
            auth.Auth.VerifyEmailOtpRequest request = auth.Auth.VerifyEmailOtpRequest
                    .newBuilder()
                    .setEmail(verifyUser.getEmail())
                    .setOtp(verifyUser.getOtp())
                    .build();

            AuthServiceGrpc.AuthServiceBlockingStub stub = AuthServiceGrpc.newBlockingStub(channel);
            response = stub.verify3ppEmailOtp(request);
        }catch (StatusRuntimeException e) {
            errorLoggingException.logError("VERIFY_USER_EMAIL_STATUS_RUNTIME_EXCEPTION_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        } catch (Exception e) {
            errorLoggingException.logError("VERIFY_USER_EMAIL_EXCEPTION_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        }finally {
            channel.shutdownNow();
        }
        return response;
    }


    //todo: step 3 verify phone number with otp from phone number otp service
    public auth.Auth.Empty verifyUserPhone(VerifyUser verifyUser){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(auth_server_ip, auth_server_port).usePlaintext().build();
        auth.Auth.Empty response = null;
        try{
            auth.Auth.VerifyPhoneNumberOtpRequest request = auth.Auth.VerifyPhoneNumberOtpRequest
                    .newBuilder()
                    .setPhoneNumber(verifyUser.getPhone())
                    .setOtp(verifyUser.getOtp())
                    .build();

            AuthServiceGrpc.AuthServiceBlockingStub stub = AuthServiceGrpc.newBlockingStub(channel);
            response = stub.verify3ppPhoneNumberOtp(request);
        }catch (StatusRuntimeException e) {
            System.out.println("kkkkkkkkkkkk = " + e.getMessage());
            errorLoggingException.logError("VERIFY_USER_PHONE_STATUS_RUNTIME_EXCEPTION_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        } catch (Exception e) {
            System.out.println("jjjjjjj = " + e.getMessage());
            errorLoggingException.logError("VERIFY_USER_PHONE_EXCEPTION_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        }finally {
            channel.shutdownNow();
        }
        return response;
    }

    //todo: step 4 login user
    public auth.Auth.LoginResponse loginUser(VerifyUser verifyUser){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(auth_server_ip, auth_server_port).usePlaintext().build();
        auth.Auth.LoginResponse response = null;
        try {
            auth.Auth.LoginRequest request = auth.Auth.LoginRequest
                    .newBuilder()
                    .setEmail(verifyUser.getEmail())
                    .setPassword(verifyUser.getPassword())
                    .build();
            AuthServiceGrpc.AuthServiceBlockingStub stub = AuthServiceGrpc.newBlockingStub(channel);
            response = stub.login3ppUser(request);
        }catch (StatusRuntimeException e) {
            errorLoggingException.logError("LOGIN_STATUS_RUNTIME_EXCEPTION_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        }
        catch (Exception e) {
            errorLoggingException.logError("LOGIN_EXCEPTION_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        }finally {
            channel.shutdownNow();
        }
        return response;
    }

    //todo: use the access token from login to generate API key
    public auth.Auth.GenerateApiKeyResponse generateApiKey(String token){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(auth_server_ip, auth_server_port).usePlaintext().build();
        auth.Auth.GenerateApiKeyResponse response = null;
        try {
            auth.Auth.GenerateApiKeyRequest request = auth.Auth.GenerateApiKeyRequest
                    .newBuilder()
                    .setToken(token)
                    .build();AuthServiceGrpc.AuthServiceBlockingStub stub = AuthServiceGrpc.newBlockingStub(channel);
            response = stub.generateApiKey(request);
        }catch (StatusRuntimeException e) {
            errorLoggingException.logError("GENERATE_API_KEY_STATUS_RUNTIME_EXCEPTION_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        }
        catch (Exception e) {
            errorLoggingException.logError("GENERATE_API_KEY_EXCEPTION_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        }finally {
            channel.shutdownNow();
        }
        return response;
    }

    public auth.Auth.Get3ppUserDataResponse getUserData(String token){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(auth_server_ip, auth_server_port).usePlaintext().build();
        auth.Auth.Get3ppUserDataResponse response = null;
        try {
            auth.Auth.Get3ppUserDataRequest request = auth.Auth.Get3ppUserDataRequest
                    .newBuilder()
                    .setToken(token)
                    .build();AuthServiceGrpc.AuthServiceBlockingStub stub = AuthServiceGrpc.newBlockingStub(channel);
            response = stub.get3ppUserData(request);
        }catch (StatusRuntimeException e){
            errorLoggingException.logError("GET_3PP_USER_DATA_STATUS_RUNTIME_EXCEPTION_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        }
        catch (Exception e){
            errorLoggingException.logError("GET_3PP_USER_DATA_EXCEPTION_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        }finally {
            channel.shutdownNow();
        }
        return response;
    }

    public Auth.Empty createWebHookCba(String token, String url){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(auth_server_ip, auth_server_port).usePlaintext().build();
        auth.Auth.Empty response = null;
        try {
            Auth.Create3ppWebhookRequest request = Auth.Create3ppWebhookRequest
                    .newBuilder()
                    .setToken(token)
                    .setUrl(url)
                    .build();AuthServiceGrpc.AuthServiceBlockingStub stub = AuthServiceGrpc.newBlockingStub(channel);
            response = stub.create3ppWebhookData(request);
        }catch (StatusRuntimeException e) {
            errorLoggingException.logError("CREATE_3PP_WEBHOOK_STATUS_RUNTIME_EXCEPTION_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        } catch (Exception e) {
            errorLoggingException.logError("CREATE_3PP_WEBHOOK_EXCEPTION_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        }finally {
            channel.shutdownNow();
        }
        return response;
    }

    public Auth.Get3ppWebhookResponse get3ppWebhook(String token, String id){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(auth_server_ip, auth_server_port).usePlaintext().build();
        Auth.Get3ppWebhookResponse response =null;
        try {
            Auth.Get3ppWebhookRequest request = Auth.Get3ppWebhookRequest
                    .newBuilder()
                    .setId(id)
                    .setToken(token)
                    .build();AuthServiceGrpc.AuthServiceBlockingStub stub = AuthServiceGrpc.newBlockingStub(channel);
            response = stub.get3ppWebhookData(request);
        }catch (StatusRuntimeException e) {
            errorLoggingException.logError("GET_3PP_WEBHOOK_STATUS_RUNTIME_EXCEPTION_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        } catch (Exception e) {
            errorLoggingException.logError("GET_3PP_WEBHOOK_EXCEPTION_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        }finally {
            channel.shutdownNow();
        }
        return response;
    }


}
