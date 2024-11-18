package com.iut.sorbonne.data.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface SessionVoteRestController {
    @GetMapping("/sessionVote")
    ResponseEntity<?> listerSessionVote(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "8") int size)
    ;

}
