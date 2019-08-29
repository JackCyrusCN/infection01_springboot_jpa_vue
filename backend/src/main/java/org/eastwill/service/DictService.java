package org.eastwill.service;

import org.eastwill.domain.Dict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DictService {

	Page<Dict> findPageAll(Pageable pageable);
}
