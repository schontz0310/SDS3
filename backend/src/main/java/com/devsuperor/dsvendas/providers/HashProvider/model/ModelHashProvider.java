package com.devsuperor.dsvendas.providers.HashProvider.model;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Service
public interface ModelHashProvider {
    String generateHash(@NotNull String hash) throws NoSuchAlgorithmException, UnsupportedEncodingException;
    Boolean compareHash(String payload, String hashed);
}
