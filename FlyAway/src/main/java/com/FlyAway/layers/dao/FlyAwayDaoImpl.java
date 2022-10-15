package com.FlyAway.layers.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.FlyAway.layers.dto.Admin;
import com.FlyAway.layers.dto.Airlines;
import com.FlyAway.layers.dto.Flights;
import com.FlyAway.layers.dto.User;
import com.FlyAway.layers.util.ConnectionManagerImpl;

public class FlyAwayDaoImpl implements FlyAwayDao {

	private SessionFactory factory = null;

	public FlyAwayDaoImpl() {
		factory = new ConnectionManagerImpl().getConnection();
	}

//	add admin
	@Override
	public Integer addadmin(Admin admin) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		int i = (int) session.save(admin);
		transaction.commit();
		session.close();
		factory.close();

		return i;
	}

//  reset password
	@Override
	public int resetpassword(String username, String newpassword, String oldpassword) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		String hql = "UPDATE Admin set password=:p where username=:u and password=:old";
		Query query = session.createQuery(hql);
		query.setParameter("p", newpassword);
		query.setParameter("u", username);
		query.setParameter("old", oldpassword);
		int result = query.executeUpdate();
		transaction.commit();
		session.close();
		factory.close();

		return result;
	}

//  search flight
	@Override
	public ArrayList<Airlines> Searchflight(Flights flights) {
		ArrayList<Airlines> searchflight = new ArrayList<Airlines>();
		Session session = factory.openSession();
		String hql = "from Airlines a inner join fetch a.flights f where f.source=:s and f.destination=:d and f.date=:date";
		Query query = (Query) session.createQuery(hql);
		query.setParameter("s", flights.getSource());
		query.setParameter("d", flights.getDestination());
		query.setParameter("date", flights.getDate());
		searchflight = (ArrayList<Airlines>) query.getResultList();

		return searchflight;
	}

//  add user
	@Override
	public Integer adduser(User user) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		int result = (int) session.save(user);
		transaction.commit();
		session.close();
		factory.close();

		return result;
	}

	// check valid Admin or not
	@Override
	public boolean validadmin(Admin admin) {
		Session session = factory.openSession();
		boolean flag = false;
		String hql = "select new Admin(a.username, a.password) from Admin a";
		Query query = session.createQuery(hql);
		ArrayList<Admin> list = (ArrayList<Admin>) query.list();
		System.out.println(list);

		for (Admin a : list) {
			if (admin.getUsername().equals(a.getUsername()) && admin.getPassword().equals(a.getPassword())) {
				System.out.println(a.getUsername());
				System.out.println(admin.getUsername());
				flag = true;
			}
		}

		System.out.println(flag);
		return flag;
	}

}
