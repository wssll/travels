package com.tv.travels.entity;

import com.sun.org.apache.xpath.internal.operations.Bool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Result {

    private Boolean state = true;
    private String msg;

    private String userId;

    public Result(){}

//    public static Result ok(){
//        Result result = new Result();
//        result.setState(true);
//        result.setMsg("操作成功");
//        return result;
//    }
//    public static Result error(){
//        Result result = new Result();
//        result.setState(false);
//        result.setMsg("操作失败");
//        return result;
//    }
//
//    public Result state(Boolean state){
//        this.state = state;
//        return this;
//    }
//
//    public Result msg(String msg){
//        this.msg = msg;
//        return this;
//    }



}
