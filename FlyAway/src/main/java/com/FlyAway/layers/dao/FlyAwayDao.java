package com.FlyAway.layers.dao;

import java.util.ArrayList;

import com.FlyAway.layers.dto.Admin;
import com.FlyAway.layers.dto.Airlines;
import com.FlyAway.layers.dto.Flights;
import com.FlyAway.layers.dto.User;

public interface FlyAwayDao {
	public Integer addadmin(Admin admin);

	public ArrayList<Airlines> Searchflight(Flights flights);

	public int resetpassword(String username, String newpassword, String oldpassword);

	public Integer adduser(User user);

	public boolean validadmin(Admin admin);

}
