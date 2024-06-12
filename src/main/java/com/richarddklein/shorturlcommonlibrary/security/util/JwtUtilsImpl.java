/**
 * The Short URL Common Library
 * (Copyright 2024 by Richard Klein)
 */

package com.richarddklein.shorturlcommonlibrary.security.util;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.crypto.SecretKey;

import com.richarddklein.shorturlcommonlibrary.aws.ParameterStoreReader;
import com.richarddklein.shorturlcommonlibrary.security.dto.UsernameAndRole;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

public class JwtUtilsImpl implements JwtUtils {
    private final ParameterStoreReader parameterStoreReader;

    public JwtUtilsImpl(ParameterStoreReader parameterStoreReader) {
        this.parameterStoreReader = parameterStoreReader;
    }

    public String generateToken(UsernameAndRole shortUrlUser) {
        Date now = new Date();
        long timeToLive = TimeUnit.MINUTES.toMillis(
                parameterStoreReader.getJwtMinutesToLive());
        Date expirationDate = new Date(now.getTime() + timeToLive);

        return Jwts.builder()
                .subject(shortUrlUser.getUsername())
                .claim("role", shortUrlUser.getRole())
                .issuedAt(now)
                .expiration(expirationDate)
                .signWith(getKey())
                .compact();
    }

    public Claims getClaimsFromToken(String token) {
        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private SecretKey getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(
                parameterStoreReader.getJwtSecretKey());
        return Keys.hmacShaKeyFor(keyBytes);
    }
}