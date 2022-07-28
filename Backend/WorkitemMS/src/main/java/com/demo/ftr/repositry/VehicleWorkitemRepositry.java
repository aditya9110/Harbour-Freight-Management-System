package com.demo.ftr.repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.ftr.entity.VehicleWorkitem;

@Repository
public interface VehicleWorkitemRepositry extends JpaRepository<VehicleWorkitem,String> {
	
	@Query(value = "SELECT * FROM ftr_vehicle_workitem where workitem_id=?1",nativeQuery = true)
	Optional<VehicleWorkitem> findByWorkitemId(String workitemId);
}
