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

import uteq.freelancer_mvc.models.Cotizacion;
import uteq.freelancer_mvc.service.CotizacionService;



@RestController
@RequestMapping("api/cotizaciones")
@CrossOrigin("*")

public class CotizacionController {

	@Autowired
	private CotizacionService cotizacionService;
	//LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Cotizacion>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(cotizacionService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Cotizacion> finfById(@PathVariable("id")int id)
    {
        try
        {
            return ResponseEntity.ok().body(cotizacionService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Cotizacion> create (@RequestBody Cotizacion entity)
    {
        try
        {
            return ResponseEntity.ok().body(cotizacionService.save(entity));
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
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(cotizacionService.delete(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<Cotizacion>update(@PathVariable int id, @RequestBody Cotizacion entity)
    {
        try
        {
            return ResponseEntity.ok().body(cotizacionService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
	}