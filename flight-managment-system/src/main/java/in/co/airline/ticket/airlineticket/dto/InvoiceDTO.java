package in.co.airline.ticket.airlineticket.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="F_INVOICE")
public class InvoiceDTO extends BaseDTO {
	
	@Column(name="INVOICE_NO")
	private long invoiceNo;
	@Column(name="FLIGHT_No" ,length = 225)
	private String flightNo;
	@Column(name="FLIGHT_NAME" ,length = 225)
	private String flightName;
	@Column(name="ARRIVAL_DATE")
	@Temporal(TemporalType.DATE)
	private Date arrivalDate;
	@Column(name="DEPARTURE_DATE")
	@Temporal(TemporalType.DATE)
	private Date departureDate;
	@Column(name="USER_ID")
	private long userId;
	@Column(name="USER_NAME" ,length = 225)
	private String userName;
	@Column(name="NO_OF_PERSON" ,length = 225)
	private String nop;
	@Column(name="PRICE" ,length = 225)
	private String price;
	@Column(name="TOTAL_AMOUNT" ,length = 225)
	private String totalAmount;
	
	@Column(name="ARRIVAL_CITY" ,length = 225)
	private String arrivalCity;
	@Column(name="DEPARTURE_CITY" ,length = 225)
	private String departureCity;
	
	
	
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

	@Override
	public String toString() {
		return "InvoiceDTO [invoiceNo=" + invoiceNo + ", flightNo=" + flightNo + ", flightName=" + flightName
				+ ", arrivalDate=" + arrivalDate + ", departureDate=" + departureDate + ", userId=" + userId
				+ ", userName=" + userName + ", nop=" + nop + ", price=" + price + ", totalAmount=" + totalAmount + "]";
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

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNop() {
		return nop;
	}

	public void setNop(String nop) {
		this.nop = nop;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
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
