package com.agarciao.backcatalog.persistence.entity.user;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;
    private String password;

    @Column(name = "is_enable")
    private boolean isEnable = true;//esta habilitado

    @Column(name = "account_No_Expired")
    private boolean accountNoExpired = true; //la cuenta no ha expirado

    @Column(name = "account_No_Locked")
    private boolean acountNoLocked = true; //La cuenta no esta bloqueada

    @Column(name = "credential_No_Expired")
    private boolean credentialNoExpired = true; //las credenciales no estan expidaras

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles= new HashSet<>();
    //tabla de unificacion de usuario con sus respectivos roles

    @Column(name = "DataTime_Create")
    private LocalDateTime DateCreate;

}
