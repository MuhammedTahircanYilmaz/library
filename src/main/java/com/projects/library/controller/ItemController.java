package com.projects.library.controller;

import com.projects.library.repository.CustomUserEntityDetails;
import com.projects.library.model.Media;
import com.projects.library.model.Status;
import com.projects.library.model.Type;
import com.projects.library.repository.ItemRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("{username}/api/items")
@CrossOrigin
public class ItemController {

    private final ItemRepository itemRepository;
    private UserEntityController userEntityController;
    private final UserDetails userEntityDetails;


    public ItemController(ItemRepository itemRepository, UserEntityController userEntityController, CustomUserEntityDetails userEntityDetails) {
        this.itemRepository = itemRepository;
        this.userEntityController = userEntityController;
        this.userEntityDetails = userEntityDetails;
    }

    @GetMapping("")
    public ResponseEntity<?> findAll(@PathVariable("username") String pathUsername) {
        String username = userEntityController.getCurrentUsername();
        if (!pathUsername.equals(username)){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access Denied!");
        }
        List<Media> items = itemRepository.findByUsername(username);
        return ResponseEntity.ok(items);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Media media){
        itemRepository.save(media);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Media media, Long id){
        if(!itemRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Item Does Not Exist");
        }
        itemRepository.save(media);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        itemRepository.deleteById(id);
    }

    @GetMapping("/filter/{keyword}")
    public List<Media> findByTitle(@PathVariable String keyword){
        return itemRepository.findAllByTitleContains(keyword);
    }

    @GetMapping("/filter/status/{status}")
    public List<Media> findByStatus( @PathVariable Status status){
        if(userEntityController != null){
            String username = userEntityController.getCurrentUsername();
            return itemRepository.findByStatusAndUsername(status,username);
        }
        else{
            throw new NullPointerException("I don't know what happened here");
        }
    }

    @GetMapping("/filter/itemType/{itemType}")
    public List<Media> findByItemType(@PathVariable Type itemType){
        if(userEntityController != null){
            String username = userEntityController.getCurrentUsername();
            return itemRepository.findByItemTypeAndUsername(itemType, username);
        }
        else{
            throw new NullPointerException("I don't know what happened here");
        }
    }
}
