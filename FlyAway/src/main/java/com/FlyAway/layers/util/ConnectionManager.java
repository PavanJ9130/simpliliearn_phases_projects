package com.FlyAway.layers.util;

import org.hibernate.SessionFactory;

public interface ConnectionManager {
	public SessionFactory getConnection();

}
