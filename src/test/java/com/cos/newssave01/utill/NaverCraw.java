package com.cos.newssave01.utill;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cos.newssave01.domain.News;

@Component
public class NaverCraw {

	int aidNum = 5;
	
	
	public List<News> collect5(){
		RestTemplate rt = new RestTemplate();
		List<News> newsList = new ArrayList<>();
		
		
		for (int i = 1; i < 5; i++) {
			String aid = String.format("%010d", aidNum);
			String url = "https://news.naver.com/main/read.naver?mode=LSD&mid=shm&sid1=103&oid=437&aid=0000277493";
			String html = rt.getForObject(url, String.class);

			Document doc = Jsoup.parse(html);
			

			Element titleElement = doc.selectFirst("#articleTitle");
			Element companyElement = doc.selectFirst("#aiticleCompany");
			Element createAtElement = doc.selectFirst("#articlecreateAt");
			
			String title = titleElement.text();
			String company = companyElement.text();
			String createAt = createAtElement.text();
			
			News news = News.builder()
					.title(title)
					.company(company)
					.createAt(createAt)
					.build();
			
			newsList.add(news);

			aidNum ++;
		}
		return newsList;
	}
}
	