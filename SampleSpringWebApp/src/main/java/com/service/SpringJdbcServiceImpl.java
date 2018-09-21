package com.service;


import org.springframework.jdbc.BadSqlGrammarException;

import com.beans.VngMem;
import com.dao.SpringJdbcDaoImpl;

public class SpringJdbcServiceImpl implements SpringJdbcService {

	SpringJdbcDaoImpl springJdbcDao;
	public SpringJdbcDaoImpl getSpringJdbcDao() {
		return springJdbcDao;
	}

	public void setSpringJdbcDao(SpringJdbcDaoImpl springJdbcDao) {
		this.springJdbcDao = springJdbcDao;
	}

	public VngMem searchMemDts(VngMem vngmem) {
		try {
			return springJdbcDao.searchMemDts(vngmem);
		} catch (BadSqlGrammarException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insertMemDts(VngMem MemDtlsbean) {
		springJdbcDao.insertMemDts(MemDtlsbean);

	}

}
