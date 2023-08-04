package com.hh.fit.model;

public class VideoReview {
	private int videoNo;
	private int reviewNo;
	private String nickName;
	private String content;
	
	
	public VideoReview() {
		super();
	}


	public VideoReview(int videoNo, int reviewNo, String nickName, String content) {
		super();
		this.videoNo = videoNo;
		this.reviewNo = reviewNo;
		this.nickName = nickName;
		this.content = content;
	}


	public int getVideoNo() {
		return videoNo;
	}


	public void setVideoNo(int videoNo) {
		this.videoNo = videoNo;
	}


	public int getReviewNo() {
		return reviewNo;
	}


	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}


	public String getNickName() {
		return nickName;
	}


	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}
	
	
}
