package in.co.airline.ticket.airlineticket.service;

import java.util.List;

import in.co.airline.ticket.airlineticket.dto.InvoiceDTO;
import in.co.airline.ticket.airlineticket.exception.DuplicateRecordException;

public interface InvoiceServiceInt {

	public long add(InvoiceDTO dto) throws DuplicateRecordException;

	public void delete(InvoiceDTO dto);

	public InvoiceDTO findBypk(long pk);

	public InvoiceDTO findByName(String name);

	public void update(InvoiceDTO dto) throws DuplicateRecordException;

	public List<InvoiceDTO> list();

	public List<InvoiceDTO> list(int pageNo, int pageSize);

	public List<InvoiceDTO> search(InvoiceDTO dto);

	public List<InvoiceDTO> search(InvoiceDTO dto, int pageNo, int pageSize);
	
}
