package com.agarciao.backcatalog.service.vehicle;

import com.agarciao.backcatalog.persistence.entity.vehicle.ItemEntity;
import com.agarciao.backcatalog.persistence.repository.ItemRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    //List of Item
    public List<ItemEntity> getsListItem(){
        return itemRepository.findAll();
    }

    //Item by id
    public ItemEntity getsIdItem(long id){
        return itemRepository.findById(id).orElse(null);
    }

    //Create item
    public ItemEntity createsItem(ItemEntity item){
        return itemRepository.save(item);
    }

    //Update item
    public ItemEntity updatesItem(long id, @NotNull ItemEntity item){
        ItemEntity updatedItem = itemRepository.findById(id).get();
        updatedItem.setPartname(item.getPartname());
        updatedItem.setDescription(item.getDescription());
        updatedItem.setImage(item.getImage());
        updatedItem.setDiagram(item.getDiagram());
        return itemRepository.save(updatedItem);
    }

    //Delete Item
    public void deletesItem(long id){
        ItemEntity deletedItem = itemRepository.findById(id).get();
        itemRepository.delete(deletedItem);
    }

}
