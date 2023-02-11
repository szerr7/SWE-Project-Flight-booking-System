package in.co.airline.ticket.airlineticket.form;

import java.util.Arrays;

import in.co.airline.ticket.airlineticket.dto.BaseDTO;
import in.co.airline.ticket.airlineticket.dto.InvoiceDetailDTO;
import in.co.airline.ticket.airlineticket.util.DataUtility;

public class InvoiceDetailForm extends BaseForm {

	private String[] name;
	private String[] gender;
	private String[] dob;
	
	private String userName;
	private String invoiceNo;
	private long userId;
	private String flightNo;
	
	
	
	
	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String[] getName() {
		return name;
	}

	public void setName(String[] name) {
		this.name = name;
	}

	public String[] getGender() {
		return gender;
	}

	public void setGender(String[] gender) {
		this.gender = gender;
	}

	public String[] getDob() {
		return dob;
	}

	public void setDob(String[] dob) {
		this.dob = dob;
	}
	
	

	@Override
	public String toString() {
		return "InvoiceDetailForm [name=" + Arrays.toString(name) + ", gender=" + Arrays.toString(gender) + ", dob="
				+ Arrays.toString(dob) + "]";
	}

	@Override
	public BaseDTO getDTO() {
		InvoiceDetailDTO dto=new InvoiceDetailDTO();
			dto.setName(userName);
			dto.setUserId(userId);
			dto.setFlightNo(flightNo);
			dto.setInvoiceNo(DataUtility.getLong(invoiceNo));
		return dto;
	}

	@Override
	public void populate(BaseDTO bdto) {
		InvoiceDetailDTO dto=(InvoiceDetailDTO)bdto;
		userName=dto.getName();
		userId=dto.getUserId();
		flightNo=dto.getFlightNo();
		invoiceNo=String.valueOf(dto.getInvoiceNo());
	}

}
