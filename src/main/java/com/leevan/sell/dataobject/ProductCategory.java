package com.leevan.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Author Leevan
 * @Date： 2018/12/3 17:14
 *
 * 类目表
 */
@Entity
@Data
@DynamicUpdate
public class ProductCategory {
    /*类目ID*/
    @Id
    @GeneratedValue
    private Integer categoryId;
    /*类目名称*/
    private String categoryName;
    /*类目编号*/
    private Integer categoryType;

    public ProductCategory(String categoryName, int categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    /* *//*创建时间*//*
    private Date createTime;
    *//*更新时间*//*
    private Date updateTime;*/
public void ProductCategory(){

}

}
