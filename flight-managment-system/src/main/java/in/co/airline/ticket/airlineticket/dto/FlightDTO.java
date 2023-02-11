package in.co.airline.ticket.airlineticket.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="F_FLIGHT")
public class FlightDTO extends BaseDTO {

	@Column(name="FLIGHT_NO",length = 225)
	private String flightNo;
	@Column(name="NAME",length = 225)
	private String name;
	@Column(name="PNR",length = 225)
	private String PNR;

	public FlightDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	public String toString() {
		return "FlightDTO [flightNo=" + flightNo + ", name=" + name + ", PNR=" + PNR + "]";
	}



	public String getFlightNo() {
		return flightNo;
	}



	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPNR() {
		return PNR;
	}



	public void setPNR(String pNR) {
		PNR = pNR;
	}



	@Override
	public String getKey() {
		return String.valueOf(id);
	}

	@Override
	public String getValue() {
		return name;
	}

}
