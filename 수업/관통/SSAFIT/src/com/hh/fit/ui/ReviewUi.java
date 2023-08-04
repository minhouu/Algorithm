package com.hh.fit.ui;

import java.util.ArrayList;

import com.hh.fit.model.VideoReview;
import com.hh.fit.model.VideoReviewDaoImpl;

public class ReviewUi {
	VideoReviewDaoImpl rm = VideoReviewDaoImpl.getInstance();
	public void listReview(int no) {
		ArrayList<VideoReview> temp = rm.selectReview(no);
		for (int i = 0; i < temp.size(); i++) {
			System.out.println(
					" " + temp.get(i).getReviewNo() + " " + temp.get(i).getNickName() + " " + temp.get(i).getContent());
		}
	}
	
	public void registerReview(int no, String nickName, String content) {
		ArrayList<VideoReview> temp = rm.selectReview(no);
		VideoReview newReview = new VideoReview(no, temp.size()+1, nickName, content);
		temp.add(newReview);
	};
}
