package com.cos.newssave01;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import com.cos.newssave01.domain.News;

public class NewsControllerTest {
	
	
	
	@Test
	public void collect5(){
		RestTemplate rt = new RestTemplate();
		List<News> newsList = new ArrayList<>();
		
		for (int i = 1; i < 5; i++) {
			String url = "https://news.naver.com/main/read.naver?mode=LSD&mid=shm&sid1=103&oid=437&aid=0000277493";
			String html = rt.getForObject(url, String.class);

			Document doc = Jsoup.parse(html);
			

			Element titleElement = doc.selectFirst("#articleTitle");
			Element companyElement = doc.selectFirst("#aiticleCompany");
			Element createAtElement = doc.selectFirst("#articlecreateAt");
			
			String title = titleElement.text();
			System.out.println(title);
			String createAt = createAtElement.text();
			System.out.println(createAt);
			System.out.println("테스트");
			String company = companyElement.text();
			System.out.println(company);
			
			News news = News.builder()
					.title(title)
					.company(company)
					.createAt(createAt)
					.build();
			
			newsList.add(news);

		}
	}
}
