package com.agarciao.backcatalog.service.user;

import com.agarciao.backcatalog.controller.DTO.AuthCreateUserRequest;
import com.agarciao.backcatalog.controller.DTO.AuthLoginRequest;
import com.agarciao.backcatalog.controller.DTO.AuthResponse;
import com.agarciao.backcatalog.persistence.entity.user.RoleEntity;
import com.agarciao.backcatalog.persistence.entity.user.UserEntity;
import com.agarciao.backcatalog.persistence.repository.RoleRepository;
import com.agarciao.backcatalog.persistence.repository.UserRepository;
import com.agarciao.backcatalog.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    LocalDateTime currentDateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.findUserEntityByusername(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario " + username
                + "no existe"));

        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();

        userEntity.getRoles()
                .forEach(role -> authorityList.add(new SimpleGrantedAuthority("ROLE_"
                        .concat(role.getRoleEnum().name()))));

        userEntity.getRoles().stream()
                .flatMap(role -> role.getPermissionList().stream())
                        .forEach(permission -> authorityList.add(new SimpleGrantedAuthority(permission.getName())));

        return new User(userEntity.getUsername(),
        userEntity.getPassword(),
        userEntity.isEnable(),
        userEntity.isAccountNoLocked(),
        userEntity.isAccountNoExpired(),
        userEntity.isCredentialNoExpired(),
        authorityList);
    }

    public AuthResponse createUser (AuthCreateUserRequest createUserRequest){

        String username = createUserRequest.username();
        String password = createUserRequest.password();
        String date = currentDateTime.format(formatter);
        List<String> rolesRequest = createUserRequest.roleRequest().roleListName();

        Set<RoleEntity> roleEntityList = roleRepository.findRoleEntitiesByRoleEnumIn(rolesRequest).stream().collect(Collectors.toSet());

        if (roleEntityList.isEmpty()){
            throw  new IllegalArgumentException("The roles specified does not exist.");
        }

        UserEntity userEntity = UserEntity.builder().username(username).password(passwordEncoder.encode(password))
                .roles(roleEntityList)
                .isEnable(true)
                .accountNoLocked(true)
                .accountNoExpired(true)
                .credentialNoExpired(true)
                .build();

        UserEntity userSaved = userRepository.save(userEntity);

        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();

        userSaved.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_".concat(role.getRoleEnum().name()))));

        userSaved.getRoles().stream().flatMap(role -> role.getPermissionList().stream()).forEach(permission -> authorities.add(new SimpleGrantedAuthority(permission.getName())));

        SecurityContext securityContextHolder = SecurityContextHolder.getContext();
        Authentication authentication =new UsernamePasswordAuthenticationToken(userSaved, null, authorities);

        String accessToken = jwtUtils.createToken(authentication);

        AuthResponse authResponse = new AuthResponse(username, "User created successfully", date, accessToken, true);
        return authResponse;

    }

    public AuthResponse loginUser (AuthLoginRequest authLoginRequest){


        String username = authLoginRequest.username();
        String password = authLoginRequest.password();
        String date = currentDateTime.format(formatter);

        Authentication authentication = this.authenticate(username, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String accessToken = jwtUtils.createToken(authentication);
        AuthResponse authResponse = new AuthResponse(username, "User loged succesfully", date, accessToken, true);

        return authResponse;
    }

    public Authentication authenticate(String username, String password){
        UserDetails userDetails = this.loadUserByUsername(username);

        if (userDetails == null){
            throw new BadCredentialsException("Invalid username or password");
        }

        if (!passwordEncoder.matches(password, userDetails.getPassword())){
            throw new BadCredentialsException("Incorrect Password");
        }

        return new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());
    }
}
