package api.payload;

public class Login {

	String mobile_no;
	String country_code;
	boolean is_customer;
	String  password;
	
	
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getCountry_code() {
		return country_code;
	}
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	public boolean isIs_customer() {
		return is_customer;
	}
	public void setIs_customer(boolean is_customer) {
		this.is_customer = is_customer;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	} 
	
	
}
