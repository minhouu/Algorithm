package com.hh.fit.model;

import java.util.List;

public interface VideoReviewDao {
	public abstract int InsertReview(int VideoReview);
	
	public abstract List<VideoReview> selectReview();
	
}
