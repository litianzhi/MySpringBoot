package com.forsrc.boot.batch.user;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) throws Exception {

        String[] springConfig = {"config/spring/batch/spring-batch.xml"};

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(springConfig);

        JobLauncher jobLauncher = (JobLauncher) context.getBean("userSimpleJobLauncher");
        Job job = (Job) context.getBean("userJob");

        JobExecution execution = jobLauncher.run(job, new JobParameters());
        System.out.println("Exit Status : " + execution.getStatus());
        System.out.println("Done");

        context.close();
    }
}
