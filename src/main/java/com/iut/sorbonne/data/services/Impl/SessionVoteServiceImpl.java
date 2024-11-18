package com.iut.sorbonne.data.services.Impl;

import com.iut.sorbonne.data.entities.SessionVote;
import com.iut.sorbonne.data.repositories.SessionVoteRepository;
import com.iut.sorbonne.data.services.SessionVoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SessionVoteServiceImpl implements SessionVoteService {
    private SessionVoteRepository sessionVoteRepository;

    @Override
    public Page<SessionVote> getAllVotes(Pageable page) {
        return sessionVoteRepository.findAllByIsActiveTrue(page);
    }
}
