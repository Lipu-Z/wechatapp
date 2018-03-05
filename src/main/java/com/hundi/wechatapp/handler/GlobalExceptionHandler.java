package com.hundi.wechatapp.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LZHONG
 * @package com.hundi.wechatapp.handler
 * @date 3/5/2018
 */

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    private Map<String,Object> exceptionHandler(HttpServletRequest req, Exception e){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        modelMap.put("success", false);
        modelMap.put("errMsg", "ooooooops"+e.getMessage());
        return modelMap;
    }
}
