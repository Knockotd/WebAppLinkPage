package com.portfolio.jeung;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.portfolio.jeung.dao.GoodsDao;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class TestPlay {
    @Autowired
    private SqlSession sqlSession;
    @Autowired
    private GoodsDao goodsDao;
    
    @Test
    public void method() {
        System.out.println(sqlSession);
        System.out.println(goodsDao.list());
    }
}
