package com.example.bsm.controller;

import com.example.bsm.vo.MessageVO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("test") // /test 형태로 맵핑
public class TestController {

    HttpStatus status;

    @RequestMapping(value="/connect", method= RequestMethod.GET)
    public ResponseEntity<MessageVO> getRequest() {

        HttpHeaders headers = new HttpHeaders();
        headers.set("BSM", "Fighting");

        MessageVO response = new MessageVO();

        try {
            response.setMessage("Success Request");
            status = HttpStatus.OK;
        } catch (Exception e) {
            response.setMessage("Fail Request");
            status = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(status)
                .headers(headers)
                .body(response);
    }

}
