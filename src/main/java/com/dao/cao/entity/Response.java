package com.dao.cao.entity;



public class Response<T> {

    private int code ;
    private String msg;
    private T obj;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getObj() {
        return obj;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", obj=" + obj +
                '}';
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public  Response(int code, String msg, T obj) {
        this.code = code;
        this.msg = msg;
        this.obj = obj;
    }
    public static  <T> Response success(T obj){
    return new Response(200,"成功啦！",obj);
    }
    public static  <T> Response failure(T obj){
        return new Response(500,"失败了！",obj);
    }

}
