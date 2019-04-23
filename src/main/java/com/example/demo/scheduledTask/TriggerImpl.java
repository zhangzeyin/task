package com.example.demo.scheduledTask;

import java.util.Date;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.support.CronTrigger;

import com.example.demo.entity.SysTask;

public class TriggerImpl implements Trigger{
	
	private SysTask  teSysTask;
    @Override
    public Date nextExecutionTime(TriggerContext triggerContext) {
        //将Cron 0/1 * * * * ? 输入取得下一次执行的时间
        CronTrigger trigger = new CronTrigger(teSysTask.getCron());
        Date nextExec = trigger.nextExecutionTime(triggerContext);
        return nextExec;
    }
    
    
    public TriggerImpl(SysTask teSysTask) {
		super();
		this.teSysTask = teSysTask;
	}


	public SysTask getTeSysTask() {
		return teSysTask;
	}
    

}
