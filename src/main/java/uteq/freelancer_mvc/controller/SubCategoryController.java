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

import uteq.freelancer_mvc.models.SubCategory;
import uteq.freelancer_mvc.service.SubCategoryService;

@RestController
@RequestMapping("api/subcategory")
@CrossOrigin("*")
public class SubCategoryController {
	@Autowired
	private SubCategoryService subCategoryService;
	//LISTAR TODO
    @GetMapping
    public ResponseEntity<List<SubCategory>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(subCategoryService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<SubCategory> finfById(@PathVariable("id")int id)
    {
        try
        {
            return ResponseEntity.ok().body(subCategoryService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<SubCategory> create (@RequestBody SubCategory entity)
    {
        try
        {
            return ResponseEntity.ok().body(subCategoryService.save(entity));
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
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(subCategoryService.delete(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<SubCategory>update(@PathVariable int id, @RequestBody SubCategory entity)
    {
        try
        {
            return ResponseEntity.ok().body(subCategoryService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
}


