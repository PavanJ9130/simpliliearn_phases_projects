package com.FlyAway.layers.service;

import java.util.ArrayList;

import com.FlyAway.layers.dao.FlyAwayDaoImpl;
import com.FlyAway.layers.dto.Admin;
import com.FlyAway.layers.dto.Airlines;
import com.FlyAway.layers.dto.Flights;
import com.FlyAway.layers.dto.User;

public class FlyAwayServiceImpl implements FlyAwayService {
	public FlyAwayDaoImpl dao;

	public FlyAwayServiceImpl() {
		dao = new FlyAwayDaoImpl();
	}

	@Override
	public Integer addadmin(Admin admin) {
		return dao.addadmin(admin);
	}

	@Override
	public int resetpassword(String username, String newpassword, String oldpassword) {
		return dao.resetpassword(username, newpassword, oldpassword);
	}

	@Override
	public ArrayList<Airlines> Searchflight(Flights flights) {
		return dao.Searchflight(flights);
	}

	@Override
	public Integer adduser(User user) {
		return dao.adduser(user);
	}

	@Override
	public boolean validadmin(Admin admin) {
		return dao.validadmin(admin);
	}

}
