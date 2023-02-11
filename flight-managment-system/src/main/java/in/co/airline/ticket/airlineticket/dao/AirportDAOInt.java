package in.co.airline.ticket.airlineticket.dao;

import java.util.List;

import in.co.airline.ticket.airlineticket.dto.AirportDTO;

public interface AirportDAOInt {

public long add(AirportDTO dto);
	
	public void delete(AirportDTO dto);
	
	public AirportDTO findBypk(long pk);
	
	public AirportDTO findByName(String name);
	
	public void update(AirportDTO dto);
	
	public List<AirportDTO> list();
	
	public List<AirportDTO>list(int pageNo,int pageSize);
	
	public List<AirportDTO> search(AirportDTO dto);
	
	public List<AirportDTO> search(AirportDTO dto,int pageNo,int pageSize);
	
	
}
