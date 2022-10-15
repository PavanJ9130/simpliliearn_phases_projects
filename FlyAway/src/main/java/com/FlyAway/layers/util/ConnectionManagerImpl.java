package com.FlyAway.layers.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionManagerImpl implements ConnectionManager {
	private SessionFactory factory = null;

	@Override
	public SessionFactory getConnection() {
		factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		return factory;
	}

}
