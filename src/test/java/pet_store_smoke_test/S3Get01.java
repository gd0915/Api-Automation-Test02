package pet_store_smoke_test;

import base_urls.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class S3Get01 extends PetStoreBaseUrl {
    /*
    Print all "available" pets on console by using"https://petstore.swagger.io/" documentation.
    There should be more than 30 "available" pets, "fish" and "doggie" pet names must exist.
    */
    /*
    Given
            https://petstore.swagger.io/v2/pet/findByStatus?status=available
    When
            User sends Get request to the Url
     Then
            HTTP Status Code is 200
     And
            There should be more than 30 "available" pets
      And
            "fish" and "doggie" pet names must exist
     */

    @Test
    @Order(3)
    public void getFindByStatus(){
        //Set the url
        spec.pathParams("first", "pet", "second", "findByStatus").
                queryParam("status", "available");

        //Set the expected data

        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do assertion
        response.then().
                assertThat().
                statusCode(200).
                body("id", hasSize(greaterThan(30)),
                        "name", hasItems("doggie", "fish"));







    }
}
