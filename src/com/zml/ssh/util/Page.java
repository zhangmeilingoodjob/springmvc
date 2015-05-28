package com.zml.ssh.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * 分页对象，包含当前页数据及分页信息
 * @author zml
 *
 */
public class Page<T> implements Serializable{
	private static Integer DEFAULT_PAGE_SIZE=20;
	private Integer numPerPage=DEFAULT_PAGE_SIZE;//每页显示的记录数
	private Integer totalNums;//总记录数
	private Integer totalPages;//总页数
	private Integer currentPage;//当前页数
	private Integer startIndex;//记录开始位置
	private List<T> data;//当前页中存放的记录
	private Integer endIndex;//记录结束位置
	/**
	 * 默认构造函数
	 * @param currentPage
	 * @param totalNums
	 * @param numPerPage
	 * @param data
	 */
	public Page(Integer currentPage,Integer totalNums,Integer numPerPage,List<T> data){
		this.currentPage=currentPage;
		this.totalNums=totalNums;
		this.numPerPage=numPerPage;
		this.data=data;
	}
	/**
	 * 构造空页
	 */
	public Page(){
		this(0, 0, DEFAULT_PAGE_SIZE, new ArrayList<T>());
	}
	/**
	 * 获取页面数据容量
	 * @return
	 */
	public Integer getNumPerPage() {
		return numPerPage;
	}
	/**
	 * 获取总记录数
	 * @return
	 */
	public Integer getTotalNums() {
		return totalNums;
	}
	/**
	 * 获取总页数
	 * @return
	 */
	public Integer getTotalPages() {
		if(totalNums%numPerPage==0){
			return totalNums/numPerPage;
		}else{
			return totalNums/numPerPage+1;
		}
	}
	/**
	 * 获取当前页码
	 * @return
	 */
	public Integer getCurrentPage() {
		return currentPage;
	}
	/**
	 * 获取记录开始位置
	 * @return
	 */
	public Integer getStartIndex() {
		return (currentPage-1)*numPerPage+1;
	}
	/**
	 * 获取当前页中记录
	 * @return
	 */
	public List<T> getData() {
		return data;
	}
	/**
	 * 获取记录结束位置
	 * @return
	 */
	public Integer getEndIndex() {
		return currentPage*numPerPage;
	}
	 /** 
     * 该页是否有下一页. 
     */ 
    public boolean hasNextPage() { 
        return getEndIndex()<totalNums; 
    } 
    /** 
     * 该页是否有上一页. 
     */ 
    public boolean hasPreviousPage() { 
        return this.currentPage > 1; 
    } 
    /**
     * 获取任意一页的第一条数据在data中的位置
     * @param pageNo
     * @param pageSize
     * @return
     */
    public int getStartOfPage(int pageNo) { 
        return (pageNo - 1) * numPerPage; 
    } 
}
