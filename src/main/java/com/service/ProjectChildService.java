package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.ProjectChildEntity;
import com.entity.view.ProjectChildView;
import com.entity.vo.ProjectChildVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProjectChildService extends IService<ProjectChildEntity> {
    PageUtils queryPage(Map<String, Object> params);

    List<ProjectChildVO> selectListVO(Wrapper<ProjectChildEntity> wrapper);

    ProjectChildVO selectVO(@Param("ew") Wrapper<ProjectChildEntity> wrapper);

    List<ProjectChildView> selectListView(Wrapper<ProjectChildEntity> wrapper);

    ProjectChildView selectView(@Param("ew") Wrapper<ProjectChildEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<ProjectChildEntity> wrapper);
}
