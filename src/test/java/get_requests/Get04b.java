package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class Get04b extends HerOkuAppBaseUrl {
     /*
        Given
            https://restful-booker.herokuapp.com/booking/71926
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json”
        And
            Response body should be like;
                     {
                            "firstname": "John",
                            "lastname": "Smith",
                            "totalprice": 111,
                            "depositpaid": true,
                            "bookingdates": {
                                "checkin": "2018-01-01",
                                "checkout": "2019-01-01"
                            },
                            "additionalneeds": "Breakfast"
}
     */
    @Test
    public void get04b(){
        //Set the url
        spec.pathParams("first", "booking", "second", 8918);

        //Set the expected data

        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        JsonPath json = response.jsonPath();

        //Soft Assertion

        //1st: Create new SofAssert object
        SoftAssert softAssert = new SoftAssert();


        //2nd: Do Assertion
        softAssert.assertEquals(response.statusCode(), 200);
        softAssert.assertEquals(response.contentType(), "application/json; charset=utf-8");
        softAssert.assertEquals(json.getString("firstname"), "John");
        softAssert.assertEquals(json.getString("lastname"), "Smith");
        softAssert.assertEquals(json.getInt("totalprice"), 111);
        softAssert.assertEquals(json.getBoolean("depositpaid"), true);
        softAssert.assertEquals(json.getString("bookingdates.checkin"), "2018-01-01");
        softAssert.assertEquals(json.getString("bookingdates.checkout"), "2019-01-01");
        softAssert.assertEquals(json.getString("additionalneeds"), "Breakfast");


        //3rd: AssertAll
        softAssert.assertAll();




    }
}
