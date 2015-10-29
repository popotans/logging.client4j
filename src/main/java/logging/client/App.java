package logging.client;

public class App {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Settings.startup(4002, "http://183.131.23.176:9092/server",2,100);
	 	ILog logger=LogManager.getLogger(App.class);
    	logger.metric("metric_java_test",1,null );
    	
    	Thread.sleep(1000);
    	logger.metric("metric_java_test",1,null );
    	
    	Thread.sleep(1000);
    	logger.metric("metric_java_test",1,null );

    	System.out.println("metric over");
    	
	}

}
