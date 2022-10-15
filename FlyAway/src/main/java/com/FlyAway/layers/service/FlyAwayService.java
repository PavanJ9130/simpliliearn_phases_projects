package com.FlyAway.layers.service;

import java.util.ArrayList;

import com.FlyAway.layers.dto.Admin;
import com.FlyAway.layers.dto.Airlines;
import com.FlyAway.layers.dto.Flights;
import com.FlyAway.layers.dto.User;

public interface FlyAwayService {
	public Integer addadmin(Admin admin);

	public ArrayList<Airlines> Searchflight(Flights flights);

	public int resetpassword(String username, String newpassword, String oldpassword);

	public Integer adduser(User user);

	public boolean validadmin(Admin admin);

}
