package org.apache.guacamole.tunnel.hzServer;

import org.apache.guacamole.net.GuacamoleTunnel;

/**
 * 每个虚拟机的连接请求
 * Created by milol on 2017/4/28.
 */
public class VmInfo {

    private String vmId;    //VmId
    private String vmName;  //VmName
    private String host;    //连接地址
    private String port;   //连接端口
    private String user;    //连接用户
    private String password;    //密码
    private String linkType;    //连接方式
    private GuacamoleTunnel tunnel ;    //guacd连接
    private int width;  //屏幕宽度
    private int height;

    public String getVmId() {
        return vmId;
    }

    public void setVmId(String vmId) {
        this.vmId = vmId;
    }

    public String getVmName() {
        return vmName;
    }

    public void setVmName(String vmName) {
        this.vmName = vmName;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLinkType() {
        return linkType;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }

    public GuacamoleTunnel getTunnel() {
        return tunnel;
    }

    public void setTunnel(GuacamoleTunnel tunnel) {
        this.tunnel = tunnel;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
