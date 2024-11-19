package com.agarciao.backcatalog.controller.user;

import com.agarciao.backcatalog.persistence.entity.user.ConcessionaireEntity;
import com.agarciao.backcatalog.service.user.ConcessionaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth/concessionaire")
@PreAuthorize("denyAll()")
public class ConcessionaireController {

    @Autowired
    private ConcessionaireService concessionaireService;

    //List of concessionaire
    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN') or hasRole('DEVELOPER')")
    public List<ConcessionaireEntity> getListConcessionarie(){
        return concessionaireService.getsListConcessionaire();
    }

    //Concessionaire by id
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN') or hasRole('DEVELOPER')")
    public ConcessionaireEntity getIdConcessionaire(@PathVariable long id){
        return concessionaireService.getsIdConcessionaire(id);
    }

    //Create concessionaire
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN') or hasRole('DEVELOPER')")
    public ConcessionaireEntity createConcessionaire(@RequestBody ConcessionaireEntity concessionaire){
        return concessionaireService.createsConcessionaire(concessionaire);
    }

    //Update concessionaire
    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasRole('ADMIN') or hasRole('DEVELOPER')")
    public ConcessionaireEntity updateConcessionaire(@PathVariable long id, @RequestBody ConcessionaireEntity concessionaire){
        return concessionaireService.updatesConcessionaire(id, concessionaire);
    }

    //Delete concessionaire by id
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ADMIN') or hasRole('DEVELOPER')")
    public void deleteConcessionaire(@PathVariable Long id){
        concessionaireService.deletesConcessionaire(id);
    }

}
