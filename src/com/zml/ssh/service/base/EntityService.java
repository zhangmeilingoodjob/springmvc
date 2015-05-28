package com.zml.ssh.service.base;

import java.io.Serializable;
import java.util.List;

import com.zml.ssh.dao.hibernate.support.Page;

public interface EntityService<T extends Serializable, PK extends Serializable> {
	
	//public T save(T Todel);

	public void saveOrUpdate(T Todel);

	public void update(T Todel);

	public void delete(PK id);

	public void deleteEntity(T Todel);

	public T get(PK id);
	
	public List<T> getAll();
	
	public List<T> findBy(String propertyName, Object value);
	
	public List<T> findByHql(String hql);
	
	
	
}
