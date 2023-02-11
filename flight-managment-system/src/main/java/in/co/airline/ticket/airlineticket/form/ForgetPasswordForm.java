package in.co.airline.ticket.airlineticket.form;


import javax.validation.constraints.NotEmpty;


import in.co.airline.ticket.airlineticket.dto.BaseDTO;
import in.co.airline.ticket.airlineticket.dto.UserDTO;

public class ForgetPasswordForm extends BaseForm {

	@NotEmpty(message = "Login is required")
	private String login;
	
	
	
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	
	

	@Override
	public BaseDTO getDTO() {
	
		UserDTO dto = new UserDTO();
		dto.setLogin(login);
		return dto;
	}

	@Override
	public void populate(BaseDTO bDto) {
		// TODO Auto-generated method stub
		
	}

}
