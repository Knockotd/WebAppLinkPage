package com.portfolio.jeung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.jeung.dao.GoodsDao;
import com.portfolio.jeung.domain.DTOFile;
@Service
public class GoodsServiceImpl implements GoodsService {
@Autowired
private GoodsDao goodsDao;
	@Override
	public List<DTOFile> list() {
		
		return goodsDao.list();
	}

}
