package com.mindtree.kalingacafe.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.kalingacafe.entity.Cafe;
import com.mindtree.kalingacafe.entity.Manager;
import com.mindtree.kalingacafe.exceptions.serviceexception.ManagerNotFoundException;
import com.mindtree.kalingacafe.exceptions.serviceexception.NosuchCafePresentException;
import com.mindtree.kalingacafe.repository.CafeRepository;
import com.mindtree.kalingacafe.repository.ManagerRepository;
import com.mindtree.kalingacafe.service.KalingaCafeService;


@Service
public class KalingaCafeServiceImpl implements KalingaCafeService {

	
	@Autowired
	private CafeRepository repository;
	
	
	@Autowired
	private ManagerRepository repo;
	
	
	
	@Override
	public Manager insertCafe(Manager manager) {
		
		List<Cafe> cafe=manager.getCafe();
		for (Cafe cafe2 : cafe) {
			cafe2.setManager(manager);
		}
//		Manager man=cafe.getManager();
//		cafe.setManager(man);
		repo.save(manager);
	return manager;
	}




	@Override
	public List<Cafe> getAllCafe(int managerId) throws ManagerNotFoundException {
		List<Cafe> list=new ArrayList<Cafe>();
		List<Cafe> result=new ArrayList<Cafe>();
		List<Manager> man=new ArrayList<Manager>();
		
		man=repo.findAll();
		for (Manager manager : man) {
			for(Cafe cafe:manager.getCafe()) {
				if(managerId==manager.getManagerId())
				{
					result.add(cafe);
					//throw new ManagerNotFoundException("not found");
				}
				
			}
					
		}
		if(result.isEmpty())
			throw new ManagerNotFoundException("not found");
	
		return result;
	}

	@Override
	public List<Cafe> getCafe(int managerId) {
		Optional<Manager> manager=repo.findById(managerId);
		List<Cafe> man=manager.get().getCafe();

		return man;
	}




	@Override
	public List<Manager> getAllCafewithManager(int revenue) throws NosuchCafePresentException{
		List<Manager> manager=new ArrayList<Manager>();
		List<Manager> result=new ArrayList<Manager>();
		manager=repo.findAll();
		for (Manager manager2 : manager) {
			for (Cafe cafe : manager2.getCafe()) {
				if(revenue==cafe.getRevenue())
					result.add(manager2);
			}
		}
		if(result.isEmpty())
			throw new  NosuchCafePresentException("not found");
		return result;
	}




	@Override
	public List<Cafe> getManager(int revenue) throws NosuchCafePresentException {
		List<Cafe> cafe=new ArrayList<Cafe>();
		List<Cafe> result=new ArrayList<Cafe>();
		cafe=repository.findAll();
		for (Cafe cafe2 : cafe) {
			if(revenue==cafe2.getRevenue())
			{
				result.add(cafe2);
			}
		}
		if(result.isEmpty())
			throw new  NosuchCafePresentException("not found");
		return result;
	}
	

}
