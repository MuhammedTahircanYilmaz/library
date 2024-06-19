package com.projects.library.repository;

import com.projects.library.model.Item;
import com.projects.library.model.Status;
import com.projects.library.model.Type;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends ListCrudRepository<Item,Long> {

    List<Item> findAllByTitleContains(String keyword);

    @Query("SELECT * FROM Item where status = :status")
    List<Item> findByStatus(@Param("status") Status status);

    @Query("SELECT * FROM Item where itemType = :itemType")
    List<Item> findByItemType(@Param("itemType") Type itemType);


}

