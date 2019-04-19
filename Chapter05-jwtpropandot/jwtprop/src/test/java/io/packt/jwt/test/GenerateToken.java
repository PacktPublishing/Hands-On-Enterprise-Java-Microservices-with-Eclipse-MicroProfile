package io.packt.jwt.test;

import java.util.HashMap;

import org.eclipse.microprofile.jwt.Claims;

/**
 * A simple utility class to generate and print a JWT token string to stdout. Can be run with:
 * mvn exec:java -Dexec.mainClass=io.packt.jwt.test.GenerateToken -Dexec.classpathScope=test
 *
 * to generate a token that has a duration of 3600 vs than the default 600 seconds, use:
 * mvn exec:java -Dexec.mainClass=io.packt.jwt.test.GenerateToken -Dexec.classpathScope=test -Dexec.args="3600"
 */
public class GenerateToken {
    /**
     *
     * @param args - [0]: optional time in seconds for expiration of generated token; defaults to 600
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String claimsJson = "/JwtClaims.json";
        HashMap<String, Long> timeClaims = new HashMap<>();
        if (args.length > 0) {
            long duration = Long.parseLong(args[0]);
            long exp = TokenUtils.currentTimeInSecs() + duration;
            timeClaims.put(Claims.exp.name(), exp);
        }
        String token = TokenUtils.generateTokenString(claimsJson, timeClaims);
        System.out.println(token);
    }
}
