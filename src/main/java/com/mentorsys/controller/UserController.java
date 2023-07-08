package com.mentorsys.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mentorsys.dao.FacultyRepository;
import com.mentorsys.dao.MajorRepository;
import com.mentorsys.dao.MinorRepository;
import com.mentorsys.dao.UserRepository;
import com.mentorsys.entities.User;
import com.mentorsys.helper.Message;
import com.mentorsys.entities.Faculty;
import com.mentorsys.entities.Major;
import com.mentorsys.entities.Minor;


@Controller
@RequestMapping("/dashboard")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private FacultyRepository facultyRepository;
	
	@Autowired
	private MajorRepository majorRepository;
	
	@Autowired
	private MinorRepository minorRepository;
	
	@ModelAttribute
	public void addCommonData(Model model, Principal principal) {
		String username = principal.getName();
		User user = userRepository.getUserbyUserName(username);
		//System.out.println("USER "+user);
		model.addAttribute("user",user);
	}

	@RequestMapping("/")
	public String dashboard(Model model, Principal principal) {
		
		
		//model.addAttribute("faculty",faculty);
		return "normal/user_dashboard";
	}
	
	@GetMapping("/faculty-details/")
	public String showFaculty(Model m) {
		m.addAttribute("title","Show Faculty Details");
		
		List<Faculty> faculty = this.facultyRepository.findAll();
		
		m.addAttribute("faculty", faculty);
		return "normal/show_faculty";
	}
	
	
	/*@GetMapping("/mentor-list-major/")
	public String showMajor(Model model) {
		model.addAttribute("title", "Mentors List Major");
		
		List<Major> major = this.majorRepository.findAll();
		
		model.addAttribute("major", major);
		return "normal/show_mentor_major";
	}*/
	//Try
	@GetMapping("/mentor-list-major/")
	public String showMajor(Model model, Principal principal) {
		model.addAttribute("title", "Mentors List Major");
		
		/*String username = principal.getName();
		User user = userRepository.getUserbyUserName(username);*/
		
		User user = new User();
		if(user.getRole()=="User") {
		
		List<Major> major = this.majorRepository.findAll();
		
		model.addAttribute("major", major);
		return "normal/show_mentor_major";
		}
		
		else {
			List<Major> major = this.majorRepository.findAll();
			
			model.addAttribute("major", major);
			return "normal/show_mentor_major_admin";
		}
	}
	
	/*@GetMapping("/mentor-list-minor/")
	public String showMinor(Model model) {
		model.addAttribute("title", "Mentors List Minor");
		
		List<Minor> minor = this.minorRepository.findAll();
		
		model.addAttribute("minor", minor);
		return "normal/show_mentor_minor";*/
	
	@GetMapping("/mentor-list-minor/")
	public String showMinor(Model model, Principal principal) {
		model.addAttribute("title", "Mentors List Minor");
		
		/*String username = principal.getName();
		User user = userRepository.getUserbyUserName(username);*/
		
		User user = new User();
		if(user.getRole()=="User") {
		
		List<Minor> minor = this.minorRepository.findAll();
		
		model.addAttribute("minor", minor);
		return "normal/show_mentor_minor";
		}
		
		else {
			List<Minor> minor = this.minorRepository.findAll();
			
			model.addAttribute("minor", minor);
			return "normal/show_mentor_minor_admin";
		}
	}

	//update form
	@PostMapping("/edit/{id}")
	public String updateForm(@PathVariable("id") Integer id, Model m, Principal principal) {
		m.addAttribute("title", "Update");
		
		Major major = this.majorRepository.findById(id).get();
		m.addAttribute("major", major);
			return "normal/update_form";
		}
	
	@PostMapping("/update/{id}")
	public String updateFormMin(@PathVariable("id") Integer id, Model m, Principal principal) {
		m.addAttribute("title", "Update");
		
		Minor minor = this.minorRepository.findById(id).get();
		m.addAttribute("minor", minor);
			return "normal/update_form_minor";
		}
	
	@RequestMapping(value="/process-update", method= RequestMethod.POST)
	public String updateHandlerMajor(@ModelAttribute Major major, HttpSession httpSession) {
		
		try {
			
			this.majorRepository.save(major);
			httpSession.setAttribute("message", new Message("Details are updated...", "success"));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/dashboard"+"/mentor-list-major/";
	}
	
	@RequestMapping(value="/process-edit", method= RequestMethod.POST)
	public String updateHandlerMinor(@ModelAttribute Minor minor, HttpSession httpSession) {
		
		try {
			
			this.minorRepository.save(minor);
			httpSession.setAttribute("message", new Message("Details are updated...", "success"));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/dashboard"+"/mentor-list-minor/";
	}
	
	//Show faculty details
	@RequestMapping("/mentor/{id}")
	public String showFacultyDetails(@PathVariable("id") Integer id, Model m) {
		m.addAttribute("title", "Mentor-Details");
		
		Optional<Faculty> facultyOptional = this.facultyRepository.findById(id);
		Faculty faculty = facultyOptional.get();
		
		m.addAttribute("faculty", faculty);
		return "normal/faculty_detail";
	}
}
