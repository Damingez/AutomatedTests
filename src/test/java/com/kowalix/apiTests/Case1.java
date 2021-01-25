package com.kowalix.apiTests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

public class Case1 {


    @Test
    public void getPosts() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        String response = given().log().all()
                .header("Content-Type", "application/json")
                .when().get("posts")
                .then().assertThat().statusCode(200).extract().response().asString();

        JsonPath js = new JsonPath(response);
        List<String> titles = js.getList("title");
        List<String> bodies = js.getList("body");


        Optional<String> titleWithNullValue = titles.stream().filter(title -> title == null).findAny();
        Optional<String> bodyWithNullValue = bodies.stream().filter(body -> body == null).findAny();

        boolean eachBodyNotNull = true;
        boolean eachTitleNotNull = true;

        if (bodyWithNullValue.isPresent()) {
            eachBodyNotNull = false;
        }
        if (titleWithNullValue.isPresent()) {
            eachTitleNotNull = false;
        }

        assertThat("At least one body is equal to null", eachBodyNotNull);
        assertThat("At least one title is equal to null", eachTitleNotNull);

    }


}
