package com.react.train.web;

import com.baomidou.mybatisplus.plugins.Page;
import com.react.train.domain.ReactDepartment;
import com.react.train.service.ReactDepartmentService;
import com.react.train.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description 用户表(ReactDepartment)表控制层
 * @author zhanhua.cheng
 * @date 2019-08-28 16:13:24
 */
@RestController
@RequestMapping("/api/department")
public class ReactDepartmentController {
    @Autowired
    private ReactDepartmentService reactDepartmentService;
    

    @PostMapping(value = "/insertReactDepartment")
    public ResponseEntity<ReactDepartment> insertReactDepartment(@RequestBody ReactDepartment ReactDepartment) {
        return reactDepartmentService.insertReactDepartment(ReactDepartment);
    }

    @PutMapping(value = "/updataReactDepartment")
    public ResponseEntity<ReactDepartment> updataReactDepartment(@RequestBody ReactDepartment ReactDepartment) {
        return reactDepartmentService.updateReactDepartment(ReactDepartment);
    }

    @DeleteMapping(value = "/deleteReactDepartment/{id}")
    public ResponseEntity<Integer> deleteReactDepartment(@PathVariable(value = "id") Long id) {
        return reactDepartmentService.deleteReactDepartment(id);
    }

    @GetMapping("/selectReactDepartment")
    public ResponseEntity<List<ReactDepartment>> selectReactDepartment(
            @RequestParam(value = "tradeCode", required = false) String tradeCode,
            @RequestParam(value = "gatherAccount", required = false) String gatherAccount,
            @RequestParam(value = "paymentStatus", required = false) Integer paymentStatus){
        return ResponseEntity.ok().body(reactDepartmentService.selectReactDepartment(tradeCode,gatherAccount,paymentStatus));
    }

    @GetMapping("/pageReactDepartment")
    public ResponseEntity<List<ReactDepartment>> pageReactDepartment(
            @RequestParam(value = "tradeCode", required = false) String tradeCode,
            @RequestParam(value = "gatherAccount", required = false) String gatherAccount,
            @RequestParam(value = "paymentStatus", required = false) Integer paymentStatus,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size
    ){
        Page mybatisPage = PageUtil.getPage(page, size);
        List<ReactDepartment> ReactDepartmentList = reactDepartmentService.selectReactDepartment(tradeCode, gatherAccount, paymentStatus);
        HttpHeaders httpHeaders = PageUtil.getTotalHeader(mybatisPage);
        return new ResponseEntity<>(ReactDepartmentList, httpHeaders, HttpStatus.OK);
    }



}