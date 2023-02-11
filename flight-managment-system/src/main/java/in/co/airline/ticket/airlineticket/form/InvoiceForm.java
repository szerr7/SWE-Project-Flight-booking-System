package in.co.airline.ticket.airlineticket.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import in.co.airline.ticket.airlineticket.dto.BaseDTO;
import in.co.airline.ticket.airlineticket.dto.InvoiceDTO;
import in.co.airline.ticket.airlineticket.util.DataUtility;

public class InvoiceForm extends BaseForm {
	private String invoiceNo;
	private String flightNo;
	private String flightName;
	private String arrivalDate;
	private String departureDate;
	private long userId;
	private String userName;
	@NotEmpty(message = "No of Person is required")
	@Min(value=1, message="At leat must be 1")
	@Max(value=100, message="At lest must be minimum less then 100")
	private String nop;
	private String price;
	private String totalAmount;
	private String arrivalCity;
	private String departureCity;
	
	private String[] array;
	
	
	
	
	
	public String[] getArray() {
		return array;
	}

	public void setArray(String[] array) {
		this.array = array;
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

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
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
	

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	@Override
	public BaseDTO getDTO() {
		InvoiceDTO dto=new InvoiceDTO();
		dto.setId(id);
		dto.setInvoiceNo(DataUtility.getLong(invoiceNo));
		dto.setFlightNo(flightNo);
		dto.setFlightName(flightName);
		dto.setArrivalDate(DataUtility.getDate(arrivalDate));
		dto.setDepartureDate(DataUtility.getDate("departureDate"));
		dto.setUserId(userId);
		dto.setUserName(userName);
		dto.setNop(nop);
		dto.setPrice(price);
		dto.setTotalAmount(totalAmount);
		dto.setArrivalCity(arrivalCity);
		dto.setDepartureCity(departureCity);
		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);
		dto.setCreatedDatetime(createdDateTime);
		dto.setModifiedDatetime(modifiedDateTime);
		return dto;
	}

	@Override
	public void populate(BaseDTO bdto) {
		InvoiceDTO dto=(InvoiceDTO)bdto;
		id=dto.getId();
		invoiceNo=String.valueOf(dto.getInvoiceNo());
		flightNo=dto.getFlightNo();
		flightName=dto.getFlightName();
		arrivalDate=DataUtility.getDateString(dto.getArrivalDate());
		departureDate=DataUtility.getDateString(dto.getDepartureDate());
		userId=dto.getUserId();
		userName=dto.getUserName();
		nop=dto.getNop();
		price=dto.getPrice();
		totalAmount=dto.getTotalAmount();
		arrivalCity=dto.getArrivalCity();
		departureCity=dto.getDepartureCity();
		createdBy=dto.getCreatedBy();
		modifiedBy=dto.getModifiedBy();
		createdDateTime=dto.getCreatedDatetime();
		modifiedDateTime=dto.getModifiedDatetime();
	}

}
