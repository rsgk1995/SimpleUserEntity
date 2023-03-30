package com.epicminds.demo.service;

import com.epicminds.demo.exception.ItemNotFoundException;
import com.epicminds.demo.model.Item;
import com.epicminds.demo.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author Sidharth
 */
@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    ItemRepo itemRepo;

    @Override
    public Item addItem(Item item) {
        return itemRepo.save(item);
    }

    @Override
    public Item getItemById(Integer itemId) {
        return itemRepo.findById(itemId).orElseThrow(
                () -> new ItemNotFoundException("No such item ("+itemId+") found")
        );
    }

    @Override
    public Item getItemByName(String name) throws ItemNotFoundException {
        return null;
    }


//      @Override
//    public Item getItemByName(String name) throws ItemNotFoundException{
//        try {
//            return itemRepo.findByName(name);
//        }catch (Exception e) {
//            throw new ItemNotFoundException(e.getMessage());
//        }
//
//    }

    @Override
    public List<Item> getItems(String name) {
        return itemRepo.findByName(name);
    }

    @Override
    public Item updateItem(Integer itemId, Item item) {
        Item item1 = itemRepo.findById(itemId).orElseThrow(
                () -> new ItemNotFoundException("No such item ("+itemId+") found")
        );
        item1.setName(Objects.isNull(item.getName())?item1.getName():item.getName());
        item1.setQuantity(Objects.isNull(item.getQuantity())?item1.getQuantity():item.getQuantity());
        item1.setPrice(Objects.isNull(item.getPrice())?item1.getPrice():item.getPrice());
        return itemRepo.save(item1);
    }

    @Override
    public void deleteItem(Integer itemId) {
        Item it = itemRepo.findById(itemId).orElseThrow(
                () -> new ItemNotFoundException("No such item found by id = "+itemId)
        );
        itemRepo.delete(it);
    }

}
