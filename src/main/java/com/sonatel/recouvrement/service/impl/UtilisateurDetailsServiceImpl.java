
package com.sonatel.recouvrement.service.impl;

import com.sonatel.recouvrement.model.Utilisateur;
import com.sonatel.recouvrement.repository.UtilisateurRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurDetailsServiceImpl implements UserDetailsService {

    private final UtilisateurRepository repository;

    public UtilisateurDetailsServiceImpl(UtilisateurRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Utilisateur utilisateur = repository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé"));

        String roleNormalise = utilisateur.getRole()
                .toUpperCase()
                .trim()
                .replace(" ", "_");

        System.out.println("Utilisateur trouvé : " + utilisateur.getEmail());
        System.out.println("Rôle normalisé : " + roleNormalise);
        System.out.println("Mot de passe hashé : " + utilisateur.getMotDePasse());

        return User.builder()
                .username(utilisateur.getEmail())
                .password(utilisateur.getMotDePasse())
                .roles(roleNormalise)
                .build();
    }
}
