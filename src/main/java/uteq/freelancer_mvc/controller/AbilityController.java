package uteq.freelancer_mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uteq.freelancer_mvc.models.Ability;
import uteq.freelancer_mvc.service.AbilityService;

import java.util.List;

@RestController
@RequestMapping("api/habilidades")
@CrossOrigin("*")
public class AbilityController {
    @Autowired
    private AbilityService abilityService;

    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Ability>> getAll() {
        try {
            return ResponseEntity.ok().body(abilityService.findAll());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Ability> finfById(@PathVariable("id")int id){
        try {
            return ResponseEntity.ok().body(abilityService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Ability> create (@RequestBody Ability entity) {
        try {
            return ResponseEntity.ok().body(abilityService.save(entity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //ELIMINAR
    @DeleteMapping(value =  "{id}")
    public ResponseEntity<Boolean> delete (@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(abilityService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<Ability>update(@PathVariable int id, @RequestBody Ability entity){
        try {
            return ResponseEntity.ok().body(abilityService.update(id,entity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}