package dao.Impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.hibernate.Transaction;
import org.hibernate.query.Query;

import dao.IHotelDAO;
import dao.JpaEntityManager;
import model.HotelDetail;
import model.Hotel;

public class HotelDAO extends JpaEntityManager implements IHotelDAO {

	@Override
	public List<Hotel> getAll() {
		// TODO Auto-generated method stub
		return super.getAll(Hotel.class);
	}
	
	public List<Hotel> getAllHotelActive(){
		Transaction trans = getCurentSession().beginTransaction();
		String sql = "From Hotel h where h.activate=true";
		Query query = getCurentSession().createQuery(sql);
		List<Hotel> hotels = query.getResultList();
		trans.commit();
		return hotels;
	}

	@Override
	public Hotel get(int id) {
		return super.get(Hotel.class, id);
		
	}
	
	public List<Hotel> getByUser(String username){
		Transaction trans = getCurentSession().beginTransaction();
		String sql = "From Hotel h where h.user.name=:username";
		Query query = getCurentSession().createQuery(sql);
		
		query.setParameter("username",username);
		List<Hotel> hotels = query.getResultList();
		trans.commit();
		return hotels;
		
	}

	public List<Hotel> getByName(String name, String room, String price) {
		Transaction trans = getCurentSession().beginTransaction();
		String sql = "From Hotel rb INNER JOIN rb.hotelDetail where rb.content  like :keyword";
		if(room != null) {
			if(Integer.valueOf(room) == 1) {
				sql += " and rb.hotelDetail.numberRoom <= :room+1";
			}
			else if(Integer.valueOf(room) == 3) {
				sql += " and rb.hotelDetail.numberRoom <= :room and rb.hotelDetail.numberRoom >= :room-1";
			}
			else if(Integer.valueOf(room) == 5) {
				sql += " and rb.hotelDetail.numberRoom <= :room and rb.hotelDetail.numberRoom >= :room-2";
			}
		}
		if(price != null) {
			sql += " and rb.hotelDetail.price <= :price";
		}
		Query query = getCurentSession().createQuery(sql);
		
		query.setParameter("keyword","%" + name + "%");
		
		if(room != null) {
			query.setParameter("room", Integer.valueOf(room));
		}
		if(price != null) {
			query.setParameter("price",BigDecimal.valueOf(Long.parseLong(price)));
		}
		
		List<Hotel> hotels = query.getResultList();
		trans.commit();
		return hotels;
	}

	@Override
	public void save(Hotel post) {
		// TODO Auto-generated method stub
		 super.save(post);
		
	}

	@Override
	public void saveOrUpdate(Hotel post) {
		// TODO Auto-generated method stub
		 super.saveOrUpdate(post);
	}

	@Override
	public void delete(Hotel hotelDeleteHotel) {
		// TODO Auto-generated method stub
		super.delete(hotelDeleteHotel);
	}
	
	

	
	public void savePostAndHotel(Hotel post, HotelDetail hotelDetail) {
		super.save(hotelDetail);
		post.setHotelDetail(hotelDetail);
		super.save(post);
	}
	

}
