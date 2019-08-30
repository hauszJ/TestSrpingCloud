package com.react.train.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.react.train.domain.ReactDepartment;
import com.react.train.persistence.ReactDepartmentMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 用户表(ReactDepartment)表服务接口
 * @author zhanhua.cheng
 * @date 2019-08-28 16:13:23
 */
@Service
public class ReactDepartmentService extends ServiceImpl<ReactDepartmentMapper, ReactDepartment> {


    public ResponseEntity<ReactDepartment> insertReactDepartment(ReactDepartment reactDepartment) {
        baseMapper.insert(reactDepartment);
        return ResponseEntity.ok().body(reactDepartment);
    }


    public ResponseEntity<ReactDepartment> updateReactDepartment(ReactDepartment reactDepartment){
        baseMapper.updateById(reactDepartment);
        return ResponseEntity.ok().body(reactDepartment);
    }


    public ResponseEntity<Integer> deleteReactDepartment(Long id){
        Integer integer = baseMapper.deleteById(id);
        return ResponseEntity.ok().body(integer);
    }


    public List<ReactDepartment> selectReactDepartment(
            String tradeCode,
            String gatherAccount,
            Integer paymentStatus){
        List<ReactDepartment> reactDepartmentList = baseMapper.selectList(new EntityWrapper<ReactDepartment>()
                .eq(paymentStatus != null, "payment_status", paymentStatus)
                .like(gatherAccount != null && !gatherAccount.equals(""), "gather_account", gatherAccount)
                .like(tradeCode != null && !tradeCode.equals(""), "trade_code", tradeCode)
        );

        return reactDepartmentList;
    }

}