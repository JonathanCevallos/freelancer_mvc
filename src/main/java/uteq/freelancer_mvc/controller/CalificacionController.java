package uteq.freelancer_mvc.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uteq.freelancer_mvc.models.Calificacion;
import uteq.freelancer_mvc.service.CalificacionService;

@RestController
@RequestMapping("api/calificaciones")
@CrossOrigin("*")
public class CalificacionController {
	
	 @Autowired
	    private CalificacionService calificacionService;

	    //LISTAR TODO
	    @GetMapping
	    public ResponseEntity<List<Calificacion>> getAll() {
	        try {
	            return ResponseEntity.ok().body(calificacionService.findAll());
	        } catch (Exception e) {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    //BUSCAR POR ID
	    @RequestMapping(value = "{id}")
	    public ResponseEntity<Calificacion> finfById(@PathVariable("id") Long id) {
	        try {
	            return ResponseEntity.ok().body(calificacionService.findById(id));
	        } catch (Exception e) {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    //GUARDAR
	    @PostMapping
	    public ResponseEntity<Calificacion> create(@RequestBody Calificacion entity) {
	        try {
	            return ResponseEntity.ok().body(calificacionService.save(entity));
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().build();
	        }
	    }

	    //ELIMINAR
	    @DeleteMapping(value = "{id}")
	    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
	        try {
	            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(calificacionService.delete(id));
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().build();
	        }
	    }

	    //ACTUALIZAR
	    @PutMapping(value = "{id}")
	    private ResponseEntity<Calificacion> update(@PathVariable Long id, @RequestBody Calificacion entity) {
	        try {
	            return ResponseEntity.ok().body(calificacionService.update(id, entity));
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().build();
	        }
	    }
}