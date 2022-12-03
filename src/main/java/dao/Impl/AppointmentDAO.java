package dao.Impl;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.query.Query;

import dao.JpaEntityManager;
import model.Appointment;
import model.Hotel;

public class AppointmentDAO extends JpaEntityManager{
		
	public List<Appointment> getByUser(String username){
		Transaction trans = getCurentSession().beginTransaction();
		String sql = "From Appointment a where a.userDatLich.name=:username";
		Query query = getCurentSession().createQuery(sql);
		query.setParameter("username",username);
		List<Appointment> appointment = query.getResultList();
		trans.commit();
		return appointment;
	}
	

}
