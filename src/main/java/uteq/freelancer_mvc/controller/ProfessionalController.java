package uteq.freelancer_mvc.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import uteq.freelancer_mvc.models.Occupation;
import uteq.freelancer_mvc.models.Professional;
import uteq.freelancer_mvc.models.Publication;
import uteq.freelancer_mvc.service.OccupationService;
import uteq.freelancer_mvc.service.ProfessionalService;

import java.util.List;

@org.springframework.stereotype.Controller
@RestController
@RequestMapping("api/professionals")
@CrossOrigin("*")
public class ProfessionalController {
    @Autowired
    private ProfessionalService professionalService;

    @Autowired
    private OccupationService occupationService;

    //LISTAR TODO
    @GetMapping("/new")
    public String registrer(Model model) throws Exception {
        List<Occupation> occupations = occupationService.findAll();
        model.addAttribute("occupations", occupations);
        return "views/registrarprofesional";
    }


    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Professional>> getAll() {
        try {
            return ResponseEntity.ok().body(professionalService.findAll());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    //TODOLISTAR
    @GetMapping("list")
    public String professionalProfile(Model model)
    {
    	try
    	{
    		Professional professional = professionalService.findById(3L);
            model.addAttribute("professional", professional);
            return "views/perfilprofesional";
    	}
    	catch(Exception e)
    	{
    		return "error";
    	}
    }

    
    //TODO: BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Professional> finfById(@PathVariable("id")Long id){
        try {
            return ResponseEntity.ok().body(professionalService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping("add")
    public ResponseEntity<Professional> create (@RequestBody Professional entity) {
        try {
            return ResponseEntity.ok().body(professionalService.save(entity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //ELIMINAR
    @DeleteMapping(value =  "{id}")
    public ResponseEntity<Boolean> delete (@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(professionalService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<Professional>update(@PathVariable Long id, @RequestBody Professional entity){
        try {
            return ResponseEntity.ok().body(professionalService.update(id,entity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}