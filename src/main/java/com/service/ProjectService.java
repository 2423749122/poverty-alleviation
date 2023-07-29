package com.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.ProjectEntity;
import com.entity.ProjectEntity;
import com.entity.view.ProjectView;
import com.entity.view.ProjectView;
import com.entity.vo.ProjectVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProjectService extends IService<ProjectEntity> {
    PageUtils queryPage(Map<String, Object> params);

    List<ProjectVO> selectListVO(Wrapper<ProjectEntity> wrapper);

    ProjectVO selectVO(@Param("ew") Wrapper<ProjectEntity> wrapper);

    List<ProjectView> selectListView(Wrapper<ProjectEntity> wrapper);

    ProjectView selectView(@Param("ew") Wrapper<ProjectEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<ProjectEntity> wrapper);
}
