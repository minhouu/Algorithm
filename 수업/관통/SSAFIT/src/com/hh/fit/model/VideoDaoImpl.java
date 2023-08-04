package com.hh.fit.model;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class VideoDaoImpl {
	private List<Video> list = new ArrayList<Video>();
	private static VideoDaoImpl instance;

	private VideoDaoImpl() {

	}

	public static VideoDaoImpl getInstance() {
		if (instance == null) {
			instance = new VideoDaoImpl();
			Gson gson = new Gson();
			try (FileReader reader = new FileReader("data/video.json")) {
				Video[] videos = gson.fromJson(reader, Video[].class);
				for (int i = 0; i < videos.length; i++) {
					instance.list.add(videos[i]);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}

	public List<Video> selectVideo() {
		return this.list;
	}

	public Video selectVideoByNo(int no) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNo() == no) {
				return list.get(i);
			}
		}
		return null;
	}
}
