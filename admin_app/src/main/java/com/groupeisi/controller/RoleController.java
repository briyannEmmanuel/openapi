package com.groupeisi.controller;

import com.groupeisi.generated.api.RolesApi;
import com.groupeisi.generated.model.RoleDTO;
import com.groupeisi.generated.model.RolesResultListDTO;
import com.groupeisi.service.AppRolesService;
import io.swagger.annotations.ApiParam;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController implements RolesApi {

    private final AppRolesService appRolesService;
    RoleController(AppRolesService appRolesService) {
        this.appRolesService = appRolesService;
    }
    @Override
    public ResponseEntity<RolesResultListDTO> getAllRoles(Integer currentPage, Integer sizePage) throws Exception {

        RolesResultListDTO rolesResultListDTO = new RolesResultListDTO();
        rolesResultListDTO.setRoleList(appRolesService.getAllAppRole());
        return new ResponseEntity<>(rolesResultListDTO, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<RoleDTO> createRole(@Valid @RequestBody(required = false) RoleDTO roleDTO) throws Exception {
        return new ResponseEntity<>(appRolesService.createAppRoles(roleDTO), HttpStatus.OK);
    }
    @Override
    public ResponseEntity<RoleDTO> getRole(@ApiParam(value = "",required=true) @PathVariable("idRole") Long idRole) throws Exception {
        return new ResponseEntity<>(appRolesService.getAppRole(idRole.intValue()),HttpStatus.OK);
    }
    @Override
    public ResponseEntity<RoleDTO> updateRole(@ApiParam(value = "",required=true) @PathVariable("idRole") Long idRole, @ApiParam(value = ""  )  @Valid @RequestBody(required = false) RoleDTO roleDTO) throws Exception {
        return new ResponseEntity<>(appRolesService.updateAppRoles(idRole.intValue(),roleDTO), HttpStatus.OK);
    }
}
