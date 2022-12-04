package dao;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Hotel;
import util.HibernateUtils;

@Transactional
public class JpaEntityManager {

	private SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

	public Session getCurentSession() {
		return sessionFactory.getCurrentSession();
	}

	public <T> T save(final T o) {
		Transaction trans = getCurentSession().beginTransaction();
		try {
			final T res = (T) sessionFactory.getCurrentSession().save(o);
			trans.commit();
			return res;
		} catch (Exception e) {
			// TODO: handle exception
			trans.rollback();
			return null;
		}
	}

	public void delete(final Object object) {
		Transaction trans = getCurentSession().beginTransaction();
		try {
			sessionFactory.getCurrentSession().delete(object);
			trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			trans.rollback();
		}
	}

	/***/
	public <T> T get(final Class<T> type, final int id) {
		Transaction trans = getCurentSession().beginTransaction();
		T ts = sessionFactory.getCurrentSession().get(type, id);
		trans.commit();
		return ts;
	}

	/***/
	public <T> T merge(final T o) {
		Transaction trans = getCurentSession().beginTransaction();
		T ts = (T) sessionFactory.getCurrentSession().merge(o);
		trans.commit();
		return ts;
	}

	/***/
	public <T> void saveOrUpdate(final T o) {
		Transaction trans = getCurentSession().beginTransaction();
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(o);
			trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			trans.rollback();
		}
	}

	public <T> List<T> getAll(final Class<T> type) {
		EntityManager em = sessionFactory.createEntityManager();
		CriteriaBuilder cBuilder = em.getCriteriaBuilder();
		CriteriaQuery<T> ts = cBuilder.createQuery(type);
		Root<T> root = ts.from(type);
		CriteriaQuery<T> allCriteriaQuery = ts.select(root);
		TypedQuery<T> alQuery = em.createQuery(allCriteriaQuery);
		return alQuery.getResultList();
	}
}
