package com.neptune.cbawrapper.Configuration;


import feign.Client;
import feign.Logger;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.ssl.SSLContexts;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@Slf4j
@Configuration
public class CoreFeignClientConfig {

    @Bean
    public CoreFeignClientInterceptor fineractFeignClientInterceptor() {
        return new CoreFeignClientInterceptor();
    }

    @Bean
    public CoreErrorDecoder fineractErrorDecoder() {
        return new CoreErrorDecoder();
    }

    @Bean
    public Client feignClient() {
        return new Client.Default(getSSLSocketFactory(), new NoopHostnameVerifier());
    }

    /**
     * Set the Feign specific log level to log client REST requests.
     *
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    private SSLSocketFactory getSSLSocketFactory() {
        try {
            TrustStrategy acceptingTrustStrategy = (chain, authType) -> true;

            SSLContext sslContext
                    = SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy).build();
            return sslContext.getSocketFactory();
        } catch (KeyManagementException | KeyStoreException | NoSuchAlgorithmException exception) {
            log.error(exception.getLocalizedMessage(), exception);
        }
        return null;
    }
}