package com.epicminds.demo.repository;

import com.epicminds.demo.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Sidharth
 */
@Repository
public interface ItemRepo extends JpaRepository<Item,Integer> {

    //Item findByName(String name);


    List<Item> findByName(String name);
}
