package uteq.freelancer_mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uteq.freelancer_mvc.models.Plan;
import uteq.freelancer_mvc.service.PlanService;

import java.util.List;

@RestController
@RequestMapping("api/plans")
@CrossOrigin("*")
public class PlanController {
	@Autowired
    private PlanService planService;

    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Plan>> getAll() {
        try {
            return ResponseEntity.ok().body(planService.findAll());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Plan> finfById(@PathVariable("id") int id) {
        try {
            return ResponseEntity.ok().body(planService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Plan> create(@RequestBody Plan entity) {
        try {
            return ResponseEntity.ok().body(planService.save(entity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //ELIMINAR
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(planService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value = "{id}")
    public ResponseEntity<Plan> update(@PathVariable int id, @RequestBody Plan entity) {
        try {
            return ResponseEntity.ok().body(planService.update(id, entity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
