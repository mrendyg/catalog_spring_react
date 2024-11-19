package com.agarciao.backcatalog.controller.user;

import com.agarciao.backcatalog.persistence.DTO.UserDTO;
import com.agarciao.backcatalog.persistence.entity.user.UserEntity;
import com.agarciao.backcatalog.persistence.repository.UserRepository;
import com.agarciao.backcatalog.service.user.UserService;
import lombok.AllArgsConstructor;
import org.aspectj.lang.annotation.DeclareError;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/auth/users")
@PreAuthorize("denyAll()")
public class UsersController {

    private UserService userService;

    //Lista de usuarios
    private UserRepository userRepository;


    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN') or hasRole('DEVELOPER')")
    public Iterable<UserEntity> userList(){
        return userService.findAll();
    }

    //busqueda de ususarios por ID
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN') or hasRole('DEVELOPER')")
    public UserEntity userGetId(@PathVariable long id) {
        return userService.findById(id);
    }

    //CReacion de usuarios
<<<<<<< HEAD
    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.OK)
=======
    @PostMapping(value = "/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
>>>>>>> d3118a9d8db03d9761765bad310b87b5142f054e
    @PreAuthorize("hasRole('ADMIN') or hasRole('DEVELOPER')")
    public UserEntity createUser(@RequestBody UserDTO userDTO){
        UserEntity user = new UserEntity();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        return userService.createsUser(user, userDTO.getPassword());
    }

    //Actualizacion de asuarios
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('DEVELOPER') or hasRole('ADMIN')")
    public UserEntity updateUser(@PathVariable long id, @RequestBody UserEntity user){
        return userService.updatesUser(id, user);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('DEVELOPER')")
    public void deleteUser(@PathVariable long id){
        userService.deletesUser(id);
    }

}
