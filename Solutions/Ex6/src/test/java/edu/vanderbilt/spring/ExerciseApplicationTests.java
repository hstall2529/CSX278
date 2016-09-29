package edu.vanderbilt.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExerciseApplicationTests {

	@Autowired
	VideoService videoService;
	
	@Test
	public void contextLoads() {	
	}
	
	@Test
	public void videoServiceLoaded() {
		assertNotNull(videoService);
	}
	
	@Test
	public void addVideoReturnsAListOfVideos() {
		Video video = new Video();
		Iterable<Video> videos = videoService.addVideo(video);
		assertNotNull(videos);
		assertTrue(videos.iterator().hasNext());
	}
	
	// Tests getVideo method
	@Test
	public void getVideoFunctionalityTest() {
		Video video = new Video();
		Iterable<Video> videos = videoService.addVideo(video);
		Iterable<Video> retrievedVideo = videoService.getVideo();
		assertNotNull(retrievedVideo);
		assertTrue(retrievedVideo.iterator().hasNext());
	}
	
	// Tests postVideo method
	@Test
	public void postVideoFunctionalityTest() {
		Iterable<Video> retrievedVideo = videoService.addVideo(new Video());
		assertNotNull(retrievedVideo);
		assertTrue(retrievedVideo.iterator().next().getId() != 0);
	}

	
	// Test update video method
	@Test
	public void updateVideoFunctionalityTest() {
		Video video = new Video();
		video.setId((long)1);	
		Iterable<Video> videos = videoService.addVideo(video);
		
		Video repeatVideo = new Video();
		repeatVideo.setName("taco");
		repeatVideo.setId((long)1);
		videos = videoService.addVideo(repeatVideo);
		
		Video retrievedVideo = videoService.postVideo((long)1);
		
		assertTrue(retrievedVideo.getName().equals("taco"));
		
	}
	
	// Test delete video method
	public void deleteVideoFunctionalityTest() {
		Video video = new Video();
		video.setId((long)100);
		
		Iterable<Video> videos = videoService.addVideo(video);
		videos = videoService.deleteVideo((long)100);
		Video deletedVid = videoService.getVideo((long)100);
		assertTrue(deletedVid == null);
		
	}
}
