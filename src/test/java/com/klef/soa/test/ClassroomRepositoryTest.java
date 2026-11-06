
package com.klef.soa.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import com.klef.soa.entity.Classroom;
import com.klef.soa.repository.ClassroomRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class ClassroomRepositoryTest
{
    @Autowired
    private ClassroomRepository repository;

    @Test
    void testFindAllClassrooms()
    {
        List<Classroom> classrooms = repository.findAll();
        assertNotNull(classrooms);
        System.out.println("Total Classrooms: " + classrooms.size());
    }

    @Test
    void testFindClassroomById()
    {
        Classroom saved = new Classroom();
        saved.setName("CSE Lab");
        saved.setType("Laboratory");
        saved.setStatus("Available");
        saved.setLocation("Block A");

        saved = repository.save(saved);

        Optional<Classroom> classroom =
            repository.findById(saved.getClassroomId());

        assertTrue(classroom.isPresent());
        assertEquals(saved.getClassroomId(),
                     classroom.get().getClassroomId());

        System.out.println("Classroom ID: " +
                           classroom.get().getClassroomId());
        System.out.println("Classroom Name: " +
                           classroom.get().getName());
    }

    @Test
    void testFindClassroomByName()
    {
        Classroom saved = new Classroom();
        saved.setName("CSE Lab");
        saved.setType("Laboratory");
        saved.setStatus("Available");
        saved.setLocation("Block A");

        repository.save(saved);

        List<Classroom> classrooms =
            repository.findByName("CSE Lab");

        assertNotNull(classrooms);
        assertFalse(classrooms.isEmpty());
        assertEquals("CSE Lab", classrooms.get(0).getName());

        System.out.println("Classroom Name: " +
                           classrooms.get(0).getName());
    }

    @Test
    void testFindClassroomByInvalidName()
    {
        List<Classroom> classrooms =
            repository.findByName("Unknown Classroom");

        assertTrue(classrooms.isEmpty());
    }

    @Test
    void testDatabaseConnection()
    {
        long count = repository.count();
        assertTrue(count >= 0);

        System.out.println("Total Classrooms in Database: " + count);
    }

    @Test
    void testClassroomDetails()
    {
        Classroom saved = new Classroom();
        saved.setName("CSE Lab");
        saved.setType("Laboratory");
        saved.setStatus("Available");
        saved.setLocation("Block A");

        saved = repository.save(saved);

        Optional<Classroom> classroom =
            repository.findById(saved.getClassroomId());

        assertTrue(classroom.isPresent());

        Classroom foundClassroom = classroom.get();

        assertNotNull(foundClassroom.getName());
        assertNotNull(foundClassroom.getType());
        assertNotNull(foundClassroom.getStatus());
        assertNotNull(foundClassroom.getLocation());
        assertNotNull(foundClassroom.getCreatedAt());

        System.out.println("Name: " + foundClassroom.getName());
        System.out.println("Type: " + foundClassroom.getType());
        System.out.println("Status: " + foundClassroom.getStatus());
        System.out.println("Location: " + foundClassroom.getLocation());
    }

    @Test
    void testClassroomType()
    {
        Classroom saved = new Classroom();
        saved.setName("CSE Lab");
        saved.setType("Laboratory");
        saved.setStatus("Available");
        saved.setLocation("Block A");

        repository.save(saved);

        List<Classroom> classrooms =
            repository.findByType("Laboratory");

        assertNotNull(classrooms);
        assertFalse(classrooms.isEmpty());
        assertEquals("Laboratory", classrooms.get(0).getType());

        System.out.println("Classroom Type: " +
                           classrooms.get(0).getType());
    }

    @Test
    void testTotalClassroomCount()
    {
        Classroom classroom1 = new Classroom();
        classroom1.setName("Room 101");
        classroom1.setType("Lecture");
        classroom1.setStatus("Available");
        classroom1.setLocation("Block A");

        Classroom classroom2 = new Classroom();
        classroom2.setName("Room 102");
        classroom2.setType("Lecture");
        classroom2.setStatus("Available");
        classroom2.setLocation("Block B");

        repository.save(classroom1);
        repository.save(classroom2);

        long count = repository.count();

        assertEquals(2L, count);
    }
}
