package com.xiaoshu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.xiaoshu.dao.CompanyMapper;
import com.xiaoshu.dao.PersonMapper;
import com.xiaoshu.dao.UserMapper;
import com.xiaoshu.entity.Company;
import com.xiaoshu.entity.Person;
import com.xiaoshu.entity.PersonVo;
import com.xiaoshu.entity.User;
import com.xiaoshu.entity.UserExample;
import com.xiaoshu.entity.UserExample.Criteria;

@Service
public class PersonService {
 
	@Autowired
	private PersonMapper personMapper;
	@Autowired
	private CompanyMapper companyMapper;
	public PageInfo<PersonVo> findPage(PersonVo personVo, Integer pageNum,Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<PersonVo> list = personMapper.findAll(personVo);
		return new PageInfo<>(list);
	}
	public List<Company> findAllC(){
		return companyMapper.selectAll();
	}
	public void addP(Person person){
		personMapper.insert(person);
	}
	public void update(Person person){
		personMapper.updateByPrimaryKeySelective(person);
		}
	public void delP(Integer id){
		personMapper.deleteByPrimaryKey(id);
	}
	public List<PersonVo> findE(){
		return personMapper.findE();
	}
}
