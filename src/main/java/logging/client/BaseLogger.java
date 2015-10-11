package logging.client;

import java.util.Map;

public abstract class BaseLogger implements ILog {

	  private String Source ;

	  static TimerActionBlock<ILogEntity>  block;
	  
	  static LogSenderBase logSender;
	  
      public BaseLogger(String source )
      {
          this.Source = source;
          if(logSender==null)
          {
        	  logSender=new THttpLogSender();
          }
          if(block==null)
          {       	  
        	  block= new TimerActionBlock<ILogEntity>(logSender,Settings.LoggingQueueLength,Settings.LoggingBufferSize,Settings.LoggingBlockElapsed);
          }
      }
	
	public void Debug(String message) {
		// TODO Auto-generated method stub
		   Debug("", message);
	}

	public void Debug(String title, String message) {
		// TODO Auto-generated method stub
		 Debug(title, message,null);
	}

	public void Debug(String title, String message, Map<String, String> tags) {
		// TODO Auto-generated method stub
		 Log(title, message,null,1);
	}

	public void DebugWithTags(String title, String message, String[] tags) {
		// TODO Auto-generated method stub
		
	}

	public void Info(String message) {
		// TODO Auto-generated method stub
		Info("", message);
	}

	public void Info(String title, String message) {
		// TODO Auto-generated method stub
		Info(title, message,null);
	}

	public void Info(String title, String message, Map<String, String> tags) {
		// TODO Auto-generated method stub
		Log(title, message,null,2);
	}

	public void InfoWithTags(String title, String message, String[] tags) {
		// TODO Auto-generated method stub
		
	}

	public void Warm(String message) {
		// TODO Auto-generated method stub
		Warm("", message);
	}

	public void Warm(String title, String message) {
		// TODO Auto-generated method stub
		Warm(title, message,null);
	}

	public void Warm(String title, String message, Map<String, String> tags) {
		// TODO Auto-generated method stub
		Log(title, message,null,3);
	}

	public void WarmWithTags(String title, String message, String[] tags) {
		// TODO Auto-generated method stub
		
	}

	public void Error(String message) {
		// TODO Auto-generated method stub
		Error("", message);
	}

	public void Error(String title, String message) {
		// TODO Auto-generated method stub
		Error(title, message,null);
	}

	public void Error(String title, String message, Map<String, String> tags) {
		// TODO Auto-generated method stub
		Log(title, message,tags,4);
	}

	public void ErrorWithTags(String title, String message, String[] tags) {
		// TODO Auto-generated method stub
		
	}

	public void Error(Exception ex) {
		// TODO Auto-generated method stub
		
	}

	public void Error(String title, Exception ex) {
		// TODO Auto-generated method stub
		
	}

	public void Error(Exception ex, Map<String, String> tags) {
		// TODO Auto-generated method stub
		
	}

	public void Error(String title, Exception ex, Map<String, String> tags) {
		// TODO Auto-generated method stub
		
	}

	public void Metric(String name, double value, Map<String, String> tags) {
		
		 if (!Settings.LoggingEnabled) { return; }
		 
			 MetricEntity Metric = new MetricEntity();
			 Metric.Type=1;
	        Metric.Name = name;
	        Metric.Value = value;
	        Metric.Tags = tags;
	        Metric.Time = System.currentTimeMillis()*10000;
	        this.block.Enqueue(Metric);
	}

	public String GetLogs(long start, long end, int appId, int[] level, String title, String msg, String source,
			String ip, Map<String, String> tags, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	protected  void Log(String title, String message, Map<String, String> tags, int level)
	{
		   if (!Settings.LoggingEnabled) { return; }
		   LogEntity log = this.CreateLog(this.Source, title, message, tags, level);
		   this.block.Enqueue(log);
		  
	}
	
	   protected LogEntity CreateLog(String source, String title, String message, Map<String, String> tags, int level)
       { 
           LogEntity log = new LogEntity();
           log.Type=1;
           log.Level = level;
           log.Message = message;
           log.Tags = tags;
           log.Time = System.currentTimeMillis()*10000;
           log.Title = title;
           log.Source = source;
           log.Thread = (int) Thread.currentThread().getId();
           return log;
       }
}
