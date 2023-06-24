package com.search.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.search.demo.Repository.CommentRepository;
import com.search.demo.comment.Comment;

@RestController
@CrossOrigin
@RequestMapping("/comment")
public class CommentController {
	@Autowired
	CommentRepository crepo;
	@PostMapping()
	@RequestMapping("/create")
	public Comment create(@RequestBody Comment comment) {
		return crepo.save(comment);
	}
	

}