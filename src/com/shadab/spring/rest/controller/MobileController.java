package com.shadab.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shadab.spring.rest.service.mobile.MobileService;

@RestController
public class MobileController {
@Autowired
MobileService mobileService;
	
	@RequestMapping("/mobile/playsong/{songname}")
	public String playSong(@PathVariable("songname") String songName) {
		mobileService.playSong(songName);
		return "Mobile is playing song "+songName;
	}
	
}
