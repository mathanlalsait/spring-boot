package com.candidjava.springboot;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

public class SimpleJob implements Job{
 
    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
    	
    	System.out.println("Candidjava welcomes simple job");
        
    }
}