package com.yhgs.api.model;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserInfo {

    /**
     * 账号
     */
    @TableField("AccountId")
    private String accountId;

    /**
     * 密码
     */
    @TableField("AccountSecret")
    private String accountSecret;
}

