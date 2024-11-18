package com.iut.sorbonne.data.controllers.Impl;

import com.iut.sorbonne.data.controllers.SessionVoteRestController;
import com.iut.sorbonne.data.services.SessionVoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SessionVoteRestControllerImpl implements SessionVoteRestController {
    private final SessionVoteService sessionVoteService;
    @Override
    public ResponseEntity<?> listerSessionVote(int page, int size) {
        return null;
    }
}
