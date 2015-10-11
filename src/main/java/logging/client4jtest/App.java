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
	
	static ILog logger=LogManager.getLogger(App.class);
	
	
	
    public static void main( String[] args ) 
    {
    	Settings.startup(4004, "http://server.logging.com",10,5000);
    	
        System.out.println( "ThriftTest begin" );
        ThriftTest();
        System.out.println( "ThriftTest end" );
    }
    
    public  static void  ThriftTest() {
    
    	for(int i=0;i<10;i++){
    	logger.debug("java test debug");
    	logger.info("java test info");
    	logger.warm("java test warm");
    	logger.error("java test error");
    	}
    	
    	try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	for(int i=0;i<10;i++){
    		logger.debug("java test debug");
        	logger.info("java test info");
        	logger.warm("java test warm");
        	logger.error("java test error");
        	}
    	
    	try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	for(int i=0;i<10;i++){
    		logger.debug("java test debug");
        	logger.info("java test info");
        	logger.warm("java test warm");
        	logger.error("java test error");
        	}
    	
    	try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	for(int i=0;i<10;i++){
    		logger.debug("java test debug");
        	logger.info("java test info");
        	logger.warm("java test warm");
        	logger.error("java test error");
        	}
    	
    	try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	logger.debug("java test debug");
    	logger.info("java test info");
    	logger.warm("java test warm");
    	logger.error( new Exception("ex test"));
    	
    	try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	logger.debug("java test Debug  over");
    }
}
