package com.agarciao.backcatalog.service.vehicle;

import com.agarciao.backcatalog.persistence.entity.vehicle.CategoryEntity;
import com.agarciao.backcatalog.persistence.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    //List of Category
    public List<CategoryEntity> getsCategoryList(){
        List<CategoryEntity> list = categoryRepository.findAll();
        list.sort(Comparator.comparing(CategoryEntity::getId));
        return list;
    }

    //Category by id
    public CategoryEntity getsIDCategory(long id){
        return categoryRepository.findById(id).orElse(null);
    }

    //Create Category
    public CategoryEntity createsCategory(CategoryEntity category){
        return categoryRepository.save(category);
    }

    //Update Category
    public CategoryEntity updatesCategory(long id, CategoryEntity category){
        CategoryEntity updatedCategory = categoryRepository.findById(id).get();
        return categoryRepository.save(updatedCategory);
    }

    //Delete Category
    public void deletesCategory(long id){
        Optional<CategoryEntity> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            CategoryEntity deletedMarca = optionalCategory.get();
            categoryRepository.delete(deletedMarca);
        }
        else {
            throw new EntityNotFoundException("Categoria no encontrada");
        }
    }

}
