package com.mindtree.kalingacafe.service;

import java.util.List;

import com.mindtree.kalingacafe.entity.Cafe;
import com.mindtree.kalingacafe.entity.Manager;
import com.mindtree.kalingacafe.exceptions.serviceexception.ManagerNotFoundException;
import com.mindtree.kalingacafe.exceptions.serviceexception.NosuchCafePresentException;

public interface KalingaCafeService {
	
	public Manager insertCafe(Manager manager);
	public List<Cafe> getAllCafe(int mangerId) throws ManagerNotFoundException;
	public List<Cafe> getCafe(int managerId);
	public List<Manager> getAllCafewithManager(int revenue)throws NosuchCafePresentException;
	public List<Cafe> getManager(int revenue)throws NosuchCafePresentException;

}
