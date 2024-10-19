package com.cibertec.carsystemuser.security;


import com.cibertec.carsystemuser.model.User;
import com.cibertec.carsystemuser.model.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Registro o inicio de sesión de usuarios
    public User registerOrLoginOAuthUser(String email, String name) {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            user = new User();
            user.setEmail(email);
            user.setName(name);
            userRepository.save(user); // Guardamos al nuevo usuario
        }

        return user;
    }

    // Generar JWT
    public String generateToken(String email) {
        String SECRET_KEY = "586E3272357538782F413F4428472B4B6250655368566B597033733676397924";
        byte[] keyBytes = SECRET_KEY.getBytes(StandardCharsets.UTF_8);
        SecretKey secretKey = new SecretKeySpec(keyBytes, SignatureAlgorithm.HS256.getJcaName());

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // Expira en 10 horas
                .signWith(secretKey, SignatureAlgorithm.HS256) // Utiliza la clave secreta y el algoritmo
                .compact();
    }
}
