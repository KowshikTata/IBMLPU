package comm.example.controller;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import comm.example.model.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

	
	@RequestMapping("/showForm")
	public String show(Model model)
	{
		Student student=new Student();
		model.addAttribute("student", student);
		return "student-form";
		
	}
	@RequestMapping("/processForm")
	public String process(@ModelAttribute("student") Student theStudent,Model model)
	{
		theStudent.setId(UUID.randomUUID().toString());
		model.addAttribute("student",theStudent);
		return "student-detail";
		
	}
	
	
	
}
