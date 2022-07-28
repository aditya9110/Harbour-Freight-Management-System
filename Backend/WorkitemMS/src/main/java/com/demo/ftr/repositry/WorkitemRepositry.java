package com.demo.ftr.repositry;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.ftr.entity.Workitem;

@Repository
public interface WorkitemRepositry extends JpaRepository<Workitem, String> {
	@Query(value="SELECT workitem_id FROM ftr_workitems order by workitem_id desc limit 1", nativeQuery = true)
	public String getLastRecord();
	
	@Query(value="SELECT workitem_id FROM ftr_workitems where user_id=?1",nativeQuery=true)
	Optional<List<String>> getWorkitemIdByUserId(Long userId);
}
