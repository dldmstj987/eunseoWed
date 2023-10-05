package dao;

import com.model.News;
import com.model.NewsDAO;
import com.service.NewsService;
import lombok.extern.log4j.Log4j2;

import org.junit.jupiter.api.Test;


@Log4j2
public class NewsServiceTests {

    private NewsService newsService;

   @Test
    public void testGetFileName() throws Exception{
     News news = News.builder()
             .img("aaa.jpg")
             .build();

   }

   @Test
    public void testAddNews() throws Exception{

   }
}
