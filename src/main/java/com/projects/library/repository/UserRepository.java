package com.projects.library.repository;

import com.projects.library.model.Item;
import com.projects.library.model.Status;
import com.projects.library.model.Type;
import com.projects.library.model.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    @Query("SELECT * FROM Item where status = :status")
    List<Item> findByUsername(@Param("username"));

    @Query("SELECT * FROM Item where itemType = :itemType")
    List<Item> findByItemType(@Param("itemType") Type itemType);
}
