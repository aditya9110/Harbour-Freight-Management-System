package com.demo.ftr.repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.ftr.entity.Harbor;

@Repository
public interface HarborRepositry extends JpaRepository<Harbor, String>{
	
	@Query(value="SELECT available_harbor_locations FROM ftr_harbor where country = ?1", nativeQuery = true)
	Optional<String> findByCountry(String country);
}
