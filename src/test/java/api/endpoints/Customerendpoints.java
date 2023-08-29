package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.GenerateOTP;
import api.payload.Login;
import api.payload.Signupcustomer;
import api.payload.VerifyOTP;
import io.restassured.response.Response;



public class Customerendpoints {
	
	
	
	public static Response GenerateOTP(GenerateOTP payload) {
		
		
		Response response = given().contentType("application/json")
				.header("Public-Key", "1d5ee304-5de4-4490-8cfa-4b23a2bb5058")
				.header("X-Device-uuid", "6b64d51f-6dd2-4635-81bf-0281a9150e9c")
				.header("X-Device", "postman")
				.header("X-Device-Token", "ff5409bd-c355-404b-92f1-440abb28b63b")
				.body(payload)
		.when().post(Routes.generate_otp);
		
		return response;
	}
	
	public static Response VerifyOTP(VerifyOTP payload) {
		
		
		Response response = given().contentType("application/json")
				.header("Public-Key", "1d5ee304-5de4-4490-8cfa-4b23a2bb5058")
				.header("X-Device-uuid", "6b64d51f-6dd2-4635-81bf-0281a9150e9c")
				.header("X-Device", "postman")
				.header("X-Device-Token", "ff5409bd-c355-404b-92f1-440abb28b63b")
				.body(payload)
		.when().post(Routes.verify_otp);
		
		return response;
	}
	
	public static Response Signup(Signupcustomer payload) {
		
		
		Response response = given().contentType("application/json")
				.header("Public-Key", "1d5ee304-5de4-4490-8cfa-4b23a2bb5058")
				.header("X-Device-uuid", "6b64d51f-6dd2-4635-81bf-0281a9150e9c")
				.header("X-Device", "postman")
				.header("X-Device-Token", "ff5409bd-c355-404b-92f1-440abb28b63b")
				.body(payload)
		.when().post(Routes.sing_up);
		
		return response;
	}
	
	public static Response logout(String accesstoken) {
	    Response response = given()
	            .header("X-Device-uuid", "6b64d51f-6dd2-4635-81bf-0281a9150e9c")
	            .header("X-Device", "postman")
	            .header("X-Device-Token", "ff5409bd-c355-404b-92f1-440abb28b63b")
	            .header("Authorization", "Bearer " + accesstoken)
	            .when().post(Routes.logout);

	    return response;
	}
	
	public static Response login(Login payload) {
		
		Response response = given().contentType("application/json")
				.header("Public-Key", "1d5ee304-5de4-4490-8cfa-4b23a2bb5058")
				.header("X-Device-uuid", "6b64d51f-6dd2-4635-81bf-0281a9150e9c")
				.header("X-Device", "postman")
				.header("X-Device-Token", "ff5409bd-c355-404b-92f1-440abb28b63b")
				.body(payload)
				.when().post(Routes.login);
		
		return response;
	}
	
	
	
	

}
