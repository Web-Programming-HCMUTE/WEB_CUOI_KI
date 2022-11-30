package dao.Impl;

import java.util.List;

import dao.IHotelDetailDAO;
import dao.IPaymentDAO;
import dao.JpaEntityManager;
import model.HotelDetail;
import model.Payment;

public class PaymentDAO extends JpaEntityManager implements IPaymentDAO {

	@Override
	public List<Payment> getAllPayment() {
		// TODO Auto-generated method stub
		return super.getAll(Payment.class);
	}
	

	@Override
	public Payment getPaymentById(int id) {
		// TODO Auto-generated method stub
		return super.get(Payment.class, id);
	}

	@Override
	public void createPayment(Payment payment) {
		 super.save(payment);
		
	}

	@Override
	public void updatePayment(Payment payment) {
		super.saveOrUpdate(payment);
		
	}

	@Override
	public void deletePayment(Payment payment) {
		super.delete(payment);
		
	}

	
}
