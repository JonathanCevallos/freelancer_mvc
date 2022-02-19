package uteq.freelancer_mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uteq.freelancer_mvc.models.Occupation;
import uteq.freelancer_mvc.models.Publication;
import uteq.freelancer_mvc.service.OccupationService;

import java.util.List;

@RestController
@RequestMapping("api/occupations")
@CrossOrigin("*")
public class OccupationController {
    @Autowired
    private OccupationService occupationService;

    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Occupation>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(occupationService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //LISTAR TODO
    @GetMapping("/new")
    public String findAll(Model model) throws Exception {
        List<Occupation> occupations = occupationService.findAll();
        model.addAttribute("occupations", occupations);
        return "views/registrarprofesional";
    }

    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Occupation> finfById(@PathVariable("id")int id)
    {
        try
        {
            return ResponseEntity.ok().body(occupationService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Occupation> create (@RequestBody Occupation entity)
    {
        try
        {
            return ResponseEntity.ok().body(occupationService.save(entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ELIMINAR
    @DeleteMapping(value =  "{id}")
    public ResponseEntity<Boolean> delete (@PathVariable int id)
    {
        try
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(occupationService.delete(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<Occupation>update(@PathVariable int id, @RequestBody Occupation entity)
    {
        try
        {
            return ResponseEntity.ok().body(occupationService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
}
