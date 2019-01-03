package com.wllfengshu.jbot.rest;

import com.wllfengshu.jbot.entity.ConnectInfo;
import com.wllfengshu.jbot.entity.DBInfo;
import com.wllfengshu.jbot.service.JbotService;
import com.wllfengshu.jbot.utils.LogUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
@RequestMapping("/jbot")
public class JbotRest {

    @Autowired
    private JbotService jbotService;

    @ApiOperation(value = "设置项目",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "projectName", value = "项目名（eg:jbot）", required = true, dataType = "string",paramType = "query"),
            @ApiImplicitParam(name = "packageName", value = "包名（包含项目名,eg:com.wllfengshu.jbot）", required = true, dataType = "string",paramType = "query")
    })
    @ApiResponses({
            @ApiResponse(code=400, message="IllegalParam")
    })
    @RequestMapping(value = "/setting",method = RequestMethod.POST)
    public Map<String, Object> settingProject(
            @RequestParam(value = "projectName") String projectName,
            @RequestParam(value = "packageName") String packageName,
            @RequestBody @ApiParam(value = "数据库连接实体类（数据库连接信息）",required = true) ConnectInfo connectInfo,
            HttpServletRequest request,
            HttpServletResponse response) {
        LogUtil.info(this,"getTableFromDB-------->projectName:%s,packageName:%s,connectInfo:%s",projectName,packageName,connectInfo);
        return jbotService.settingProject(projectName,packageName,connectInfo);
    }

    @ApiOperation(value = "生成项目",httpMethod = "POST")
    @ApiResponses({
            @ApiResponse(code=400, message="IllegalParam")
    })
    @RequestMapping(value = "/produce",method = RequestMethod.POST)
    public Map<String, Object> produceProject(
            @RequestBody @ApiParam(value = "数据库实体类（选择的表的集合）",required = true) DBInfo dbInfo,
            HttpServletRequest request,
            HttpServletResponse response) {
        LogUtil.info(this,"produceProject-------->dbInfo:%s",dbInfo);
        return jbotService.produceProject(dbInfo);
    }
}