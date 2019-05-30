package health;

import javax.json.bind.annotation.JsonbProperty;

/*
Data object for:
{"realm":"quarkus-quickstart",
"public_key":"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApmpYuqsAzLvHiWvPtiPggzEgsjpj1zw55Q8soArey...",
"token-service":"http://localhost:8180/auth/realms/quarkus-quickstart/protocol/openid-connect",
"account-service":"http://localhost:8180/auth/realms/quarkus-quickstart/account",
"tokens-not-before":0
}
 */
public class KeycloakRealm {
    String realm;
    @JsonbProperty("public_key")
    String publicKey;
    @JsonbProperty("token-service")
    String tokenService;
    @JsonbProperty("account-service")
    String accountService;


    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getTokenService() {
        return tokenService;
    }

    public void setTokenService(String tokenService) {
        this.tokenService = tokenService;
    }

    public String getAccountService() {
        return accountService;
    }

    public void setAccountService(String accountService) {
        this.accountService = accountService;
    }
}
