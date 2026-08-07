package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klef.soa.entity.Classroom;
import com.klef.soa.service.ClassroomService;

@RestController
@RequestMapping("/classroom")
@CrossOrigin("*")
public class ClassroomController
{
	@Autowired
	private ClassroomService classroomService;

	@PostMapping("/add")
	public String addClassroom(@RequestBody Classroom classroom)
	{
		return classroomService.addClassroom(classroom);
	}

	@PutMapping("/update")
	public String updateClassroom(@RequestBody Classroom classroom)
	{
		return classroomService.updateClassroom(classroom);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteClassroom(@PathVariable long id)
	{
		return classroomService.deleteClassroom(id);
	}

	@GetMapping("/view/{id}")
	public Classroom displayClassroomById(@PathVariable long id)
	{
		return classroomService.displayClassroomById(id);
	}

	@GetMapping("/viewall")
	public List<Classroom> displayAllClassrooms()
	{
		return classroomService.displayAllClassrooms();
	}

	@GetMapping("/viewbyname/{name}")
	public List<Classroom> displayByName(@PathVariable String name)
	{
		return classroomService.displayByName(name);
	}

	@GetMapping("/viewbytype/{type}")
	public List<Classroom> displayByType(@PathVariable String type)
	{
		return classroomService.displayByType(type);
	}
}