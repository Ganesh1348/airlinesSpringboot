package com.SnapAirLines.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface adminDao extends JpaRepository<airLines, Integer> {

//	2 type of query
	// 1.JPQL -java persistence query languages
//	2.NATIVE QUERY(LIKE SQL)
	@Query("SELECT A.id,A.creationDate,A.airLinesNames,A.airLinesAddress" + ",A.airLinesTypes FROM airLines  A "
			+ "WHERE A.airLinesNames=?1 OR A.airLinesAddress=?2 ") // JPQL Query we cann't use * symbols

//	@Query(value="SELECT * from airLines A where A.airLinesNames=?1 OR A.airLinesAddress=?2 ",nativeQuery=true)
	// this query like a sql dependent query
	// by default, nativeQuery=false
	List<Object[]> findByAirLines(String airLinesNames, String airLinesAddress);

	@Query("DELETE FROM airLines A WHERE A.id=?1 ")
	@Modifying
	@Transactional
	void deleteAirLines(String names, String id);

	@Query("SELECT DISTINCT A.id,B.fromCity FROM airLines A JOIN detailAirLines B ON A.id=A.id")
	List<Object[]> findByDetailAirLines();

	@Query("SELECT A.id,B.owner,A.airLinesNames" + ",B.type FROM airLines A JOIN Cat_airlines B ON A.id=B.airLinesId")
	List<Object[]> findByCatServices();

}