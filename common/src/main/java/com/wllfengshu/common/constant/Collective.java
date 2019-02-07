package com.wllfengshu.common.constant;

import com.wllfengshu.common.utils.StringUtil;

/**
 * 公共常量集合
 * @author wllfengshu
 */
public class Collective {

    /**
     * 目标项目存放路径
     */
    public static final String TARGET_PROJECT_HOME = "/home/listen/Apps";

    /**
     * 模板项目名
     */
    public static final String MODEL_PROJECT_NAME = "model";

    /**
     * 模板项目包名
     */
    public static final String MODEL_PACKAGE_NAME = "com.wllfengshu";

    /**
     * 模板项目根路径
     */
    public static final String MODEL_PROJECT_HOME = "./"+MODEL_PROJECT_NAME;

    /**
     * 模板项目java文件夹路径
     */
    public static final String MODEL_PROJECT_HOME_JAVA = MODEL_PROJECT_HOME+"/src/main/java";

    /**
     * 模板项目resources文件夹路径
     */
    public static final String MODEL_PROJECT_HOME_RESOURCES = MODEL_PROJECT_HOME+"/src/main/resources";

    /**
     * 模板项目基础包路径
     */
    public static final String MODEL_PROJECT_HOME_JAVA_PACKAGE_BASE = MODEL_PROJECT_HOME_JAVA+"/"+StringUtil.spotToSlash(MODEL_PACKAGE_NAME+"/"+MODEL_PROJECT_NAME);
}
