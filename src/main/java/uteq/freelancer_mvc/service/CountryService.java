package uteq.freelancer_mvc.service;


@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    //Este metodo permite listar todos los registro de la entidad.
    @Transactional
    public List<Country> findAll() throws Exception {
        try {
            return countryRepository.findAll();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    //Este metodo permite: Actualizar un país mediante su ID.
    @Transactional
    public Country findById(int id) throws Exception {
        try {
            Optional<Country> entityOptional = countryRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar
    @Transactional
    public Country save(Country entity) throws Exception {
        try {
            entity = countryRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    @Transactional
    public Country update(int id, Country entity) throws Exception {
        try {
            Optional<Country> entityOptional = countryRepository.findById(id);
            Country country = entityOptional.get();
            country = countryRepository.save(entity);
            return country;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    @Transactional
    public boolean delete(int id) throws Exception {
        try {
            if (countryRepository.existsById(id)) {
                countryRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
