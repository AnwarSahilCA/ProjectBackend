package com.search.demo.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="Event")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="event_id")
	private long eventId;
	@Column(name="deadline")
	private String deadline;
	@Column(name="description")
	private String Description;
	@Column(name="title")
	private String title;
	@Column(name="comments")
	private String comments;
	@Column(name="status")
	private String status;
	

}