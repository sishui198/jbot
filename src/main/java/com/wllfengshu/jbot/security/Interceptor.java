package com.wllfengshu.jbot.security;

import com.wllfengshu.jbot.utils.FileUtil;
import com.wllfengshu.jbot.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 参数检测
 *
 * @author wllfengshu
 */
@Slf4j
public class Interceptor {

    private static final Set<String> black = new HashSet<>();

    static {
        try {
            black.addAll(Arrays.asList(
                    "java", "model", "xml"
            ));
            black.addAll(FileUtil.readFile2Set("public/javaKeys"));
        } catch (Exception e) {
            log.error("对项目名、包名进行过滤异常", e);
        }
    }

    /**
     * 检查project(只能使用字母、数字、中划线、下划线，不超过50个字符)
     *
     * @param deci
     * @return false 不通过
     *          true 通过
     */
    public static boolean checkProject(String deci) {
        if (StringUtil.isEmpty(deci) || deci.length() < 2 || deci.length() > 50 || !StringUtil.checkProjectName(deci) || black.contains(deci)) {
            return false;
        }
        return true;
    }

    /**
     * 检查package(只能使用字母、数字、点，不超过100个字符)
     *
     * @param deci
     * @return false 不通过
     *          true 通过
     */
    public static boolean checkPackage(String deci) {
        if (StringUtil.isEmpty(deci) || deci.length() < 2 || deci.length() > 100 || !StringUtil.checkPackageName(deci) || black.contains(deci)) {
            return false;
        }
        return true;
    }

}
