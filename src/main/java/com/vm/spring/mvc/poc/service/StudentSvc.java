package com.vm.spring.mvc.poc.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.vm.spring.mvc.poc.model.Student;

@Service
public class StudentSvc implements IStudentSvc{

	private Map<Integer, Student> studentMap = new HashMap<>();
	private static int i = 0;
	@Override
	public List<Student> getStudentList() {

		Collection<Student> stutents = studentMap.values();

		return new ArrayList<>(stutents);
	}

	@Override
	public int deleteStudent(int studentId) {
		Student student = studentMap.remove(studentId);
		if(student == null) {
			return 0;
		}
		return 1;
	}

	@Override
	public Student addStudent(Student student) {
		i++;
		return studentMap.put(i, student);
	}

}
