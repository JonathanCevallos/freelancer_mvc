package uteq.freelancer_mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import uteq.freelancer_mvc.interfaceService.IcategoriaService;
import uteq.freelancer_mvc.models.Category;
import uteq.freelancer_mvc.models.People;
import uteq.freelancer_mvc.models.Publication;
import uteq.freelancer_mvc.service.PeopleService;
import uteq.freelancer_mvc.service.PublicationService;

import java.util.List;

import javax.validation.Valid;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller {
    @Autowired
    PeopleService peopleService;
    @Autowired
    PublicationService publicationService;
    @Autowired
    private IcategoriaService service;
     
     @GetMapping
     public String home(Model model) throws Exception {
         List<Publication> servicios = publicationService.findAll();
         model.addAttribute("servicios", servicios);
         return "index";
     }
     
     @GetMapping("/listar")
     public String listar(Model model){
         List<Category>Category=service.listar();
         model.addAttribute("Category", Category);
         return "views/category";
     }
     
     @GetMapping("/new")
     public String agregar(Model model){
         model.addAttribute("category",new Category());
         return "views/forninsertCategory";
     }
     @PostMapping("/save")
     public String save(@Valid Category c, Model model)
     {
     	service.save(c);
     	return "redirect:/listar";
     } 
     
     @GetMapping("/servicios")
     public String services(Model model) throws Exception {
     	return "views/postservice";
     }
     @GetMapping("/list")
     public String list(Model model) throws Exception {
         List<People> personas = peopleService.findAll();
         model.addAttribute("personas", personas);
         return "list";
     }


}
