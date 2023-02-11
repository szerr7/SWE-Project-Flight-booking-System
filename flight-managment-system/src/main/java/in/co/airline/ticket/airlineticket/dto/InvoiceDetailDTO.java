package in.co.airline.ticket.airlineticket.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="F_INVOICE_DETAIL")
public class InvoiceDetailDTO extends BaseDTO {

	@Column(name="INVOICE_NO")
	private long invoiceNo;
	@Column(name="FLIGHT_NO",length = 225)
	private String flightNo;
	@Column(name="FLIGHT_NAME",length = 225)
	private String flightName;
	@Column(name="NAME",length = 225)
	private String name;
	@Column(name="DOB")
	@Temporal(TemporalType.DATE)
	private Date dob;
	@Column(name="GENDER",length = 225)
	private String gender;
	@Column(name="SEAT_NO",length = 225)
	private String seatNo;
	@Column(name="PRICE",length = 225)
	private String price;
	@Column(name="ARRIVAL_CITY",length = 225)
	private String arrivalCity;
	@Column(name="DEPARTURE_CITY",length = 225)
	private String departureCity;
	@Column(name="DATE")
	@Temporal(TemporalType.DATE)
	private Date date; 
	
	@Column(name="USER_ID")
	private long userId;
	
	
	@Override
	public String toString() {
		return "InvoiceDetailDTO [invoiceNo=" + invoiceNo + ", flightNo=" + flightNo + ", flightName=" + flightName
				+ ", name=" + name + ", dob=" + dob + ", gender=" + gender + ", seatNo=" + seatNo + ", price=" + price
				+ ", arrivalCity=" + arrivalCity + ", departureCity=" + departureCity + ", date=" + date + "]";
	}
	
	

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(long invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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
