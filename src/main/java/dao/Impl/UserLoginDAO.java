package dao.Impl;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.query.Query;

import dao.IUserLoginDAO;
import dao.JpaEntityManager;
import model.Hotel;
import model.UserLogin;

public class UserLoginDAO extends JpaEntityManager implements IUserLoginDAO {

	@Override
	public List<UserLogin> getAll() {
		return super.getAll(UserLogin.class);
	}

	@Override
	public UserLogin get(int id) {
		return super.get(UserLogin.class, id);
	}
	
	public UserLogin checkLogin(String username, String password) {
		Transaction trans = getCurentSession().beginTransaction();
		Query query = getCurentSession().createQuery("From UserLogin as u where u.username=:username and u.password=:password ");
		query.setParameter("username",username);
		query.setParameter("password",password);
		
		List<UserLogin> user =query.getResultList();
		
		trans.commit();
		if(user != null && user.size() > 0)
			return user.get(0);
		return null;
	}

	@Override
	public void save(UserLogin userlogin) {
		super.save(userlogin);	
	}

	@Override
	public void update(UserLogin userlogin) {
		super.save(userlogin);
	}

	@Override
	public void delete(UserLogin userlogin) {
		super.delete(userlogin);
	}
}
