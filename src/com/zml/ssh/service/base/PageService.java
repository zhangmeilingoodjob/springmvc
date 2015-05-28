package com.zml.ssh.service.base;

import java.io.Serializable;
import java.util.List;

import com.zml.ssh.dao.hibernate.support.Page;

public interface PageService<T extends Serializable> {
		//总记录数
		public long countAll();
		//第pn页的记录，pageSize数据
		public Page<T> listAll(int pn, int pageSize);
		//前一页记录
		public Page<T> pre(int pn, int pageSize);
		//下一页记录
		public Page<T> next(int pn, int pageSize);
}
