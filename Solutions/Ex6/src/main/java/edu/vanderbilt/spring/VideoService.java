package edu.vanderbilt.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VideoService {

	private VideoRepository videos_;
	
	@Autowired
	public VideoService(VideoRepository repo) {
		videos_ = repo;
	}
	
	@RequestMapping(value="/video/{id}", method=RequestMethod.GET)
	public Video getVideo(@PathVariable("id") Long videoId){
		System.out.println("id:"+videoId);
		return videos_.findOne(videoId);
	}
	
	@RequestMapping(value="/video/{id}", method=RequestMethod.POST)
	public Video postVideo(@PathVariable("id") Long videoId){
		System.out.println("id:"+videoId);
		return videos_.findOne(videoId);
	}
	
	@RequestMapping(value="/video", method=RequestMethod.POST)
	public Iterable<Video> addVideo(@RequestBody Video video){
		videos_.save(video);
		return videos_.findAll();
	}
	
	@RequestMapping(value="/video", method=RequestMethod.GET)
	public Iterable<Video> getVideo(){
		return videos_.findAll();
	}
	
	@RequestMapping(value="/video/{id}", method=RequestMethod.DELETE)
	public Iterable<Video> deleteVideo(@PathVariable("id") Long videoId){
		videos_.delete(videoId);
		return videos_.findAll();
	}
	
	@RequestMapping(value="/test/foo", method=RequestMethod.GET)
	public String myTest() {
		return "Test";
	}
}
