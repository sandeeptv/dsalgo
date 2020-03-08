package com.test.example.other;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by meg on 5/7/17.
 */
public class HashTest {


    public static void main(String[] args) {

        try {

            String password = "gfkjgfkjgklf";
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            String hashedString = new String(md.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }


}
