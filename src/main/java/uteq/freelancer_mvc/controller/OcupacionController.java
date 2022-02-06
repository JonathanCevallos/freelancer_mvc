package uteq.freelancer_mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uteq.freelancer_mvc.models.Ocupacion;
import uteq.freelancer_mvc.service.OcupacionService;

import java.util.List;

@RestController
@RequestMapping("api/ocupaciones")
@CrossOrigin("*")
public class OcupacionController {
    @Autowired
    private OcupacionService ocupacionService;

    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Ocupacion>> getAll()
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
    public ResponseEntity<Ocupacion> finfById(@PathVariable("id")int id)
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
    public ResponseEntity<Ocupacion> create (@RequestBody Ocupacion entity)
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
    private ResponseEntity<Ocupacion>update(@PathVariable int id, @RequestBody Ocupacion entity)
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
