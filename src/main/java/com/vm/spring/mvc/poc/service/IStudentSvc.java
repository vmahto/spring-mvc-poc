package com.vm.spring.mvc.poc.service;

import java.util.List;

import com.vm.spring.mvc.poc.model.Student;

public interface IStudentSvc {

	List<Student> getStudentList();
	int deleteStudent(int studentId);
	Student addStudent(Student student);
}
