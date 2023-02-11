package in.co.airline.ticket.airlineticket.service;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.airline.ticket.airlineticket.dao.UserDAOInt;
import in.co.airline.ticket.airlineticket.dto.UserDTO;
import in.co.airline.ticket.airlineticket.exception.DuplicateRecordException;
import in.co.airline.ticket.airlineticket.util.EmailBuilder;




@Service
public class UserServiceImpl implements UserServiceInt {

	private static Logger log=Logger.getLogger(UserServiceImpl.class.getName());
	
	@Autowired
	private UserDAOInt dao;
	
//	@Autowired
//	private JavaMailSenderImpl mailSender;
	
	@Override
	@Transactional
	public long add(UserDTO dto) throws DuplicateRecordException {
		log.info("UserServiceImpl Add method start");
		UserDTO existdto=dao.findByLogin(dto.getLogin());
		System.out.println("in Student add After finad b pk");
		if(existdto !=null)
			throw new DuplicateRecordException("Login Already Exist");
		long pk=dao.add(dto);
		log.info("UserServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(UserDTO dto) {
		log.info("UserServiceImpl Delete method start");
		dao.delete(dto);
		log.info("UserServiceImpl Delete method end");
		
	}

	@Override
	@Transactional
	public UserDTO findBypk(long pk) {
		log.info("UserServiceImpl findBypk method start");
		UserDTO dto=dao.findBypk(pk);
		log.info("UserServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public UserDTO findByLogin(String login) {
		log.info("UserServiceImpl findByUserName method start");
		UserDTO dto=dao.findByLogin(login);
		log.info("UserServiceImpl findByUserName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(UserDTO dto) throws DuplicateRecordException {
		log.info("UserServiceImpl update method start");
		UserDTO existdto=dao.findByLogin(dto.getLogin());
		if(existdto !=null && dto.getId()!=existdto.getId())
			throw new DuplicateRecordException("Login Already Exist");
		dao.update(dto);
		log.info("UserServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<UserDTO> list() {
		log.info("UserServiceImpl list method start");
		List<UserDTO> list=dao.list();
		log.info("UserServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<UserDTO> list(int pageNo, int pageSize) {
		log.info("UserServiceImpl list method start");
		List<UserDTO> list=dao.list(pageNo, pageSize);
		log.info("UserServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<UserDTO> search(UserDTO dto) {
		log.info("UserServiceImpl search method start");
		List<UserDTO> list=dao.search(dto);
		log.info("UserServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize) {
		log.info("UserServiceImpl search method start");
		List<UserDTO> list=dao.search(dto, pageNo, pageSize);
		log.info("UserServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public UserDTO authentication(UserDTO dto) {
		log.info("UserServiceImpl authentication method start");
		dto=dao.authentication(dto);
		log.info("UserServiceImpl authentication method end");
		return dto;
	}
	
	@Override
	@Transactional
	public boolean changePassword(Long id, String oldPassword, String newPassword) {
		log.info("UserServiceImpl  changePassword method start");
		UserDTO dtoExist = findBypk(id);
		if (dtoExist != null && dtoExist.getPassword().equals(oldPassword)) {
			dtoExist.setPassword(newPassword);
			dao.update(dtoExist);
			log.info("UserServiceImpl  changePassword method end");
			return true;
		} else {
			return false;
		}
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean forgetPassword(String login) {

		UserDTO dtoExist = dao.findByLogin(login);

		if (dtoExist != null) {

			HashMap<String, String> map = new HashMap<String, String>();
			map.put("firstName", dtoExist.getFirstName());
			map.put("lastName", dtoExist.getLastName());
			map.put("login", dtoExist.getLogin());
			map.put("password", dtoExist.getPassword());

			String message = EmailBuilder.getForgetPasswordMessage(map);

//			MimeMessage msg = mailSender.createMimeMessage();

//			try {
//				MimeMessageHelper helper = new MimeMessageHelper(msg);
//				helper.setTo(dtoExist.getEmail());
//				helper.setSubject("Login Regisration Password Password");
//				helper.setText(message, true);
//				mailSender.send(msg);
//			} catch (MessagingException e) {
//				e.printStackTrace();
//				return false;
//			}
		} else {
			return false;
		}
		return true;
	}

	
}
