package com.example.demo.Controller;
import com.example.demo.model.MessageModel;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class APIController {

    @GetMapping(value = "/public")
    public MessageModel publicEndpoint() {
        return new MessageModel("All good. You DO NOT need to be authenticated to call /api/public.");
    }

    @GetMapping(value = "/private")
    public MessageModel privateEndpoint() {
        return new MessageModel("Private Route, access token verified");
    }

    @GetMapping(value = "/private-scoped")
    public MessageModel privateScopedEndpoint() {
        return new MessageModel("Only with read:message scope");
    }
}