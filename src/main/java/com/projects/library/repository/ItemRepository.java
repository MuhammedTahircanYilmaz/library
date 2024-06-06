package com.projects.library.repository;

import com.projects.library.model.Item;
import com.projects.library.model.Status;
import com.projects.library.model.Type;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends ListCrudRepository<Item,Integer> {

    List<Item> findAllByTitleContains(String keyword);

    @Query("SELECT * FROM Item where status = :status")
    List<Item> listByStatus(@Param("status") Status status);

    @Query("SELECT * FROM Item where item_type = :type")
    List<Item> listByType(@Param("type") Type type);
}

