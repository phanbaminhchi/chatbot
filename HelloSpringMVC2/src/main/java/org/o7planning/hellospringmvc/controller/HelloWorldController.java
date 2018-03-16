package org.o7planning.hellospringmvc.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
public class HelloWorldController {
 
    @RequestMapping("/hello")
    public String hello(Model model) {
        
        model.addAttribute("greeting", "Hello Spring MVC");
        
        return "helloworld";
        
    }
    @RequestMapping("/home")
    public String home(Model model) {
        
        model.addAttribute("greeting", "Hello Spring MVC");
        
        return "home";
        
    }
    @RequestMapping("/view")
    public String view(Model model) {
        
        model.addAttribute("greeting", "Hello Spring MVC");
        
        return "view";
        
    }
    @RequestMapping("/addNewStudent")
    public String addNewStudent(Model model) {
        
        model.addAttribute("greeting", "Hello Spring MVC");
        
        return "addNewStudent";
        
    }
    @RequestMapping("/register")
    public String register(Model model) {
        
        model.addAttribute("greeting", "Hello Spring MVC");
        
        return "register";
        
    }
    @RequestMapping("/addScore")
    public String addScore(Model model) {
        
        model.addAttribute("greeting", "Hello Spring MVC");
        
        return "addScore";
        
    }
    @RequestMapping("/showScoreStudent")
    public String showScoreStudent(Model model) {
        
        model.addAttribute("greeting", "Hello Spring MVC");
        
        return "showScoreStudent";
        
    }
}