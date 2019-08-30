package com.react.train.persistence;


import com.baomidou.mybatisplus.mapper.BaseMapper;

import com.react.train.domain.ReactDepartment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description 用户表(ReactDepartment)表Mapper接口
 * @author zhanhua.cheng
 * @date 2019-08-28 16:13:24
 */
@Mapper
public interface ReactDepartmentMapper extends BaseMapper<ReactDepartment> {

}