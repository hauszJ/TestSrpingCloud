package com.react.train.domain;


import com.baomidou.mybatisplus.annotations.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;

@Data
abstract public class BaseObject implements Serializable {
    @TableId
    @JsonSerialize(using = ToStringSerializer.class)
    protected Long id;
}