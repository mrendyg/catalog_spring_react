package com.agarciao.backcatalog.service.user;

import com.agarciao.backcatalog.persistence.entity.user.ConcessionaireEntity;
import com.agarciao.backcatalog.persistence.repository.ConcessionaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

@Service
public class ConcessionaireService {

    @Autowired
    private ConcessionaireRepository concessionaireRepository;

    //List of Concessionaire
    public List<ConcessionaireEntity> getsListConcessionaire(){
        return concessionaireRepository.findAll();
    }

    //Concessionaire by id
    public ConcessionaireEntity getsIdConcessionaire(Long id){
        return concessionaireRepository.findById(id).orElse(null);
    }

    //Create concessionaire
    public ConcessionaireEntity createsConcessionaire(ConcessionaireEntity concessionaire){
        return concessionaireRepository.save(concessionaire);
    }

    //Update Concessionaire
    public ConcessionaireEntity updatesConcessionaire(Long id, ConcessionaireEntity concessionaire){

        ConcessionaireEntity updatedConcessionaire = concessionaireRepository.findById(id).get();
        updatedConcessionaire.setName(concessionaire.getName());
        updatedConcessionaire.setBrand(concessionaire.getBrand());
        return concessionaireRepository.save(updatedConcessionaire);
    }

    //Delete Concessionaire
    public void deletesConcessionaire(Long id){
        ConcessionaireEntity deletedConcessionaire = concessionaireRepository.findById(id).get();
        concessionaireRepository.delete(deletedConcessionaire);
    }

}

