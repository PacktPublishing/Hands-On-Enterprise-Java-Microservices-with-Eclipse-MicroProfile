package io.packt.jwt.test;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenerateJWTTest {
    @Test
    public void generateJWT(TestReporter reporter) throws Exception {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        Assumptions.assumeTrue(kpg.getAlgorithm().equals("RSA"));
        kpg.initialize(2048);
        reporter.publishEntry("Created RSA key pair generator of size 2048");
        KeyPair keyPair = kpg.generateKeyPair();
        reporter.publishEntry("Created RSA key pair");
        Assumptions.assumeTrue(keyPair != null, "KeyPair is not null");
        PublicKey publicKey = keyPair.getPublic();
        reporter.publishEntry("RSA.publicKey", publicKey.toString());
        PrivateKey privateKey = keyPair.getPrivate();
        reporter.publishEntry("RSA.privateKey", privateKey.toString());

        assertAll("GenerateJWTTest",
            () -> assertEquals("X.509", publicKey.getFormat()),
            () -> assertEquals("PKCS#8", privateKey.getFormat()),
            () -> assertEquals("RSA", publicKey.getAlgorithm()),
            () -> assertEquals("RSA", privateKey.getAlgorithm())
        );
    }
}
