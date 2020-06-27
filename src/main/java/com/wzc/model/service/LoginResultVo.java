package com.wzc.model.service;

import com.wzc.model.common.ErrorMsg;
import lombok.Data;

@Data
public class LoginResultVo {

    private ErrorMsg errorMsg;

    private String  token;

    private String userId;

    private String userName;

    @Override
    public String toString(){
        if(!this.getErrorMsg().getErrorCode().equals("0001")){
            return "No user Info!";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("userId = ");
        sb.append(this.getUserId());
        sb.append("; ");
        sb.append("userName =");
        sb.append(this.getUserName());
        sb.append("; ");
        sb.append("token = ");
        sb.append(this.getToken());
        return sb.toString();
    }
}
