package com.xiaoshu.dao;

import com.xiaoshu.base.dao.BaseMapper;
import com.xiaoshu.entity.Dev;
import com.xiaoshu.entity.DevExample;
import com.xiaoshu.entity.DeviceVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DevMapper extends BaseMapper<Dev> {

	List<Dev> findAll(Dev deviceVo);

	List<DeviceVo> findAll(DeviceVo deviceVo);
}