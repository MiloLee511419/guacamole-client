package org.apache.guacamole.tunnel.hzServer;

import org.apache.guacamole.protocol.GuacamoleClientInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * http请求连接虚拟机工具类
 * 管理会话
 * Created by milol on 2017/4/27.
 */
public class TunnelSimplUtil {

    private final Logger logger = LoggerFactory.getLogger(TunnelSimplUtil.class);

//    public static Map<String,Object>

    /**
     * 获取用户浏览器高度与宽度
     * @param width
     * @param height
     * @return
     */
    public static GuacamoleClientInformation getGuacamoleClientInformation(Integer width,Integer height){
        GuacamoleClientInformation information = new GuacamoleClientInformation();
        information.setOptimalScreenHeight(height);
        information.setOptimalScreenWidth(width);
        //添加默认音频
        information.getAudioMimetypes().add("audio/L8");
        information.getAudioMimetypes().add("audio/L16");
        information.getImageMimetypes().add("image/jpeg");
        information.getImageMimetypes().add("image/png");
        return information;
    }

}
