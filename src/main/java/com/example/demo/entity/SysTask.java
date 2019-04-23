package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

public class SysTask implements Serializable {
    /**
     * 主键
     * 表 : sys_task
     * 对应字段 : seq_id
     */
    private Integer seqId;

    /**
     * 任务名称          
     * 表 : sys_task
     * 对应字段 : task_name
     */
    private String taskName;

    /**
     * 执行任务的时间规则
     * 表 : sys_task
     * 对应字段 : cron
     */
    private String cron;

    /**
     * 类名
     * 表 : sys_task
     * 对应字段 : class_name
     */
    private String className;

    /**
     * 方法名,方法不能有参数       
            
     * 表 : sys_task
     * 对应字段 : method_name
     */
    private String methodName;

    /**
     * 种类 0:重复执行 1:执行一次 
     * 表 : sys_task
     * 对应字段 : type
     */
    private String type;

    /**
     * 删除标记 - 0否1是
            
     * 表 : sys_task
     * 对应字段 : is_delete
     */
    private Byte isDelete;

    /**
     * 备注
     * 表 : sys_task
     * 对应字段 : remark
     */
    private String remark;

    /**
     * 创建人
     * 表 : sys_task
     * 对应字段 : create_user
     */
    private String createUser;

    /**
     * 创建时间
     * 表 : sys_task
     * 对应字段 : create_date
     */
    private Date createDate;

    /**
     * 修改人
     * 表 : sys_task
     * 对应字段 : update_user
     */
    private String updateUser;

    /**
     * 修改时间
     * 表 : sys_task
     * 对应字段 : update_date
     */
    private Date updateDate;

    private static final long serialVersionUID = 1L;

    /**
     * get method 
     *
     * @return sys_task.seq_id：主键
     */
    public Integer getSeqId() {
        return seqId;
    }

    /**
     * set method 
     *
     * @param seqId  主键
     */
    public void setSeqId(Integer seqId) {
        this.seqId = seqId;
    }

    /**
     * get method 
     *
     * @return sys_task.task_name：任务名称          
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * set method 
     *
     * @param taskName  任务名称          
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    /**
     * get method 
     *
     * @return sys_task.cron：执行任务的时间规则
     */
    public String getCron() {
        return cron;
    }

    /**
     * set method 
     *
     * @param cron  执行任务的时间规则
     */
    public void setCron(String cron) {
        this.cron = cron == null ? null : cron.trim();
    }

    /**
     * get method 
     *
     * @return sys_task.class_name：类名
     */
    public String getClassName() {
        return className;
    }

    /**
     * set method 
     *
     * @param className  类名
     */
    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    /**
     * get method 
     *
     * @return sys_task.method_name：方法名,方法不能有参数       
            
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * set method 
     *
     * @param methodName  方法名,方法不能有参数       
            
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName == null ? null : methodName.trim();
    }

    /**
     * get method 
     *
     * @return sys_task.type：种类 0:重复执行 1:执行一次 
     */
    public String getType() {
        return type;
    }

    /**
     * set method 
     *
     * @param type  种类 0:重复执行 1:执行一次 
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * get method 
     *
     * @return sys_task.is_delete：删除标记 - 0否1是
            
     */
    public Byte getIsDelete() {
        return isDelete;
    }

    /**
     * set method 
     *
     * @param isDelete  删除标记 - 0否1是
            
     */
    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * get method 
     *
     * @return sys_task.remark：备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * set method 
     *
     * @param remark  备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * get method 
     *
     * @return sys_task.create_user：创建人
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * set method 
     *
     * @param createUser  创建人
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * get method 
     *
     * @return sys_task.create_date：创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * set method 
     *
     * @param createDate  创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * get method 
     *
     * @return sys_task.update_user：修改人
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * set method 
     *
     * @param updateUser  修改人
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    /**
     * get method 
     *
     * @return sys_task.update_date：修改时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * set method 
     *
     * @param updateDate  修改时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     *
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", seqId=").append(seqId);
        sb.append(", taskName=").append(taskName);
        sb.append(", cron=").append(cron);
        sb.append(", className=").append(className);
        sb.append(", methodName=").append(methodName);
        sb.append(", type=").append(type);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", remark=").append(remark);
        sb.append(", createUser=").append(createUser);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateDate=").append(updateDate);
        sb.append("]");
        return sb.toString();
    }
}