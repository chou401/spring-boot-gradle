package io.chou401.system.controller;

import io.chou401.common.entity.sys.SysRole;
import io.chou401.common.page.Paging;
import io.chou401.common.query.sys.SysRoleQuery;
import io.chou401.common.vo.sys.SysRoleVo;
import io.chou401.framework.annotation.Permission;
import io.chou401.framework.response.ApiResult;
import io.chou401.system.dto.RoleMenusDto;
import io.chou401.system.dto.SysRoleDto;
import io.chou401.system.service.SysMenuService;
import io.chou401.system.service.SysRoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 系统角色 控制器
 * {@code @author}  chou401
 * {@code @date} 2022-12-26
 */
@Slf4j
@RestController
@Tag(name = "系统角色")
@RequestMapping("/admin/sysRole")
public class SysRoleController {

    private final SysRoleService sysRoleService;

    private final SysMenuService sysMenuService;

    public SysRoleController(SysRoleService sysRoleService, SysMenuService sysMenuService) {
        this.sysRoleService = sysRoleService;
        this.sysMenuService = sysMenuService;
    }

    /**
     * 添加系统角色
     *
     * @param dto
     * @return
     * @throws Exception
     */
    @PostMapping("/addSysRole")
    @Operation(summary = "添加系统角色")
    @Permission("sys:role:add")
    public ApiResult addSysRole(@Valid @RequestBody SysRoleDto dto) throws Exception {
        boolean flag = sysRoleService.addSysRole(dto);
        return ApiResult.result(flag);
    }

    /**
     * 修改系统角色
     *
     * @param dto
     * @return
     * @throws Exception
     */
    @PostMapping("/updateSysRole")
    @Operation(summary = "修改系统角色")
    @Permission("sys:role:update")
    public ApiResult updateSysRole(@Valid @RequestBody SysRoleDto dto) throws Exception {
        boolean flag = sysRoleService.updateSysRole(dto);
        return ApiResult.result(flag);
    }

    /**
     * 删除系统角色
     *
     * @param id
     * @return
     * @throws Exception
     */
    @PostMapping("/deleteSysRole/{id}")
    @Operation(summary = "删除系统角色")
    @Permission("sys:role:delete")
    public ApiResult deleteSysRole(@PathVariable Long id) throws Exception {
        boolean flag = sysRoleService.deleteSysRole(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取系统角色详情
     *
     * @param id
     * @return
     * @throws Exception
     */
    @PostMapping("/getSysRole/{id}")
    @Operation(summary = "系统角色详情")
    @Permission("sys:role:info")
    public ApiResult<SysRoleVo> getSysRole(@PathVariable Long id) throws Exception {
        SysRoleVo sysRoleVo = sysRoleService.getSysRoleById(id);
        return ApiResult.success(sysRoleVo);
    }

    /**
     * 系统角色分页列表
     *
     * @param query
     * @return
     * @throws Exception
     */
    @PostMapping("/getSysRolePage")
    @Operation(summary = "系统角色分页列表")
    @Permission("sys:role:list")
    public ApiResult<Paging<SysRoleVo>> getSysRolePage(@Valid @RequestBody SysRoleQuery query) throws Exception {
        Paging<SysRoleVo> paging = sysRoleService.getSysRolePage(query);
        return ApiResult.success(paging);
    }

    /**
     * 系统所有角色列表
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/getSysRoleAllList")
    @Operation(summary = "系统所有角色列表")
    public ApiResult<List<SysRole>> getSysRoleAllList() throws Exception {
        List<SysRole> list = sysRoleService.getSysRoleAllList();
        return ApiResult.success(list);
    }

    /**
     * 设置角色权限
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/setRoleMenus")
    @Operation(summary = "设置角色权限")
    @Permission("sys:role:set-role-menus")
    public ApiResult setRoleMenus(@Valid @RequestBody RoleMenusDto roleMenusDto) throws Exception {
        boolean flag = sysRoleService.setRoleMenus(roleMenusDto);
        return ApiResult.success(flag);
    }

    /**
     * 获取角色权限ID集合
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/getMenuIdsByRoleId/{roleId}")
    @Operation(summary = "获取角色权限ID集合")
    @Permission("sys:role:menu-ids")
    public ApiResult getMenuIdsByRoleId(@PathVariable Long roleId) throws Exception {
        List<Long> list = sysMenuService.getMenuIdsByRoleId(roleId);
        return ApiResult.success(list);
    }

}
