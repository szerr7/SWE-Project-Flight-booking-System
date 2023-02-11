package in.co.airline.ticket.airlineticket.service;

import java.util.List;

import in.co.airline.ticket.airlineticket.dto.InvoiceDetailDTO;
import in.co.airline.ticket.airlineticket.exception.DuplicateRecordException;

public interface InvoiceDetailServiceInt {

	public long add(InvoiceDetailDTO dto) throws DuplicateRecordException;

	public void delete(InvoiceDetailDTO dto);

	public InvoiceDetailDTO findBypk(long pk);

	public InvoiceDetailDTO findByName(String name);

	public void update(InvoiceDetailDTO dto) throws DuplicateRecordException;

	public List<InvoiceDetailDTO> list();

	public List<InvoiceDetailDTO> list(int pageNo, int pageSize);

	public List<InvoiceDetailDTO> search(InvoiceDetailDTO dto);

	public List<InvoiceDetailDTO> search(InvoiceDetailDTO dto, int pageNo, int pageSize);
	
}
