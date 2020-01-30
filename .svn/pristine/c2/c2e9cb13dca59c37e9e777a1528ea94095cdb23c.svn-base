package com.rxsoft.crm.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.rxsoft.crm.bean.BaseDict;
import com.rxsoft.crm.bean.Customer;
import com.rxsoft.crm.service.BaseDictService;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

public class BaseDictAction extends ActionSupport implements ModelDriven<BaseDict> {
	private BaseDict baseDict=new BaseDict();
	@Override
	public BaseDict getModel() {
		return baseDict;
	}
	private BaseDictService baseDictService;
	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}
	/**
	 * 根据类型代码查询字典的方法
	 * @return
	 * @throws IOException 
	 */
	public String findByTypeCode() throws IOException {
		List<BaseDict> list=baseDictService.findByTypeCode(baseDict.getDict_type_code());
		//将list转json
		JsonConfig config=new JsonConfig();
		config.setExcludes(new String [] {"dict_sort","dict_enable","dict_memo"});
		JSONArray jsonArray = JSONArray.fromObject(list,config);
		System.out.println(jsonArray.toString());
		//打印到页面
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().print(jsonArray.toString());
		return NONE;
	}
	
}
