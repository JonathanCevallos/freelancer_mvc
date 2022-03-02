package uteq.freelancer_mvc.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uteq.freelancer_mvc.interfaceService.IcategoriaService;
import uteq.freelancer_mvc.models.Category;
import uteq.freelancer_mvc.repository.CategoryRepository;

@Service
public class CategoryService implements IcategoriaService {
    
	@Autowired
	private CategoryRepository data;
	
	@Override
	public List<Category> listar() {
	return (List<Category>)data.findAll();
	}

	@Override
	public Optional<Category> listarId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(Category c) {
		int res=0;
		Category Category=data.save(c);
		if(!Category.equals(null))
		{
			res=1;
		}
		// TODO Auto-generated method stub
		return res;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}


     
    
    
}

