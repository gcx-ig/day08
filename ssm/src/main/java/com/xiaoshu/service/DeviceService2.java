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

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class DeviceService2 {

	@Autowired
	UserMapper userMapper;
	@Autowired
	private DeviceMapper deviceMapper;
	@Autowired
	private TypeMapper typeMapper;

	@Autowired
	private JedisPool jedisPool;

	
	public PageInfo<DeviceVo> findPage(DeviceVo deviceVo,Integer pageNum,Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<DeviceVo> list = deviceMapper.findAll(deviceVo);
		return new PageInfo<>(list);
	}
	public List<DeviceVo> findAll(DeviceVo deviceVo){
		return deviceMapper.findAll(deviceVo);
	}
	
	public void addD(Device device){
		Jedis jedis = jedisPool.getResource();
		jedis.set(device.getDeviceName(), device.getPrice().toString());
		
		deviceMapper.insert(device);
	}
	public void updateD(Device device){
		deviceMapper.updateByPrimaryKeySelective(device);
		
	}
	public void delD(Integer id){
		deviceMapper.deleteByPrimaryKey(id);
	}


	public List<Type> findAllT() {
		
		return typeMapper.selectAll();
		
	}


	public Device findByName(String deviceName) {
		Device parm = new Device();
		parm.setDeviceName(deviceName);
		// TODO Auto-generated method stub
		return deviceMapper.selectOne(parm);
	}


	public List<DeviceVo> findE() {
		// TODO Auto-generated method stub
		return deviceMapper.findE();
	}


	

}
