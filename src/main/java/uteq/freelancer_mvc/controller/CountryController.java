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
import uteq.freelancer_mvc.models.Country;
import uteq.freelancer_mvc.service.CountryService;

@RestController
@RequestMapping("api/countries")
@CrossOrigin("*")
public class CountryController {
	@Autowired
	private CountryService countryService;
	
	//LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Country>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(countryService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Country> finfById(@PathVariable("id")int id)
    {
        try
        {
            return ResponseEntity.ok().body(countryService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Country> create (@RequestBody Country entity)
    {
        try
        {
            return ResponseEntity.ok().body(countryService.save(entity));
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
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(countryService.delete(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<Country>update(@PathVariable int id, @RequestBody Country entity)
    {
        try
        {
            return ResponseEntity.ok().body(countryService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
}
