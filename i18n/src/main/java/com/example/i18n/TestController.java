package com.example.i18n;

import com.example.i18n.common.api.ErrorCodeEnum;
import com.example.i18n.common.api.Result;
import com.example.i18n.common.util.MessageUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/get")
public class TestController {

    @GetMapping("/success")
    public Result success() {
        return new Result<>(1, MessageUtils.get("code.success"));
    }

    @GetMapping("/failure")
    public Result failure() {
        return new Result<>(1, MessageUtils.get("code.failure"));
    }

    @GetMapping("/status")
    public Result status() {
        return Result.status(ErrorCodeEnum.SUCCESS, MessageUtils.get("code.success"));
    }

    @GetMapping("/test")
    public String test() {
        return MessageUtils.get("string");
    }


}
