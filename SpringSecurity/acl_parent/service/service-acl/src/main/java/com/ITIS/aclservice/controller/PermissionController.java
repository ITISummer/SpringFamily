package com.ITIS.aclservice.controller;


import com.ITIS.aclservice.entity.Permission;
import com.ITIS.aclservice.service.PermissionService;
import com.ITIS.utils.utils.CRModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 权限 菜单管理
 * </p>
 *
 * @author testjava
 * @since 2020-01-12
 */
@RestController
@RequestMapping("/admin/acl/permission")
//@CrossOrigin
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    //获取全部菜单
    @ApiOperation(value = "查询所有菜单")
    @GetMapping
    public CRModel indexAllPermission() {
        List<Permission> list =  permissionService.queryAllMenu();
        return CRModel.ok().data("children",list);
    }

    @ApiOperation(value = "给角色分配权限")
    @PostMapping("/doAssign")
    public CRModel doAssign(String roleId, String[] permissionId) {
        permissionService.saveRolePermissionRealtionShipGuli(roleId,permissionId);
        return CRModel.ok();
    }

    @ApiOperation(value = "根据角色获取菜单")
    @GetMapping("toAssign/{roleId}")
    public CRModel toAssign(@PathVariable String roleId) {
        List<Permission> list = permissionService.selectAllMenu(roleId);
        return CRModel.ok().data("children", list);
    }

}

