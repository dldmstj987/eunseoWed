package dao;

import com.model.News;
import com.model.NewsDAO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.List;


@Log4j2
public class NewsDAOTests {
    private NewsDAO newsDAO;

    @BeforeEach
    public void ready(){newsDAO = new NewsDAO();}

    /*데베가 잘 연결되어 있는지 확인하는 테스트 코드*/
    @Test
    public void testConnection() throws Exception{
        NewsDAO newsDAO = new NewsDAO();
        Connection connection = newsDAO.open();
        log.info(connection);

    }

    /*데베 안으로 잘 들어가는지 확인하는 코드*/
    @Test
    public void testInsertNews() throws Exception{
        for(int i = 1; i <= 7; i++){
            News news = News.builder()
                    .title("JDBC NEWS..." + i)
                    .img("NEWS" + i)
                    .content("시사" + i)
                    .build();
            newsDAO.insertNews(news);
        }
    }

    /*뉴스 기사 목록 전체를 가져오는지 확인하는 테스트 코드*/
    @Test
    public void testSelectAll() throws Exception{
        List<News> list = newsDAO.selectAll();

        for(News news : list){
            System.out.println(news);
        }
    }

    @Test
    public void testSelectOne() throws Exception{
        int aid = 2;
        News news = newsDAO.selectOne(aid);
        System.out.println(news);
    }

    @Test
    public void testDeleteNews() throws Exception{
        List<News> list = newsDAO.selectAll();
        list.forEach(News -> System.out.println(newsDAO));

        int aid = 3;
        newsDAO.deleteNews(aid);

        list = newsDAO.selectAll();
        list.forEach(news -> System.out.println(news));
    }
}
