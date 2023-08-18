package com.marketapp.MarketApp.repository;

import com.marketapp.MarketApp.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment,Long> {
}
