package com.example.bsm.controller;

import com.example.bsm.common.ResponseObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("test") // /test 형태로 맵핑
public class TestController {

    HttpStatus status;

    @RequestMapping(value="/connect", method= RequestMethod.GET)
    public ResponseEntity<ResponseObject> getRequest() {

        HttpHeaders headers = new HttpHeaders();
        headers.set("BSM", "Fighting");

        ResponseObject response = new ResponseObject();

        try {
            response.setSuccess(true);
            response.setMessage("Success Request");
            status = HttpStatus.OK;
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("Fail Request");
            status = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(status)
                .headers(headers)
                .body(response);
    }

}
