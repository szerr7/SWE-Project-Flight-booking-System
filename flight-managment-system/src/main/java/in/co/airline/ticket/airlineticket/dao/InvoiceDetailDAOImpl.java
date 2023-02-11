package in.co.airline.ticket.airlineticket.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.airline.ticket.airlineticket.dto.InvoiceDTO;
import in.co.airline.ticket.airlineticket.dto.InvoiceDetailDTO;

@Repository
public class InvoiceDetailDAOImpl implements InvoiceDetailDAOInt {

private static Logger log = Logger.getLogger(InvoiceDetailDAOImpl.class.getName());
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public long add(InvoiceDetailDTO dto) {
		log.info("InvoiceDetailDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(dto);
		log.info("InvoiceDetailDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(InvoiceDetailDTO dto) {
		log.info("InvoiceDetailDAOImpl Delete method Start");
		Session session = entityManager.unwrap(Session.class);
		session.delete(dto);
		log.info("InvoiceDetailDAOImpl Delete method End");
		
	}

	@Override
	public InvoiceDetailDTO findBypk(long pk) {
		log.info("InvoiceDetailDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		InvoiceDetailDTO dto = (InvoiceDetailDTO) session.get(InvoiceDetailDTO.class, pk);
		log.info("InvoiceDetailDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public InvoiceDetailDTO findByName(String name) {
		log.info("InvoiceDetailDAOImpl FindByLogin method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(InvoiceDetailDTO.class);
		criteria.add(Restrictions.eq("name", name));
		InvoiceDetailDTO dto = (InvoiceDetailDTO) criteria.uniqueResult();
		log.info("InvoiceDetailDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(InvoiceDetailDTO dto) {
		log.info("InvoiceDetailDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("InvoiceDetailDAOImpl update method End");
	}

	@Override
	public List<InvoiceDetailDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<InvoiceDetailDTO> list(int pageNo, int pageSize) {
		log.info("InvoiceDetailDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<InvoiceDetailDTO> query = session.createQuery("from InvoiceDetailDTO", InvoiceDetailDTO.class);
		List<InvoiceDetailDTO> list = query.getResultList();
		log.info("InvoiceDetailDAOImpl List method End");
		return list;
	}

	@Override
	public List<InvoiceDetailDTO> search(InvoiceDetailDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<InvoiceDetailDTO> search(InvoiceDetailDTO dto, int pageNo, int pageSize) {
		log.info("InvoiceDetailDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<InvoiceDetailDTO> query = session.createQuery("from InvoiceDetailDTO", InvoiceDetailDTO.class);
		Criteria criteria = session.createCriteria(InvoiceDetailDTO.class);
		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getUserId() > 0) {
				criteria.add(Restrictions.eq("userId", dto.getUserId()));
			}
			if (dto.getInvoiceNo() >0) {
				criteria.add(Restrictions.eq("invoiceNo", dto.getInvoiceNo()));
			}
			if (dto.getFlightName() != null && dto.getFlightName().length() > 0) {
				criteria.add(Restrictions.like("flightName", dto.getFlightName() + "%"));
			}
			if (dto.getName() != null && dto.getName().length() > 0) {
				criteria.add(Restrictions.like("name", dto.getName() + "%"));
			}
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		}
		log.info("InvoiceDAOImpl Search method End");
		return criteria.list();
	}

}
