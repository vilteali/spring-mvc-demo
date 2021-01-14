package ar.alicode.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "showForm";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloWorld";
	}

	@RequestMapping("/validateForm")
	public String messageToUpperCase(HttpServletRequest request, Model model) {
		
		String name = request.getParameter("studentName");
		name = name.toUpperCase();
		String response = "I'm! "+name;
		
		model.addAttribute("message", response);
		
		return "helloWorld";
		
	}
	
	@RequestMapping("/validateForm2")
	public String messageToUpperCase2(
			@RequestParam("studentName") String name,
			Model model) {
		
		name = name.toUpperCase();
		String response = "Hi my friend: "+name;
		
		model.addAttribute("message", response);
		
		return "helloWorld";
		
	}

}


