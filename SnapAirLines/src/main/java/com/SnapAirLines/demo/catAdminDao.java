package com.SnapAirLines.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface catAdminDao extends JpaRepository<Cat_airlines, Integer> {

}
