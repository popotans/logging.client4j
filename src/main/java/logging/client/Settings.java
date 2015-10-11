package logging.client;

public class Settings {

    /// <summary>
    /// 设置日志服务器
    /// </summary>
    public static String LoggingServerHost;

    /// <summary>
    /// 设置日志发送线程数。默认为1
    /// </summary>
    public static int LoggingTaskNum ;

    /// <summary>
    /// 设置日志队列最大长度
    /// </summary>
    public static int LoggingQueueLength ;

    /// <summary>
    /// 设置日志打包大小
    /// </summary>
    public static int LoggingBufferSize ;

    /// <summary>
    /// 设置日志发送阻塞时间。单位:毫秒
    /// </summary>
    public static int LoggingBlockElapsed ;

    /// <summary>
    /// 是否禁用日志
    /// </summary>
    public static Boolean LoggingEnabled ;

    /// <summary>
    /// 默认日志发送线程数：1
    /// </summary>
    public  static int DefaultLoggingTaskNum = 1;

    /// <summary>
    /// 应用号
    /// </summary>
    public  static int AppId ;

    /// <summary>
    /// 默认日志队列最大长度：100000
    /// </summary>
    private static int DefaultLoggingQueueLength = 100000;

    /// <summary>
    /// 默认日志打包大小：300
    /// </summary>
    private static int DefaultLoggingBufferSize = 300;

    /// <summary>
    /// 默认发送阻塞时间。单位:毫秒。5000,即5秒
    /// </summary>
    private  static int DefaultLoggingBlockElapsed = 5000;
    
    public static void Init(Boolean enabled,int appId,String serverHost,int bufferSize,int blockElapsed){   	
    	LoggingEnabled=enabled;
    	AppId=appId;
    	LoggingServerHost=serverHost;
    	LoggingBufferSize=bufferSize;
    	LoggingBlockElapsed=blockElapsed;
    }
    
    
    public static void Init(int appId,String serverHost,int bufferSize,int blockElapsed){   	
    	Init(true,appId,serverHost,bufferSize,blockElapsed);
    }
    

    
    public static void Init(int appId,String serverHost){   	
    	LoggingEnabled=true;
    	AppId=appId;
    	LoggingServerHost=serverHost;
    	
    	if(LoggingBufferSize<=0){
    		LoggingBufferSize=DefaultLoggingBufferSize;
    	}
    	
		if(LoggingBlockElapsed<=0){	
			LoggingBlockElapsed=DefaultLoggingBlockElapsed;
		}
	}
    
    public static void Enabled(){   	
    	LoggingEnabled=true;
    }
    
    public static void Disabled(){   	
    	LoggingEnabled=false;
    }
}
