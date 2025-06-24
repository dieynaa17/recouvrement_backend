package com.sonatel.recouvrement.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordTest {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String rawPassword = "2004";
        String generatedHash = encoder.encode(rawPassword);

        System.out.println("Hash généré pour '2004' : " + generatedHash);

        // Puis test du match
        boolean matches = encoder.matches(rawPassword, generatedHash);
        System.out.println("Match mot de passe avec hash généré ? " + matches);
    }
}


