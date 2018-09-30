package com.vm.spring.mvc.poc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vm.spring.mvc.poc.model.Student;
import com.vm.spring.mvc.poc.service.IStudentSvc;

@Controller
@RequestMapping("/")
public class StudentRegistrationController {

	@Autowired
	private IStudentSvc studentSvc;

	@RequestMapping(value = "/studentregpage", method = RequestMethod.GET)
	public String studnetIndexpage(ModelMap model) {
		Student student = new Student();
		model.addAttribute("studentAdd", student);
		return "studentform";
	}
	@RequestMapping(value = { "/showStudnets", "/addStudent/showStudents" })
	public ModelAndView multiMappingMethod() {

		displayStudent();
		Student student = null;
		if (studentSvc.getStudentList().size() > 0) {
			student = studentSvc.getStudentList().get(0);
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(student);
		modelAndView.setViewName("studentDisplay");
		return modelAndView;
	}

	/*
	 * @RequestMapping(value = "/addStudent") public ModelAndView
	 * addStudent(HttpServletRequest request, HttpServletResponse response) {
	 * 
	 * Student student = new Student();
	 * student.setFname(request.getParameter("first_name"));
	 * student.setLname(request.getParameter("last_name"));
	 * student.setUsername(request.getParameter("username"));
	 * student.setPassword(request.getParameter("password"));
	 * student.setAddress(request.getParameter("address"));
	 * student.setContactNo(request.getParameter("contactNo")); ModelAndView
	 * modelAndView = new ModelAndView(); modelAndView.addObject(student);
	 * modelAndView.setViewName("studentAddSuccess"); return modelAndView; }
	 */
	/*
	 * Using @ModelAttribute to bind all model attribute.
	 */
	/*
	 * @RequestMapping(value = "/addStudent") public ModelAndView
	 * addStudent(@ModelAttribute Student student, BindingResult bindingResult)
	 * {
	 * 
	 * ModelAndView modelAndView = new ModelAndView();
	 * if(bindingResult.hasErrors()) {
	 * 
	 * modelAndView.addObject(bindingResult.getFieldError());
	 * modelAndView.setViewName("studentAddError");
	 * 
	 * } else {
	 * 
	 * modelAndView.addObject(student);
	 * modelAndView.setViewName("studentAddSuccess"); }
	 * 
	 * return modelAndView; }
	 */

	public void setStudnetSvc(IStudentSvc studnetSvc) {
		this.studentSvc = studnetSvc;
	}

	/*
	 * @RequestMapping(value = "/addStudent") public ModelAndView
	 * addStudent(@ModelAttribute("student") Student student) {
	 * 
	 * studentSvc.addStudent(student);
	 * 
	 * displayStudent();
	 * 
	 * ModelAndView modelAndView = new ModelAndView();
	 * 
	 * modelAndView.setViewName("studentAddSuccess");
	 * 
	 * return modelAndView; }
	 */

	/*@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	// @GetMapping(path = "/addStudent")
	public ModelAndView addStudent(@Valid Student student,
			BindingResult bindingResult, ModelMap model) {

		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {

			System.out.println("*********************** Eroor********************");
		
			modelAndView.addObject(bindingResult.getFieldError());
			modelAndView.setViewName("studentAddError");

		} else {
			int id = studentSvc.addStudent(student);
			System.out.println("------------" + id);
			displayStudent();

			modelAndView.addObject(student);
			modelAndView.setViewName("studentAddSuccess");
		}
		return modelAndView;
	}*/
	
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
//	 @GetMapping(path = "/addStudent")
	public String addStudent(@Valid Student studentAdd,
			BindingResult result, ModelMap model) {

		if (result.hasErrors()) {

			System.out.println("*********************** Eroor********************");
			model.addAttribute("eroor", "please fill require fields");

			throw new NullPointerException();
		} else {
			int id = studentSvc.addStudent(studentAdd);
			System.out.println("------------" + id);
			displayStudent();

			model.addAttribute("success", "Dear " + studentAdd.getFname()
					+ " , your Registration completed successfully");
		}
		return "studentAddSuccess";
	}

	private void displayStudent() {
		System.out
				.println(" ********************All Students  *********************");

		// studentSvc.getStudentList().forEach(student ->
		// System.out.print(student));
		for (Student student : studentSvc.getStudentList()) {
			System.out.println(student);
		}
		System.out.println(studentSvc.getStudentList());

		System.out.println("*******************************************");
	}

	/*
	 * When each handler call in your Controller class needs the same common
	 * information adding to the model for every page request. We may require to
	 * get some dto from service then transfer it to view for every request.
	 * Here It automatically add this dto to Model object.
	 */
	/*
	 * @ModelAttribute("student") public Student populateUser() {
	 * 
	 * Student student = null; if(studentSvc.getStudentList().size() > 0) {
	 * student = studentSvc.getStudentList().get(0); } return student; }
	 */

	// @GetMapping(value = "/deleteStudent")
	// //@RequestParam(value = "", required = false, defaultValue = "xxx")
	// String id

	@RequestMapping(value = "/deleteStudent")
	public ModelAndView deleteStudent(
			@RequestParam(value = "id", required = true) int id) {

		int studentId = studentSvc.deleteStudent(id);
		System.out.println("******************Studnet Deleted *********ID::"
				+ studentId);
		displayStudent();
		ModelAndView modelAndView = new ModelAndView();
		Student student = null;
		if (studentSvc.getStudentList().size() > 0) {
			student = studentSvc.getStudentList().get(0);
			modelAndView.addObject(student);
		}

		modelAndView.setViewName("studentDisplay");
		return modelAndView;
	}

	/*
	 * @RequestMapping(value = "/deleteStudent/{id}") public ModelAndView
	 * deleteStudent(@PathVariable("id") int id) {
	 * 
	 * int studentId = studentSvc.deleteStudent(id); System.out.println(
	 * "******************Test Push Studnet Deleted *********ID::"+studentId);
	 * displayStudent(); ModelAndView modelAndView = new ModelAndView(); Student
	 * student = null; if(studentSvc.getStudentList().size() > 0) { student =
	 * studentSvc.getStudentList().get(0); modelAndView.addObject(student); }
	 * 
	 * modelAndView.setViewName("studentDisplay"); return modelAndView; }
	 */

}
