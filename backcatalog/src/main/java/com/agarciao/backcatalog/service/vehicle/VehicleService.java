package com.agarciao.backcatalog.service.vehicle;

import com.agarciao.backcatalog.persistence.entity.vehicle.VehicleEntity;
import com.agarciao.backcatalog.persistence.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    //List of vehicles
    public List<VehicleEntity> getsListVehicle(){
        return vehicleRepository.findAll();
    }

    //Vehicles search by id
    public VehicleEntity getsIdVehicle(long id){
        return vehicleRepository.findById(id).orElse(null);
    }

    //Create new vehicle
    public VehicleEntity createsVehicle(VehicleEntity vehicle){
        return vehicleRepository.save(vehicle);
    }


    //Update an existing vehicle
    public VehicleEntity updateVehicle(long id, VehicleEntity vehicle){
        VehicleEntity updatedVehicle = vehicleRepository.findById(id).get();
        updatedVehicle.setVin(vehicle.getVin());
        updatedVehicle.setModel(vehicle.getModel());
        return vehicleRepository.save(updatedVehicle);
    }

    //Deleted vehicle by id
    public void deleteVehicle(long id){
        VehicleEntity deletedVehicle = vehicleRepository.findById(id).get();
        vehicleRepository.delete(deletedVehicle);
    }
}
