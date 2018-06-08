package com.rose.web.action;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.rose.domain.Customer;
import com.rose.domain.User;
import com.rose.service.CustomerService;
import com.rose.service.UserService;
import com.rose.utils.PageBean;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

	private Customer customer = new Customer();
	private CustomerService cs;
	//上传的文件会自动封装到File对象
	//在后台提供一个与前台input type=file组件 name相同的属性
	private File photo;
	//在提交键名后加上固定后缀FileName,文件名称会自动封装到属性中
	private String photoFileName;
	//在提交键名后加上固定后缀ContentType,文件MIME类型会自动封装到属性中 
	private String photoContentType;
	
	private Integer currentPage;
	private Integer pageSize;
	
	public String list() throws Exception {
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		//判断并封装参数
		if(StringUtils.isNotBlank(customer.getCust_name())) {
			dc.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
		}
		//调用service查询分页数据（PageBean）
		PageBean pb = cs.getPageBean(dc,currentPage,pageSize);
		//将PageBean放入request域，转发至列表页面显示
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
	
	public String add() throws Exception {
		if(photo!=null) {
			System.out.println("文件名称："+photoFileName);
			System.out.println("文件类型："+photoContentType);
			photo.renameTo(new File("D:/photo/haha.jpg"));
			
		}
		//调用service层，保存Customer对象
		cs.save(customer);
		//重定向到客户列表action
		return "toList";		
		
	}
	
	public String toEdit() throws Exception {
		//调用service层获得Customer对象
		Customer c = cs.getById(customer.getCust_id());
		//将客户对象放入request域，并转发至修改页面
		ActionContext.getContext().put("customer", c);
		return "edit";
	}


	@Override
	public Customer getModel() {
		return customer;
	}

	public void setCs(CustomerService cs) {
		this.cs = cs;
	}


	public Integer getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}


	public Integer getPageSize() {
		return pageSize;
	}


	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public String getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

	
	
}
