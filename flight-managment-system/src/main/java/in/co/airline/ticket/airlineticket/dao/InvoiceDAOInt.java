package in.co.airline.ticket.airlineticket.dao;

import java.util.List;

import in.co.airline.ticket.airlineticket.dto.InvoiceDTO;

public interface InvoiceDAOInt {

public long add(InvoiceDTO dto);
	
	public void delete(InvoiceDTO dto);
	
	public InvoiceDTO findBypk(long pk);
	
	public InvoiceDTO findByName(String name);
	
	public void update(InvoiceDTO dto);
	
	public List<InvoiceDTO> list();
	
	public List<InvoiceDTO>list(int pageNo,int pageSize);
	
	public List<InvoiceDTO> search(InvoiceDTO dto);
	
	public List<InvoiceDTO> search(InvoiceDTO dto,int pageNo,int pageSize);
	
	
}
