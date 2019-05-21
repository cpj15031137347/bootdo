package com.bootdo.system.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.system.domain.UserinfoddDO;
import com.bootdo.system.service.UserinfoddService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-05-13 16:51:33
 */
 
@Controller
@RequestMapping("/system/userinfodd")
public class UserinfoddController {
	@Autowired
	private UserinfoddService userinfoddService;
	
	@GetMapping()
	@RequiresPermissions("system:userinfodd:userinfodd")
	String Userinfodd(){
	    return "system/userinfodd/userinfodd";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:userinfodd:userinfodd")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<UserinfoddDO> userinfoddList = userinfoddService.list(query);
		int total = userinfoddService.count(query);
		PageUtils pageUtils = new PageUtils(userinfoddList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:userinfodd:add")
	String add(){
	    return "system/userinfodd/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("system:userinfodd:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		UserinfoddDO userinfodd = userinfoddService.get(id);
		model.addAttribute("userinfodd", userinfodd);
	    return "system/userinfodd/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:userinfodd:add")
	public R save( UserinfoddDO userinfodd){
		if(userinfoddService.save(userinfodd)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:userinfodd:edit")
	public R update( UserinfoddDO userinfodd){
		userinfoddService.update(userinfodd);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:userinfodd:remove")
	public R remove( Integer id){
		if(userinfoddService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:userinfodd:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		userinfoddService.batchRemove(ids);
		return R.ok();
	}
	
}
