package in.co.airline.ticket.airlineticket.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="A_AIRPORT")
public class AirportDTO  extends BaseDTO {

	
	@Column(name="CODE",length = 225)
	private String code;
	@Column(name="NAME",length = 225)
	private String name;
	@Column(name="COUNTRY",length = 225)
	private String country;
	@Column(name="STATE",length = 225)
	private String state;
	@Column(name="CITY",length = 225)
	private String city;
	@Column(name="ADDRESS",length = 225)
	private String address;
	
	
	 public AirportDTO() {
		// TODO Auto-generated constructor stub
	}
	 
	 
	
	
	@Override
	public String toString() {
		return "AirportDTO [code=" + code + ", name=" + name + ", country=" + country + ", state=" + state + ", city="
				+ city + ", address=" + address + ", id=" + id + ", createdBy=" + createdBy + ", modifiedBy="
				+ modifiedBy + ", createdDatetime=" + createdDatetime + ", modifiedDatetime=" + modifiedDatetime + "]";
	}




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
	public String getKey() {
		// TODO Auto-generated method stub
		return String.valueOf(id);
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return name;
	}
	
	
	
}
