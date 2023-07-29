package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.ProjectEntity;
import com.entity.ProjectEntity;
import com.entity.view.ProjectView;
import com.entity.view.ProjectView;
import com.entity.vo.ProjectVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectDao  extends BaseMapper<ProjectEntity> {
    List<ProjectVO> selectListVO(@Param("ew") Wrapper<ProjectEntity> wrapper);

    ProjectVO selectVO(@Param("ew") Wrapper<ProjectEntity> wrapper);

    List<ProjectView> selectListView(@Param("ew") Wrapper<ProjectEntity> wrapper);

    List<ProjectView> selectListView(Pagination page, @Param("ew") Wrapper<ProjectEntity> wrapper);

    ProjectView selectView(@Param("ew") Wrapper<ProjectEntity> wrapper);
}
