package com.hh.fit.model;

import java.util.List;

public interface VideoDao {
	public abstract List<Video> selectVideo();

	public abstract Video selectVideoByNo(int no);

}
