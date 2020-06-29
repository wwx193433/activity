package com.hsbc.activity.core.factory;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.*;
import java.util.List;
import java.util.zip.ZipInputStream;

/**
 * 管理流程定义
 */

@Component
public class ActivitiProcess {

    @Resource
    private ProcessEngine processEngine;


    @Resource
    private RepositoryService repositoryService;

    @Resource
    private RuntimeService runtimeService;
    @Resource
    private TaskService taskService;

    /**
     * 部署流程
     * zip方式（png和bpmn的打包部署）
     */
    public void deployByZip(){
        InputStream inputStream = this.getClass().getResourceAsStream("/atwf/HelloWorld.zip");
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        Deployment deployment = repositoryService.createDeployment().name("请假流程001")
                .addZipInputStream(zipInputStream)
                .deploy();
        System.out.println("部署成功! 流程部署ID:"+deployment.getId());
    }

    /**
     * 查询部署信息
     */
    public void queryProcessDeployment(){
//        String deploymentId = "1";
        List<Deployment> list = repositoryService.createDeploymentQuery()
//                .deploymentId(deploymentId)
//                .singleResult();
                  .list();
//        System.out.println("部署id："+deployment.getId());
//        System.out.println("部署名称："+deployment.getName());
//        System.out.println("部署时间："+deployment.getDeploymentTime());
        System.out.println(list);
    }

    public void queryProcessDef(){
        repositoryService.createProcessDefinitionQuery().count();
//                .deploymentId(deploymentId)
//        .deploymentIds(deploymentIds);
    }

    public void viewProcessImg(){
        String deploymentId = "1";
        ProcessDefinition processDefinition = repositoryService
                .createProcessDefinitionQuery()
                .deploymentId(deploymentId).singleResult();

        String processDefinitionId = processDefinition.getId();
        File file = new File("/Users/wangxuefeng/"+processDefinition.getDiagramResourceName());
        InputStream inputStream = repositoryService.getProcessDiagram(processDefinitionId);
        try {
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file));
            int len = 0;
            byte[] b = new byte[1024];
            while((len = inputStream.read(b))!=-1){
                outputStream.write(b, 0, len);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
