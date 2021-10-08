package com.cos.newssave01.batch;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cos.newssave01.domain.News;
import com.cos.newssave01.domain.NewsRepository;
import com.cos.newssave01.utill.NaverCraw;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class NewBatch {
	private final NewsRepository newsRepository;
	private final NaverCraw naverCraw;
	
	 
	@Scheduled(fixedDelay=1000*60*1)
	public void newsCrawAndSave() {
		List<News>newsList =  naverCraw.collect5();
		newsRepository.saveAll(newsList);
		}	
}
