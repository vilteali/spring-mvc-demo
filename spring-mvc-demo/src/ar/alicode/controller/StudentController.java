package ar.alicode.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ar.alicode.model.Student;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		
		// add a student object to the model
		model.addAttribute("student", new Student());
		
		return "studentForm";
	}
	
	@RequestMapping("/processForm")
	public String processForm(
			@Valid @ModelAttribute("student") Student theStudent,
			BindingResult result) {
		
		if(result.hasErrors()) {
			return "studentForm";
		} else {
			return "studentConfirmation";
		}
		
	}

}
