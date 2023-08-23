package com.atguigu.model;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import lombok.Data;

import java.io.Serializable;

@Data
public class Payment implements Serializable {
    @Id(keyType = KeyType.Auto)
    private Integer id;
    private String serial;
}
