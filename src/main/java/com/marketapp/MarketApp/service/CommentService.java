package com.marketapp.MarketApp.service;

import com.marketapp.MarketApp.model.Comment;
import com.marketapp.MarketApp.repository.CommentRepository;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// For Redis
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Could not find comment by id" + id));
    }

    public List<Comment> getAll() {
        return new ArrayList<Comment>((Collection<? extends Comment>) commentRepository.findAll());
    }

    public Comment updateComment(Long id, Comment comment) {
        Comment oldComment = getCommentById(id);
        oldComment.setComment(comment.getComment());
        return commentRepository.save(oldComment);
    }

    public Comment deleteComment(Long id) {
        Comment comment = getCommentById(id);
        commentRepository.delete(comment);
        return comment;
    }


}
