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
import uteq.freelancer_mvc.models.People;
import uteq.freelancer_mvc.service.UserService;

@RestController
@RequestMapping("api/users")
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserService userService;
	
	//LISTAR TODO
    @GetMapping
    public ResponseEntity<List<People>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(userService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<People> finfById(@PathVariable("id")Long id)
    {
        try
        {
            return ResponseEntity.ok().body(userService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<People> create (@RequestBody People entity)
    {
        try
        {
            return ResponseEntity.ok().body(userService.save(entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ELIMINAR
    @DeleteMapping(value =  "{id}")
    public ResponseEntity<Boolean> delete (@PathVariable Long id)
    {
        try
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(userService.delete(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<People>update(@PathVariable Long id, @RequestBody People entity)
    {
        try
        {
            return ResponseEntity.ok().body(userService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
}
