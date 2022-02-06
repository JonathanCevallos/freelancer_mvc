package uteq.freelancer_mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uteq.freelancer_mvc.models.Occupation;
import uteq.freelancer_mvc.service.OcupacionService;

import java.util.List;

@RestController
@RequestMapping("api/ocupaciones")
@CrossOrigin("*")
public class OccupationController {
    @Autowired
    private OcupacionService ocupacionService;

    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Occupation>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(ocupacionService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Occupation> finfById(@PathVariable("id")int id)
    {
        try
        {
            return ResponseEntity.ok().body(ocupacionService.findById(id));
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
            return ResponseEntity.ok().body(ocupacionService.save(entity));
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
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ocupacionService.delete(id));
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
            return ResponseEntity.ok().body(ocupacionService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
}
