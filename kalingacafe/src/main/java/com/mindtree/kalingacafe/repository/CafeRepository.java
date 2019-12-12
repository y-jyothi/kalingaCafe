package com.mindtree.kalingacafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.kalingacafe.entity.Cafe;


@Repository
public interface CafeRepository extends JpaRepository<Cafe, Integer> {

}
