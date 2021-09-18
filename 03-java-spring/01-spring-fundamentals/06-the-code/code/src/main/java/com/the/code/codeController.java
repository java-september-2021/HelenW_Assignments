package com.the.code;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class codeController {
	@GetMapping("/")
	public String index(@ModelAttribute("errors") String errors) {
		System.out.println(errors);
		
		return "index.jsp";
	}
	//have to redirect after a post request
	 @RequestMapping(path="/trycode", method=RequestMethod.POST)
	    public String code(@RequestParam(value="code") String code, HttpSession session) {
		
		System.out.println(code);
		session.setAttribute("code", code);
		return "redirect:/code";
	 }
		
	@GetMapping("/code") 
		public String secretcode(HttpSession session) {
		String code = (String) session.getAttribute("code");
		 if (code.equals("bushido")) {
			 return "secretcode.jsp";
		 }
		 else
			 return "redirect:/errors";
	}
		 @RequestMapping("/errors")
		 public String errors(RedirectAttributes redirectAttributes) {
		        redirectAttributes.addFlashAttribute("errors", "You must train harder!");
		       return "redirect:/";
		        }
		 
}

