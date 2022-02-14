package uteq.freelancer_mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uteq.freelancer_mvc.models.People;
import uteq.freelancer_mvc.models.Publication;
import uteq.freelancer_mvc.service.PeopleService;
import uteq.freelancer_mvc.service.PublicationService;

import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller {
    @Autowired
    PeopleService peopleService;
    @Autowired
    PublicationService publicationService;

    @GetMapping
    public String home(Model model) throws Exception {
        List<Publication> servicios = publicationService.findAll();
        model.addAttribute("servicios", servicios);
        return "index";
    }


    @GetMapping("/list")
    public String list(Model model) throws Exception {
        List<People> personas = peopleService.findAll();
        model.addAttribute("personas", personas);
        return "list";
    }

}
