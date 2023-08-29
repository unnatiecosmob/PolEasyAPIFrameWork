package api.payload;

public class VerifyOTP {
	
	String mobile_no;
	String otp_type;
	String otp;
	String country_code;
	boolean is_customer;
	
	public String getmobile_no() {
		return mobile_no;
	}
	public void setmobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getotp_type() {
		return otp_type;
	}
	public void setotp_type(String otp_type) {
		this.otp_type = otp_type;
	}
	public String getotp() {
		return otp;
	}
	public void setotp(String otp) {
		this.otp = otp;
	}
	public String getcountry_code() {
		return country_code;
	}
	public void setcountry_code(String country_code) {
		this.country_code = country_code;
	}
	public boolean isis_customer() {
		return is_customer;
	}
	public void setis_customer(boolean is_customer) {
		this.is_customer = is_customer;
	}
	
	

}
