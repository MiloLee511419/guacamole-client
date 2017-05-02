package org.apache.guacamole.tunnel.hzServer;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 记录当前使用的虚拟机信息
 * Created by milol on 2017/4/28.
 */
public class UserInfo {

    public static Map<String,UserInfo> userMap = new HashMap<String, UserInfo>();   //保存连接的用户信息

    private String sUseId;  //请求连接的用户
    private Long sEndTime;  //结束的时间

    public UserInfo(String sUseId,Long sEndTime){
        this.sUseId = sUseId;
        this.sEndTime = sEndTime;
    }

    private Queue<VmInfo> vmList = new LinkedList<VmInfo>();    //用户当前请求

    private Map<String,VmInfo> vmMap = new HashMap<String, VmInfo>();   //用户已获取的连接  key:vmId value:连接信息

    public String getsUseId() {
        return sUseId;
    }

    public void setsUseId(String sUseId) {
        this.sUseId = sUseId;
    }

    public Long getsEndTime() {
        return sEndTime;
    }

    public void setsEndTime(Long sEndTime) {
        this.sEndTime = sEndTime;
    }

    public Queue<VmInfo> getVmList() {
        return vmList;
    }

    public void setVmList(Queue<VmInfo> vmList) {
        this.vmList = vmList;
    }

    public Map<String, VmInfo> getVmMap() {
        return vmMap;
    }

    public void setVmMap(Map<String, VmInfo> vmMap) {
        this.vmMap = vmMap;
    }

    public static void addUserInfo(HttpServletRequest request){
        String useId = request.getParameter("userId"); //用户名
        request.getSession().setAttribute("useId",useId); //存放用户姓名
        Long endTime = Long.parseLong(request.getParameter("endTime")); //结束时间
        String vmId = request.getParameter("vmId");
        UserInfo userInfo = userMap.get("userName");
        if(userInfo==null){
            userInfo = new UserInfo(useId,endTime);
            userMap.put(useId,userInfo);
        }

        VmInfo vmInfo = userInfo.getVmMap().get(vmId)==null?new VmInfo():userInfo.getVmMap().get(vmId);
        vmInfo.setVmId(vmId);
        vmInfo.setVmName(request.getParameter("vmName"));
        vmInfo.setHost(request.getParameter("host"));
        vmInfo.setPort(request.getParameter("port"));
        vmInfo.setUser(request.getParameter("user"));
        vmInfo.setPassword(request.getParameter("password"));
        vmInfo.setLinkType(request.getParameter("linkType"));
        vmInfo.setWidth(Integer.parseInt(request.getParameter("width")));
        vmInfo.setHeight(Integer.parseInt(request.getParameter("height")));
        if(vmInfo.getTunnel()==null){
            userInfo.getVmMap().put(vmId,vmInfo);
            userInfo.getVmList().offer(vmInfo);
        }
    }


}
