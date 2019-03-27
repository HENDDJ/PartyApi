package com.cloudkeeper.leasing.bean.base.to;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public abstract class BaseTO implements Serializable {

    private String id;
}
