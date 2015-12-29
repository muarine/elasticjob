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

import com.dangdang.ddframe.job.api.JobExecutionSingleShardingContext;
import com.dangdang.ddframe.job.plugin.job.type.AbstractSequenceDataFlowElasticJob;
import com.muarine.entity.Foo;

/**
 * SequenceDataFlow.
 * SequenceDataFlow类型作业则根据当前服务器所分配的分片项数量进行多线程处理，每个分片项使用同一线程处理，防止了同一分片的数据被多线程处理，从而导致的顺序问题
 * 
 * 由于ThroughputDataFlow作业可以使用多于分片项的任意线程数处理，所以性能调优的可能会优于SequenceDataFlow作业
 * 
 * @author muarine
 * @since 2.1.6
 */
public class SequenceDataFlow extends AbstractSequenceDataFlowElasticJob<Foo>{
	
    public List<Foo> fetchData(JobExecutionSingleShardingContext context) {
    	System.out.println("SequenceDataFlow fetchData");
        String offset = context.getOffset();
        System.out.println(offset);
        List<Foo> result = new ArrayList<Foo>();		// get data from database by sharding items and by offset
        result.add(new Foo());
        return result;
    }

    public boolean processData(JobExecutionSingleShardingContext context, Foo data) {
        // process data
        // ...
    	System.out.println("SequenceDataFlow processData");
        // store offset
        updateOffset(context.getShardingItem(), "your offset, maybe id");
        return true;
    }
	
    public boolean isStreamingProcess() {
    	System.out.println("SequenceDataFlow isStreamingProcess");
        return true;
    }

}
