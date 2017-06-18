package com.gundam.services.mongo;

import com.mongodb.Mongo;
import com.yammer.dropwizard.lifecycle.Managed;

/**
 * Created by moorthy on 6/14/2017.
 */
public class MongoManaged implements Managed {

    private Mongo mongo;

    public MongoManaged(Mongo mongo) {
        this.mongo = mongo;
    }

    @Override
    public void start() throws Exception {
    }

    @Override
    public void stop() throws Exception {
        mongo.close();
    }

}