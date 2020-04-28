package mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

/**
 * @author ：zht
 * @date ：Created in 2020/3/18 9:36
 * @description：
 * @modified By：
 * @version: $
 */
//服务器端消息处理器
public class MinaServerHandler extends IoHandlerAdapter {
    @Override//一次会话被打开
    public void sessionOpened(IoSession session) throws Exception {
        super.sessionOpened(session);
        System.out.println("client"+session.getRemoteAddress());
    }

    @Override//一次会话结束
    public void sessionClosed(IoSession session) throws Exception {
        super.sessionClosed(session);
        System.out.println("client closed");
    }

    @Override//接收消息
    public void messageReceived(IoSession session, Object message) throws Exception {
        super.messageReceived(session, message);
        //String msg = (String) message;//接收到的消息对象
        Message msg = (Message)message;
        System.out.println("收到的消息为"+msg);
        msg.setInfo("46464");
        //向客户端发送消息对象
        session.write(msg);
    }
}
