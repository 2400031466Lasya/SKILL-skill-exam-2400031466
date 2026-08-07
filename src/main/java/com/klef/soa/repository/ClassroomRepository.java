package com.klef.soa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.soa.entity.Classroom;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long>
{
	public List<Classroom> findByName(String name);

	public List<Classroom> findByType(String type);
}