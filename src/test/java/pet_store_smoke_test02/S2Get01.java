package pet_store_smoke_test02;

import base_urls.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.jupiter.api.Test;
import pojos.PetStoreStorePojo;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class S2Get01 extends PetStoreBaseUrl {
    /*
    Given
            https://petstore.swagger.io/v2/store/order/:id
    When
        User sends Get request
    Then
        Status code is 200
    And
        Response body is like
                        {
                "id": 444666,
                "petId": 1569,
                "quantity": 12,
                "shipDate": "2022-11-15T17:59:36.177+0000",
                "status": "placed",
                "complete": true
            }
     */
    @Test
    public void get01() throws IOException {
        //Set the url
        spec.pathParams("first", "store", "second", "order", "third", 444666);

        //Set the expected data
        PetStoreStorePojo expectedData = new PetStoreStorePojo(444666,1569, 12, "2022-11-15T17:59:36.177+0000", "placed", true);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}/{third}");
        response.prettyPrint();

        //Do Assertion
        PetStoreStorePojo actualData = new ObjectMapper().readValue(response.asString(), PetStoreStorePojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getId(), actualData.getId());
        assertEquals(expectedData.getPetId(), actualData.getPetId());
        assertEquals(expectedData.getQuantity(), actualData.getQuantity());
        assertEquals(expectedData.getShipDate(), actualData.getShipDate());
        assertEquals(expectedData.getStatus(), actualData.getStatus());
        assertEquals(expectedData.isComplete(), actualData.isComplete());





    }
}
