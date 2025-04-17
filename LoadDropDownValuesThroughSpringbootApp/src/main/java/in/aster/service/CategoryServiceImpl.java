package in.aster.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.aster.entity.Category;
import in.aster.repository.CategoryRepository;
@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
	private CategoryRepository catRepo;
	@Override
	public List<String> getAllCategories() {
		// TODO Auto-generated method stub
		List<Category> all = catRepo.findAll();
		List<String> list=new ArrayList<>();
		all.forEach(c->list.add(c.getCategoryName()));
		return list;
	}

}
