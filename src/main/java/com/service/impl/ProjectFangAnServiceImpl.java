package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.ProjectFangAnDao;
import com.entity.ProjectFangAnEntity;
import com.entity.view.ProjectFangAnView;
import com.entity.vo.ProjectFangAnVO;
import com.service.ProjectFangAnService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("projectFangAnService")
public class ProjectFangAnServiceImpl extends ServiceImpl<ProjectFangAnDao, ProjectFangAnEntity> implements ProjectFangAnService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ProjectFangAnEntity> page = this.selectPage(
                new Query<ProjectFangAnEntity>(params).getPage(),
                new EntityWrapper<ProjectFangAnEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ProjectFangAnEntity> wrapper) {
		  Page<ProjectFangAnView> page =new Query<ProjectFangAnView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ProjectFangAnVO> selectListVO(Wrapper<ProjectFangAnEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ProjectFangAnVO selectVO(Wrapper<ProjectFangAnEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ProjectFangAnView> selectListView(Wrapper<ProjectFangAnEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ProjectFangAnView selectView(Wrapper<ProjectFangAnEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
