package com.groupeisi.controller;

import com.groupeisi.generated.api.UsersApi;
import com.groupeisi.generated.model.UserDTO;
import com.groupeisi.generated.model.UsersResultListDTO;
import com.groupeisi.service.AppUserService;
import io.swagger.annotations.ApiParam;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UsersApi {
    private final AppUserService appUserService;
    UserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }
    @Override
    public ResponseEntity<UsersResultListDTO> getAllUsers(Integer currentPage, Integer sizePage) throws Exception {

        UsersResultListDTO usersResultListDTO = new UsersResultListDTO();
        usersResultListDTO.setUserList(appUserService.getAllAppUser());
        return new ResponseEntity<>(usersResultListDTO, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody(required = false) UserDTO userDTO) throws Exception {
        return new ResponseEntity<>(appUserService.createAppUser(userDTO), HttpStatus.OK);
    }
    @Override
    public ResponseEntity<UserDTO> getUser(@ApiParam(value = "",required=true) @PathVariable("idUser") Long idUser) throws Exception {
        return new ResponseEntity<>(appUserService.getAppUser(idUser.intValue()),HttpStatus.OK);
    }
    @Override
    public ResponseEntity<UserDTO> updateUser(@ApiParam(value = "",required=true) @PathVariable("idUser") Long idUser,@ApiParam(value = ""  )  @Valid @RequestBody(required = false) UserDTO userDTO) throws Exception {
        return new ResponseEntity<>(appUserService.updateAppUser(idUser.intValue(),userDTO),HttpStatus.OK);
    }
}
