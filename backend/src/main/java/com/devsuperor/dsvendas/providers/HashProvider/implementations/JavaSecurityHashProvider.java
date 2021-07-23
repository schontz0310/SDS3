package com.devsuperor.dsvendas.providers.HashProvider.implementations.JavaSecurity;

import com.devsuperor.dsvendas.providers.HashProvider.model.ModelHashProvider;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class JavaSecurityHashProvider implements ModelHashProvider {

    @Override
    public String generateHash(String hash) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte messageDigestHash[] = algorithm.digest(hash.getBytes("UTF-8"));

        StringBuilder hexHash = new StringBuilder();
        for (byte b : messageDigestHash) {
            hexHash.append(String.format("%02X", 0xFF & b));
        }
        return hexHash.toString();
    }

    @Override
    public Boolean compareHash(String payload, String hashed) {
        return null;
    }
}
