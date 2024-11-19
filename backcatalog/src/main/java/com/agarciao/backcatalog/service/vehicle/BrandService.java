package com.agarciao.backcatalog.service.vehicle;

import com.agarciao.backcatalog.persistence.entity.vehicle.BrandEntity;
import com.agarciao.backcatalog.persistence.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    //List of Brand
    public List<BrandEntity> getsListBrand(){
        return brandRepository.findAll();
    }

    //Brand of id
    public BrandEntity getsIdBrand(Long id){
        return brandRepository.findById(id).get();
    }

    //Create Brand
    public BrandEntity createsBrand(BrandEntity brand){
        return brandRepository.save(brand);
    }

    //Update Brand
    public BrandEntity updatesBrand(Long id, BrandEntity brand){
        BrandEntity updatedBrand = brandRepository.findById(id).get();
        updatedBrand.setName(brand.getName());
        updatedBrand.setDescription(brand.getDescription());
        return  brandRepository.save(updatedBrand);
    }

    //Delete Brand by id
    public void deletesBrand(Long id){
        BrandEntity deletedBrand = brandRepository.findById(id).get();
        brandRepository.delete(deletedBrand);
    }
}
