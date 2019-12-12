package com.mindtree.kalingacafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.kalingacafe.entity.Manager;


@Repository
public interface ManagerRepository extends JpaRepository<Manager,Integer> {

}
