package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.ProjectView;
import com.service.ProjectChildService;
import com.service.ProjectService;
import com.service.TokenService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ProjectChildService projectChildService;



    @Autowired
    private TokenService tokenService;

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ProjectEntity project,
                  HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();

//        new EntityWrapper<UserEntity>().eq("username", username)




        EntityWrapper<ProjectEntity> ew = new  EntityWrapper<ProjectEntity>() ;
        TokenEntity token = tokenService.getTokenEntity(request.getHeader("Token"));
        if (token.getTablename().equals("yonghu")){
            ew = (EntityWrapper<ProjectEntity>) new EntityWrapper<ProjectEntity>().eq("wordb",'1');
        }else{

        }

        PageUtils page = projectService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, project), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ProjectEntity project,
                  HttpServletRequest request){
        EntityWrapper<ProjectEntity> ew = new EntityWrapper<ProjectEntity>();
        PageUtils page = projectService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, project), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ProjectEntity project){
        EntityWrapper<ProjectEntity> ew = new EntityWrapper<ProjectEntity>();
        ew.allEq(MPUtil.allEQMapPre( project, "project"));
        return R.ok().put("data", projectService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ProjectEntity project){
        EntityWrapper< ProjectEntity> ew = new EntityWrapper< ProjectEntity>();
        ew.allEq(MPUtil.allEQMapPre( project, "project"));
        ProjectView projectView =  projectService.selectView(ew);
        return R.ok("查询项目成功").put("data", projectView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ProjectEntity project = projectService.selectById(id);

        return R.ok().put("data", project);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/childinfo/{id}")
    public R childinfo(@PathVariable("id") Long id){
        ProjectEntity project = projectService.selectById(id);
        EntityWrapper<ProjectChildEntity> ew = new  EntityWrapper<ProjectChildEntity>() ;
        ew = (EntityWrapper<ProjectChildEntity>) new EntityWrapper<ProjectChildEntity>().eq("projectid",id);
        List<ProjectChildEntity> projectChildEntities = projectChildService.selectList(ew);



        return R.ok().put("data", projectChildEntities);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ProjectEntity project = projectService.selectById(id);

        return R.ok().put("data", project);
    }




    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ProjectEntity project, HttpServletRequest request){
        ProjectEntity user = projectService.selectOne(new EntityWrapper<ProjectEntity>().eq("name", project.getName()));
        if(user!=null) {
            return R.error("项目已存在");
        }
        project.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        project.setAddtime(new Date());
        //ValidatorUtils.validateEntity(project);
        projectService.insert(project);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ProjectEntity project, HttpServletRequest request){
        project.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        //ValidatorUtils.validateEntity(project);
        projectService.insert(project);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ProjectEntity project, HttpServletRequest request){
        //ValidatorUtils.validateEntity(project);
        projectService.updateById(project);//全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        projectService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

  
  
}

