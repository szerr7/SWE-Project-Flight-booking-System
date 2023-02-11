package in.co.airline.ticket.airlineticket.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.airline.ticket.airlineticket.dao.InvoiceDAOInt;
import in.co.airline.ticket.airlineticket.dto.InvoiceDTO;
import in.co.airline.ticket.airlineticket.exception.DuplicateRecordException;

@Service
public class InvoiceServiceImpl implements InvoiceServiceInt {

private static Logger log=Logger.getLogger(InvoiceServiceImpl.class.getName());
	
	@Autowired
	private InvoiceDAOInt dao;
	
	
	@Override
	@Transactional
	public long add(InvoiceDTO dto) throws DuplicateRecordException {
		log.info("InvoiceServiceImpl Add method start");
		/*
		 * InvoiceDTO existdto=dao.findByName(dto.getName()); if(existdto !=null) throw
		 * new DuplicateRecordException("Login Already Exist");
		 */
		long pk=dao.add(dto);
		log.info("InvoiceServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(InvoiceDTO dto) {
		log.info("InvoiceServiceImpl Delete method start");
		dao.delete(dto);
		log.info("InvoiceServiceImpl Delete method end");
		
	}

	@Override
	@Transactional
	public InvoiceDTO findBypk(long pk) {
		log.info("InvoiceServiceImpl findBypk method start");
		InvoiceDTO dto=dao.findBypk(pk);
		log.info("InvoiceServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public InvoiceDTO findByName(String name) {
		log.info("InvoiceServiceImpl findByInvoiceName method start");
		InvoiceDTO dto=dao.findByName(name);
		log.info("InvoiceServiceImpl findByInvoiceName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(InvoiceDTO dto) throws DuplicateRecordException {
		log.info("InvoiceServiceImpl update method start");
		/*
		 * InvoiceDTO existdto=dao.findByName(dto.getName()); if(existdto !=null &&
		 * dto.getId()!=existdto.getId()) throw new
		 * DuplicateRecordException("Login Already Exist");
		 */
		dao.update(dto);
		log.info("InvoiceServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<InvoiceDTO> list() {
		log.info("InvoiceServiceImpl list method start");
		List<InvoiceDTO> list=dao.list();
		log.info("InvoiceServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<InvoiceDTO> list(int pageNo, int pageSize) {
		log.info("InvoiceServiceImpl list method start");
		List<InvoiceDTO> list=dao.list(pageNo, pageSize);
		log.info("InvoiceServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<InvoiceDTO> search(InvoiceDTO dto) {
		log.info("InvoiceServiceImpl search method start");
		List<InvoiceDTO> list=dao.search(dto);
		log.info("InvoiceServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<InvoiceDTO> search(InvoiceDTO dto, int pageNo, int pageSize) {
		log.info("InvoiceServiceImpl search method start");
		List<InvoiceDTO> list=dao.search(dto, pageNo, pageSize);
		log.info("InvoiceServiceImpl search method end");
		return list;
	}
}
