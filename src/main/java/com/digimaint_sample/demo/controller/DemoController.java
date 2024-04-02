
package com.digimaint_sample.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/video")
    public String videoPage() {
        return "video";
    }
}