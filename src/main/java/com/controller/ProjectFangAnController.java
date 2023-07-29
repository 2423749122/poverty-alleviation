package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.ProjectChildEntity;
import com.entity.ProjectEntity;
import com.entity.ProjectFangAnEntity;
import com.entity.TokenEntity;
import com.entity.view.ProjectFangAnView;
import com.service.ProjectChildService;
import com.service.ProjectFangAnService;
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


/**
 * 
 * 后端接口
 * @author 
 * @email 
 * @date 
 */
@RestController
@RequestMapping("/fangan")
public class ProjectFangAnController {
    @Autowired
    private ProjectFangAnService projectFangAnService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private ProjectChildService	 projectChildService;

	@Autowired
	private TokenService tokenService;


	/**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ProjectFangAnEntity projectFangAn,
		HttpServletRequest request){
        EntityWrapper<ProjectFangAnEntity> ew = new EntityWrapper<ProjectFangAnEntity>();
		TokenEntity token = tokenService.getTokenEntity(request.getHeader("Token"));
		if (token.getTablename().equals("yonghu")){
			ew = (EntityWrapper<ProjectFangAnEntity>) new EntityWrapper<ProjectFangAnEntity>().eq("wordb",'1');
		}else{

		}
		PageUtils page = projectFangAnService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, projectFangAn), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ProjectFangAnEntity projectFangAn, 
		HttpServletRequest request){
        EntityWrapper<ProjectFangAnEntity> ew = new EntityWrapper<ProjectFangAnEntity>();
		PageUtils page = projectFangAnService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, projectFangAn), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ProjectFangAnEntity projectFangAn){
       	EntityWrapper<ProjectFangAnEntity> ew = new EntityWrapper<ProjectFangAnEntity>();
      	ew.allEq(MPUtil.allEQMapPre( projectFangAn, "projectFangAn")); 
        return R.ok().put("data", projectFangAnService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ProjectFangAnEntity projectFangAn){
        EntityWrapper< ProjectFangAnEntity> ew = new EntityWrapper< ProjectFangAnEntity>();
 		ew.allEq(MPUtil.allEQMapPre( projectFangAn, "projectFangAn")); 
		ProjectFangAnView projectFangAnView =  projectFangAnService.selectView(ew);
		return R.ok("查询热门新闻成功").put("data", projectFangAnView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ProjectFangAnEntity projectFangAn = projectFangAnService.selectById(id);

		projectFangAnService.updateById(projectFangAn);
        return R.ok().put("data", projectFangAn);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ProjectFangAnEntity projectFangAn = projectFangAnService.selectById(id);

		projectFangAnService.updateById(projectFangAn);
        return R.ok().put("data", projectFangAn);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ProjectFangAnEntity projectFangAn, HttpServletRequest request){
    	projectFangAn.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(projectFangAn);
        projectFangAnService.insert(projectFangAn);
		ProjectEntity projectEntity = projectService.selectById(projectFangAn.getProjectid());
		Float aFloat = Float.valueOf(projectEntity.getWorda());
		Float aFloat1 = Float.valueOf(projectFangAn.getPrice());
		projectEntity.setWorda(String.valueOf(aFloat+aFloat1));
		projectService.updateById(projectEntity);
		ProjectChildEntity childEntity = new ProjectChildEntity();
		childEntity.setAddtime(new Date());
		childEntity.setFanganid(projectFangAn.getId());
		childEntity.setPinkunhu(projectFangAn.getPinkunhu());
		childEntity.setPinkunhuname(projectFangAn.getPinkunhuname());
		childEntity.setPrice(projectFangAn.getPrice());
		childEntity.setYonghuname(projectFangAn.getYonghuname());
		childEntity.setProjectid(projectEntity.getId());
		childEntity.setName(projectFangAn.getBiaoti());
		projectChildService.insert(childEntity);

		return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ProjectFangAnEntity projectFangAn, HttpServletRequest request){
    	projectFangAn.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(projectFangAn);
        projectFangAnService.insert(projectFangAn);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ProjectFangAnEntity projectFangAn, HttpServletRequest request){
        //ValidatorUtils.validateEntity(projectFangAn);
        projectFangAnService.updateById(projectFangAn);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        projectFangAnService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<ProjectFangAnEntity> wrapper = new EntityWrapper<ProjectFangAnEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = projectFangAnService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,ProjectFangAnEntity projectFangAn, HttpServletRequest request,String pre){
        EntityWrapper<ProjectFangAnEntity> ew = new EntityWrapper<ProjectFangAnEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = projectFangAnService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, projectFangAn), params), params));
        return R.ok().put("data", page);
    }


}
