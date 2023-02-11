package in.co.airline.ticket.airlineticket.dao;

import java.util.List;

import in.co.airline.ticket.airlineticket.dto.UserDTO;

public interface UserDAOInt {

	public long add(UserDTO DTO);
	
	public void delete(UserDTO DTO);
	
	public UserDTO findBypk(long pk);
	
	public UserDTO findByLogin(String login);
	
	public void update(UserDTO DTO);
	
	public List<UserDTO> list();
	
	public List<UserDTO>list(int pageNo,int pageSize);
	
	public List<UserDTO> search(UserDTO DTO);
	
	public List<UserDTO> search(UserDTO DTO,int pageNo,int pageSize);
	
	public UserDTO authentication(UserDTO DTO);
}
