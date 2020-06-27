package com.wzc.model.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMsg {

    private String errorCode = "0001";

    private String errorMsg = "登陆成功";
}
