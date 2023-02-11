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

import in.co.airline.ticket.airlineticket.dto.FlightDTO;
import in.co.airline.ticket.airlineticket.dto.ManageFlightDTO;

@Repository
public class ManageFlightDAOImpl implements ManageFlightDAOInt {

private static Logger log = Logger.getLogger(ManageFlightDAOImpl.class.getName());
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public long add(ManageFlightDTO dto) {
		log.info("ManageFlightDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(dto);
		log.info("ManageFlightDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(ManageFlightDTO dto) {
		log.info("ManageFlightDAOImpl Delete method Start");
		Session session = entityManager.unwrap(Session.class);
		session.remove(session.contains(dto) ? dto : session.merge(dto));
		log.info("ManageFlightDAOImpl Delete method End");
		
	}

	@Override
	public ManageFlightDTO findBypk(long pk) {
		log.info("ManageFlightDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		ManageFlightDTO dto = (ManageFlightDTO) session.get(ManageFlightDTO.class, pk);
		log.info("ManageFlightDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public ManageFlightDTO findByName(String name) {
		log.info("ManageFlightDAOImpl FindByLogin method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(ManageFlightDTO.class);
		criteria.add(Restrictions.eq("name", name));
		ManageFlightDTO dto = (ManageFlightDTO) criteria.uniqueResult();
		log.info("ManageFlightDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(ManageFlightDTO dto) {
		log.info("ManageFlightDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("ManageFlightDAOImpl update method End");
	}

	@Override
	public List<ManageFlightDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<ManageFlightDTO> list(int pageNo, int pageSize) {
		log.info("ManageFlightDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<ManageFlightDTO> query = session.createQuery("from ManageFlightDTO", ManageFlightDTO.class);
		List<ManageFlightDTO> list = query.getResultList();
		log.info("ManageFlightDAOImpl List method End");
		return list;
	}

	@Override
	public List<ManageFlightDTO> search(ManageFlightDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<ManageFlightDTO> search(ManageFlightDTO dto, int pageNo, int pageSize) {
		log.info("ManageFlightDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(ManageFlightDTO.class);
		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getFlightName() != null && dto.getFlightName().length() > 0) {
				criteria.add(Restrictions.like("flightName", dto.getFlightName() +"%"));
			}
			if (dto.getFlightNo() != null && dto.getFlightNo().length() > 0) {
				criteria.add(Restrictions.like("flightNo", dto.getFlightNo() + "%"));
			}
			if (dto.getArrivalCity() != null && dto.getArrivalCity().length() > 0) {
				criteria.add(Restrictions.like("arrivalCity", dto.getArrivalCity() + "%"));
			}
			if (dto.getDepartureCity() != null && dto.getDepartureCity().length() > 0) {
				criteria.add(Restrictions.like("departureCity", dto.getDepartureCity() + "%"));
			}
			if (dto.getArrivalDate() != null && dto.getArrivalDate().getDate()>0) {
				criteria.add(Restrictions.eq("arrivalDate", dto.getArrivalDate()));
			}
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		}
		log.info("ManageFlightDAOImpl Search method End");
		return criteria.list();
	}

}
