package in.co.airline.ticket.airlineticket.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.airline.ticket.airlineticket.dao.FlightDAOInt;
import in.co.airline.ticket.airlineticket.dto.FlightDTO;
import in.co.airline.ticket.airlineticket.exception.DuplicateRecordException;

@Service
public class FlightServiceImpl implements FlightServiceInt {

private static Logger log=Logger.getLogger(FlightServiceImpl.class.getName());
	
	@Autowired
	private FlightDAOInt dao;
	
//	@Autowired
//	private JavaMailSenderImpl mailSender;
	
	@Override
	@Transactional
	public long add(FlightDTO dto) throws DuplicateRecordException {
		log.info("FlightServiceImpl Add method start");
		FlightDTO existdto=dao.findByName(dto.getName());
		if(existdto !=null)
			throw new DuplicateRecordException("Login Already Exist");
		long pk=dao.add(dto);
		log.info("FlightServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(FlightDTO dto) {
		log.info("FlightServiceImpl Delete method start");
		dao.delete(dto);
		log.info("FlightServiceImpl Delete method end");
		
	}

	@Override
	@Transactional
	public FlightDTO findBypk(long pk) {
		log.info("FlightServiceImpl findBypk method start");
		FlightDTO dto=dao.findBypk(pk);
		log.info("FlightServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public FlightDTO findByName(String name) {
		log.info("FlightServiceImpl findByFlightName method start");
		FlightDTO dto=dao.findByName(name);
		log.info("FlightServiceImpl findByFlightName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(FlightDTO dto) throws DuplicateRecordException {
		log.info("FlightServiceImpl update method start");
		FlightDTO existdto=dao.findByName(dto.getName());
		if(existdto !=null && dto.getId()!=existdto.getId())
			throw new DuplicateRecordException("Login Already Exist");
		dao.update(dto);
		log.info("FlightServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<FlightDTO> list() {
		log.info("FlightServiceImpl list method start");
		List<FlightDTO> list=dao.list();
		log.info("FlightServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<FlightDTO> list(int pageNo, int pageSize) {
		log.info("FlightServiceImpl list method start");
		List<FlightDTO> list=dao.list(pageNo, pageSize);
		log.info("FlightServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<FlightDTO> search(FlightDTO dto) {
		log.info("FlightServiceImpl search method start");
		List<FlightDTO> list=dao.search(dto);
		log.info("FlightServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<FlightDTO> search(FlightDTO dto, int pageNo, int pageSize) {
		log.info("FlightServiceImpl search method start");
		List<FlightDTO> list=dao.search(dto, pageNo, pageSize);
		log.info("FlightServiceImpl search method end");
		return list;
	}
}
