package uteq.freelancer_mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uteq.freelancer_mvc.models.Question;
import uteq.freelancer_mvc.service.QuestionService;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/question")

public class QuestionController {
	 @Autowired
	    private QuestionService questionService;

	    //LISTAR TODO
	    @GetMapping
	    public ResponseEntity<List<Question>> getAll() {
	        try {
	            return ResponseEntity.ok().body(questionService.findAll());
	        } catch (Exception e) {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // BUSCAR POR ID
	    @RequestMapping(value = "{id}")
	    public ResponseEntity<Question> finfById(@PathVariable("id") Long id) {
	        try {
	            return ResponseEntity.ok().body(questionService.findById(id));
	        } catch (Exception e) {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    //GUARDAR
	    @PostMapping
	    public ResponseEntity<Question> create(@RequestBody Question entity) {
	        try {
	            return ResponseEntity.ok().body(questionService.save(entity));
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().build();
	        }
	    }

	    //ELIMINAR
	    @DeleteMapping(value = "{id}")
	    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
	        try {
	            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(questionService.delete(id));
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().build();
	        }
	    }

	    //ACTUALIZAR
	    @PutMapping(value = "{id}")
	    public ResponseEntity<Question> update(@PathVariable Long id, @RequestBody Question entity) {
	        try {
	            return ResponseEntity.ok().body(questionService.update(id, entity));
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().build();
	        }
	    }
}
