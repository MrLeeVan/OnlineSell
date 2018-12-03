package com.leevan.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Author Leevan
 * @Date： 2018/12/3 17:14
 *
 * 类目表
 */
@Entity
@Data
public class ProductCategory {
    /*类目ID*/
    @Id
    @GeneratedValue
    private Integer categoryId;
    /*类目名称*/
    private String categoryName;
    /*类目编号*/
    private Integer categoryType;

    @Override
    public String toString() {
        return "ProductCategory{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryType=" + categoryType +
                '}';
    }
}
