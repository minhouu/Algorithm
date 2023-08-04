package com.hh.fit.model;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class VideoReviewDaoImpl {
	private Map<Integer, ArrayList<VideoReview>> videoReviewDb = new HashMap<Integer, ArrayList<VideoReview>>();
	private static VideoReviewDaoImpl instance;

	private VideoReviewDaoImpl() {
	}

	public static VideoReviewDaoImpl getInstance() {
		if (instance == null) {
			instance = new VideoReviewDaoImpl();
			Gson gson = new Gson();
			try (FileReader reader = new FileReader("data/review.json")) {
				VideoReview[] reviews = gson.fromJson(reader, VideoReview[].class);
				for (int i = 0; i < reviews.length; i++) {
					int key = reviews[i].getVideoNo();
					ArrayList<VideoReview> temp = instance.videoReviewDb.getOrDefault(key,
							new ArrayList<VideoReview>());
					temp.add(reviews[i]);
					instance.videoReviewDb.put(key, temp);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}

	public ArrayList<VideoReview> selectReview(int videoNo) {
		return videoReviewDb.get(videoNo);
	}

	public void insertReview(VideoReview videoReview) {
		ArrayList<VideoReview> temp = videoReviewDb.getOrDefault(videoReview.getVideoNo(),
				new ArrayList<VideoReview>());
		temp.add(videoReview);
		videoReviewDb.put(videoReview.getVideoNo(), temp);
		return;
	}

}