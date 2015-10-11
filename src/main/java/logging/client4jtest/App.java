package logging.client4jtest;



import java.util.ArrayList;
import java.util.List;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TTransport;

import logging.client.ILog;
import logging.client.LogManager;
import logging.client.Settings;
import logging.client.THttpLogSender;
import logging.client.TLogEntity;
import logging.client.TLogPackage;

/**
 * Hello world!
 *
 */
public class App 
{
	
	static ILog logger=LogManager.GetLogger(App.class);
	
	
	
    public static void main( String[] args ) 
    {
    	Settings.Init(4004, "http://server.logging.com",10,5000);
    	
        System.out.println( "ThriftTest begin" );
        ThriftTest();
        System.out.println( "ThriftTest end" );
    }
    
    public  static void  ThriftTest() {
    
    	for(int i=0;i<10;i++){
    	logger.Debug("java test debug");
    	logger.Info("java test info");
    	logger.Warm("java test warm");
    	logger.Error("java test error");
    	}
    	
    	try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	for(int i=0;i<10;i++){
        	logger.Debug("java test debug");
        	logger.Info("java test info");
        	logger.Warm("java test warm");
        	logger.Error("java test error");
        	}
    	
    	try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	for(int i=0;i<10;i++){
        	logger.Debug("java test debug");
        	logger.Info("java test info");
        	logger.Warm("java test warm");
        	logger.Error("java test error");
        	}
    	
    	try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	for(int i=0;i<10;i++){
        	logger.Debug("java test debug");
        	logger.Info("java test info");
        	logger.Warm("java test warm");
        	logger.Error("java test error");
        	}
    	
    	try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	logger.Info("java test info  over");
    	logger.Info("java test info  over");
    	logger.Info("java test info  over");
    	logger.Info("java test info  over");
    	
    	try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	logger.Debug("java test Debug  over");
    }
}
