package in.co.airline.ticket.airlineticket.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import in.co.airline.ticket.airlineticket.dto.BaseDTO;
import in.co.airline.ticket.airlineticket.dto.UserDTO;
import in.co.airline.ticket.airlineticket.util.DataUtility;



public class UserRegistrationForm extends BaseForm {

	@NotEmpty(message = "First Name is required")
	@Pattern(regexp = "(^[A-Za-z ]*)*$",message = "First Name is Invalid")
	private String firstName;
	
	@NotEmpty(message = "LastName is required")
	@Pattern(regexp = "(^[A-Za-z ]*)*$",message = "Last Name is Invalid")
	private String lastName;
	
	@NotEmpty(message = "Login is required")
	private String login;
	
	@NotEmpty(message = "Password is required")
	@Pattern(regexp="(^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[\\S])[A-Za-z0-9\\S]{6,12})*$",message="Password is invalid must be 6 latter")
	private String password;
	
	@NotEmpty(message = "Mobile No is required")
	@Pattern(regexp="(^[7-9][0-9]{9})*$",message = "MobileNo is Invalid")
	private String mobileNo;

	@NotEmpty(message = "Email is required")
	@Pattern(regexp="(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,}))*$",message = "Email id is invalid")
	private String email;
	
	@NotEmpty(message = "Confirm Password is required")
	private String confirmPassword;
	
	@NotEmpty(message = "Gender is required")
	private String gender;
	
	@NotEmpty(message = "Date of Birth is required")
	@Pattern(regexp = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$",message = "Date Of Birth is Invalid")
	private String dob;
	
	@NotEmpty(message = "Country is required")
	@Pattern(regexp = "(^[A-Za-z ]*)*$",message = "Country is Invalid")
	private String country;
	
	@NotEmpty(message = "State is required")
	@Pattern(regexp = "(^[A-Za-z ]*)*$",message = "State is Invalid")
	private String state;
	
	@NotEmpty(message = "City is required")
	@Pattern(regexp = "(^[A-Za-z ]*)*$",message = "City is Invalid")
	private String city;
	
	
	
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public BaseDTO getDTO() {
		UserDTO dto=new UserDTO();
		dto.setId(id);
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setLogin(login);
		dto.setPassword(password);
		dto.setMobileNo(mobileNo);
		dto.setEmail(email);
		dto.setDob(DataUtility.getDate(dob));
		dto.setGender(gender);
		dto.setCity(city);
		dto.setCountry(country);
		dto.setState(state);
		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);
		dto.setCreatedDatetime(createdDateTime);
		dto.setModifiedDatetime(modifiedDateTime);
		return dto;
	}

	@Override
	public void populate(BaseDTO bDto) {
		UserDTO dto=(UserDTO)bDto;
		id=dto.getId();
		firstName=dto.getFirstName();
		lastName=dto.getLastName();
		login=dto.getLogin();
		password=dto.getPassword();
		mobileNo=dto.getMobileNo();
		email=dto.getEmail();
		gender=dto.getGender();
		city=dto.getCity();
		state=dto.getState();
		country=dto.getCountry();
		dob=DataUtility.getDateString(dto.getDob());
		createdBy=dto.getCreatedBy();
		modifiedBy=dto.getModifiedBy();
		createdDateTime=dto.getCreatedDatetime();
		modifiedDateTime=dto .getModifiedDatetime();
	}

}
