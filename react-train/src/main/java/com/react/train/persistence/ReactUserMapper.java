package com.react.train.persistence;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.react.train.domain.ReactUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description 用户表(ReactUser)表Mapper接口
 * @author zhanhua.cheng
 * @date 2019-08-28 15:55:19
 */
@Mapper
public interface ReactUserMapper extends BaseMapper<ReactUser> {

}