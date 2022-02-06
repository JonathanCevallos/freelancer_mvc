package uteq.freelancer_mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uteq.freelancer_mvc.models.Certification;
import uteq.freelancer_mvc.service.CertificacionService;

import java.util.List;

@RestController
@RequestMapping("api/certificaciones")
@CrossOrigin("*")
public class CertificacionController {
    @Autowired
    private CertificacionService certificacionService;

    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Certification>> getAll() {
        try {
            return ResponseEntity.ok().body(certificacionService.findAll());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Certification> finfById(@PathVariable("id")int id){
        try {
            return ResponseEntity.ok().body(certificacionService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Certification> create (@RequestBody Certification entity) {
        try {
            return ResponseEntity.ok().body(certificacionService.save(entity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //ELIMINAR
    @DeleteMapping(value =  "{id}")
    public ResponseEntity<Boolean> delete (@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(certificacionService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<Certification>update(@PathVariable int id, @RequestBody Certification entity){
        try {
            return ResponseEntity.ok().body(certificacionService.update(id,entity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
