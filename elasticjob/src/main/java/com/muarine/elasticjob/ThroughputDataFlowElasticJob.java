/* 
 * RT MAP, Home of Professional MAP 
 * Copyright 2015 Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.muarine.elasticjob;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dangdang.ddframe.job.api.JobExecutionMultipleShardingContext;
import com.dangdang.ddframe.job.plugin.job.type.AbstractThroughputDataFlowElasticJob;
import com.muarine.entity.Foo;

/**
 * ThroughputDataFlowElasticJob.	高吞吐的数据流作业
 * 需要继承AbstractThroughputDataFlowElasticJob并可以指定返回值泛型，该类提供3个方法可覆盖，
 * 分别用于抓取数据，处理数据和指定是否流式处理数据。可以获取数据处理成功失败次数等辅助监控信息。
 * 如果流式处理数据，fetchData方法的返回值只有为null或长度为空时，作业才会停止执行，否则作业会一直运行下去；
 * 非流式处理数据则只会在每次作业执行过程中执行一次fetchData方法和processData方法，即完成本次作业。
 * 
 * 流式数据处理参照TbSchedule设计，适用于不间歇的数据处理。
 * 
 * @author muarine
 * @since 2.1.6
 */
public class ThroughputDataFlowElasticJob extends AbstractThroughputDataFlowElasticJob<Foo>{

	public List<Foo> fetchData(JobExecutionMultipleShardingContext context) {
		System.out.println("ThroughputDataFlowElasticJob fetchData");
		Map<Integer, String> offset = context.getOffsets();
        List<Foo> result =  new ArrayList<Foo>();				// get data from database by sharding items and by offset
        result.add(new Foo());
        return result;
	}

	public boolean isStreamingProcess() {
		System.out.println("ThroughputDataFlowElasticJob isStreamingProcess");
		return true;
	}

	public boolean processData(JobExecutionMultipleShardingContext context, Foo data) {
		System.out.println("ThroughputDataFlowElasticJob processData");
		// process data
        // ...

        // store offset
        for (int each : context.getShardingItems()) {
            updateOffset(each, "your offset, maybe id");
        }
        return false;
		
	}
	
}
