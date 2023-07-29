package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.ProjectFangAnEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 热门新闻
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 
 */
@TableName("projectFangAn")
public class ProjectFangAnView extends ProjectFangAnEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ProjectFangAnView(){
	}
 
 	public ProjectFangAnView(ProjectFangAnEntity projectFangAnEntity){
 	try {
			BeanUtils.copyProperties(this, projectFangAnEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
