package uteq.freelancer_mvc.interfaceService;
import java.util.List;
import java.util.Optional;
import uteq.freelancer_mvc.models.Category;

public interface IcategoriaService {
	public List<Category>listar();
	public Optional<Category>listarId(int id);
	public int save(Category c);
	public void delete(int id);
}

