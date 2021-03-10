package com.example.pingb.result;

public class Result {
    public int code;

    public String error;
    public Result(String error,int code){
        this.error=error;
        this.code=code;
    }
    public Result(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
