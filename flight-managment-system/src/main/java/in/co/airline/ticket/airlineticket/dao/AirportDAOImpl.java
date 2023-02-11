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

import in.co.airline.ticket.airlineticket.dto.AirportDTO;
import in.co.airline.ticket.airlineticket.dto.UserDTO;
import in.co.airline.ticket.airlineticket.dto.AirportDTO;

@Repository
public class AirportDAOImpl implements AirportDAOInt {

	private static Logger log = Logger.getLogger(AirportDAOImpl.class.getName());

	@Autowired
	private EntityManager entityManager;

	@Override
	public long add(AirportDTO dto) {
		log.info("AirportDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(dto);
		log.info("AirportDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(AirportDTO dto) {
		log.info("AirportDAOImpl Delete method Start");
		Session session = entityManager.unwrap(Session.class);
		session.remove(session.contains(dto) ? dto : session.merge(dto));
		log.info("AirportDAOImpl Delete method End");

	}

	@Override
	public AirportDTO findBypk(long pk) {
		log.info("AirportDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		AirportDTO dto = (AirportDTO) session.get(AirportDTO.class, pk);
		log.info("AirportDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public AirportDTO findByName(String name) {
		log.info("AirportDAOImpl FindByLogin method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(AirportDTO.class);
		criteria.add(Restrictions.eq("name", name));
		AirportDTO dto = (AirportDTO) criteria.uniqueResult();
		log.info("AirportDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(AirportDTO dto) {
		log.info("AirportDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("AirportDAOImpl update method End");
	}

	@Override
	public List<AirportDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<AirportDTO> list(int pageNo, int pageSize) {
		log.info("AirportDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<AirportDTO> query = session.createQuery("from AirportDTO", AirportDTO.class);
		List<AirportDTO> list = query.getResultList();
		log.info("AirportDAOImpl List method End");
		return list;
	}

	@Override
	public List<AirportDTO> search(AirportDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<AirportDTO> search(AirportDTO dto, int pageNo, int pageSize) {
		log.info("AirportDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(AirportDTO.class);
		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getCode() != null && dto.getCode().length() > 0) {
				criteria.add(Restrictions.like("code", dto.getCode() + "%"));
			}
			if (dto.getName() != null && dto.getName().length() > 0) {
				criteria.add(Restrictions.like("name", dto.getName() + "%"));
			}
			if (dto.getCity() != null && dto.getCity().length() > 0) {
				criteria.add(Restrictions.like("city", dto.getCity() + "%"));
			}
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		}
		log.info("AirportDAOImpl Search method End");
		return criteria.list();
	}

}
