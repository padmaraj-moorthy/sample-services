package com.gundam.services.mongo;

import com.mongodb.Mongo;
import com.yammer.metrics.core.HealthCheck;

/**
 * Created by moorthy on 6/14/2017.
 */
public class MongoHealthCheck extends HealthCheck {

    private Mongo mongo;

    public MongoHealthCheck(Mongo mongo) {
        super("MongoDBHealthCheck");
        this.mongo = mongo;
    }

    @Override
    protected Result check() throws Exception {
        mongo.getDatabaseNames();
        return Result.healthy();
    }

}