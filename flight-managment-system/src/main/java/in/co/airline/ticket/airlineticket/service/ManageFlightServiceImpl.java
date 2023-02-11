package in.co.airline.ticket.airlineticket.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import in.co.airline.ticket.airlineticket.dao.ManageFlightDAOInt;
import in.co.airline.ticket.airlineticket.dto.ManageFlightDTO;
import in.co.airline.ticket.airlineticket.exception.DuplicateRecordException;

@Service
public class ManageFlightServiceImpl implements ManageFlightServiceInt {

private static Logger log=Logger.getLogger(ManageFlightServiceImpl.class.getName());
	
	@Autowired
	private ManageFlightDAOInt dao;
	
//	@Autowired
//	private JavaMailSenderImpl mailSender;
	
	@Override
	@Transactional
	public long add(ManageFlightDTO dto) throws DuplicateRecordException {
		log.info("ManageFlightServiceImpl Add method start");
		
		long pk=dao.add(dto);
		log.info("ManageFlightServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(ManageFlightDTO dto) {
		log.info("ManageFlightServiceImpl Delete method start");
		dao.delete(dto);
		log.info("ManageFlightServiceImpl Delete method end");
		
	}

	@Override
	@Transactional
	public ManageFlightDTO findBypk(long pk) {
		log.info("ManageFlightServiceImpl findBypk method start");
		ManageFlightDTO dto=dao.findBypk(pk);
		log.info("ManageFlightServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public ManageFlightDTO findByName(String name) {
		log.info("ManageFlightServiceImpl findByManageFlightName method start");
		ManageFlightDTO dto=dao.findByName(name);
		log.info("ManageFlightServiceImpl findByManageFlightName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(ManageFlightDTO dto) throws DuplicateRecordException {
		log.info("ManageFlightServiceImpl update method start");
		dao.update(dto);
		log.info("ManageFlightServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<ManageFlightDTO> list() {
		log.info("ManageFlightServiceImpl list method start");
		List<ManageFlightDTO> list=dao.list();
		log.info("ManageFlightServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<ManageFlightDTO> list(int pageNo, int pageSize) {
		log.info("ManageFlightServiceImpl list method start");
		List<ManageFlightDTO> list=dao.list(pageNo, pageSize);
		log.info("ManageFlightServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<ManageFlightDTO> search(ManageFlightDTO dto) {
		log.info("ManageFlightServiceImpl search method start");
		List<ManageFlightDTO> list=dao.search(dto);
		log.info("ManageFlightServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<ManageFlightDTO> search(ManageFlightDTO dto, int pageNo, int pageSize) {
		log.info("ManageFlightServiceImpl search method start");
		List<ManageFlightDTO> list=dao.search(dto, pageNo, pageSize);
		log.info("ManageFlightServiceImpl search method end");
		return list;
	}
}
