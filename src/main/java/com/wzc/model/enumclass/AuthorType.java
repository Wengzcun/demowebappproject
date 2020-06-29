package com.wzc.model.enumclass;

public enum AuthorType {


    LOGIN(0,"登陆");

    private int authorType;

    private String desc;


    AuthorType(int authorType, String desc) {
        this.authorType =  authorType;
        this.desc = desc;
    }

    public int getAuthorType(){
        return this.authorType;
    }
}
