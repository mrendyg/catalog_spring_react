package com.agarciao.backcatalog.persistence.DTO;

import com.agarciao.backcatalog.persistence.entity.user.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserDTO {

    private String username;
    private String password;

}
