package com.search.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.search.demo.comment.Comment;
@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

}
