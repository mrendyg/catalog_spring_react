package com.agarciao.backcatalog.controller.vehicle;

import com.agarciao.backcatalog.persistence.entity.vehicle.BrandEntity;
import com.agarciao.backcatalog.service.vehicle.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth/brand")
@PreAuthorize("denyAll()")
public class BrandController {

    //The logic of each function is found in the service
    @Autowired
    private BrandService brandService;

    //List of brand
    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('READ')")
    public List<BrandEntity> getListBrand(){
        return brandService.getsListBrand();
    }

    //Brand by id
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('READ')")
    public BrandEntity getIdBrand(@PathVariable long id){
        return brandService.getsIdBrand(id);
    }

    //Create brands
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('CREATE')")
    public BrandEntity createBrand(@RequestBody BrandEntity brand){
        return brandService.createsBrand(brand);
    }

    //Update brand
    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAuthority('UPDATE')")
    public BrandEntity updateBrand(@PathVariable long id, @RequestBody BrandEntity brand){
        return brandService.updatesBrand(id, brand);
    }

    //Delete brand by id
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasRole('DEVELOPER')")
    public void deleteBrand(@PathVariable long id){
        brandService.deletesBrand(id);
    }

}
