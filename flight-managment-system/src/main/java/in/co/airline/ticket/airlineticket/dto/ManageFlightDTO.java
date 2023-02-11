package in.co.airline.ticket.airlineticket.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="F_MANAGE_FLIGHT")
public class ManageFlightDTO extends BaseDTO {

	@Column(name="ARRIVAL_AIRPORT_ID")
	private long arrivalAirportId;
	@Column(name="DEPARTURE_AIRPORT_ID")
	private long departureAirportId;
	@Column(name="ARRIVAL_AIRPORT_NAME",length = 225)
	private String arrivalAirportName;
	@Column(name="DEPARTURE_AIRPORT_NAME",length = 225)
	private String departureAirportName;
	@Column(name="FLIGHT_ID")
	private long flightId;
	@Column(name="FLIGHT_NAME",length = 225)
	private String flightName;
	@Column(name="FLIGHT_NO",length = 225)
	private String flightNo;
	
	@Column(name="ARRIVAL_DATE")
	@Temporal(TemporalType.DATE)
	private Date arrivalDate;
	@Column(name="DEPARTURE_DATE")
	@Temporal(TemporalType.DATE)
	private Date departureDate;
	@Column(name="ARRIVAL_TIME",length = 225)
	private String arrivalTime;
	@Column(name="DEPARTURE_TIME",length = 225)
	private String departureTime;
	@Column(name="PRICE",length = 225)
	private String price;
	
	@Column(name="ARRIVAL_CITY",length = 225)
	private String arrivalCity;
	@Column(name="DEPARTURE_CITY",length = 225)
	private String departureCity;
	
	public ManageFlightDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	public String toString() {
		return "ManageFlightDTO [arrivalAirportId=" + arrivalAirportId + ", departureAirportId=" + departureAirportId
				+ ", arrivalAirportName=" + arrivalAirportName + ", departureAirportName=" + departureAirportName
				+ ", flightId=" + flightId + ", flightName=" + flightName + ", flightNo=" + flightNo + ", arrivalDate="
				+ arrivalDate + ", departureDate=" + departureDate + ", arrivalTime=" + arrivalTime + ", departureTime="
				+ departureTime + ", price=" + price + ", arrivalCity=" + arrivalCity + ", departureCity="
				+ departureCity + "]";
	}

	
	

	public String getArrivalCity() {
		return arrivalCity;
	}



	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}



	public String getDepartureCity() {
		return departureCity;
	}



	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}



	public long getArrivalAirportId() {
		return arrivalAirportId;
	}

	public void setArrivalAirportId(long arrivalAirportId) {
		this.arrivalAirportId = arrivalAirportId;
	}

	public long getDepartureAirportId() {
		return departureAirportId;
	}

	public void setDepartureAirportId(long departureAirportId) {
		this.departureAirportId = departureAirportId;
	}

	public String getArrivalAirportName() {
		return arrivalAirportName;
	}

	public void setArrivalAirportName(String arrivalAirportName) {
		this.arrivalAirportName = arrivalAirportName;
	}

	public String getDepartureAirportName() {
		return departureAirportName;
	}

	public void setDepartureAirportName(String departureAirportName) {
		this.departureAirportName = departureAirportName;
	}

	public long getFlightId() {
		return flightId;
	}

	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
