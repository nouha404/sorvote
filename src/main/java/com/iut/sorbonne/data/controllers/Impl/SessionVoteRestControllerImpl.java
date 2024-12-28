package com.iut.sorbonne.data.controllers.Impl;

import com.iut.sorbonne.data.controllers.SessionVoteRestController;
import com.iut.sorbonne.data.controllers.dto.response.RestResponseDto;
import com.iut.sorbonne.data.entities.SessionVote;
import com.iut.sorbonne.data.services.SessionVoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SessionVoteRestControllerImpl implements SessionVoteRestController {
    private final SessionVoteService sessionVoteService;

    @Override
    public ResponseEntity<Map<Object,Object>> listerSessionVote(int page, int size) {
        Page<SessionVote> sessionVotePage = sessionVoteService.getAllVotes(PageRequest.of(page, size));
        Map<Object,Object> response = RestResponseDto.response(sessionVotePage, HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
