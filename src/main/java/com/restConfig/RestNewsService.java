package com.restConfig;

import com.model.News;
import com.model.NewsDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/news")
public class RestNewsService {
    NewsDAO dao;

    public RestNewsService(){
        dao = new NewsDAO();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON) //클라이언트 요청에 포함된 미디어타입을 지정. JSON을 사용
    public String addNews(News news){
        /*뉴스 등록*/
        try{
            dao.insertNews(news);
            // @Consumes 설정에 따라 HTTP Body에 포함된 JSON 문자열이 자동으로 News로 변환
            //이를 위해서 JSON 문자열의 키와 News 객체의 멤버 변수명이 동일해야 함.
        } catch (Exception e){
            e.printStackTrace();
            return "NEWS API : 뉴스 등록 실패";
        }
        return "News API : 뉴스 등록됨!";
    }

    @GET
    @Path("{aid}") // /api/news/100의 형태로 요청을 하면 100이 aid 값으로 자동 처리됨
    @Produces(MediaType.APPLICATION_JSON)
    public News getName(@PathParam("aid")int aid){
        /*뉴스 상세보기*/
        News news = null;
        try{
            news = dao.selectOne(aid);
        } catch (Exception e){
            e.printStackTrace();
        }
        return news;
        // @Produces 설정으로 News객체가 JSON문자열로 출력
    }

    @GET
    @Path("/news")
    @Produces(MediaType.APPLICATION_JSON)
    public String selectAll(News news){
        /*뉴스 목록 가져오기*/
        try{
            dao.selectAll();
        } catch (Exception e){
            e.printStackTrace();
            return "News API : 목록가져오기 실패";
        }
        return "NEWS API : 목록가져오기 성공";
    }

    @DELETE
    @Path("{aid}") // /api/news/100의 형태로 요청을 하면 100이 aid 값으로 자동 처리됨
    @Produces(MediaType.APPLICATION_JSON)
    public String DeleteNews(@PathParam("aid")int aid){
        /*뉴스 삭제하기*/

        try{
            dao.selectOne(aid);
        } catch (Exception e){
            e.printStackTrace();
            return "News API : 삭제 실패";
        }
        return "News API : 삭제성공";
    }






}
