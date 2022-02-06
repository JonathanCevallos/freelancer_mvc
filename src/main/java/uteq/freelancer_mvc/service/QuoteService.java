package uteq.freelancer_mvc.service;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uteq.freelancer_mvc.models.Quote;
import uteq.freelancer_mvc.repository.QuoteRepository;

@Service
public class QuoteService {
    @Autowired
    private QuoteRepository quoteRepository;

    //Este metodo permite listar todos los registros de la entidad.
    @Transactional
    public List<Quote> findAll() throws Exception {
        try {
            return quoteRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Buscar una cotización mediante su ID.
    @Transactional
    public Quote findById(int id) throws Exception {
        try {
            Optional<Quote> entityOptional = quoteRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar.
    @Transactional
    public Quote save(Quote entity) throws Exception {
        try {
            entity = quoteRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public Quote update(int id, Quote entity) throws Exception {
        try {
            Optional<Quote> entityOptional = quoteRepository.findById(id);
            Quote quote = entityOptional.get();
            quote = quoteRepository.save(entity);
            return quote;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    @Transactional
    public boolean delete(int id) throws Exception {
        try {
            if (quoteRepository.existsById(id)) {
                quoteRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}