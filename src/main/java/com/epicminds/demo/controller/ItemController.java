package com.epicminds.demo.controller;

import com.epicminds.demo.model.Item;
import com.epicminds.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Sidharth
 */

@RestController
@RequestMapping("api/v1")
public class ItemController {

    @Autowired
    ItemService itemService;

    @PostMapping("/items")
    public ResponseEntity<Object> createItem(@RequestBody Item item){
        return new ResponseEntity<>(itemService.addItem(item),HttpStatus.CREATED);
    }
//    @GetMapping("/items/{id}")
//    public ResponseEntity<Item> getItem(@PathVariable("id") Integer itemId){
//        return ResponseEntity.ok().body(itemService.getItemById(itemId));
//    }






    @GetMapping("/items/{name}")
    public List<Item> getItems(@PathVariable String name){
        return itemService.getItems(name);
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable("id") Integer itemId, @RequestBody Item item){
        return ResponseEntity.ok((itemService.updateItem(itemId,item)));
    }
    @DeleteMapping("items/{id}")
    public ResponseEntity<Object> deleteItem(@PathVariable("id") int itemId){
        itemService.deleteItem(itemId);
        return new ResponseEntity<>("",HttpStatus.NO_CONTENT);
    }
}
