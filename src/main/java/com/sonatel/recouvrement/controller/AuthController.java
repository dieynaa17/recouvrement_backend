package com.sonatel.recouvrement.controller;

import com.sonatel.recouvrement.model.Utilisateur;
import com.sonatel.recouvrement.repository.UtilisateurRepository;
import com.sonatel.recouvrement.utils.JwtUtils;
import jakarta.validation.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class
AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);
    private final UtilisateurRepository utilisateurRepository;
    private final JwtUtils jwtUtil;
    private final AuthenticationManager authenticationManager;

    public AuthController(UtilisateurRepository utilisateurRepository, JwtUtils jwtUtil, AuthenticationManager authenticationManager) {
        this.utilisateurRepository = utilisateurRepository;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody AuthRequest request) {
        log.info("AuthRequest: {}", request);
        Utilisateur utilisateur = utilisateurRepository.findByEmail(request.email())
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé"));
        System.out.println(utilisateur.getMotDePasse());

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.email(), request.password())
            );
            log.info("authentication: {}", authentication);

            String token = jwtUtil.generateToken(authentication.getName());
            return Map.of("token", token);

        } catch (Exception ex) {
            throw new RuntimeException("Identifiants incorrects");
        }
    }

    public record AuthRequest(@NotBlank String email, @NotBlank String password) {}
}

