package uteq.freelancer_mvc.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import uteq.freelancer_mvc.models.Image;
import uteq.freelancer_mvc.repository.ImageRepository;

import javax.transaction.Transactional;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    //Este metodo permite lisatr todos los registro de la entidad.
    @Transactional
    public List<Image> findAll() throws Exception {
        try {
            return imageRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    public void saveImage(MultipartFile file) throws IOException
    {
    	String source = ".//src//main//resources//static//assets//img//publications//publication//";
        if(!file.isEmpty())
        {
        	int index = file.getOriginalFilename().indexOf(".");
        	String extension = "." + file.getOriginalFilename().substring(index + 1);
        	String nameImage = Calendar.getInstance().getTimeInMillis() + extension;
            byte[] bytes = file.getBytes();
            Path path = Paths.get(source + nameImage);
            //Path path = Paths.get(source + file.getOriginalFilename());
            Files.write(path,bytes);
        }
    }
    
    public void saveImages(MultipartFile[] files) throws IOException
    {
    	String source = ".//src//main//resources//static//assets//img//publications//publication//";
        if(files.length != 0)
        {
        	for(MultipartFile file:files)
        	{
        		try
        		{
        			int index = file.getOriginalFilename().indexOf(".");
                	String extension = "." + file.getOriginalFilename().substring(index + 1);
                	String nameImage = Calendar.getInstance().getTimeInMillis() + extension;
                    byte[] bytes = file.getBytes();
                    Path path = Paths.get(source + nameImage);
                    Files.write(path,bytes);
        		}
        		catch(IOException e)
        		{
        			e.printStackTrace();
        		}
        	}
        }
    }

    //Este metodo permite: Buscar un imagen mediante su ID.
    @Transactional
    public Image findById(Long id) throws Exception {
        try {
            Optional<Image> entityOptional = imageRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar.
    @Transactional
    public Image save(Image entity) throws Exception {
        try {
            entity = imageRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public Image update(Long id, Image entity) throws Exception {
        try {
            Optional<Image> entityOptional = imageRepository.findById(id);
            Image image = entityOptional.get();
            image = imageRepository.save(entity);
            return image;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (imageRepository.existsById(id)) {
                imageRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}