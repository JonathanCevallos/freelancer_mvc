package uteq.freelancer_mvc.controller;

import uteq.freelancer_mvc.models.Image;
import uteq.freelancer_mvc.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/image")
@CrossOrigin("*")
public class ImageController {
	 @Autowired
	    private ImageService imageService;

	    //LISTAR TODO
	    @GetMapping
	    public ResponseEntity<List<Image>> getAll() {
	        try {
	            return ResponseEntity.ok().body(imageService.findAll());
	        } catch (Exception e) {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // BUSCAR POR ID
	    @RequestMapping(value = "{id}")
	    public ResponseEntity<Image> finfById(@PathVariable("id") Long id) {
	        try {
	            return ResponseEntity.ok().body(imageService.findById(id));
	        } catch (Exception e) {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    //GUARDAR
	    @PostMapping
	    public ResponseEntity<Image> create(@RequestBody Image entity) {
	        try {
	            return ResponseEntity.ok().body(imageService.save(entity));
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().build();
	        }
	    }

	    //ELIMINAR
	    @DeleteMapping(value = "{id}")
	    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
	        try {
	            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(imageService.delete(id));
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().build();
	        }
	    }

	    //ACTUALIZAR
	    @PutMapping(value = "{id}")
	    public ResponseEntity<Image> update(@PathVariable Long id, @RequestBody Image entity) {
	        try {
	            return ResponseEntity.ok().body(imageService.update(id, entity));
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().build();
	        }
	    }
	
}