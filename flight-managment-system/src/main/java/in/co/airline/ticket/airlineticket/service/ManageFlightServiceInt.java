package in.co.airline.ticket.airlineticket.service;

import java.util.List;

import in.co.airline.ticket.airlineticket.dto.ManageFlightDTO;
import in.co.airline.ticket.airlineticket.exception.DuplicateRecordException;

public interface ManageFlightServiceInt {

	public long add(ManageFlightDTO dto) throws DuplicateRecordException;

	public void delete(ManageFlightDTO dto);

	public ManageFlightDTO findBypk(long pk);

	public ManageFlightDTO findByName(String name);

	public void update(ManageFlightDTO dto) throws DuplicateRecordException;

	public List<ManageFlightDTO> list();

	public List<ManageFlightDTO> list(int pageNo, int pageSize);

	public List<ManageFlightDTO> search(ManageFlightDTO dto);

	public List<ManageFlightDTO> search(ManageFlightDTO dto, int pageNo, int pageSize);
	
}
