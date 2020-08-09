package com.xiaoshu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.xiaoshu.dao.DevMapper;
import com.xiaoshu.dao.DeviceMapper;
import com.xiaoshu.dao.TypeMapper;
import com.xiaoshu.dao.UserMapper;
import com.xiaoshu.entity.Dev;
import com.xiaoshu.entity.Device;
import com.xiaoshu.entity.DeviceVo;
import com.xiaoshu.entity.Type;
import com.xiaoshu.entity.User;
import com.xiaoshu.entity.UserExample;
import com.xiaoshu.entity.UserExample.Criteria;

@Service
public class DeviceService {

	@Autowired
	UserMapper userMapper;
	@Autowired
	private DevMapper deviceMapper;

	

	
	public PageInfo<Dev> findPage(Dev deviceVo,Integer pageNum,Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<Dev> list = deviceMapper.findAll(deviceVo);
		return new PageInfo<>(list);
	}
	
	
	public void addD(Dev device){
		deviceMapper.insert(device);
	}
	public void updateD(Dev device){
		deviceMapper.updateByPrimaryKeySelective(device);
		
	}
	public void delD(Integer id){
		deviceMapper.deleteByPrimaryKey(id);
	}

}
