package com.zml.ssh.dao.hibernate.extend;


/** 
 * 装载Entity信息的内部类. 
 * 
 * @author springside 
 *  
 */ 
public class EntityInfo { 
    boolean isUndeletable = false; // entity是否undeleteable的标志 

    String statusProperty; // 标识状态的属性名 

    @SuppressWarnings("unchecked") 
    public EntityInfo(Class entityClass) { 
        init(entityClass); 
    } 

    /** 
     * 初始函数,判断EntityClass是否UndeletableEntity. 
     */ 
    @SuppressWarnings("unchecked") 
    private void init(Class entityClass) { 
        // 通过EntityClass的interface判断entity是否undeletable 
        if (IUndeletableEntity.class.isAssignableFrom(entityClass)) { 
            isUndeletable = true; 
            statusProperty = IUndeletableEntityOperation.STATUS; 
        } 

        // 通过EntityClass的annotation判断entity是否undeletable 
        if (entityClass.isAnnotationPresent(IUndeletable.class)) { 
            isUndeletable = true; 
            IUndeletable anno = (IUndeletable) entityClass.getAnnotation(IUndeletable.class); 
            statusProperty = anno.status(); 
        } 
    } 
} 

