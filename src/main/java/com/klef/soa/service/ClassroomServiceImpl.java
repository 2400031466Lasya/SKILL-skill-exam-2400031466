package com.klef.soa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.Classroom;
import com.klef.soa.repository.ClassroomRepository;

@Service
public class ClassroomServiceImpl implements ClassroomService
{
	@Autowired
	private ClassroomRepository classroomRepository;

	@Override
	public String addClassroom(Classroom classroom)
	{
		classroomRepository.save(classroom);
		return "Classroom Added Successfully";
	}

	@Override
	public String updateClassroom(Classroom classroom)
	{
		Classroom c = classroomRepository.findById(classroom.getClassroomId()).orElse(null);

		if(c != null)
		{
			c.setName(classroom.getName());
			c.setType(classroom.getType());
			c.setStatus(classroom.getStatus());
			c.setLocation(classroom.getLocation());

			classroomRepository.save(c);

			return "Classroom Updated Successfully";
		}

		return "Classroom ID Not Found";
	}

	@Override
	public String deleteClassroom(long id)
	{
		Classroom c = classroomRepository.findById(id).orElse(null);

		if(c != null)
		{
			classroomRepository.deleteById(id);
			return "Classroom Deleted Successfully";
		}

		return "Classroom ID Not Found";
	}

	@Override
	public Classroom displayClassroomById(long id)
	{
		return classroomRepository.findById(id).orElse(null);
	}

	@Override
	public List<Classroom> displayAllClassrooms()
	{
		return classroomRepository.findAll();
	}

	@Override
	public List<Classroom> displayByName(String name)
	{
		return classroomRepository.findByName(name);
	}

	@Override
	public List<Classroom> displayByType(String type)
	{
		return classroomRepository.findByType(type);
	}
}