package com.beyond.todolist.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {
    public static String calculate(String data)
    {
        String hash = "";

        try {
            MessageDigest mdg = MessageDigest.getInstance("SHA-256");
            hash = hex(mdg.digest(data.getBytes()));
        }
        catch (NoSuchAlgorithmException e) {
            hash = data;
        }

        return hash;
    }

    private static String hex(byte[] ds)
    {
        StringBuilder sb = new StringBuilder();

        for( byte bv : ds ) {
            sb.append(String.format("%02x", bv));
        }

        return sb.toString();
    }
}
