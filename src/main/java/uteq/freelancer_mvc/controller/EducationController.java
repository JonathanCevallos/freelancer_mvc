package uteq.freelancer_mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uteq.freelancer_mvc.models.Education;
import uteq.freelancer_mvc.service.EducationService;

import java.util.List;

@RestController
@RequestMapping("api/formaciones")
@CrossOrigin("*")
public class EducationController {
    @Autowired
    private EducationService educationService;

    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Education>> getAll() {
        try {
            return ResponseEntity.ok().body(educationService.findAll());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Education> finfById(@PathVariable("id") int id) {
        try {
            return ResponseEntity.ok().body(educationService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Education> create(@RequestBody Education entity) {
        try {
            return ResponseEntity.ok().body(educationService.save(entity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //ELIMINAR
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(educationService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value = "{id}")
    private ResponseEntity<Education> update(@PathVariable int id, @RequestBody Education entity) {
        try {
            return ResponseEntity.ok().body(educationService.update(id, entity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}