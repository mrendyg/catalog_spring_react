package com.agarciao.backcatalog.service.vehicle;

import com.agarciao.backcatalog.persistence.entity.vehicle.ModelEntity;
import com.agarciao.backcatalog.persistence.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelService {

    @Autowired
    private ModelRepository modelRepository;

    //List of model
    public List<ModelEntity> getsListModel(){
        return modelRepository.findAll();
    }

    //Model by id
    public ModelEntity getsIdModel(long id){
        return modelRepository.findById(id).orElse(null);
    }

    //create Model
    public ModelEntity createsModel(ModelEntity model){
        return modelRepository.save(model);
    }

    //Update model
    public ModelEntity updatesModel(long id, ModelEntity model){
        ModelEntity updatedModel = modelRepository.findById(id).get();
        updatedModel.setName(model.getName());
        updatedModel.setDescription(model.getDescription());
        updatedModel.setBrand(model.getBrand());
        return modelRepository.save(updatedModel);
    }

    //Delete Model
    public void deletesModel(long id){
        ModelEntity deletedModel = modelRepository.findById(id).get();
        modelRepository.delete(deletedModel);
    }

}
