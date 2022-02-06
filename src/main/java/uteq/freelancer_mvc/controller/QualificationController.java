package uteq.freelancer_mvc.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uteq.freelancer_mvc.models.Qualification;
import uteq.freelancer_mvc.service.QualificationService;

@RestController
@RequestMapping("api/qualification")
@CrossOrigin("*")
public class QualificationController {
	
	 @Autowired
	    private QualificationService qualificationService;

	    //LISTAR TODO
	    @GetMapping
	    public ResponseEntity<List<Qualification>> getAll() {
	        try {
	            return ResponseEntity.ok().body(qualificationService.findAll());
	        } catch (Exception e) {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    //BUSCAR POR ID
	    @RequestMapping(value = "{id}")
	    public ResponseEntity<Qualification> finfById(@PathVariable("id") Long id) {
	        try {
	            return ResponseEntity.ok().body(qualificationService.findById(id));
	        } catch (Exception e) {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    //GUARDAR
	    @PostMapping
	    public ResponseEntity<Qualification> create(@RequestBody Qualification entity) {
	        try {
	            return ResponseEntity.ok().body(qualificationService.save(entity));
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().build();
	        }
	    }

	    //ELIMINAR
	    @DeleteMapping(value = "{id}")
	    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
	        try {
	            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(qualificationService.delete(id));
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().build();
	        }
	    }

	    //ACTUALIZAR
	    @PutMapping(value = "{id}")
	    private ResponseEntity<Qualification> update(@PathVariable Long id, @RequestBody Qualification entity) {
	        try {
	            return ResponseEntity.ok().body(qualificationService.update(id, entity));
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().build();
	        }
	    }
}