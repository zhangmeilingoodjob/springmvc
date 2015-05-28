package com.zml.ssh.service.base.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zml.ssh.dao.hibernate.basedao.BaseDao;
import com.zml.ssh.dao.hibernate.support.Page;
import com.zml.ssh.domain.User;
import com.zml.ssh.service.base.EntityService;
import com.zml.ssh.service.base.PageService;

@Service
public class IBaseService implements EntityService<User, Integer>,PageService<User>{
	
	@Resource(name="UserDao")
	private BaseDao<User, Serializable> userDao;
	
	public BaseDao<User, Serializable> getUserDao() {
		return userDao;
	}

	public void setUserDao(BaseDao<User, Serializable> userDao) {
		this.userDao = userDao;
	}

	@Override
	public long countAll() {
		return userDao.getAllCount(User.class);
	}


	@SuppressWarnings("unchecked")
	@Override
	public Page<User> listAll(int pn, int pageSize) {
		return userDao.pagedQuery(User.class, pn, pageSize);
	}

	@Override
	public Page<User> pre(int pn, int pageSize) {
		return listAll(pn-1, pageSize);
	}

	@Override
	public Page<User> next(int pn, int pageSize) {
		return listAll(pn+1, pageSize);
	}


	@Override
	public void saveOrUpdate(User Todel) {
		userDao.save(Todel);
	}

	@Override
	public void update(User Todel) {
		userDao.save(Todel);
	}

	@Override
	public void delete(Integer id) {
		userDao.removeById(id);
	}

	@Override
	public void deleteEntity(User Todel) {
		userDao.remove(Todel);
	}

	@Override
	public User get(Integer id) {
		return userDao.get(id);
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Override
	public List<User> findBy(String propertyName, Object value) {
		return userDao.findBy(propertyName, value);
	}

	@Override
	public List<User> findByHql(String hql) {
		return userDao.find(hql);
	}


}
