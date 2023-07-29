package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.ProjectChildEntity;
import com.entity.view.ProjectChildView;
import com.entity.vo.ProjectChildVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectChildDao extends BaseMapper<ProjectChildEntity> {
    List<ProjectChildVO> selectListVO(@Param("ew") Wrapper<ProjectChildEntity> wrapper);

    ProjectChildVO selectVO(@Param("ew") Wrapper<ProjectChildEntity> wrapper);

    List<ProjectChildView> selectListView(@Param("ew") Wrapper<ProjectChildEntity> wrapper);

    List<ProjectChildView> selectListView(Pagination page, @Param("ew") Wrapper<ProjectChildEntity> wrapper);

    ProjectChildView selectView(@Param("ew") Wrapper<ProjectChildEntity> wrapper);
}
