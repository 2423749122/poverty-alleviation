package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.ProjectFangAnEntity;
import com.entity.view.ProjectFangAnView;
import com.entity.vo.ProjectFangAnVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 热门新闻
 * 
 * @author 
 * @email 
 * @date 
 */
public interface ProjectFangAnDao extends BaseMapper<ProjectFangAnEntity> {
	
	List<ProjectFangAnVO> selectListVO(@Param("ew") Wrapper<ProjectFangAnEntity> wrapper);
	
	ProjectFangAnVO selectVO(@Param("ew") Wrapper<ProjectFangAnEntity> wrapper);
	
	List<ProjectFangAnView> selectListView(@Param("ew") Wrapper<ProjectFangAnEntity> wrapper);

	List<ProjectFangAnView> selectListView(Pagination page,@Param("ew") Wrapper<ProjectFangAnEntity> wrapper);
	
	ProjectFangAnView selectView(@Param("ew") Wrapper<ProjectFangAnEntity> wrapper);
	
}
