package com.pulse.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Pulse Admin 启动程序
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = "com.pulse.*")
public class PulseAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(PulseAdminApplication.class, args);
        String successMsg = "  ____        _            _        \n"
                          + " |  _ \\ _   _| | ___  ___ | |_       \n"
                          + " | |_) | | | | |/ _ \\/ __|| __|      \n"
                          + " |  __/| |_| | |  __/\\__ \\| |_       \n"
                          + " |_|    \\__,_|_|\\___||___/ \\__|     \n"
                          + "                                     \n"
                          + " :: Pulse Admin ::  (v1.0.0)\n";

        System.out.println(successMsg);
    }
}
