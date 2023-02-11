package in.co.airline.ticket.airlineticket.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import in.co.airline.ticket.airlineticket.dto.BaseDTO;
import in.co.airline.ticket.airlineticket.dto.UserDTO;
import in.co.airline.ticket.airlineticket.util.DataUtility;

public class MyProfileForm extends BaseForm {

	@NotEmpty(message = "First Name is required")
	@Pattern(regexp = "(^[A-Za-z ]*)*$", message = "First Name is Invalid")
	private String firstName;

	@NotEmpty(message = "LastName is required")
	@Pattern(regexp = "(^[A-Za-z ]*)*$", message = "Last Name is Invalid")
	private String lastName;

	@NotEmpty(message = "Login is required")
	private String login;

	@NotEmpty(message = "Mobile No is required")
	@Pattern(regexp = "(^[7-9][0-9]{9})*$", message = "MobileNo is Invalid")
	private String mobileNo;

	@NotEmpty(message = "Email is required")
	@Pattern(regexp = "(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,}))*$", message = "Email id is invalid")
	private String email;

	@NotEmpty(message = "Gender is required")
	private String gender;

	@NotEmpty(message = "Date of Birth is required")
	@Pattern(regexp = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$", message = "Date Of Birth is Invalid")
	private String dob;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public BaseDTO getDTO() {
		UserDTO dto = new UserDTO();
		dto.setMobileNo(mobileNo);
		dto.setLogin(login);
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setEmail(email);
		dto.setDob(DataUtility.getDate(dob));
		dto.setGender(gender);
		return dto;
	}

	public void populate(BaseDTO bDto) {
		UserDTO dto = (UserDTO) bDto;
		mobileNo = dto.getMobileNo();
		login = dto.getLogin();
		firstName = dto.getFirstName();
		lastName = dto.getLastName();
		email = dto.getEmail();
		gender = dto.getGender();
		dob = DataUtility.getDateString(dto.getDob());

	}

}
