package com.leevan.sell.form;

import lombok.Data;

/**
 * @Author Leevan
 * @Date： 2018/12/15 19:24
 */
@Data
public class CategoryForm {
    private Integer categoryId;
    /*类目名称*/
    private String categoryName;
    /*类目编号*/
    private Integer categoryType;
}
