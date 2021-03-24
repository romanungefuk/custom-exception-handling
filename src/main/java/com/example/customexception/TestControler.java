package com.example.customexception;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestControler {

    @RequestMapping("/api")
    public void message() throws CustomException {
        throw new CustomException();
    }
}
