package logging.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TimerActionBlock<T> implements ITimerActionBlock<T> {

	LinkedBlockingQueue<T> queue   = new LinkedBlockingQueue<T>(1024);  
	
	 /// <summary>
    /// 阻塞队列的最大长度
    /// </summary>
    private int QueueMaxLength;

    /// <summary>
    /// 元素包的大小
    /// </summary>
    private int BufferSize;

    /// <summary>
    /// 上一次打包处理的时间
    /// </summary>
    private Date LastActionTime;

    private int BlockElapsed;
	
    private DequeueAction<T> Action;
    
 	public	TimerActionBlock(DequeueAction<T> action,int queueMaxLength, int bufferSize, int blockElapsed){
		this.QueueMaxLength=queueMaxLength;
		this.BufferSize=bufferSize;
		this.LastActionTime=new Date();
		this.BlockElapsed=blockElapsed;
		this.Action=action;
	}
	
	public void Enqueue(T item)  {
		// TODO Auto-generated method stub
		int queueLen=this.queue.size();
//		int over_count = 0;
//		if(queueLen>=this.QueueMaxLength){
//			  over_count = (queueLen - this.QueueMaxLength) + 1;
//			  for (int i = 0; i < over_count; i++)
//              {
//                  try {
//					this.queue.take();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}//超过队列长度，扔掉
//              }
//		}
		
		if(queueLen>0&&( queueLen>=BufferSize || (new Date().getTime()-this.LastActionTime.getTime())>=this.BlockElapsed)){
			
			List<T> buffer=new ArrayList<T>();
			for	(int i=0;i<queueLen;i++){
				
				try {
					buffer.add(this.queue.take());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			this.Action.execute(buffer);
			this.LastActionTime=new Date();
		}
		queue.add(item);
	}
	
	public interface DequeueAction<T>
	{
		public void execute(List<T> items);		
	}
}
