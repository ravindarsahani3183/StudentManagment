package com.rud.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rud.crud.Entity.Student;
import com.rud.crud.Repository.StudentRepository;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;



@Controller
public class HomeController {
	@Autowired
	private StudentRepository Student_Repository;
	
	// getting all students record by using the method findaAll() of JpaRepository 
	@GetMapping("/")
	public String home(Model m)
	{
		List<Student> list =Student_Repository.findAll();
		
		
		System.err.println(list);
		m.addAttribute("list",list);
		
		return "index1";
	}
	
	// create students record 
	@GetMapping("/load_form")
	public String loadForm()
	{
		return "add";
	}
	
	// update students record
	@GetMapping("/edit_form/{id}")
	public String editForm(@PathVariable(value="id") int id, Model m)
	{
		Optional<Student> student = Student_Repository.findById(id);
		Student stu = student.get();
		m.addAttribute("student", stu);
		return "update";
	}
	
	// saving a specific record by using the method save() of JpaRepository 
	@PostMapping("/save_student")
	public String saveStudent(@ModelAttribute @Valid Student stud , HttpSession session,Model model,BindingResult result11,RedirectAttributes  ra) {
		
		 if (result11.hasErrors()) {
			 model.addAttribute("stud", stud);
	            return "index1";
	        }
		
		Student result=Student_Repository.save(stud);
		//session.setAttribute("msg", "students added successfully");
		ra.addFlashAttribute("success", "Submitted successfully");
		
		return "redirect:";
	}
	
	
	// updating a specific record by using the method save() of JpaRepository 
	@PostMapping("/update_student")
	public String updatestudent(@ModelAttribute Student student, HttpSession session,RedirectAttributes  ra)
	{
		Student_Repository.save(student);
		session.setAttribute("msg", "students update successfully");
		return "redirect:/";
		
	}
	
	
    //deleting a specific record by using the method deleteById() of JpaRepository  
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable(value="id") int id, HttpSession session,RedirectAttributes  ra)
	{
		Student_Repository.deleteById(id);
		ra.addFlashAttribute("success", "students delete successfully");
		return "redirect:/";
		
	}
	

}
