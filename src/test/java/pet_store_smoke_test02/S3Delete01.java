package pet_store_smoke_test02;

import base_urls.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.jupiter.api.Test;
import pojos.PetStoreUserResponsePojo;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class S3Delete01 extends PetStoreBaseUrl {
    /*
    Given
        https://petstore.swagger.io/v2/store/order:id
    When
        user sends Delete request
    Then
        Status code must be 200
    And
        Response body like the folowing
                        {
                    "code": 200,
                    "type": "unknown",
                    "message": "444666"
                }
     */
    @Test
    public void delete01() throws IOException {
        //Set the url
        spec.pathParams("first", "store", "second", "order", "third", 444666);

        //Set the expected data
        PetStoreUserResponsePojo expectedData = new PetStoreUserResponsePojo(200, "unknown", "444666" );
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given().spec(spec).when().delete("/{first}/{second}/{third}");
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
