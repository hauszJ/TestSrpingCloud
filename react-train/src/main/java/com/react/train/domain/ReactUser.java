package com.react.train.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
/**
 * @description 用户表(react_user)表实体类
 * @author zhanhua.cheng
 * @date 2019-08-28 15:55:16
 */
 
@TableName(value = "react_user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
/**
 * 没有callSuper继承来的不会返回给前端  因为调用toString方法返回
 */
@ToString(callSuper = true)
public class ReactUser extends BaseObject {
                    /**
      名字 
    */
    @TableField(value = "name")
    private String name;
    
                /**
      电话 
    */
    @TableField(value = "phone_number")
    private String phoneNumber;
    
                /**
      性别 
    */
    @TableField(value = "sex")
    private Integer sex;
    
                /**
      邮箱 
    */
    @TableField(value = "email")
    private String email;
    
                /**
      工作id 
    */
    @TableField(value = "job_number")
    private String jobNumber;
    
                /**
                 * @JsonSerialize(using = ToStringSerializer.class)
                 * 发往前台转换Long为String  否则会因为Long太长精度截断
      部门id
    */
    @TableField(value = "department_id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long departmentId;
    
}