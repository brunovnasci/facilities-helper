package com.estudo.helper.facilities.entities;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Jwt {
    private String key = "teste";
    private String subject = "teste";
    private String issuer = "teste";

    public String codificar(Claims claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuer(issuer)
                .signWith(SignatureAlgorithm.HS256, new SecretKeySpec(DatatypeConverter.parseBase64Binary(key),
                        SignatureAlgorithm.HS256.getJcaName())).compact();
    }

    public Claims descodificar(String jwt) {
        return Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(key))
                .parseClaimsJws(jwt).getBody();
    }
}