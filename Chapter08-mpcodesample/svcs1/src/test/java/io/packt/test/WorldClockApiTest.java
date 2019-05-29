package io.packt.test;

import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import io.packt.sample.restclient.Now;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
@Disabled
public class WorldClockApiTest {
    @Test
    @Disabled
    public void testNow() throws URISyntaxException {
        Response response = given()
                .when()
                .get("/data/time/now")
                .andReturn();

        Assertions.assertEquals(HttpURLConnection.HTTP_OK, response.getStatusCode());
        String replyString = response.body().asString();
        JsonReader jsonReader = Json.createReader(new StringReader(replyString));
        JsonObject reply = jsonReader.readObject();
        System.out.println(reply);
        Now numbers = response.as(Now.class);
        System.out.println(numbers);
    }
}
