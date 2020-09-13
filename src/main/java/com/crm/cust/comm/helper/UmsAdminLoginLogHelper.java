package com.crm.cust.comm.helper;

import com.crm.cust.entity.UmsAdmin;
import com.crm.cust.entity.UmsAdminLoginLog;
import com.crm.cust.service.IUmsAdminLoginLogService;
import com.crm.cust.service.IUmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @ClassName UmsAdminLoginLogHelper
 * @Description TODO
 * @Author lvhd
 * @Date 2020/9/12、23:32
 * @Version 1.0.0
 */
@Component
public class UmsAdminLoginLogHelper {

    @Autowired
    private IUmsAdminLoginLogService umsAdminLoginLogService;
    @Autowired
    private IUmsAdminService umsAdminService;
    /**
     * 添加登录记录
     * @param username 用户名
     */
    public void insertLoginLog(String username) {
        UmsAdmin admin = umsAdminService.loadUserByUsername(username);
        if(admin==null) {
            return;
        }
        UmsAdminLoginLog loginLog = new UmsAdminLoginLog();
        loginLog.setAdminId(admin.getId());
        loginLog.setCreateTime(new Date());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        loginLog.setIp(request.getRemoteAddr());
        umsAdminLoginLogService.save(loginLog);
    }
}
