package in.co.airline.ticket.airlineticket.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import in.co.airline.ticket.airlineticket.dto.BaseDTO;
import in.co.airline.ticket.airlineticket.dto.ManageFlightDTO;
import in.co.airline.ticket.airlineticket.util.DataUtility;

public class ManageFlightForm extends BaseForm {

	@Min(value = 1, message = "Arrival Airport Name required")
	private long arrivalAirportId;
	@Min(value = 1, message = "Departure Airport Name required")
	private long departureAirportId;

	private String arrivalAirportName;
	private String departureAirportName;
	@Min(value = 1, message = "Flight Name required")
	private long flightId;
	private String flightName;
	private String flightNo;
	@NotEmpty(message = "Arrival Date is required")
	@Pattern(regexp = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$", message = "Arrival Date is Invalid")
	private String arrivalDate;
	@NotEmpty(message = "Departure Date is required")
	@Pattern(regexp = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$", message = "Departure is Invalid")
	private String departureDate;
	@NotEmpty(message = "Arrival Time is required")
	private String arrivalTime;
	@NotEmpty(message = "Departure Time is required")
	private String departureTime;
	@NotEmpty(message = "Ticket Price is required")
	@Pattern(regexp = "^((\\d{1,3}|\\s*){1})((\\,\\d{3}|\\d)*)(\\s*|\\.(\\d{2}))$", message = "Price is Invalid")
	private String price;
	@NotEmpty(message = "Arrival City is required")
	@Pattern(regexp = "(^[A-Za-z ]*)*$",message = "Arrival City is Invalid")
	private String arrivalCity;
	@NotEmpty(message = "Departure City is required")
	@Pattern(regexp = "(^[A-Za-z ]*)*$",message = "Departure City is Invalid")
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
	public BaseDTO getDTO() {
		ManageFlightDTO dto = new ManageFlightDTO();
		dto.setId(id);
		dto.setArrivalAirportId(arrivalAirportId);
		dto.setDepartureAirportId(departureAirportId);
		dto.setArrivalAirportName(arrivalAirportName);
		dto.setDepartureAirportName(departureAirportName);
		dto.setFlightId(flightId);
		dto.setFlightName(flightName);
		dto.setFlightNo(flightNo);
		dto.setArrivalDate(DataUtility.getDate(arrivalDate));
		dto.setDepartureDate(DataUtility.getDate(departureDate));
		dto.setArrivalTime(arrivalTime);
		dto.setDepartureTime(departureTime);
		dto.setPrice(price);
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
		ManageFlightDTO dto = (ManageFlightDTO) bdto;
		id = dto.getId();
		arrivalAirportId = dto.getArrivalAirportId();
		departureAirportId = dto.getDepartureAirportId();
		arrivalAirportName = dto.getArrivalAirportName();
		departureAirportName = dto.getDepartureAirportName();
		flightId = dto.getFlightId();
		flightName = dto.getFlightName();
		flightNo = dto.getFlightNo();
		arrivalDate = DataUtility.getDateString(dto.getArrivalDate());
		departureDate = DataUtility.getDateString(dto.getDepartureDate());
		arrivalTime = dto.getArrivalTime();
		departureTime = dto.getDepartureTime();
		price = dto.getPrice();
		arrivalCity = dto.getArrivalCity();
		departureCity = dto.getDepartureCity();
		createdBy = dto.getCreatedBy();
		modifiedBy = dto.getModifiedBy();
		createdDateTime = dto.getCreatedDatetime();
		modifiedDateTime = dto.getModifiedDatetime();
	}

}
