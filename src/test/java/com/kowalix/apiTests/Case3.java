package com.kowalix.apiTests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Case3 {

    @Test
    public void createNewPost() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        given().log().all()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "\"title\":\"this is title\",\n" +
                        "\"body\":\"this is body\",\n" +
                        "\"userId\":\"this is user id\"\n" +
                        "}")
                .when().post("posts")
                .then().log().all().assertThat().statusCode(201);
    }

}
