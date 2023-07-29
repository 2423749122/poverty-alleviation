package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.ProjectFangAnEntity;
import com.entity.view.ProjectFangAnView;
import com.entity.vo.ProjectFangAnVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 热门新闻
 *
 * @author 
 * @email 
 * @date 
 */
public interface ProjectFangAnService extends IService<ProjectFangAnEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ProjectFangAnVO> selectListVO(Wrapper<ProjectFangAnEntity> wrapper);
   	
   	ProjectFangAnVO selectVO(@Param("ew") Wrapper<ProjectFangAnEntity> wrapper);
   	
   	List<ProjectFangAnView> selectListView(Wrapper<ProjectFangAnEntity> wrapper);
   	
   	ProjectFangAnView selectView(@Param("ew") Wrapper<ProjectFangAnEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ProjectFangAnEntity> wrapper);
   	
}

