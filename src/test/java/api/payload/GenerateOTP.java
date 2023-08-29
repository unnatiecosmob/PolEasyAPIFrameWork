package api.payload;

public class GenerateOTP {

	String mobile_no;
	String country_code;
	String otp_type;
	boolean is_customer;
	
	
	public String getmobile_no() {
		return mobile_no;
	}
	public void setmobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getcountry_code() {
		return country_code;
	}
	public void setcountry_code(String country_code) {
		this.country_code = country_code;
	}
	public String getotp_type() {
		return otp_type;
	}
	public void setotp_type(String otp_type) {
		this.otp_type = otp_type;
	}
	public boolean getis_customer() {
		return is_customer;
	}
	public void setis_customer(boolean is_customer) {
		this.is_customer = is_customer;
	}
	
	
	
	
}
