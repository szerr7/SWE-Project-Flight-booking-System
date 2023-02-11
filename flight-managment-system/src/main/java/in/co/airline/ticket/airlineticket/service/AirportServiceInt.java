package in.co.airline.ticket.airlineticket.service;

import java.util.List;

import in.co.airline.ticket.airlineticket.dto.AirportDTO;
import in.co.airline.ticket.airlineticket.exception.DuplicateRecordException;

public interface AirportServiceInt {

	public long add(AirportDTO dto) throws DuplicateRecordException;

	public void delete(AirportDTO dto);

	public AirportDTO findBypk(long pk);

	public AirportDTO findByName(String name);

	public void update(AirportDTO dto) throws DuplicateRecordException;

	public List<AirportDTO> list();

	public List<AirportDTO> list(int pageNo, int pageSize);

	public List<AirportDTO> search(AirportDTO dto);

	public List<AirportDTO> search(AirportDTO dto, int pageNo, int pageSize);
	
}
