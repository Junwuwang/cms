package com.briup.cms.web.controller;

import com.briup.cms.bean.Link;
import com.briup.cms.service.ILinkService;
import com.briup.cms.util.Message;
import com.briup.cms.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/link")
@Api(description = "链接管理")
public class LinkController {

    @Autowired
    private ILinkService linkService;

    @PostMapping("/add")
    @ApiOperation("添加链接")
    public Message addLink(Link link) {
        linkService.saveOrUpdateLink(link);
        return MessageUtil.success();
    }

    @GetMapping("/delete")
    @ApiOperation("删除链接")
    @ApiImplicitParam(name = "id",value = "链接id",paramType = "query",dataType = "int",required = true)
    public  Message deleteLink(int id) {
        linkService.delete(id);
        return  MessageUtil.success();
    }

    @GetMapping("/queryid")
    @ApiOperation("根据id查询")
    @ApiImplicitParam(name = "id",value = "链接id",paramType = "query",dataType = "int",required = true)
    public Message<Link> queryById(int id) {
        Link link = linkService.queryById(id);
        return MessageUtil.success(link);

    }

    @GetMapping("/update")
    @ApiOperation("更新")
    public  Message update(Link link) {
        linkService.saveOrUpdateLink(link);
        return MessageUtil.success();
    }

    @GetMapping("/getAll")
    @ApiOperation("获取所有链接数据")
    public  Message<List<Link>> getAll() {
        List<Link> links = linkService.getAllLink();
        return MessageUtil.success(links);
    }
}
