package com.rose.service;

import org.hibernate.criterion.DetachedCriteria;

import com.rose.domain.Customer;
import com.rose.utils.PageBean;

public interface CustomerService {

	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

	void save(Customer customer);

	Customer getById(Long cust_id);

}
