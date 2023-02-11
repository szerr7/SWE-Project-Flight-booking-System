package in.co.airline.ticket.airlineticket.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import in.co.airline.ticket.airlineticket.dto.AirportDTO;
import in.co.airline.ticket.airlineticket.dto.BaseDTO;

public class AirportForm extends BaseForm  {

	@NotEmpty(message = "Airport Code is required")
	private String code;
	@NotEmpty(message = "Name is required")
	@Pattern(regexp = "(^[A-Za-z ]*)*$",message = "First Name is Invalid")
	private String name;
	@NotEmpty(message = "Country is required")
	@Pattern(regexp = "(^[A-Za-z ]*)*$",message = "Country  is Invalid")
	private String country;
	@NotEmpty(message = "State is required")
	@Pattern(regexp = "(^[A-Za-z ]*)*$",message = "State is Invalid")
	private String state;
	@NotEmpty(message = "City is required")
	@Pattern(regexp = "(^[A-Za-z ]*)*$",message = "City is Invalid")
	private String city;
	@NotEmpty(message = "Address is required")
	private String address;
	
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public BaseDTO getDTO() {
		AirportDTO dto=new AirportDTO();
		dto.setId(id);
		dto.setCode(code);
		dto.setName(name);
		dto.setCountry(country);
		dto.setState(state);
		dto.setCity(city);
		dto.setAddress(address);
		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);
		dto.setCreatedDatetime(createdDateTime);
		dto.setModifiedDatetime(modifiedDateTime);
		return dto;
	}
	@Override
	public void populate(BaseDTO bdto) {
		AirportDTO dto=(AirportDTO) bdto;
		id=dto.getId();
		code=dto.getCode();
		name=dto.getName();
		country=dto.getCountry();
		state=dto.getState();
		city=dto.getCity();
		address=dto.getAddress();
		createdBy=dto.getCreatedBy();
		modifiedBy=dto.getModifiedBy();
		createdDateTime=dto.getCreatedDatetime();
		modifiedDateTime=dto .getModifiedDatetime();
	}
	
}
