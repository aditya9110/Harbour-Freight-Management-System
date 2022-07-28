package com.terminalMS.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.terminalMS.Entity.FtrTerminalsEntity;

@Repository
public interface FtrTerminalsRepository extends JpaRepository<FtrTerminalsEntity,String>{
List<FtrTerminalsEntity> findByItemType(String itemType);

FtrTerminalsEntity findByTerminalId(String terminalId);
}
