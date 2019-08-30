package com.react.train.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.react.train.domain.ReactUser;
import com.react.train.persistence.ReactUserMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 用户表(ReactUser)表服务接口
 * @author zhanhua.cheng
 * @date 2019-08-28 15:55:17
 */
@Service
public class ReactUserService  extends ServiceImpl<ReactUserMapper, ReactUser> {



    public ResponseEntity<ReactUser> insertReactUser(ReactUser reactUser) {
        baseMapper.insert(reactUser);
        return ResponseEntity.ok().body(reactUser);
    }


    public ResponseEntity<ReactUser> updateReactUser(ReactUser reactUser){
        baseMapper.updateById(reactUser);
        return ResponseEntity.ok().body(reactUser);
    }


    public ResponseEntity<Integer> deleteReactUser(Long id){
        Integer integer = baseMapper.deleteById(id);
        return ResponseEntity.ok().body(integer);
    }


    public List<ReactUser> selectReactUser(
            String tradeCode,
            String gatherAccount,
            Integer paymentStatus){
        List<ReactUser> reactUserList = baseMapper.selectList(new EntityWrapper<ReactUser>()
                .eq(paymentStatus != null, "payment_status", paymentStatus)
                .like(gatherAccount != null && !gatherAccount.equals(""), "gather_account", gatherAccount)
                .like(tradeCode != null && !tradeCode.equals(""), "trade_code", tradeCode)
        );

        return reactUserList;
    }
}