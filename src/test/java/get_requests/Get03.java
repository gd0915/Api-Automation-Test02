package get_requests;

import base_urls.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class Get03 extends PetStoreBaseUrl {
    /*
    Print all "available" pets on console by using"https://petstore.swagger.io/" documentation.
    There should be more than 30 "available" pets, "fish" and "doggie" pet names must exist.
    */
    /*
    Given
            "https://petstore.swagger.io/"
    When
            User sends Get request to the Url
     Then
            HTTP Sttaus Code is 200
     And
            There should be more than 30 "available" pets
      And
            "fish" and "doggie" pet names must exist
     */
    @Test
    public void get03(){
        //Set the url
        spec.pathParams("first", "pet", "second", "findByStatus").queryParam("status", "available");

        //Set the expected data

        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        response.then().assertThat().statusCode(200).body("name", hasItems("fish", "doggie"),
                "id", hasSize(greaterThan(30)));


    }
}
