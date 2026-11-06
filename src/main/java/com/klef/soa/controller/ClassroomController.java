
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

    // 1. Insert a new record
    @PostMapping("/add")
    public String addClassroom(@RequestBody Classroom classroom)
    {
        return classroomService.addClassroom(classroom);
    }

    // 2. Update an existing record
    @PutMapping("/update")
    public String updateClassroom(@RequestBody Classroom classroom)
    {
        return classroomService.updateClassroom(classroom);
    }

    // 3. Delete a record by ID
    @DeleteMapping("/delete/{id}")
    public String deleteClassroom(@PathVariable long id)
    {
        return classroomService.deleteClassroom(id);
    }

    // 4. Display all records
    @GetMapping("/viewall")
    public List<Classroom> displayAllClassrooms()
    {
        return classroomService.displayAllClassrooms();
    }

    // 5. Display a record by ID
    @GetMapping("/view/{id}")
    public Classroom displayClassroomById(@PathVariable long id)
    {
        return classroomService.displayClassroomById(id);
    }

    // Additional: Display classrooms by name
    @GetMapping("/viewbyname/{name}")
    public List<Classroom> displayByName(@PathVariable String name)
    {
        return classroomService.displayByName(name);
    }

    // Additional: Display classrooms by type
    @GetMapping("/viewbytype/{type}")
    public List<Classroom> displayByType(@PathVariable String type)
    {
        return classroomService.displayByType(type);
    }
}
