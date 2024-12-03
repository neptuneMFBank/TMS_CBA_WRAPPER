package com.neptune.cbawrapper.Configuration;

import com.neptune.cbawrapper.Services.Cron;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Service
public class AESServiceImp implements AESService {
    @Value("${aes.key}")
    private String key;

    @Value("${aes.iv}")
    private String ivKey;

    @Value("${aes.algo}")
    private String algo;


    private static final Logger log = LoggerFactory.getLogger(AESServiceImp.class);

    @Override
    public String encrypt(String encryptValue) {
        return this.aesEncrypt(encryptValue);
    }

    @Override
    public String decrypt(Object decryptValueObject) {
        String decryptValue = decryptValueObject.toString();
        return this.aesDecrypt(decryptValue);
    }

    public String aesEncrypt(final String value) {
        try {
            IvParameterSpec iv = new IvParameterSpec(ivKey.getBytes(StandardCharsets.UTF_8));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");

            Cipher cipher = Cipher.getInstance(algo);
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());
            return Base64.encodeBase64String(encrypted);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException |
                 BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException ex) {
            log.warn("aesEncrypt: {}", ex);
        }
        return null;
    }

    public String aesDecrypt(String encrypted) {
        try {
            IvParameterSpec iv = new IvParameterSpec(ivKey.getBytes(StandardCharsets.UTF_8));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");

            Cipher cipher = Cipher.getInstance(algo);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

            byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));
            return new String(original);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException ex) {
            log.warn("aesDecrypt: {}", ex);
        }
        return null;
    }

}
