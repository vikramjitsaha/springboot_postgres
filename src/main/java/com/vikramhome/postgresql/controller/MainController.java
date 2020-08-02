/**
 * 
 */
package com.vikramhome.postgresql.controller;

import org.springframework.beans.factory.annotation.Autowired;
/**
 * @author Vikram
 *
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.vikramhome.postgresql.repository.StudentRepository;

@Controller
public class MainController {
	
	@Autowired
	private StudentRepository studentRepository;

    @GetMapping("/")
    public String root(Model model) {
    	model.addAttribute("students", studentRepository.findAll());
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userIndex(Model model) {
    	model.addAttribute("students", studentRepository.findAll());
    	return "user/index";
    }
}