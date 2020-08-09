package com.xiaoshu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.xiaoshu.dao.MajorMapper;
import com.xiaoshu.dao.StudentMapper;
import com.xiaoshu.dao.UserMapper;
import com.xiaoshu.entity.Major;
import com.xiaoshu.entity.Student;
import com.xiaoshu.entity.StudentVo;
import com.xiaoshu.entity.User;
import com.xiaoshu.entity.UserExample;
import com.xiaoshu.entity.UserExample.Criteria;

@Service
public class StudentService {

	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private MajorMapper majorMapper;
	public PageInfo<StudentVo> findPage(StudentVo studentVo, Integer pageNum,Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<StudentVo> list = studentMapper.findAll(studentVo);
		return new PageInfo<>(list);
		
		
	}
	public List<Major> findMajor(){
		return majorMapper.selectAll();
	}
	
	public void addStu(Student student){
		studentMapper.insert(student);
	}
	public void updateStu(Student student){
		studentMapper.updateByPrimaryKeySelective(student);
	}
	public void delStu(Integer id){
		studentMapper.deleteByPrimaryKey(id);
	}
	public List<StudentVo> findAll(StudentVo studentVo){
		return studentMapper.findAll(studentVo);
	}
	public List<StudentVo> findE(){
		return studentMapper.findE();
	}
}
