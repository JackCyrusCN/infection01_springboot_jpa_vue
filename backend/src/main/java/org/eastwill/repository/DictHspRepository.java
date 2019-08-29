package org.eastwill.repository;

import org.eastwill.domain.DictHsp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
@Transactional(timeout=15)
public interface DictHspRepository extends JpaRepository<DictHsp, String> {
	//查询医院信息
	@Query(value="SELECT hsp_code, hsp_name, organization_code, prov_id, city_id, county_id, street_id, addr_detail, hos_key FROM public.dict_hsp",nativeQuery=true)
	public DictHsp searchDictHsp();
	
	//根据传入的医院key查询医院信息
	@Query(value="SELECT hsp_code, hsp_name, organization_code, prov_id, city_id, county_id, street_id, addr_detail, hos_key FROM public.dict_hsp where hos_key=?1",nativeQuery=true)
	public DictHsp searchByHoskey(String thoskey);
}
