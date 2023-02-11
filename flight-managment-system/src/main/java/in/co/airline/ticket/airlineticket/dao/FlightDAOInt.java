package in.co.airline.ticket.airlineticket.dao;

import java.util.List;

import in.co.airline.ticket.airlineticket.dto.FlightDTO;

public interface FlightDAOInt {

public long add(FlightDTO dto);
	
	public void delete(FlightDTO dto);
	
	public FlightDTO findBypk(long pk);
	
	public FlightDTO findByName(String name);
	
	public void update(FlightDTO dto);
	
	public List<FlightDTO> list();
	
	public List<FlightDTO>list(int pageNo,int pageSize);
	
	public List<FlightDTO> search(FlightDTO dto);
	
	public List<FlightDTO> search(FlightDTO dto,int pageNo,int pageSize);
	
	
}
