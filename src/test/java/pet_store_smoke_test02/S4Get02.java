package pet_store_smoke_test02;

import base_urls.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import pojos.PetStoreInventoryPojo;

import static io.restassured.RestAssured.given;

public class S4Get02 extends PetStoreBaseUrl {
    /*
    Given
    https://petstore.swagger.io/v2/store/inventory
    When
        User sends Get request
    Then
        Status code is 200
    And
        Response body is like
                                {
                      " Not available": 1,
                      "totvs": 1,
                      "sold": 3,
                      " not available": 8,
                      "string": 517,
                      "unavailable": 2,
                      "pending": 15,
                      "available": 445,
                      "Kebipmj": 1,
                      "totvs1": 1
                    }
     */
    @Test
    public void get02(){
        //Set the url
        spec.pathParams("first", "store", "second", "inventorey");

        //Set the expected data
        PetStoreInventoryPojo expectedData = new PetStoreInventoryPojo(1, 1, 3, 8, 517, 2, 15, 445, 1, 1);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();


    }

}
