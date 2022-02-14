package uteq.freelancer_mvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller {
    @GetMapping
    String menu(){
        return "index";
    }
}