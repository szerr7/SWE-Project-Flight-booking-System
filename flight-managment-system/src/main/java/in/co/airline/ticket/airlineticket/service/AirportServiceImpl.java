package in.co.airline.ticket.airlineticket.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.airline.ticket.airlineticket.dao.AirportDAOInt;
import in.co.airline.ticket.airlineticket.dto.AirportDTO;
import in.co.airline.ticket.airlineticket.exception.DuplicateRecordException;

@Service
public class AirportServiceImpl implements AirportServiceInt {

private static Logger log=Logger.getLogger(AirportServiceImpl.class.getName());
	
	@Autowired
	private AirportDAOInt dao;
	
//	@Autowired
//	private JavaMailSenderImpl mailSender;
	
	@Override
	@Transactional
	public long add(AirportDTO dto) throws DuplicateRecordException {
		log.info("AirportServiceImpl Add method start");
		AirportDTO existdto=dao.findByName(dto.getName());
		if(existdto !=null)
			throw new DuplicateRecordException("Login Already Exist");
		long pk=dao.add(dto);
		log.info("AirportServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(AirportDTO dto) {
		log.info("AirportServiceImpl Delete method start");
		dao.delete(dto);
		log.info("AirportServiceImpl Delete method end");
		
	}

	@Override
	@Transactional
	public AirportDTO findBypk(long pk) {
		log.info("AirportServiceImpl findBypk method start");
		AirportDTO dto=dao.findBypk(pk);
		log.info("AirportServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public AirportDTO findByName(String name) {
		log.info("AirportServiceImpl findByAirportName method start");
		AirportDTO dto=dao.findByName(name);
		log.info("AirportServiceImpl findByAirportName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(AirportDTO dto) throws DuplicateRecordException {
		log.info("AirportServiceImpl update method start");
		AirportDTO existdto=dao.findByName(dto.getName());
		if(existdto !=null && dto.getId()!=existdto.getId())
			throw new DuplicateRecordException("Login Already Exist");
		dao.update(dto);
		log.info("AirportServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<AirportDTO> list() {
		log.info("AirportServiceImpl list method start");
		List<AirportDTO> list=dao.list();
		log.info("AirportServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<AirportDTO> list(int pageNo, int pageSize) {
		log.info("AirportServiceImpl list method start");
		List<AirportDTO> list=dao.list(pageNo, pageSize);
		log.info("AirportServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<AirportDTO> search(AirportDTO dto) {
		log.info("AirportServiceImpl search method start");
		List<AirportDTO> list=dao.search(dto);
		log.info("AirportServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<AirportDTO> search(AirportDTO dto, int pageNo, int pageSize) {
		log.info("AirportServiceImpl search method start");
		List<AirportDTO> list=dao.search(dto, pageNo, pageSize);
		log.info("AirportServiceImpl search method end");
		return list;
	}
}
