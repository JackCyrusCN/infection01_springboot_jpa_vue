package org.eastwill.service;

import org.eastwill.domain.DictHsp;

public interface DictHspService {
	public DictHsp searchDictHsp();
	public DictHsp searchByHoskey(String thoskey);
}
