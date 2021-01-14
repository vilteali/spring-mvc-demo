package ar.alicode.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		
		// create a student object
		Student theStudent = new Student();
		
		// add a student object to the model
		model.addAttribute("student", theStudent);
		
		return "studentForm";
	}
	
	@RequestMapping("/processForm")
	public String processForm(
			@ModelAttribute("student") Student theStudent) {
		
		System.out.println("theStudent: "+theStudent.getFirstName()
						+" "+theStudent.getLastName());
		
		return "studentConfirmation";
	}
	
}
