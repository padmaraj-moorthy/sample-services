package com.gundam.services.mongo;

import com.codahale.metrics.health.HealthCheck;
import com.mongodb.Mongo;

/**
 * Created by moorthy on 6/14/2017.
 */
public class MongoHealthCheck extends HealthCheck {

    private Mongo mongo;

    public MongoHealthCheck(Mongo mongo) {
        this.mongo = mongo;
    }

    @Override
    protected Result check() throws Exception {
        mongo.getDatabaseNames();
        return Result.healthy();
    }

}