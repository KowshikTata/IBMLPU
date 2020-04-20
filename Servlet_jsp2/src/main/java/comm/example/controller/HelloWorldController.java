package comm.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	
	@RequestMapping("/showForm")
	public String show()
	{
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String process()
	{
		return "helloworld";
	}
	@RequestMapping("/processFormv2")
	public String process(HttpServletRequest request,Model model)
	{
		String message="Yo!!"+request.getParameter("StudentName").toString();
		model.addAttribute("message", message);
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormv3")
	public String process(@RequestParam("StudentName") String str,Model model)
	{
		
		model.addAttribute("message", str);
		
		return "helloworld";
	}
	
	
	
	
	
}
