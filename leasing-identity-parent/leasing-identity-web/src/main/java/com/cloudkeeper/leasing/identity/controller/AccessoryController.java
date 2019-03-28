package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.identity.dto.accessory.AccessoryDTO;
import com.cloudkeeper.leasing.identity.dto.accessory.AccessorySearchable;
import com.cloudkeeper.leasing.identity.vo.AccessoryVO;
import com.cloudkeeper.leasing.base.model.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 系统附件 controller
 * @author asher
 */
@Api(value = "系统附件", tags = "系统附件")
@RequestMapping("/accessory")
public interface AccessoryController {

    /**
     * 查询
     * @param id 系统附件id
     * @return 系统附件 VO
     */
    @ApiOperation(value = "查询", notes = "查询", position = 1)
    @GetMapping("/{id}id")
    Result<AccessoryVO> findOne(@ApiParam(value = "系统附件id", required = true) @PathVariable String id);

    /**
     * 新增
     * @param accessoryDTO 系统附件 DTO
     * @return 系统附件 VO
     */
    @ApiOperation(value = "新增", notes = "新增", position = 2)
    @PostMapping("/")
    Result<AccessoryVO> add(@ApiParam(value = "系统附件 DTO", required = true) AccessoryDTO accessoryDTO, MultipartFile file) throws IOException;

    /**
     * 更新
     * @param id 系统附件id
     * @param accessoryDTO 系统附件 DTO
     * @return 系统附件 VO
     */
    @ApiOperation(value = "更新", notes = "更新", position = 3)
    @PutMapping("/{id}id")
    Result<AccessoryVO> update(@ApiParam(value = "系统附件id", required = true) @PathVariable String id,
                               @ApiParam(value = "系统附件 DTO", required = true) @RequestBody @Validated AccessoryDTO accessoryDTO);

    /**
     * 删除
     * @param id 系统附件id
     * @return 删除结果
     */
    @ApiOperation(value = "删除", notes = "删除", position = 4)
    @DeleteMapping("/{id}id")
    Result delete(@ApiParam(value = "系统附件id", required = true) @PathVariable String id);

    /**
     * 列表查询
     * @param accessorySearchable 系统附件查询条件
     * @param sort 排序条件
     * @return 系统附件 VO 集合
     */
    @ApiOperation(value = "列表查询", notes = "列表查询<br/>sort：排序字段，默认是asc排序方式，可以不写，格式：sort=code,asc&sort=name&sort=note,desc", position = 5)
    @PostMapping("/list")
    Result<List<AccessoryVO>> list(@ApiParam(value = "系统附件查询条件", required = true) @RequestBody AccessorySearchable accessorySearchable,
                                   @ApiParam(value = "排序条件", required = true) Sort sort);

    /**
     * 分页查询
     * @param accessorySearchable 系统附件查询条件
     * @param pageable 分页条件
     * @return 系统附件 VO 分页
     */
    @ApiOperation(value = "分页查询", notes = "分页查询<br/>page：第几页，默认为0，是第一页<br/>size：分页大小, 默认为10<br/>sort：排序字段，默认是asc排序方式，可以不写，格式：sort=code,asc&sort=name&sort=note,desc", position = 6)
    @PostMapping("/page")
    Result<Page<AccessoryVO>> page(@ApiParam(value = "系统附件查询条件", required = true) @RequestBody AccessorySearchable accessorySearchable,
                                   @ApiParam(value = "分页参数", required = true) Pageable pageable);

    /**
     * 文件下载
     * @author asher
     * @param id 附件id
     * @param response response
     * @throws IOException 异常
     */
    @GetMapping(value = "/download/{id}")
    void download(@PathVariable("id") String id, HttpServletResponse response) throws IOException;

    @PostMapping(value = "/batch")
    @ApiOperation(value = "批量上传", notes = "批量上传", position = 6)
    Result<List<AccessoryVO>> addList(@ApiParam(value = "系统附件 DTO", required = true) List<AccessoryDTO> accessoryDTOs, @RequestParam("files") MultipartFile[] files) throws IOException;
}
