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
import in.co.airline.ticket.airlineticket.dto.FlightDTO;

@Repository
public class FlightDAOImpl implements FlightDAOInt {

private static Logger log = Logger.getLogger(FlightDAOImpl.class.getName());
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public long add(FlightDTO dto) {
		log.info("FlightDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(dto);
		log.info("FlightDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(FlightDTO dto) {
		log.info("FlightDAOImpl Delete method Start");
		Session session = entityManager.unwrap(Session.class);
		session.remove(session.contains(dto) ? dto : session.merge(dto));
		log.info("FlightDAOImpl Delete method End");
		
	}

	@Override
	public FlightDTO findBypk(long pk) {
		log.info("FlightDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		FlightDTO dto = (FlightDTO) session.get(FlightDTO.class, pk);
		log.info("FlightDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public FlightDTO findByName(String name) {
		log.info("FlightDAOImpl FindByLogin method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(FlightDTO.class);
		criteria.add(Restrictions.eq("name", name));
		FlightDTO dto = (FlightDTO) criteria.uniqueResult();
		log.info("FlightDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(FlightDTO dto) {
		log.info("FlightDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("FlightDAOImpl update method End");
	}

	@Override
	public List<FlightDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<FlightDTO> list(int pageNo, int pageSize) {
		log.info("FlightDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<FlightDTO> query = session.createQuery("from FlightDTO", FlightDTO.class);
		List<FlightDTO> list = query.getResultList();
		log.info("FlightDAOImpl List method End");
		return list;
	}

	@Override
	public List<FlightDTO> search(FlightDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<FlightDTO> search(FlightDTO dto, int pageNo, int pageSize) {
		log.info("FlightDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(FlightDTO.class);
		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getFlightNo() != null && dto.getFlightNo().length() > 0) {
				criteria.add(Restrictions.like("flightNo", dto.getFlightNo() +"%"));
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
		log.info("FlightDAOImpl Search method End");
		return criteria.list();
	}

}
