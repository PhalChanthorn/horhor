package com.setec.controller;


import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.setec.entities.Booked;
import com.setec.repository.BookedRepo;
import com.setec.service.Mytelegrambot;

@Controller
public class MyController {
	
	@GetMapping({"/","/home/page"})
	public String home(Model mod) {
		Booked booked = new Booked(1,
				"",
				"",
				"",
				LocalDate.now(),
				LocalTime.now(),0);
		mod.addAttribute("booked",booked);
		return "index";
	}
	@GetMapping("/about")
	public String about() {
		return "about";
	}
	@GetMapping("/service")
	public String service() {
		return "service";
	}
	@GetMapping("/menu")
	public String menu() {
		return "menu";
	}
	@GetMapping("/reservation")
	public String reservation(Model mod) {
		Booked booked = new Booked(1,
				"",
				"",
				"",
				LocalDate.now(),
				LocalTime.now(),0);
		mod.addAttribute("booked",booked);
		return "reservation";
	}
	
	@GetMapping("/testimonial")
	public String testimonial() {
		return "testimonial";
	}
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	
	@Autowired
	private BookedRepo bookedRepo;
	
	@Autowired
	private Mytelegrambot bot;
	
	@PostMapping("/success")
	public String success(@ModelAttribute Booked booked) {
		bookedRepo.save(booked);
		bot.sendMessage("🆔 ID: "+booked.getId()+"\n👤 Name : "+booked.getName()+"\n📞 Phone: "+booked.getPhoneNumber()+"\n✉️ Mail : "+booked.getEmail()+"\n📅 Date : "+booked.getDate()+"\n⏰ Time : "+booked.getTime()+"\n👥 Person : "+booked.getPerson());
		
		
		
		return "success";
	}
}
