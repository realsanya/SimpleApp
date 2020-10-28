package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashPassword {
    public static String getHash(String password) {
        StringBuilder hash;
        MessageDigest messageDigest = null;

        try {
            messageDigest = MessageDigest.getInstance("SHA-1");
            byte[] bytes = messageDigest.digest(password.getBytes());
            hash = new StringBuilder();
            for (byte b : bytes) {
                hash.append(b);
            }
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException();
        }
        return hash.toString();
    }
}
