package com.react.train.web;

import com.baomidou.mybatisplus.plugins.Page;
import com.react.train.domain.ReactUser;
import com.react.train.service.ReactUserService;
import com.react.train.util.PageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description 用户表(ReactUser)表控制层
 * @author zhanhua.cheng
 * @date 2019-08-28 15:55:18
 */
@RestController
@RequestMapping("/api/user")
public class ReactUserController {

    @Autowired
    private ReactUserService reactUserService;
    private static final Logger log = LoggerFactory.getLogger(ReactUserController.class);
    @PostMapping(value = "/createOrUpdate")
    public ResponseEntity<Boolean> createOrUpdate(@RequestBody ReactUser reactUser) {
        log.debug(reactUser.toString());

        return ResponseEntity.ok().body(reactUserService.insertOrUpdate(reactUser));
//        reactUserService.insertOrUpdate(reactUser);
//        return reactUserService.insertReactUser(reactUser);
    }
    @PostMapping(value = "/insertReactUser")
    public ResponseEntity<ReactUser> insertReactUser(@RequestBody ReactUser reactUser) {
        return reactUserService.insertReactUser(reactUser);
    }

    @PutMapping(value = "/updataReactUser")
    public ResponseEntity<ReactUser> updataReactUser(@RequestBody ReactUser reactUser) {
        return reactUserService.updateReactUser(reactUser);
    }

    @DeleteMapping(value = "/deleteReactUser/{id}")
    public ResponseEntity<Integer> deleteReactUser(@PathVariable(value = "id") Long id) {
        return reactUserService.deleteReactUser(id);
    }

    @GetMapping("/selectReactUser")
    public ResponseEntity<List<ReactUser>> selectReactUser(
            @RequestParam(value = "tradeCode", required = false) String tradeCode,
            @RequestParam(value = "gatherAccount", required = false) String gatherAccount,
            @RequestParam(value = "paymentStatus", required = false) Integer paymentStatus){
        return ResponseEntity.ok().body(reactUserService.selectReactUser(tradeCode,gatherAccount,paymentStatus));
    }

    @GetMapping("/pageReactUser")
    public ResponseEntity<List<ReactUser>> pageReactUser(
            @RequestParam(value = "tradeCode", required = false) String tradeCode,
            @RequestParam(value = "gatherAccount", required = false) String gatherAccount,
            @RequestParam(value = "paymentStatus", required = false) Integer paymentStatus,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size
    ){
        Page mybatisPage = PageUtil.getPage(page, size);
        List<ReactUser> reactUserServiceList = reactUserService.selectReactUser(tradeCode, gatherAccount, paymentStatus);
        HttpHeaders httpHeaders = PageUtil.getTotalHeader(mybatisPage);
        return new ResponseEntity<>(reactUserServiceList, httpHeaders, HttpStatus.OK);
    }

}