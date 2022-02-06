package uteq.freelancer_mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uteq.freelancer_mvc.models.SubCategoria;
import uteq.freelancer_mvc.service.SubCategoriaService;

@RestController
@RequestMapping("api/subcategorias")
@CrossOrigin("*")
public class SubCategoriaController {
	@Autowired
	private SubCategoriaService subCategoriaService;
	//LISTAR TODO
    @GetMapping
    public ResponseEntity<List<SubCategoria>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(subCategoriaService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<SubCategoria> finfById(@PathVariable("id")int id)
    {
        try
        {
            return ResponseEntity.ok().body(subCategoriaService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<SubCategoria> create (@RequestBody SubCategoria entity)
    {
        try
        {
            return ResponseEntity.ok().body(subCategoriaService.save(entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ELIMINAR
    @DeleteMapping(value =  "{id}")
    public ResponseEntity<Boolean> delete (@PathVariable int id)
    {
        try
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(subCategoriaService.delete(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<SubCategoria>update(@PathVariable int id, @RequestBody SubCategoria entity)
    {
        try
        {
            return ResponseEntity.ok().body(subCategoriaService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
}


