package ValidateResponse;

import com.shaft.driver.SHAFT;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class Validate_Response {

    @Test
    public void TC_01_Validate_Response_With_RestAssured(){

        given().header("Platform" , "careferFleet.eyJhbGciOiJ2Ej!%IUzI1NiIs")

                .get("https://provider.test.carefer.co/api/fleet/v1/constant")
                .then().assertThat().statusCode(200);
    }



    @Test
    public void TC_02_Validate_Response_With_RestAssured(){
        Response response_Body = RestAssured
                .get("https://provider.test.carefer.co/api/fleet/v1/constant");

        Assert.assertEquals(response_Body.getStatusCode() ,200);


    }

    @Test
    public void TC_03_Uplode_Iamge(){

        File file = new File("C:/Users/ashra/Downloads/1.png");

        Response response = RestAssured
                .given()
                .multiPart("file" , file , "multipart/form-data")
                .post("https://the-internet.herokuapp.com/upload")
                .thenReturn();

        System.out.println(response.prettyPrint());
    }


    @Test
    public void TC_04_UPlode_Iamge(){

        File file = new File("C:/Users/ashra/Downloads/1.png");
        RequestSpecification request = RestAssured.given();

        JSONObject body = new JSONObject();
        body.put("type","17");
        body.put("type_id","3");
        body.put("creator_id","1");
        request.body(body.toString());

        Response response = RestAssured
                .given()
                .header("platform" , "@ZSI6Ik>+PpvaG4gRG9l_adQssw5c")
                .multiPart("file" , file , "multipart/form-data")
                .post("https://rabet.test.carefer.co/media")
                .thenReturn();
        System.out.println(response.prettyPrint());
    }



    @Test
    public void TC_05_UPlode_Iamge(){
        RestAssured.baseURI = "https://rabet.test.carefer.co/";
        File file = new File("TestData/Automation_Testing.jpg");

       Response response =  given().header("platform" ,"@ZSI6Ik>+PpvaG4gRG9l_adQssw5c")
               .formParam("type" ,"17")
               .formParam("type_id" ,"3")
               .formParam("creator_id" ,"1")
               .multiPart("file" ,file , "multipart/form-data")
               .when()
               .post("media")
               .thenReturn();

        System.out.println(response.prettyPrint());
        System.out.println(response.print());
    }

}