package in.co.airline.ticket.airlineticket.dao;

import java.util.List;

import in.co.airline.ticket.airlineticket.dto.ManageFlightDTO;

public interface ManageFlightDAOInt {

public long add(ManageFlightDTO dto);
	
	public void delete(ManageFlightDTO dto);
	
	public ManageFlightDTO findBypk(long pk);
	
	public ManageFlightDTO findByName(String name);
	
	public void update(ManageFlightDTO dto);
	
	public List<ManageFlightDTO> list();
	
	public List<ManageFlightDTO>list(int pageNo,int pageSize);
	
	public List<ManageFlightDTO> search(ManageFlightDTO dto);
	
	public List<ManageFlightDTO> search(ManageFlightDTO dto,int pageNo,int pageSize);
	
	
}
