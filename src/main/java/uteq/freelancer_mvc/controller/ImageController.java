package uteq.freelancer_mvc.controller;

import uteq.freelancer_mvc.models.Image;
import uteq.freelancer_mvc.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("api/images")
//@CrossOrigin("*")
public class ImageController {
	@Autowired
	private ImageService imageService;

	// LISTAR TODO
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

	// CARGA LA PÁGINA
	@GetMapping("/")
	public static String image(Model model) {
		return "views/varias";
	}

	//CARGA LA IMAGEN AL SERVIDOR
	@PostMapping("upload")
	public ResponseEntity<?> uploadFile(@RequestParam("image") MultipartFile file) {
		if (file.isEmpty()) {
			return new ResponseEntity<Object>("Seleccionar un archivo", HttpStatus.OK);
		}
		try
		{
			imageService.saveImage(file);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<Object>("Archivo subido correctamente", HttpStatus.OK);
	}
	
	@PostMapping("uploads")
	public ResponseEntity<?> uploadFiles(@RequestParam("image") MultipartFile[] files) {
		if (files.length == 0)
		{
			return new ResponseEntity<Object>("Seleccionar un archivo", HttpStatus.OK);
		}
		try
		{
			imageService.saveImages(files);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<Object>("Archivo subido correctamente", HttpStatus.OK);
	}

	// ELIMINAR
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id) {
		try {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(imageService.delete(id));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	// ACTUALIZAR
	@PutMapping(value = "{id}")
	public ResponseEntity<Image> update(@PathVariable Long id, @RequestBody Image entity) {
		try {
			return ResponseEntity.ok().body(imageService.update(id, entity));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

}