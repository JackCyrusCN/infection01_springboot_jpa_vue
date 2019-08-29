package org.eastwill.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.domain.Page;

public class BaseController {
	protected Map<String, Object> getDataTable(Page<?> pageInfo) {
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", pageInfo.getContent());
        rspData.put("total", pageInfo.getTotalElements());
        return rspData;
    }
}
