package com.service;

import com.beans.VngMem;

public interface SpringJdbcService {
	
	VngMem searchMemDts(VngMem vngmem);
	 
	void insertMemDts(VngMem MemDtlsbean);

}
