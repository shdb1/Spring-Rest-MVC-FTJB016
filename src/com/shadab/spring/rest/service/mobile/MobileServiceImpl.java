package com.shadab.spring.rest.service.mobile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shadab.spring.rest.db.MobileDBFunctions;

@Service
public class MobileServiceImpl implements MobileService{
@Autowired
MobileDBFunctions mobileDBFunctions;
	@Override
	public void playSong(String songName) {
		// TODO Auto-generated method stub
		mobileDBFunctions.doDBOperation();// jdbc
		System.out.println("Songs are being played!!!"+songName);
	}

}
