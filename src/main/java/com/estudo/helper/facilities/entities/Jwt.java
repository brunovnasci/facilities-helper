package com.estudo.helper.facilities.entities;

import com.estudo.helper.facilities.entities.Jwt.JwtTokens;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Jwt {
    private String key = "teste";
    private String subject = "teste";
    private String issuer = "teste";

    public JwtTokens codificar(Claims claims) {
        String jwt = Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuer(issuer)
                //.setExpiration(new Date(System.currentTimeMillis() + 360000))
                .signWith(SignatureAlgorithm.HS256, new SecretKeySpec(DatatypeConverter.parseBase64Binary(key),
                        SignatureAlgorithm.HS256.getJcaName())).compact();


        return new JwtTokens(jwt, "Refresh");
    }

    public Claims descodificar(String jwt) {
        return Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(key))
                .parseClaimsJws(jwt).getBody();
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class JwtTokens {
        private String jwt;
        private String jwtRefresh;
    }
}