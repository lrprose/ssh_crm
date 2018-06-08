package com.rose.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.rose.domain.BaseDict;
import com.rose.service.BaseDictService;

import net.sf.json.JSONArray;

public class BaseDictAction extends ActionSupport{
	
	private String dict_type_code;
	private BaseDictService baseDictService;

	@Override
	public String execute() throws Exception {
		//调用service根据typecode获得字典数据对象list
		List<BaseDict> list = baseDictService.getListByTypeCode(dict_type_code);
		//将list转化为json
		String json = JSONArray.fromObject(list).toString();
		//将json发送给页面
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		return null;
	}
	
	public String getDict_type_code() {
		return dict_type_code;
	}

	public void setDict_type_code(String dict_type_code) {
		this.dict_type_code = dict_type_code;
	}

	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	} 

}
