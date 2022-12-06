package pet_store_smoke_test;

import base_urls.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.jupiter.api.Test;
import pojos.PetStoreUserResponsePojo;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;


public class S5Delete01 extends PetStoreBaseUrl {
    /*
    Given
        https://petstore.swagger.io/v2/pet:id
    When
        User sends Delete request
    Then
        Status code is 200
    And
        Response body like the following
                            {
                        "code": 200,
                        "type": "unknown",
                        "message": "1234321"
                    }
     */
    @Test
    public void delete01() throws IOException {
        //Set the url
        spec.pathParams("first", "pet", "second", 1234321);

        //Set the expected data
        PetStoreUserResponsePojo expectedData = new PetStoreUserResponsePojo(200, "unknown", "1234321");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given().spec(spec).when().delete("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        PetStoreUserResponsePojo actualData = new ObjectMapper().readValue(response.asString(), PetStoreUserResponsePojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getCode(), actualData.getCode());
        assertEquals(expectedData.getType(), actualData.getType());
        assertEquals(expectedData.getMessage(), actualData.getMessage());

    }

}
