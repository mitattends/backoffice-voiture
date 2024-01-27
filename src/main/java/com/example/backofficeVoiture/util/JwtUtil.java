package com.example.backofficeVoiture.util;

import java.nio.file.AccessDeniedException;
import java.security.Key;
import java.util.Date;

import com.example.backofficeVoiture.domain.Utilisateur;
import com.example.backofficeVoiture.models.admin.Administrateur;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {
    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    private static final long expiryDuration = 60 * 60;

    public String userToken(Utilisateur utilisateur){
        long milliTime = System.currentTimeMillis();
        long expiryTime = milliTime + expiryDuration * 1000;

        Date issuedAt = new Date(milliTime);
        Date expiryAt = new Date(expiryTime);

        // claims
        Claims claims = Jwts.claims()
                .setIssuer(utilisateur.getIdUtilisateur())
                .setIssuedAt(issuedAt)
                .setExpiration(expiryAt);

        // optional claims
        claims.put("nom", utilisateur.getNom());
        claims.put("prenom", utilisateur.getPrenom());
        claims.put("email",utilisateur.getEmail());

        return Jwts.builder()
                .setClaims(claims).signWith(key).compact();
    }
    public String generate(Administrateur admin) {
        long milliTime = System.currentTimeMillis();
        long expiryTime = milliTime + expiryDuration * 1000;

        Date issuedAt = new Date(milliTime);
        Date expiryAt = new Date(expiryTime);

        // claims
        Claims claims = Jwts.claims()
                .setIssuer(admin.getIdAdministrateur().toString())
                .setIssuedAt(issuedAt)
                .setExpiration(expiryAt);

        // optional claims
        claims.put("userName", admin.getEmail());
        claims.put("password", admin.getMotDePasse());

        // generate jwt using claims
        String token = Jwts.builder()
                .setClaims(claims)
                .signWith(key)
                .compact();

        return token;

    }

    public Claims verify(String authorization) throws Exception {
        authorization = authorization.replace("Bearer ", "");
        try {
            return Jwts.parser().setSigningKey(key).parseClaimsJws(authorization).getBody();
        } catch (Exception e) {
            throw new AccessDeniedException("Access Denied");
        }
    }

    public Utilisateur findUserByToken(String authorization) throws AccessDeniedException {
        authorization = authorization.replace("Bearer ", "");
        try {
            Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(authorization).getBody();
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setIdUtilisateur(claims.getIssuer());
            return utilisateur;
        } catch (Exception e) {
            throw new AccessDeniedException("Access Denied "+e.getMessage());
        }
    }

}
