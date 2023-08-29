package api.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.Customerendpoints;
import api.payload.GenerateOTP;
import api.payload.Login;
import api.payload.Signupcustomer;
import api.payload.VerifyOTP;
import io.restassured.response.Response;

public class Customertest {
	
	
	Faker faker;
	GenerateOTP generateotp;
	Login login;
	Signupcustomer signup;
	VerifyOTP verifyotp;
	private static String mobilenumber;
	private static String generatedOTP;
	public static String generatedaccesstoken;
	
	public Logger logger;
	

	
	
	//private static String Mobilenumber;
	public static String  Mobilenumbergenerate() {
			Random random = new Random();
			
			 // Indian phone numbers typically start with 7, 8, or 9, followed by 9 digits.
	        // For example, 9876543210.
	       
	        // Generate the first digit (7, 8, or 9)
	        int firstDigit = random.nextInt(3) + 7;
	       
	        // Generate the remaining 9 digits
	        StringBuilder phoneNumber = new StringBuilder(String.valueOf(firstDigit));
	        for (int i = 1; i < 10; i++) {
	            phoneNumber.append(random.nextInt(10));
	        }
	       
	        return phoneNumber.toString();
	    }
	
	@BeforeClass()
	
	void logsetup() {
		
		logger = LogManager.getLogger(this.getClass());
	}
	
	
	@Test (priority = 1)
	
	public void TestgenerateOTP()
	{
		mobilenumber = Mobilenumbergenerate();
		generateotp = new GenerateOTP();
		
		generateotp.setmobile_no(mobilenumber);
		generateotp.setcountry_code("+91");
		generateotp.setis_customer(true);
		generateotp.setotp_type("SIGN_UP");
		
		
		logger.info("********** OTP Generate **************");
		
		Response response = Customerendpoints.GenerateOTP(generateotp);
		response.then();
		
		generatedOTP =response.jsonPath().get("data.otp").toString();
		AssertJUnit.assertEquals(response.getStatusCode(), 201);
		System.out.println("Generated OTP is: "+generatedOTP);
		
		logger.info("********** OTP Successfully Generated **************");
	}
	
	
	@Test (priority = 2)
	public void TestverifyOTP() 
	{
		
		verifyotp = new VerifyOTP();
		
		verifyotp.setmobile_no(mobilenumber);
		verifyotp.setotp_type("SIGN_UP");
		verifyotp.setotp(generatedOTP);
		verifyotp.setcountry_code("+91");
		verifyotp.setis_customer(true);
		
		logger.info("********** Verify OTP **************");
		
		Response response = Customerendpoints.VerifyOTP(verifyotp);
		response.then().log().all();
		
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		System.out.println("OTP is successfully verified");
		
		logger.info("********** OTP Verified Succesfully **************");
		
	
	}
	
	@Test (priority = 3)
	
	public void Testsignup()
	{
		signup = new Signupcustomer();
		faker = new Faker();
		
		
		signup.setFirst_name(faker.name().firstName());
		signup.setLast_name(faker.name().lastName());
		signup.setEmail(faker.internet().emailAddress());
		signup.setMobile_no(mobilenumber);
		signup.setPassword("Test@123");
		signup.setConfirm_password("Test@123");
		signup.setTitle("MR");
		signup.setCountry_code("+91");
		signup.setTerms_conditions(true);
		signup.setOtp(generatedOTP);
		signup.setIs_customer(true);
		
		logger.info("********** User Register **************");
		
		Response response = Customerendpoints.Signup(signup);
		response.then().log().all();
		
		generatedaccesstoken = response.jsonPath().get("data.access_token").toString();
		AssertJUnit.assertEquals(response.getStatusCode(), 201);
		System.out.println("User is successfully registered");
		System.out.println("Access token: "+generatedaccesstoken);
		
		logger.info("********** User successfully Registered **************");
		
		}

	

	@Test(priority = 4)
	public void Testlogout() {
		
		logger.info("********** User Logout **************");
		
	    Response response = Customerendpoints.logout(generatedaccesstoken);
	    response.then().log().all();

	    AssertJUnit.assertEquals(response.getStatusCode(), 200);
	    System.out.println("User successfully logout");
	    
	    logger.info("********** User logout Successfully **************");
	}
	
	@Test (priority = 5)
	public void Testlogin() {
		
		login = new Login();
		login.setMobile_no(mobilenumber);
		login.setCountry_code("+91");
		login.setIs_customer(true);
		login.setPassword("Test@123");
		
		logger.info("********** User Login **************");
		
		Response response = Customerendpoints.login(login);
		response.then().log().all();
		
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		System.out.println("User login Successfully");
		
		logger.info("********** User Login Successfully **************");
	}
}
