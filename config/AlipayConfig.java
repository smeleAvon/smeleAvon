import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Properties;

/**
 * @author jiang hui
 * @date 2019/8/24
 */
@Component
public class AlipayConfig {

    public static final String URL = "http://localhost:8081";
    public static final String FRONT_URL = "http://localhost:8080";
    public static final String FROM_EMAIL = "1121057486@qq.com";
    public static final String ALIPAY_DEMO = "alipay_demo";
    public static final String ALIPAY_DEMO_VERSION = "alipay_demo_JAVA_20180907104657";

    private static AlipayClient alipayClient;

    /**
     * 配置文件加载
     */
    private static Properties prop;

    /**
     * 配置文件名称
     */
    public static String CONFIG_FILE = "Alipay-Config.properties";

    /**
     * 配置文件相对路径
     */
    public static String ALIPAY_CONFIG_PATH = File.separator + "etc" + File.separator + CONFIG_FILE;

    /**
     * 项目路径
     */
    public static String PROJECT_PATH = "";

    private static Log logger = LogFactory.getLog(AlipayConfig.class);


    /**
     * 初始化配置值
     */
    public static void initProperties() {
        prop = new Properties();
        try {
            synchronized (prop) {
                InputStream inputStream = AlipayConfig.class.getClassLoader().getResourceAsStream(CONFIG_FILE);
                prop.load(inputStream);
                inputStream.close();
            }
            String address = getUrl();
            prop.setProperty("NOTIFY_URL", address + "/finance/notify");
            prop.setProperty("RETURN_URL", address + "/finance/returnHandler");
        } catch (IOException e) {
            logger.error("日志 =============》： 配置文件Alipay-Config.properties找不到");
            e.printStackTrace();
        }
    }

    private static String getUrl() {
        return URL;
    }

    /**
     * 获取配置文件信息
     *
     * @return 配置文件信息
     */
    public static Properties getProperties() {
        if (prop == null) {
            initProperties();
        }
        return prop;
    }

}