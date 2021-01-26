package com.kowalix.apiTests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Case2 {

    @Test
    public void getSinglePostInfo() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        int postId = 7;
        given().log().all()
                .header("Content-Type", "application/json")
                .when().get("posts/" + postId)
                .then().log().all().assertThat().statusCode(200).body("id", equalTo(postId));
    }

}
