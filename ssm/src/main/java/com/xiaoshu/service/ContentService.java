package com.xiaoshu.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.xiaoshu.dao.CategoryMapper;
import com.xiaoshu.dao.ContentMapper;
import com.xiaoshu.dao.UserMapper;
import com.xiaoshu.entity.Category;
import com.xiaoshu.entity.Content;
import com.xiaoshu.entity.ContentVo;
import com.xiaoshu.entity.User;
import com.xiaoshu.entity.UserExample;
import com.xiaoshu.entity.UserExample.Criteria;
import com.xiaoshu.util.WriterUtil;

@Service
public class ContentService {

	@Autowired
	UserMapper userMapper;

	@Autowired
	private ContentMapper contentMapper;
	@Autowired
	private CategoryMapper categoryMapper;
	public PageInfo<ContentVo> findPage(ContentVo contentVo,Integer pageNum,Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<ContentVo> list = contentMapper.findAll(contentVo);
		return new PageInfo<>(list);
	}
	public List<ContentVo> findAll(ContentVo contentVo){
		return contentMapper.findAll(contentVo);
	}
	public List<Category> findC(){
		return categoryMapper.selectAll();
	}
	public void addC(Content content){
		contentMapper.insert(content);
		}
	public void delC(Integer id){
		contentMapper.deleteByPrimaryKey(id);
	}
	public Content findByName(String name){
		Content parm = new Content();
		parm.setContenttitle(name);
		return contentMapper.selectOne(parm);
	}
	public void updateC(Content content){
		contentMapper.updateByPrimaryKeySelective(content);
	}
	public void importC(MultipartFile newFile) throws InvalidFormatException, IOException{
		//Integer userId = user.getUserid();
			Workbook workbook = WorkbookFactory.create(newFile.getInputStream());
			Sheet sheet = workbook.getSheetAt(0);
			int num = sheet.getLastRowNum();
			for (int i = 0; i < num; i++) {
				Row row = sheet.getRow(i+1);
				String contenttitle = row.getCell(0).toString();
				String cname = row.getCell(1).toString();
				String contenturl = row.getCell(2).toString();
				String picpath = row.getCell(3).toString();
				long price = (long) row.getCell(4).getNumericCellValue();
				String status = row.getCell(5).toString();
				Date createtime = row.getCell(6).getDateCellValue();
				Content content = new Content();
				content.setContenttitle(contenttitle);
				content.setContenturl(contenturl);
				content.setPrice((int)price);
				content.setCreatetime(createtime);
				content.setPicpath(picpath);
				content.setStatus(status);
				content.setContenturl(contenturl);
				Category category = findN(cname);
				content.setContentcategoryid(category.getContencategoryid());
				addC(content);
				
			}
			
	}
	public Category findN(String cname){
		Category parm = new Category();
		parm.setCategoryname(cname);
		return categoryMapper.selectOne(parm);
	}
}
