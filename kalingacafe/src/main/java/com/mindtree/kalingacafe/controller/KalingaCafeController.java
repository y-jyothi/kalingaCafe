package com.mindtree.kalingacafe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.kalingacafe.entity.Cafe;
import com.mindtree.kalingacafe.entity.Manager;
import com.mindtree.kalingacafe.exceptions.serviceexception.ManagerNotFoundException;
import com.mindtree.kalingacafe.exceptions.serviceexception.NosuchCafePresentException;
import com.mindtree.kalingacafe.service.KalingaCafeService;

@RestController
@ComponentScan({"com.mindtree"})
@EnableJpaRepositories("com.mindtree.kalingacafe.repository")

public class KalingaCafeController {
	
	@Autowired
	private KalingaCafeService ser;
	
	@PostMapping(value="/Cafe")
	public String addCafe(@RequestBody Manager manager)
	{
		ser.insertCafe(manager);
		return "cafe";
		
	}
	
	@GetMapping(value="/Cafes/{managerId}")
	public List<Cafe> getCafes(@PathVariable int managerId)
	{
		
		List<Cafe> cafes=new ArrayList<Cafe>();
		try {
			cafes=ser.getAllCafe(managerId);
		} catch (ManagerNotFoundException e) {
			
			System.out.print(e.getMessage());
		}
		return cafes;
		
	}
	@GetMapping(value="/Revenue/{revenue}")
	public List<Manager> getManager(@PathVariable int revenue)
	{
		
		List<Manager> manager=new ArrayList<Manager>();
		try {
			manager=ser.getAllCafewithManager(revenue);
		} catch ( NosuchCafePresentException e) {
			
			System.out.print(e.getMessage());
		}
		return manager;
		
	}
	@GetMapping(value="/Revenues/{revenue}")
	public List<Cafe> getManagers(@PathVariable int revenue)
	{
		
		List<Cafe> manager=new ArrayList<Cafe>();
		try {
			manager=ser.getManager(revenue);
		} catch ( NosuchCafePresentException e) {
			
			System.out.print(e.getMessage());
		}
		return manager;
		
	}


}
