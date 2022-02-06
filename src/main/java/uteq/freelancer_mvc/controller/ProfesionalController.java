package uteq.freelancer_mvc.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uteq.freelancer_mvc.models.Profesional;
import uteq.freelancer_mvc.service.ProfesionalService;

import java.util.List;

@RestController
@RequestMapping("api/profesionales")
@CrossOrigin("*")
public class ProfesionalController {
    @Autowired
    private ProfesionalService profesionalService;

    //TODO LISTAR
    @GetMapping
    public ResponseEntity<List<Profesional>> getAll() {
        try {
            return ResponseEntity.ok().body(profesionalService.findAll());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    //TODO: BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Profesional> finfById(@PathVariable("id")Long id){
        try {
            return ResponseEntity.ok().body(profesionalService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Profesional> create (@RequestBody Profesional entity) {
        try {
            return ResponseEntity.ok().body(profesionalService.save(entity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //ELIMINAR
    @DeleteMapping(value =  "{id}")
    public ResponseEntity<Boolean> delete (@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(profesionalService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<Profesional>update(@PathVariable Long id, @RequestBody Profesional entity){
        try {
            return ResponseEntity.ok().body(profesionalService.update(id,entity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}