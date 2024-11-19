package com.agarciao.backcatalog.controller.vehicle;

import com.agarciao.backcatalog.persistence.entity.vehicle.CategoryEntity;
import com.agarciao.backcatalog.service.vehicle.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth/category")
@PreAuthorize("denyAll()")
public class CategoryController {

    //The logic of each function is found in the service
    @Autowired
    private CategoryService categoryService;

    //List of category
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('READ')")
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryEntity> categoryList(){
        return categoryService.getsCategoryList();
    }

    //Category by id
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('READ')")
    @ResponseStatus(HttpStatus.OK)
    public CategoryEntity getIdCategory(@PathVariable Long id){
        return categoryService.getsIDCategory(id);
    }

    //Create Category
    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN') or hasRole('DEVELOPER')")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryEntity CreateCategory(@RequestBody CategoryEntity category){
        return categoryService.createsCategory(category);
    }

    //Update Category
    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('DEVELOPER')")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public CategoryEntity updateCategory(@PathVariable Long id, @RequestBody CategoryEntity category){
        return categoryService.updatesCategory(id, category);
    }

    //Delete category by id
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('DEVELOPER')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletedCategory(@PathVariable Long id){
        categoryService.deletesCategory(id);
    }

}
