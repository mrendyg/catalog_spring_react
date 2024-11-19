package com.agarciao.backcatalog.controller.vehicle;

import com.agarciao.backcatalog.persistence.entity.vehicle.ModelEntity;
import com.agarciao.backcatalog.service.vehicle.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth/model")
@PreAuthorize("denyAll()")
public class ModelController {

    @Autowired
    private ModelService modelService;

    //List of models
    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('READ')")
    public List<ModelEntity> getListModel(){
        return modelService.getsListModel();
    }

    //Models search by id
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('READ')")
    public ModelEntity getIdModel(@PathVariable long id){
        return modelService.getsIdModel(id);
    }

    //Create new model
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN') or hasRole('DEVELOPER')")
    public ModelEntity createModel(@RequestBody ModelEntity model){
        return modelService.createsModel(model);
    }

    //Update an existing model
    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasRole('ADMIN') or hasRole('DEVELOPER')")
    public ModelEntity updateModel(@PathVariable long id, @RequestBody ModelEntity model){
        return modelService.updatesModel(id, model);
    }

    //Delete model by id
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ADMIN') or hasRole('DEVELOPER')")
    public void deleteModel(@PathVariable long id){
        modelService.deletesModel(id);
    }

}