package com.demo.ftr.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.ftr.entity.WorkitemTerminal;

@Repository
public interface WorkitemTerminalRepositry extends JpaRepository<WorkitemTerminal, String> {

}
