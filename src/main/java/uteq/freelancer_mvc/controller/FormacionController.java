package uteq.freelancer_mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uteq.freelancer_mvc.models.Formacion;
import uteq.freelancer_mvc.service.FormacionService;

import java.util.List;

@RestController
@RequestMapping("api/formaciones")
@CrossOrigin("*")
public class FormacionController {
    @Autowired
    private FormacionService formacionService;

    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Formacion>> getAll() {
        try {
            return ResponseEntity.ok().body(formacionService.findAll());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Formacion> finfById(@PathVariable("id")int id){
        try {
            return ResponseEntity.ok().body(formacionService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Formacion> create (@RequestBody Formacion entity) {
        try {
            return ResponseEntity.ok().body(formacionService.save(entity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //ELIMINAR
    @DeleteMapping(value =  "{id}")
    public ResponseEntity<Boolean> delete (@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(formacionService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<Formacion>update(@PathVariable int id, @RequestBody Formacion entity){
        try {
            return ResponseEntity.ok().body(formacionService.update(id,entity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}