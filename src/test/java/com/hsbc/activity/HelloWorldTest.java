package com.hsbc.activity;

import com.hsbc.activity.core.factory.ActivitiFactory;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloWorldTest {


    @Resource
    private ActivitiFactory activitiFactory;


    @Test
    public void executeForWorkflow(){
//        activitiFactory.deployByClass();
//        activitiFactory.startProcess();
    }


    @Test
    public void findTask(){
        activitiFactory.findTask();
    }

    @Test
    public void completeTask(){
        activitiFactory.completeTask();
    }

}
