package in.co.airline.ticket.airlineticket.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "L_USER")
public class UserDTO extends BaseDTO {

	@Column(name = "FIRST_NAME", length = 225)
	private String firstName;
	
	@Column(name = "LAST_NAME", length = 225)
	private String lastName;
	
	@Column(name = "LOGIN", length = 225)
	private String login;
	
	@Column(name = "PASSWORD", length = 225)
	private String password;
	
	@Column(name = "EMAIL", length = 225)
	private String email;
	
	@Column(name = "MOBILE_NO", length = 225)
	private String mobileNo;
	
	@Column(name = "ROLE_ID")
	private long roleId;
	
	@Column(name = "GENDER", length = 225)
	private String gender;
	
	@Column(name="DOB")
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	@Column(name = "COUNTRY", length = 225)
	private String country;
	
	@Column(name = "STATE", length = 225)
	private String state;
	
	@Column(name = "CITY", length = 225)
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





	public UserDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	

	@Override
	public String toString() {
		return "UserDTO [firstName=" + firstName + ", lastName=" + lastName + ", login=" + login + ", password="
				+ password + ", email=" + email + ", mobileNo=" + mobileNo + ", roleId=" + roleId + ", gender=" + gender
				+ ", dob=" + dob + ", country=" + country + ", state=" + state + ", city=" + city + "]";
	}





	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
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

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}



	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return String.valueOf(id);
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return firstName+" "+lastName;
	}

	

}
