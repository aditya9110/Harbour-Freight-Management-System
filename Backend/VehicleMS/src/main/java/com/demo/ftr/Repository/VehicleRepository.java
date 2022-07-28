package com.demo.ftr.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.ftr.Entity.VehicleEntity;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity, String> {

	//VehicleEntity findByVehicleNumber(String vehicleNumber);

	@Query("from VehicleEntity v where v.vehicleNumber=?1")
	public Optional<VehicleEntity> findByVehicleNumber(String vehicleNumber);

	//void deleteByvehicleNumber(String vehicleNum);

	/*@Modifying
	@Query("update VehicleEntity e set e.vehicleStatus=?1 where e.vehicleNumber=?2")
	public void updateVehicleStatus(String vehicleNum, VehicleDTO dto);*/

	@Modifying
	@Query("delete from VehicleEntity m where m.vehicleNumber=?1")
	public void removeVehicle(String vehicleNum);

	@Query("from VehicleEntity v where v.vehicleName=?1")
	public List<VehicleEntity> findByVehicleName(String vehicleName);

	
	

}
