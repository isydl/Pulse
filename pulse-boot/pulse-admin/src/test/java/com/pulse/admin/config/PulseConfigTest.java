package com.pulse.admin.config;


import com.pulse.admin.PulseAdminApplication;
import com.pulse.common.config.PulseConfig;
import com.pulse.common.constant.Constants.UploadSubDir;
import java.io.File;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = PulseAdminApplication.class)
@RunWith(SpringRunner.class)
public class PulseConfigTest {

    @Resource
    private PulseConfig config;

    @Test
    public void testConfig() {
        String fileBaseDir = "D:\\pulse\\profile";

        Assertions.assertEquals("Pulse", config.getName());
        Assertions.assertEquals("1.8.0", config.getVersion());
        Assertions.assertEquals("2022", config.getCopyrightYear());
        Assertions.assertFalse(config.isDemoEnabled());
        Assertions.assertEquals(fileBaseDir, PulseConfig.getFileBaseDir());
        Assertions.assertFalse(PulseConfig.isAddressEnabled());
        Assertions.assertEquals("math", PulseConfig.getCaptchaType());
        Assertions.assertEquals("math", PulseConfig.getCaptchaType());
        Assertions.assertEquals(fileBaseDir + "\\import",
            PulseConfig.getFileBaseDir() + File.separator + UploadSubDir.IMPORT_PATH);
        Assertions.assertEquals(fileBaseDir + "\\avatar",
            PulseConfig.getFileBaseDir() + File.separator + UploadSubDir.AVATAR_PATH);
        Assertions.assertEquals(fileBaseDir + "\\download",
            PulseConfig.getFileBaseDir() + File.separator + UploadSubDir.DOWNLOAD_PATH);
        Assertions.assertEquals(fileBaseDir + "\\upload",
            PulseConfig.getFileBaseDir() + File.separator + UploadSubDir.UPLOAD_PATH);
    }

}
