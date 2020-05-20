package com.tv.travels.controller;

import com.tv.travels.utils.CreateImageCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("code")
@CrossOrigin //允许跨域
@Slf4j
public class CodeController {

    /**
     * 生成验证码
     * @param request
     * @return
     * @throws IOException
     */
    @GetMapping("getImage")
    @ResponseBody
    public Map<String,String> getImage(HttpServletRequest request) throws IOException {
        Map<String,String> result = new HashMap<>();
        CreateImageCode createImageCode = new CreateImageCode();
//        获取验证码
        String securityCode = createImageCode.getCode();
//        验证码传入session
        String key = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        request.getServletContext().setAttribute(key,securityCode);
//        request.getServletContext().setAttribute("6233",securityCode);
//        log.info((String) request.getServletContext().getAttribute("6233"));
//        生成图片
        BufferedImage image = createImageCode.getBuffImg();
//        进行base64的编码
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(image,"png",bos);
        String string = Base64Utils.encodeToString(bos.toByteArray());
        result.put("key",key);
        result.put("image",string);
        return result;
    }

}
