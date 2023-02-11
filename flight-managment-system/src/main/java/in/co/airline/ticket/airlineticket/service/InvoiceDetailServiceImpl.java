package in.co.airline.ticket.airlineticket.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.airline.ticket.airlineticket.dao.InvoiceDetailDAOInt;
import in.co.airline.ticket.airlineticket.dto.InvoiceDetailDTO;
import in.co.airline.ticket.airlineticket.exception.DuplicateRecordException;

@Service
public class InvoiceDetailServiceImpl implements InvoiceDetailServiceInt {

private static Logger log=Logger.getLogger(InvoiceDetailServiceImpl.class.getName());
	
	@Autowired
	private InvoiceDetailDAOInt dao;
	
//	@Autowired
//	private JavaMailSenderImpl mailSender;
	
	@Override
	@Transactional
	public long add(InvoiceDetailDTO dto) throws DuplicateRecordException {
		log.info("InvoiceDetailServiceImpl Add method start");
		/*
		 * InvoiceDetailDTO existdto=dao.findByName(dto.getName()); if(existdto !=null)
		 * throw new DuplicateRecordException("Login Already Exist");
		 */
		long pk=dao.add(dto);
		log.info("InvoiceDetailServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(InvoiceDetailDTO dto) {
		log.info("InvoiceDetailServiceImpl Delete method start");
		dao.delete(dto);
		log.info("InvoiceDetailServiceImpl Delete method end");
		
	}

	@Override
	@Transactional
	public InvoiceDetailDTO findBypk(long pk) {
		log.info("InvoiceDetailServiceImpl findBypk method start");
		InvoiceDetailDTO dto=dao.findBypk(pk);
		log.info("InvoiceDetailServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public InvoiceDetailDTO findByName(String name) {
		log.info("InvoiceDetailServiceImpl findByInvoiceDetailName method start");
		InvoiceDetailDTO dto=dao.findByName(name);
		log.info("InvoiceDetailServiceImpl findByInvoiceDetailName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(InvoiceDetailDTO dto) throws DuplicateRecordException {
		log.info("InvoiceDetailServiceImpl update method start");
		/*
		 * InvoiceDetailDTO existdto=dao.findByName(dto.getName()); if(existdto !=null
		 * && dto.getId()!=existdto.getId()) throw new
		 * DuplicateRecordException("Login Already Exist");
		 */
		dao.update(dto);
		log.info("InvoiceDetailServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<InvoiceDetailDTO> list() {
		log.info("InvoiceDetailServiceImpl list method start");
		List<InvoiceDetailDTO> list=dao.list();
		log.info("InvoiceDetailServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<InvoiceDetailDTO> list(int pageNo, int pageSize) {
		log.info("InvoiceDetailServiceImpl list method start");
		List<InvoiceDetailDTO> list=dao.list(pageNo, pageSize);
		log.info("InvoiceDetailServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<InvoiceDetailDTO> search(InvoiceDetailDTO dto) {
		log.info("InvoiceDetailServiceImpl search method start");
		List<InvoiceDetailDTO> list=dao.search(dto);
		log.info("InvoiceDetailServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<InvoiceDetailDTO> search(InvoiceDetailDTO dto, int pageNo, int pageSize) {
		log.info("InvoiceDetailServiceImpl search method start");
		List<InvoiceDetailDTO> list=dao.search(dto, pageNo, pageSize);
		log.info("InvoiceDetailServiceImpl search method end");
		return list;
	}
}
