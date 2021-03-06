package uteq.freelancer_mvc.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uteq.freelancer_mvc.models.Publication;
import uteq.freelancer_mvc.service.PublicationService;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("api/publications")
@CrossOrigin("*")
public class PublicationController {
	@Autowired
	private PublicationService publicationService;
	
	
	@GetMapping("/new")
    public String services(Model model) throws Exception {
    	return "views/postservice";
    }
	
	//LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Publication>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(publicationService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }
    
    //LISTAR POR PROFESIONAL
    @GetMapping("/list")
    public ResponseEntity<List<Publication>> findByIdProfessional(@RequestParam Long idProfessional)
    {
    	try
        {
            return ResponseEntity.ok().body(publicationService.findByIdProfessional(idProfessional));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }
    
    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Publication> finfById(@PathVariable("id")Long id)
    {
        try
        {
            return ResponseEntity.ok().body(publicationService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Publication> create (@RequestBody Publication entity)
    {
        try
        {
            return ResponseEntity.ok().body(publicationService.save(entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ELIMINAR
    @DeleteMapping(value =  "{id}")
    public ResponseEntity<Boolean> delete (@PathVariable Long id)
    {
        try
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(publicationService.delete(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<Publication>update(@PathVariable Long id, @RequestBody Publication entity)
    {
        try
        {
            return ResponseEntity.ok().body(publicationService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
}
