package com.agarciao.backcatalog.controller.vehicle;

import com.agarciao.backcatalog.persistence.entity.vehicle.ItemEntity;
import com.agarciao.backcatalog.service.vehicle.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth/item")
@PreAuthorize("denyAll()")
public class ItemController {

    @Autowired
    private ItemService itemService;

    //List of Items
    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('READ')")
    public List<ItemEntity> getListItem(){
        return itemService.getsListItem();
    }

    //Item by id
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('READ')")
    public ItemEntity getIdItem(@PathVariable long id){
        return itemService.getsIdItem(id);
    }

    //Create item
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('CREATE')")
    public ItemEntity createItem(@RequestBody ItemEntity item){
        return itemService.createsItem(item);
    }

    //Update Item
    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAuthority('UPDATE')")
    public ItemEntity updateItem(@PathVariable long id, @RequestBody ItemEntity item){
        return itemService.updatesItem(id, item);
    }

    //delete item
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ADMIN') or hasRole('DEVELOPER')")
    public void deleteItem (@PathVariable long id){
        itemService.deletesItem(id);
    }

}