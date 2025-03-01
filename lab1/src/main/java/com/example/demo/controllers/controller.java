package com.example.demo.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/action")
class GetController {
    private int getCount = 0;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String handleGet(HttpServletRequest request) {
        System.out.println("Get count: " + getCount++);
        return "Get";
    }
}

@RestController
@RequestMapping("/api/action")
class PostController {
    private int postCount = 0;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String handlePost(HttpServletRequest request) {
        System.out.println("Post count: " + postCount++);
        return "Post";
    }
}

@RestController
@RequestMapping("/api/action")
class PutController {
    private int putCount = 0;

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public String handlePut(HttpServletRequest request) {
        System.out.println("Put count: " + putCount++);
        return "Put";
    }
}

@RestController
@RequestMapping("/api/action")
class DeleteController {
    private int deleteCount = 0;

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public String handleDelete(HttpServletRequest request) {
        System.out.println("Delete count: " + deleteCount++);
        return "Delete";
    }
}
