package pet_store_smoke_test;

import base_urls.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.jupiter.api.Test;
import pojos.PetStoreUserResponsePojo;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class S6Get02 extends PetStoreBaseUrl {
    /*
    Given
            https://petstore.swagger.io/v2/pet:id
    When
        User sends Get request
    Then
        Status code is 404
    And
        Response body is like
                    {
                "code": 1,
                "type": "error",
                "message": "Pet not found"
            }
     */

    @Test
    public void get02() throws IOException {
        //Set the url
        spec.pathParams("first", "pet", "second", 1234321);

        //Set the expected data
        PetStoreUserResponsePojo expectedData = new PetStoreUserResponsePojo(1, "error", "Pet not found");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        PetStoreUserResponsePojo actualData = new ObjectMapper().readValue(response.asString(), PetStoreUserResponsePojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(404, response.statusCode());
        assertEquals(expectedData.getCode(), actualData.getCode());
        assertEquals(expectedData.getType(), actualData.getType());
        assertEquals(expectedData.getMessage(), actualData.getMessage());


    }

}
