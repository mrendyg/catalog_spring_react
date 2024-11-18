package com.agarciao.backcatalog;

import com.agarciao.backcatalog.persistence.entity.user.PermissionEntity;
import com.agarciao.backcatalog.persistence.entity.user.RoleEntity;
import com.agarciao.backcatalog.persistence.entity.user.RoleEnum;
import com.agarciao.backcatalog.persistence.entity.user.UserEntity;
import com.agarciao.backcatalog.persistence.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class BackcatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackcatalogApplication.class, args);
	}
//
//
//	@Bean
//	CommandLineRunner init(UserRepository userRepository){
//		return args -> {
//			//Create permissionS
//			PermissionEntity createPermission = PermissionEntity.builder()
//					.name("CREATE")
//					.build();
//
//			PermissionEntity readPermission = PermissionEntity.builder()
//					.name("READ")
//					.build();
//
//			PermissionEntity updatePermission = PermissionEntity.builder()
//					.name("UPDATE")
//					.build();
//
//			PermissionEntity deletePermission = PermissionEntity.builder()
//					.name("DELETE")
//					.build();
//
//
//			//Create Role
//			RoleEntity adminRole = RoleEntity.builder()
//					.roleEnum(RoleEnum.ADMIN)
//					.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission))
//					.build();
//
//			RoleEntity userRole = RoleEntity.builder()
//					.roleEnum(RoleEnum.USER)
//					.permissionList(Set.of(updatePermission, readPermission))
//					.build();
//
//			RoleEntity invitedRole = RoleEntity.builder()
//					.roleEnum(RoleEnum.INVITED)
//					.permissionList(Set.of(readPermission))
//					.build();
//
//			RoleEntity developerRole = RoleEntity.builder()
//					.roleEnum(RoleEnum.DEVELOPER)
//					.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission))
//					.build();
//
//			//Create users
//			UserEntity userAndy = UserEntity.builder()
//					.username("Andy")
//					.password("$2a$10$nbUS.NBQi9M87Zd/Hw3qzOnuvB314pia8WHLxMdu13ak4qtwYlmx2")
//					.isEnable(true)
//					.accountNoExpired(true)
//					.accountNoLocked(true)
//					.credentialNoExpired(true)
//					.roles(Set.of(developerRole))
//					.DateCreate(LocalDateTime.now())
//					.build();
//
//			UserEntity userCristian = UserEntity.builder()
//					.username("Cristian")
//					.password("$2a$10$nbUS.NBQi9M87Zd/Hw3qzOnuvB314pia8WHLxMdu13ak4qtwYlmx2")
//					.isEnable(true)
//					.accountNoExpired(true)
//					.accountNoLocked(true)
//					.credentialNoExpired(true)
//					.roles(Set.of(adminRole))
//					.DateCreate(LocalDateTime.now())
//					.build();
//
//			UserEntity userLeo = UserEntity.builder()
//					.username("Leo")
//					.password("$2a$10$nbUS.NBQi9M87Zd/Hw3qzOnuvB314pia8WHLxMdu13ak4qtwYlmx2")
//					.isEnable(true)
//					.accountNoExpired(true)
//					.accountNoLocked(true)
//					.credentialNoExpired(true)
//					.roles(Set.of(adminRole))
//					.DateCreate(LocalDateTime.now())
//					.build();
//
//			UserEntity userJuan = UserEntity.builder()
//					.username("Juan")
//					.password("$2a$10$nbUS.NBQi9M87Zd/Hw3qzOnuvB314pia8WHLxMdu13ak4qtwYlmx2")
//					.isEnable(true)
//					.accountNoExpired(true)
//					.accountNoLocked(true)
//					.credentialNoExpired(true)
//					.roles(Set.of(adminRole))
//					.DateCreate(LocalDateTime.now())
//					.build();
//
//			UserEntity userPablo = UserEntity.builder()
//					.username("Pablo")
//					.password("$2a$10$7lselJxx/vhxOqlt.f09pe5wSugKbk1Dbfn5dblmaSeMpJbpaTSHC")
//					.isEnable(true)
//					.accountNoExpired(true)
//					.accountNoLocked(true)
//					.credentialNoExpired(true)
//					.roles(Set.of(invitedRole))
//					.DateCreate(LocalDateTime.now())
//					.build();
//
//			UserEntity userDavid = UserEntity.builder()
//					.username("David")
//					.password("$2a$10$nbUS.NBQi9M87Zd/Hw3qzOnuvB314pia8WHLxMdu13ak4qtwYlmx2")
//					.isEnable(true)
//					.accountNoExpired(true)
//					.accountNoLocked(true)
//					.credentialNoExpired(true)
//					.roles(Set.of(userRole))
//					.DateCreate(LocalDateTime.now())
//					.build();
//
//			userRepository.saveAll(List.of(userAndy, userLeo, userCristian, userJuan, userPablo, userDavid));
//		};
//
//	}

<<<<<<< HEAD
=======

/*
	@Bean
	CommandLineRunner init(UserRepository userRepository){
		return args -> {
			//Create permissionS
			PermissionEntity createPermission = PermissionEntity.builder()
					.name("CREATE")
					.build();

			PermissionEntity readPermission = PermissionEntity.builder()
					.name("READ")
					.build();

			PermissionEntity updatePermission = PermissionEntity.builder()
					.name("UPDATE")
					.build();

			PermissionEntity deletePermission = PermissionEntity.builder()
					.name("DELETE")
					.build();


			//Create Role
			RoleEntity adminRole = RoleEntity.builder()
					.roleEnum(RoleEnum.ADMIN)
					.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission))
					.build();

			RoleEntity userRole = RoleEntity.builder()
					.roleEnum(RoleEnum.USER)
					.permissionList(Set.of(updatePermission, readPermission))
					.build();

			RoleEntity invitedRole = RoleEntity.builder()
					.roleEnum(RoleEnum.INVITED)
					.permissionList(Set.of(readPermission))
					.build();

			RoleEntity developerRole = RoleEntity.builder()
					.roleEnum(RoleEnum.DEVELOPER)
					.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission))
					.build();

			//Create users
			UserEntity userAndy = UserEntity.builder()
					.username("Andy")
					.password("$2a$10$zoz3iAn//lTGHVvvZseIXuGTXRK/giEY28.u60pMW2JlUz5mUOyfC")
					.isEnable(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(developerRole))
					.DateCreate(LocalDateTime.now())
					.build();

			UserEntity userCristian = UserEntity.builder()
					.username("Cristian")
					.password("$2a$10$zoz3iAn//lTGHVvvZseIXuGTXRK/giEY28.u60pMW2JlUz5mUOyfC")
					.isEnable(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(adminRole))
					.DateCreate(LocalDateTime.now())
					.build();

			UserEntity userLeo = UserEntity.builder()
					.username("Leo")
					.password("$2a$10$zoz3iAn//lTGHVvvZseIXuGTXRK/giEY28.u60pMW2JlUz5mUOyfC")
					.isEnable(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(adminRole))
					.DateCreate(LocalDateTime.now())
					.build();

			UserEntity userJuan = UserEntity.builder()
					.username("Juan")
					.password("$2a$10$zoz3iAn//lTGHVvvZseIXuGTXRK/giEY28.u60pMW2JlUz5mUOyfC")
					.isEnable(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(adminRole))
					.DateCreate(LocalDateTime.now())
					.build();

			UserEntity userPablo = UserEntity.builder()
					.username("Pablo")
					.password("$2a$10$zoz3iAn//lTGHVvvZseIXuGTXRK/giEY28.u60pMW2JlUz5mUOyfC")
					.isEnable(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(invitedRole))
					.DateCreate(LocalDateTime.now())
					.build();

			UserEntity userDavid = UserEntity.builder()
					.username("David")
					.password("$2a$10$zoz3iAn//lTGHVvvZseIXuGTXRK/giEY28.u60pMW2JlUz5mUOyfC")
					.isEnable(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(userRole))
					.DateCreate(LocalDateTime.now())
					.build();

			userRepository.saveAll(List.of(userAndy, userLeo, userCristian, userJuan, userPablo, userDavid));
		};

	}

*/
>>>>>>> d3118a9d8db03d9761765bad310b87b5142f054e

}
