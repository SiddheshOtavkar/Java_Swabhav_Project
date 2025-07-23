package com.aurionpro.OCP.test;

import com.aurionpro.OCP.model.Article;
import com.aurionpro.OCP.model.Quiz;
import com.aurionpro.OCP.model.Video;

public class Test {
	public static void main(String[] args) {
		ContentTypeMethod renderer = new ContentTypeMethod();

		renderer.contentType(new Video()); // → Play Video
		renderer.contentType(new Article()); // → Display Article
		renderer.contentType(new Quiz()); // → Quiz Display
		
	}
}
