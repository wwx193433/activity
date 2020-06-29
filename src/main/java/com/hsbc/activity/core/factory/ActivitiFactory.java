package com.hsbc.activity.core.factory;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

@Component
public class ActivitiFactory {

    @Resource
    private RepositoryService repositoryService;

    @Resource
    private RuntimeService runtimeService;
    @Resource
    private TaskService taskService;

    public void deployByClass(){
        Deployment deployment = repositoryService.createDeployment().name("请假流程001")
                .addClasspathResource("atwf/HelloWorld.bpmn")
                .addClasspathResource("atwf/HelloWorld.png").deploy();
        System.out.println("部署成功! 流程部署ID:"+deployment.getId());
    }

    /**
     * 启动流程
     */
    public void startProcess(){
        String processDefinitionId = "HelloWorld:1:4";
        runtimeService.startProcessInstanceById(processDefinitionId);
        System.out.println("流程启动成功....");
    }

    /**
     * 查询任务
     */
    public void findTask(){
        String assigner = "Malvyn";
        List<Task> taskList = taskService.createTaskQuery()
                .taskAssignee(assigner).list();
        if(null!=taskList && taskList.size()>0){
            for(Task task:taskList){
                System.out.println("任务ID:"+task.getId());
                System.out.println("流程实例ID:"+task.getProcessInstanceId());
                System.out.println("执行实例ID:"+task.getExecutionId());
                System.out.println("流程定义ID:"+task.getProcessDefinitionId());
                System.out.println("任务名称:"+task.getName());
                System.out.println("任务办理人:"+task.getAssignee());
                System.out.println("======");
            }
        }
    }


    /**
     * 完成任务
     */
    public void completeTask(){
        String taskId = "5002";
        taskService.complete(taskId);
        System.out.println("任务完成");
    }




}
