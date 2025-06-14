package org.example.lesson2_8;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PostmanEcho {
    private static String BASE_URL = "htpps://postman-echo.com";
    @Test
    public void testGetRequest(){
        given()
                .baseUri("https://postman-echo.com")
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get(BASE_URL + "/cookies")
                .then()
                .statusCode (200);
    }

    @Test
    public void testDeleteRequest(){
        Response response = given()
                .header("Content-Type", "text/plan")
                .when()
                .delete(BASE_URL + "/delete");

        response.then().statusCode(200);

        response.then()
                .body("url", equalTo(BASE_URL + "/delete"));
    }

    @Test
    public void testPostFormData(){
        Response response = given()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post(BASE_URL + "/post")
                .then()
                .log().all()
                .extract()
                .response();

        response.then().statusCode(200);

        response.then().body("form.fool", equalTo("bar1"));
        response.then().body("form.foo2", equalTo("bar2"));
    }

    @Test
    public void testPatchRequest(){
        String requestBody = "This is expected to be sent back as part of response body.";

        Response response = given()
                .header("Content-Type", "text/plain")
                .body (requestBody)
                .when()
                .patch(BASE_URL + "/patch")
                .then()
                .extract().response();

        response.then().statusCode(200);
        String responseBody = response.getBody().asString();
        System.out.println("Response Body:" + responseBody);

        response.then().body("data", equalTo(requestBody));
    }
    @Test
    public void testPostRequest() {
        Response response = given()
                .contentType("application/json")
                .body("{\"fool\": \"bar1\", \"foo2\":\"bar2\"}")
                .when()
                .post(BASE_URL + "/post");

        assertEquals (200, response.getStatusCode());

        response.then()
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"));

    }
    @Test
    public void testPutRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";
        Response response = given()
                .contentType("text/plain")
                .header("Cookie", "sails.sid=s%3Aj8B4L4PitTIToJCzLFvBxfGhJhHK7hna.bZBMu8aN9NpIVCeKTXoV0cIhgjhNL2aQwCsmUUuFMaU")
                .body(requestBody)
                .when()
                .put(BASE_URL + "/put")
                .then()
                .extract()
                .response();

        response.then().statusCode(200);

        response.then().body("form.fool", equalTo("bar1"));
        response.then().body("form.foo2", equalTo("bar2"));
    }
}