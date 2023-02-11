package in.co.airline.ticket.airlineticket.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import in.co.airline.ticket.airlineticket.dto.BaseDTO;
import in.co.airline.ticket.airlineticket.dto.FlightDTO;

public class FlightForm extends BaseForm {

	@NotEmpty(message="Flight No is required")
	private String flightNo;
	@NotEmpty(message="Name is required")
	@Pattern(regexp = "(^[A-Za-z ]*)*$",message = "Name is Invalid")
	private String name;
	@NotEmpty(message="PNR No is required")
	private String PNR;
	
	
	
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
	public BaseDTO getDTO() {
		FlightDTO dto=new FlightDTO();
		dto.setId(id);
		dto.setFlightNo(flightNo);
		dto.setName(name);
		dto.setPNR(PNR);
		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);
		dto.setCreatedDatetime(createdDateTime);
		dto.setModifiedDatetime(modifiedDateTime);
		return dto;
	}

	@Override
	public void populate(BaseDTO bdto) {
		FlightDTO dto=(FlightDTO) bdto;
		id=dto.getId();
		flightNo=dto.getFlightNo();
		name=dto.getName();
		PNR=dto.getPNR();
		createdBy=dto.getCreatedBy();
		modifiedBy=dto.getModifiedBy();
		createdDateTime=dto.getCreatedDatetime();
		modifiedDateTime=dto .getModifiedDatetime();
	}

}
