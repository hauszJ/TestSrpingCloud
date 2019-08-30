package com.react.train.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.*;


/**
 * @description 用户表(react_department)表实体类
 * @author zhanhua.cheng
 * @date 2019-08-28 16:13:23
 */
 
@TableName(value = "react_department")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class ReactDepartment extends BaseObject {
                    /**
      部门名字 
    */
    @TableField(value = "name")
    private String name;
    
}