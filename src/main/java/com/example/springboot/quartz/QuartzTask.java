package com.example.springboot.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author fengaihua
 * @project springboot
 * @package com.example.springboot.quartz
 * @date 2020/5/15 13:50
 * @description
 */
@Configuration
@Slf4j
public class QuartzTask {

    @Bean
    public JobDetail createJobDetail() {
        return JobBuilder.newJob(SampleJob.class)
                .withIdentity(SampleJob.class.getName())
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger createTrigger() {
        return TriggerBuilder.newTrigger()
                .forJob(createJobDetail())
                .withIdentity(SampleJob.class.getName())
                .withSchedule(CronScheduleBuilder.cronSchedule("*/30 * * * * ?"))
                .build();
    }

    class SampleJob  extends QuartzJobBean {
        @Override
        protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
            log.info("{}",jobExecutionContext);
        }
    }

}
