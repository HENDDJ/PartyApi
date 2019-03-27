package com.cloudkeeper.leasing.bean.identity.to;

import com.cloudkeeper.leasing.bean.base.to.BaseTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PrincipalTO extends BaseTO {

    /** 登录名*/
    private String code;

    /** 姓名*/
    private String name;
}
