package com.thinkgem.jeesite.tools;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.TooManyListenersException;

import com.mysql.jdbc.StringUtils;

import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;

public class Comm implements Runnable, SerialPortEventListener {
	// 检测系统中可用的通讯端口类
	private static CommPortIdentifier portId;
	private static Enumeration<CommPortIdentifier> portList;
	// 输入输出流
	public static InputStream inputStream;
	public static OutputStream outputStream;
	// RS-232的串行口
	public static SerialPort serialPort;
	//初始化串口  
    public static void init() {  
        portList = CommPortIdentifier.getPortIdentifiers();  
        while (portList.hasMoreElements()) {  
            portId = (CommPortIdentifier) portList.nextElement();  
            if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL){  
                if (portId.getName().equals("COM8")) {  
                    try {  
                        serialPort = (SerialPort) portId.open("SerialPort-Test", 2000);  
                        serialPort.addEventListener(new Comm());  
                        serialPort.notifyOnDataAvailable(true);  
                        /* 设置串口通讯参数 */  
                        serialPort.setSerialPortParams(115200,SerialPort.DATABITS_8, SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);  
                          
                        outputStream = serialPort.getOutputStream();  
                        inputStream = serialPort.getInputStream();  
                    } catch (PortInUseException e) {  
                        e.printStackTrace();  
                    } catch (TooManyListenersException e) {  
                        e.printStackTrace();  
                    } catch (UnsupportedCommOperationException e) {  
                        e.printStackTrace();  
                    } catch (IOException e) {  
                        e.printStackTrace();  
                    }   
                }  
            }  
        }  
    }  
	@Override
	/** 
     * 实现接口SerialPortEventListener中的方法 读取从串口中接收的数据 
     */  
    public void serialEvent(SerialPortEvent event) {  
        switch (event.getEventType()) {  
        case SerialPortEvent.BI:  
        case SerialPortEvent.OE:  
        case SerialPortEvent.FE:  
        case SerialPortEvent.PE:  
        case SerialPortEvent.CD:  
        case SerialPortEvent.CTS:  
        case SerialPortEvent.DSR:  
        case SerialPortEvent.RI:  
        case SerialPortEvent.OUTPUT_BUFFER_EMPTY:  
            break;  
        case SerialPortEvent.DATA_AVAILABLE://获取到串口返回信息  
            int newData = 0;  
            int i = 0;  
              
            do{  
                try{  
                    newData = inputStream.read();  
                    //对数据进行处理，省略...  
                      
                    i++;  
                    if(i == 24){ //根据实际需求，在适当的时候设置结束条件  
                        newData = -1;  
                    }  
                      
                }catch(IOException e){  
                    return;  
                }  
            }  
            while(newData != -1);  
              
            serialPort.close();//这里一定要用close()方法关闭串口，释放资源  
              
            break;  
        default:  
            break;  
        }  
    }  

	//向串口发送信息方法  
    public static void sendMsg(){  
        String msg = "xxxxxxxxxxxxxx";//要发送的命令  
        try {  
            outputStream.write(StringUtils.getBytes(msg));  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
      
    public void run(){          
        init();  
        //sendMsg();  
          
    }  

}
