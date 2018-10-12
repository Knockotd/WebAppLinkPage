package com.portfolio.jeung.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portfolio.jeung.domain.DTOFile;

@Repository
public class GoodsDao {
@Autowired
private SqlSession sqlSession;

public List<DTOFile> list(){
	return sqlSession.selectList("goods.alldata");
}
}
