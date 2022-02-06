package uteq.freelancer_mvc.controller;

import uteq.freelancer_mvc.models.Imagen;
import uteq.freelancer_mvc.service.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/imagenes")
@CrossOrigin("*")
public class ImagenController {
	 @Autowired
	    private ImagenService imagenService;

	    //LISTAR TODO
	    @GetMapping
	    public ResponseEntity<List<Imagen>> getAll() {
	        try {
	            return ResponseEntity.ok().body(imagenService.findAll());
	        } catch (Exception e) {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // BUSCAR POR ID
	    @RequestMapping(value = "{id}")
	    public ResponseEntity<Imagen> finfById(@PathVariable("id") Long id) {
	        try {
	            return ResponseEntity.ok().body(imagenService.findById(id));
	        } catch (Exception e) {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    //GUARDAR
	    @PostMapping
	    public ResponseEntity<Imagen> create(@RequestBody Imagen entity) {
	        try {
	            return ResponseEntity.ok().body(imagenService.save(entity));
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().build();
	        }
	    }

	    //ELIMINAR
	    @DeleteMapping(value = "{id}")
	    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
	        try {
	            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(imagenService.delete(id));
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().build();
	        }
	    }

	    //ACTUALIZAR
	    @PutMapping(value = "{id}")
	    public ResponseEntity<Imagen> update(@PathVariable Long id, @RequestBody Imagen entity) {
	        try {
	            return ResponseEntity.ok().body(imagenService.update(id, entity));
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().build();
	        }
	    }
	
}