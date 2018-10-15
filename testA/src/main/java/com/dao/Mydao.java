package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.entity.Test;

public interface Mydao extends JpaRepository<Test, Long> {
	List<Test> findByA(String a);	
	@Modifying
	@Query("update Test set a=?1 where id=?2")
	void updateA(String a,int id);
}
