package uteq.freelancer_mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uteq.freelancer_mvc.models.Ability;
import uteq.freelancer_mvc.service.HabilidadService;

import java.util.List;

@RestController
@RequestMapping("api/habilidades")
@CrossOrigin("*")
public class HabilidadController {
    @Autowired
    private HabilidadService habilidadService;

    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Ability>> getAll() {
        try {
            return ResponseEntity.ok().body(habilidadService.findAll());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Ability> finfById(@PathVariable("id")int id){
        try {
            return ResponseEntity.ok().body(habilidadService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Ability> create (@RequestBody Ability entity) {
        try {
            return ResponseEntity.ok().body(habilidadService.save(entity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //ELIMINAR
    @DeleteMapping(value =  "{id}")
    public ResponseEntity<Boolean> delete (@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(habilidadService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<Ability>update(@PathVariable int id, @RequestBody Ability entity){
        try {
            return ResponseEntity.ok().body(habilidadService.update(id,entity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}