package com.agarciao.backcatalog.controller.user;

import com.agarciao.backcatalog.persistence.DTO.UserDTO;
import com.agarciao.backcatalog.persistence.entity.user.UserEntity;
import com.agarciao.backcatalog.persistence.repository.UserRepository;
import com.agarciao.backcatalog.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/auth/users")
@PreAuthorize("denyAll()")
public class UsersController {

    @Autowired
    private UserService userService;

    //List of users
    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN') or hasRole('DEVELOPER')")
    public Iterable<UserEntity> userList(){
        return userService.findAll();
    }

    //User by id
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN') or hasRole('DEVELOPER')")
    public UserEntity userGetId(@PathVariable long id) {
        return userService.findById(id);
    }

    //Creation of users
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    @PreAuthorize("hasAuthority('CREATE')")
    public UserEntity createUser(@RequestBody UserDTO userDTO) {
        UserEntity user = new UserEntity();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        return userService.createsUser(user, userDTO.getPassword());
    }

    //Update users
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('DEVELOPER') or hasRole('ADMIN')")
    public UserEntity updateUser(@PathVariable long id, @RequestBody UserEntity user){
        return userService.updatesUser(id, user);
    }

    //Delete user by id
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('DEVELOPER')")
    public void deleteUser(@PathVariable long id){
        userService.deletesUser(id);
    }

}
