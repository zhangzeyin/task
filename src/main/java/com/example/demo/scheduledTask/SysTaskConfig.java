package com.example.demo.scheduledTask;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.example.demo.dao.SysTaskMapper;
import com.example.demo.entity.SysTask;
import com.example.demo.entity.SysTaskExample;
import com.example.demo.util.SpringUtil;

@Lazy(value = false)
@Component
public class SysTaskConfig implements SchedulingConfigurer {

    protected static Logger logger = LoggerFactory.getLogger(SysTaskConfig.class);

    private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Resource
    private SysTaskMapper sysTaskMapper;
    
    private Map<Integer,SysTask>  TaskMap = new HashMap<Integer,SysTask>();

    //从数据库里取得所有要执行的定时任务`
    private List<SysTask> getAllTasks() {
        SysTaskExample example=new SysTaskExample();
        example.createCriteria();
        return sysTaskMapper.selectByExample(example);
    }

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		List<SysTask> tasks = getAllTasks();
		logger.info("定时任务启动,预计启动任务数量=" + tasks.size() + "; time=" + sdf.format(new Date()));

		checkDataList(tasks);
		if (tasks.size() > 0) {
			tasks.forEach(task -> {
				try {
					if (task.getIsDelete() == 0) {
						taskRegistrar.addTriggerTask(getRunnable(task), getTrigger(task));
					}
				} catch (Exception e) {
					logger.error("定时任务启动错误:" + task.getClassName() + ";" + task.getMethodName() + ";" + e.getMessage());
				}
				TaskMap.put(task.getSeqId(), task);

			});

		}
		System.out.println(JSON.toJSONString(taskRegistrar));
		
		
		logger.info("定时任务实际启动数量=" + taskRegistrar.getTriggerTaskList().size() + "; time=" + sdf.format(new Date()));
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {

				Map<Integer, SysTask> TaskMap1 = new HashMap<Integer, SysTask>();
				List<SysTask> tasks = getAllTasks();
				
				
 
				for (SysTask task : tasks) {
					System.out.println(JSON.toJSONString(task));
					System.out.println(JSON.toJSONString(TaskMap.get(task.getSeqId())));
					if (TaskMap.get(task.getSeqId()) != null) {
						if (!task.getCron().equals(TaskMap.get(task.getSeqId()).getCron())
								||!task.getClassName().equals(TaskMap.get(task.getSeqId()).getClassName())
								||!task.getMethodName().equals(TaskMap.get(task.getSeqId()).getMethodName())) {
							taskRegistrar.getTriggerTaskList().stream().filter(ta -> {
								return ((TriggerImpl)ta.getTrigger()).getTeSysTask().getSeqId() == task.getSeqId();
							}).findFirst().ifPresent(tig -> {
								taskRegistrar.getTriggerTaskList().remove(tig);
							});
							taskRegistrar.addTriggerTask(getRunnable(task), getTrigger(task));
						}
						if (task.getIsDelete() == 1) {
							taskRegistrar.getTriggerTaskList().stream().filter(ta -> {
								return ((TriggerImpl)ta.getTrigger()).getTeSysTask().getSeqId() == task.getSeqId();
							}).findFirst().ifPresent(tig -> {
//								taskRegistrar.
//								
//								
								taskRegistrar.setFixedRateTasksList(new ArrayList<>());
								taskRegistrar.setFixedDelayTasksList(new ArrayList<>());
							});
						}
					} else {
						taskRegistrar.addTriggerTask(getRunnable(task), getTrigger(task));
					}
					TaskMap1.put(task.getSeqId(), task);
				}
				TaskMap = TaskMap1;
				System.out.println(JSON.toJSONString(taskRegistrar));
			}
		}, 0, 2 * 1000);

	};

    private Runnable getRunnable(SysTask task){
        return new Runnable() {
            @Override
            public void run() {
                try {
                    Object obj = SpringUtil.getBean(task.getClassName());
                    Method method = obj.getClass().getMethod(task.getMethodName(),null);
                    method.invoke(obj);
                } catch (InvocationTargetException e) {
                    logger.error("定时任务启动错误，反射异常:"+task.getClassName()+";"+task.getMethodName()+";"+ e.getMessage());
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
            }
        };
    }

    private Trigger getTrigger(SysTask task){
     
        return new TriggerImpl(task);
    }

    private List<SysTask> checkDataList(List<SysTask> list) {
        String errMsg="";
        for(int i=0;i<list.size();i++){
            if(!checkOneData(list.get(i)).equalsIgnoreCase("success")){
                errMsg+=list.get(i).getTaskName()+";";
                list.remove(list.get(i));
                i--;
            };
        }
//        if(!StringUtils.isBlank(errMsg)){
//            errMsg="未启动的任务:"+errMsg;
//            logger.error(errMsg);
//        }
    return list;
    }

    private String checkOneData(SysTask task){
        String result="success";
        Class cal= null;
        try {
            cal = Class.forName(task.getClassName());

            Object obj =SpringUtil.getBean(cal);
            Method method = obj.getClass().getMethod(task.getMethodName(),null);
            String cron=task.getCron();
//            if(StringUtils.isBlank(cron)){
//                result="定时任务启动错误，无cron:"+task.getTaskName();
//                logger.error(result);
//            }
        } catch (ClassNotFoundException e) {
            result="定时任务启动错误，找不到类:"+task.getClassName()+ e.getMessage();
            logger.error(result);
        } catch (NoSuchMethodException e) {
            result="定时任务启动错误，找不到方法,方法必须是public:"+task.getClassName()+";"+task.getMethodName()+";"+ e.getMessage();
            logger.error(result);
        } catch (Exception e) {
          logger.error(e.getMessage());
         }
        return result;
    }


}
