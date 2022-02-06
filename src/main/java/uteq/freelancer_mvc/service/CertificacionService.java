package uteq.freelancer_mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.freelancer_mvc.models.Certification;
import uteq.freelancer_mvc.repository.CertificacionRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CertificacionService {
    @Autowired
    private CertificacionRepository certificacionRepository;

    //Este metodo permite lisatr todos los registro de la entidad.
    @Transactional
    public List<Certification> findAll() throws Exception{
        try {
            return certificacionRepository.findAll();
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Buscar un certificacion mediante su ID.
    @Transactional
    public Certification findById(int id) throws Exception{
        try {
            Optional<Certification> entityOptional = certificacionRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar.
    @Transactional
    public Certification save(Certification entity) throws Exception{
        try {
            entity = certificacionRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public Certification update(int id, Certification entity) throws Exception{
        try {
            Optional<Certification> entityOptional = certificacionRepository.findById(id);
            Certification certification = entityOptional.get();
            certification = certificacionRepository.save(entity);
            return certification;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    @Transactional
    public boolean delete(int id) throws Exception{
        try {
            if(certificacionRepository.existsById(id)){
                certificacionRepository.deleteById(id);
                return  true;
            }else {
                throw  new Exception();
            }
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }
}