package com.core;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Jonathan
 * @version 2016/5/31 11:22
 * @since JDK 7.0+
 */
@Controller
@RequestMapping(value = "error")
public class RestErrorEndpoint implements ErrorController {

	@RequestMapping("")
	@ResponseBody
    public String error(HttpServletRequest request) {
		HttpStatus v = getStatus(request);
        return String.valueOf(v.value());
    }
	
    /**
     * 获取错误编码
     * @param request
     * @return
     */
    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request
                .getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        try {
            return HttpStatus.valueOf(statusCode);
        }
        catch (Exception ex) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    /**
     * 实现错误路径,暂时无用
     * @see ExceptionMvcAutoConfiguration#containerCustomizer()
     * @return
     */
    @Override
    public String getErrorPath() {
        return "";
    }

}