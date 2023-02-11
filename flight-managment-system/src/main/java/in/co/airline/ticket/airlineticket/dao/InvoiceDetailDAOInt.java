package in.co.airline.ticket.airlineticket.dao;

import java.util.List;

import in.co.airline.ticket.airlineticket.dto.InvoiceDetailDTO;

public interface InvoiceDetailDAOInt {

public long add(InvoiceDetailDTO dto);
	
	public void delete(InvoiceDetailDTO dto);
	
	public InvoiceDetailDTO findBypk(long pk);
	
	public InvoiceDetailDTO findByName(String name);
	
	public void update(InvoiceDetailDTO dto);
	
	public List<InvoiceDetailDTO> list();
	
	public List<InvoiceDetailDTO>list(int pageNo,int pageSize);
	
	public List<InvoiceDetailDTO> search(InvoiceDetailDTO dto);
	
	public List<InvoiceDetailDTO> search(InvoiceDetailDTO dto,int pageNo,int pageSize);
	
	
}
