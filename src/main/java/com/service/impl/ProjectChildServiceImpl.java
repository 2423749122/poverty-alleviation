package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.ProjectChildDao;
import com.entity.ProjectChildEntity;
import com.entity.view.ProjectChildView;
import com.entity.vo.ProjectChildVO;
import com.service.ProjectChildService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("projectChildService")
public class ProjectChildServiceImpl extends ServiceImpl<ProjectChildDao,ProjectChildEntity> implements ProjectChildService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ProjectChildEntity> page = this.selectPage(
                new Query<ProjectChildEntity>(params).getPage(),
                new EntityWrapper<ProjectChildEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<ProjectChildEntity> wrapper) {
        Page<ProjectChildView> page =new Query<ProjectChildView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<ProjectChildVO> selectListVO(Wrapper<ProjectChildEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public ProjectChildVO selectVO(Wrapper<ProjectChildEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<ProjectChildView> selectListView(Wrapper<ProjectChildEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public ProjectChildView selectView(Wrapper<ProjectChildEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }

}
