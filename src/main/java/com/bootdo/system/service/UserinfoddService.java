package com.bootdo.system.service;

import com.bootdo.system.domain.UserinfoddDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-05-13 16:51:33
 */
public interface UserinfoddService {
	
	UserinfoddDO get(Integer id);
	
	List<UserinfoddDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UserinfoddDO userinfodd);
	
	int update(UserinfoddDO userinfodd);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
