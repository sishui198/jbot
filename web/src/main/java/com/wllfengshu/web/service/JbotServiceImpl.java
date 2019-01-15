package com.wllfengshu.web.service;

import com.wllfengshu.common.constant.Collective;
import com.wllfengshu.common.utils.FileDownloadUtil;
import com.wllfengshu.core.Launch;
import com.wllfengshu.web.dao.JbotDao;
import com.wllfengshu.common.entity.ConnectInfo;
import com.wllfengshu.common.entity.DBInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Service
public class JbotServiceImpl implements JbotService {

	@Autowired
	private JbotDao jbotDao;
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public Map<String, Object> settingProject(ConnectInfo connectInfo){
		Map<String, Object> result = new HashMap<>();
		//获取数据库中的表信息
		result.put("data",jbotDao.getDBInfo(connectInfo.getDbName()));
		logger.info("JbotServiceImpl,settingProject-------->result:{}",result);
		return result;
	}

	@Override
	public Map<String, Object> produceProject(String projectName, String packageName, DBInfo dbInfo, HttpServletResponse response){
		Map<String, Object> result = new HashMap<>();
		//调用生成项目的入口类
		if (Launch.start(projectName, packageName, dbInfo)){
			FileDownloadUtil.download(Collective.TARGET_PROJECT_HOME+"/"+projectName+".zip",response);
		}else {
			result.put("isSuccess",false);
		}
		logger.info("JbotServiceImpl,produceProject-------->result:{}",result);
		return result;
	}
}
