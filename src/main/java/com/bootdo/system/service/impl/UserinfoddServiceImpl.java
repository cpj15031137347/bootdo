package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.UserinfoddDao;
import com.bootdo.system.domain.UserinfoddDO;
import com.bootdo.system.service.UserinfoddService;



@Service
public class UserinfoddServiceImpl implements UserinfoddService {
	@Autowired
	private UserinfoddDao userinfoddDao;
	
	@Override
	public UserinfoddDO get(Integer id){
		return userinfoddDao.get(id);
	}
	
	@Override
	public List<UserinfoddDO> list(Map<String, Object> map){
		return userinfoddDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return userinfoddDao.count(map);
	}
	
	@Override
	public int save(UserinfoddDO userinfodd){
		return userinfoddDao.save(userinfodd);
	}
	
	@Override
	public int update(UserinfoddDO userinfodd){
		return userinfoddDao.update(userinfodd);
	}
	
	@Override
	public int remove(Integer id){
		return userinfoddDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return userinfoddDao.batchRemove(ids);
	}
	
}
