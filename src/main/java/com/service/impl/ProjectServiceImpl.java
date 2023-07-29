package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.PinkunhuDao;
import com.dao.ProjectDao;
import com.dao.ProjectDao;
import com.entity.PinkunhuEntity;
import com.entity.ProjectEntity;
import com.entity.ProjectEntity;
import com.entity.view.ProjectView;
import com.entity.view.ProjectView;
import com.entity.vo.ProjectVO;
import com.service.PinkunhuService;
import com.service.ProjectService;
import com.service.ProjectService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("projectService")
public class ProjectServiceImpl extends ServiceImpl<ProjectDao,ProjectEntity> implements ProjectService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ProjectEntity> page = this.selectPage(
                new Query<ProjectEntity>(params).getPage(),
                new EntityWrapper<ProjectEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<ProjectEntity> wrapper) {
        Page<ProjectView> page =new Query<ProjectView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<ProjectVO> selectListVO(Wrapper<ProjectEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public ProjectVO selectVO(Wrapper<ProjectEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<ProjectView> selectListView(Wrapper<ProjectEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public ProjectView selectView(Wrapper<ProjectEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }

}
