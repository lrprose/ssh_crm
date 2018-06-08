package com.rose.utils;

import java.util.List;

public class PageBean {
	
	//当前页数
	private Integer currentPage;
	//总记录数
	private Integer totalCount;
	//每页显示条数
	private Integer pageSize;
	//总页数
	private Integer totalPage;
	//分页列表
	private List list;
	public PageBean(Integer currentPage, Integer totalCount, Integer pageSize) {
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		
		//如果输入没有显示那一页，显示第一页
		if(this.currentPage==null) {
			this.currentPage=1;
		}
		
		//如果输入没有显示每页显示条数
		if(this.pageSize==null) {
			this.pageSize=3;
		}
		
		//计算总页数
		this.totalPage = (this.totalCount+this.pageSize-1)/this.pageSize;
		
		//判断当前页数是否超出范围
		//不能小于1
		if(this.currentPage < 1) {
			this.currentPage = 1;
		}
		//不能大于总页数
		if(this.currentPage>this.totalPage) {
			this.currentPage = this.totalPage;
		}
	}
	
	//计算开始索引
	public int getStart() {
		return (this.currentPage-1)*this.pageSize;
	}
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
	
	
	
	
}
