/* 
 * RT MAP, Home of Professional MAP 
 * Copyright 2015 Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.muarine.elasticjob;

import com.dangdang.ddframe.job.api.JobExecutionMultipleShardingContext;
import com.dangdang.ddframe.job.plugin.job.type.AbstractSimpleElasticJob;

/**
 * MyElasticJob.
 * 
 * @author muarine
 * @since 2.1.6
 */
public class SimpleElasticJob extends AbstractSimpleElasticJob{

	@Override
	public void process(JobExecutionMultipleShardingContext context) {
		
		System.out.println("SimpleElasticJob process");
		System.out.println(context.getJobName());
		System.out.println(context.getJobParameter());
		System.out.println(context.getShardingTotalCount());
		System.out.println(context.getShardingItems().size());
//		for (Integer in : context.getShardingItems()) {
//			
//			System.out.println(in);
//			
//		}
		
		
	}

}
