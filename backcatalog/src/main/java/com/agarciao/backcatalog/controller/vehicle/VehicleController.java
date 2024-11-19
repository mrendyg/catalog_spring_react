package com.agarciao.backcatalog.controller.vehicle;

import com.agarciao.backcatalog.persistence.entity.vehicle.VehicleEntity;
import com.agarciao.backcatalog.service.vehicle.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/auth/vehicle")
@PreAuthorize("denyAll()")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    //List of vehicles
    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('READ')")
    public List<VehicleEntity> getListVehicle(){
        return vehicleService.getsListVehicle();
    }

    //Vehicle search by id
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('READ')")
    public VehicleEntity getIdVehicle(@PathVariable long id){
        return vehicleService.getsIdVehicle(id);
    }

    //Create new vehicle
    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN') or hasRole('DEVELOPER')")
    public VehicleEntity createVehicle(@RequestBody VehicleEntity vehicle){
        return vehicleService.createsVehicle(vehicle);
    }

    //Update an exiting vehicle
    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasRole('ADMIN') or hasRole('DEVELOPER')")
    public VehicleEntity updateVehicle(@PathVariable long id, @RequestBody VehicleEntity vehicle){
        return vehicleService.updateVehicle(id, vehicle);
    }

    //Delete vehicle
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ADMIN') or hasRole('DEVELOPER')")
    public void deleteVehicle(@PathVariable long id){
        vehicleService.deleteVehicle(id);
    }

}
