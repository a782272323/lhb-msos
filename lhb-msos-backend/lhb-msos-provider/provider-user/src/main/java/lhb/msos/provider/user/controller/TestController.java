package lhb.msos.provider.user.controller;

import lhb.msos.commons.utils.BaseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @GetMapping("/test")
    public BaseResult test() {
        return BaseResult.ok();
    }
}
