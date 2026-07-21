package com.pulse.admin.customize.async;

import cn.hutool.extra.servlet.ServletUtil;
import com.pulse.common.utils.ServletHolderUtil;
import com.pulse.common.utils.ip.IpRegionUtil;
import com.pulse.common.enums.common.LoginStatusEnum;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.slf4j.Slf4j;

/**
 * 异步工厂（产生任务用）
 */
@Slf4j
public class AsyncTaskFactory {

    private AsyncTaskFactory() {
    }

    /**
     * 记录登录信息（仅日志输出，不持久化到数据库）
     *
     * @param username        用户名
     * @param loginStatusEnum 状态
     * @param message         消息
     * @return 任务task
     */
    public static Runnable loginInfoTask(final String username, final LoginStatusEnum loginStatusEnum, final String message) {
        final UserAgent userAgent = UserAgent.parseUserAgentString(
            ServletHolderUtil.getRequest().getHeader("User-Agent"));
        final String browser = userAgent.getBrowser() != null ? userAgent.getBrowser().getName() : "";
        final String ip = ServletUtil.getClientIP(ServletHolderUtil.getRequest());
        final String address = IpRegionUtil.getBriefLocationByIp(ip);
        final String os = userAgent.getOperatingSystem() != null ? userAgent.getOperatingSystem().getName() : "";

        log.info("ip: {}, address: {}, username: {}, loginStatusEnum: {}, message: {}", ip, address, username,
            loginStatusEnum, message);
        return () -> {
            log.info("Login record - user: {}, status: {}, msg: {}, ip: {}, browser: {}, os: {}",
                username, loginStatusEnum, message, ip, browser, os);
        };
    }

}
