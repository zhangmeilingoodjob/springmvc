package com.zml.ssh.dao.basedao;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 
 * @author zml
 *
 * @param <T> 实体类型
 */
public interface GenericDao<T,PK extends Serializable> {
	
	public List<T> findByHql(String hql);
	
	public List<T> findAll();
	//flush方法的主要作用就是清理缓存，强制数据库与Hibernate缓存同步，以保证数据的一致性
	public void flush();
	//获取记录总数
	public long getCount(final String wherejpql,final Object[] queryParams);
	//清除一级缓存
	public void clear();
	//保存实体
	public void save(Object entityId);
	//更新实体
	public void update(Object entityId);
	/**
	 * 删除实体
	 * @param entityids 实体id数组
	 */
	public void delete(Serializable ...entityids);
	/**
	 * 获取实体
	 * @param entityId  实体id
	 * @return
	 */
	public T find(Serializable entityId);
	/**
	 * 获取实体
	 * @param entityId  实体id
	 * @return
	 */
	public T get(Serializable entityId);
	
	public int executeDML(final String hql);
	
	public int executeDML(final String hql,Object[] values);
	
	public List<T> limitFindByHql(final int firstindex,final int maxresult,final String wherejpql,final Object[] queryParams,final LinkedHashMap<String, String> orderby);
	
}
