package org.example.domain.issue;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
public class IssueService {

    private final IssueRepository issueRepository;

    public List<IssueEntity> findAll(){
        return issueRepository.findAll();
    }
    @Transactional
    public void create(String summary, String description){
        issueRepository.insert(summary,description);
    }

    public IssueEntity findById(long issueId) {
        return issueRepository.findById(issueId);
    }
    @Transactional
    public void update(long issueId, String summary, String description) {
        issueRepository.update(issueId,summary,description);
    }
    @Transactional
    public void delete(long issueId) {
        issueRepository.delete(issueId);
    }
}
