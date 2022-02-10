package uteq.freelancer_mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uteq.freelancer_mvc.models.Skill;
import uteq.freelancer_mvc.service.SkillService;

import java.util.List;

@RestController
@RequestMapping("api/abilities")
@CrossOrigin("*")
public class AbilityController {
    @Autowired
    private SkillService skillService;

    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Skill>> getAll() {
        try {
            return ResponseEntity.ok().body(skillService.findAll());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Skill> finfById(@PathVariable("id") int id) {
        try {
            return ResponseEntity.ok().body(skillService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Skill> create(@RequestBody Skill entity) {
        try {
            return ResponseEntity.ok().body(skillService.save(entity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //ELIMINAR
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(skillService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value = "{id}")
    private ResponseEntity<Skill> update(@PathVariable int id, @RequestBody Skill entity) {
        try {
            return ResponseEntity.ok().body(skillService.update(id, entity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}