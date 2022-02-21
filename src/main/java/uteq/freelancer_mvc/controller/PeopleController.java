package uteq.freelancer_mvc.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uteq.freelancer_mvc.models.People;
import uteq.freelancer_mvc.service.PeopleService;

@org.springframework.stereotype.Controller
@RestController
@RequestMapping("api/people")
@CrossOrigin("*")
public class PeopleController {
	@Autowired
	private PeopleService peopleService;
	//private Long id = 3L;
	//LISTAR TODO
    @GetMapping
    public ResponseEntity<List<People>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(peopleService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/list")
    public String peopleProfile(Model model)
    {
    	try
    	{
    		People people = peopleService.findById(3L);
            model.addAttribute("people", people);
            return "views/perfilusuario";
    	}
    	catch(Exception e)
    	{
    		return "error";
    	}
    }
    
    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<People> finfById(@PathVariable("id")Long id)
    {
        try
        {
            return ResponseEntity.ok().body(peopleService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<People> create (@RequestBody People entity)
    {
        try
        {
            return ResponseEntity.ok().body(peopleService.save(entity));
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
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(peopleService.delete(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<People>update(@PathVariable Long id, @RequestBody People entity)
    {
        try
        {
            return ResponseEntity.ok().body(peopleService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
}
