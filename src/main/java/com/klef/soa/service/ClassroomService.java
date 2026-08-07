package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.Classroom;

public interface ClassroomService
{
	public String addClassroom(Classroom classroom);

	public String updateClassroom(Classroom classroom);

	public String deleteClassroom(long id);

	public Classroom displayClassroomById(long id);

	public List<Classroom> displayAllClassrooms();

	public List<Classroom> displayByName(String name);

	public List<Classroom> displayByType(String type);
}