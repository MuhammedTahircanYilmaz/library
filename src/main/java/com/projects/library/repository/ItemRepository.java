package com.projects.library.repository;

import com.projects.library.model.Media;
import com.projects.library.model.Status;
import com.projects.library.model.Type;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends ListCrudRepository<Media,Long> {

    List<Media> findAllByTitleContains(String keyword);


    @Query("SELECT m FROM media m WHERE m.username =:username")
    List<Media> findByUsername(@Param("username") String username);

    @Query("SELECT m FROM media m where m.status =:status AND m.username =:username")
    List<Media> findByStatusAndUsername(@Param("status") Status status, @Param("username") String username);

    @Query("SELECT m FROM media m where m.item_type =:itemType AND m.username =:username")
    List<Media> findByItemTypeAndUsername(@Param("itemType") Type itemType, @Param("username") String username);

}

