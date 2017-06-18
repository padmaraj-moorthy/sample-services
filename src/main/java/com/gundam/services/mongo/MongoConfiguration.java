package com.gundam.services.mongo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by moorthy on 6/14/2017.
 */
public class MongoConfiguration extends Configuration {

    @JsonProperty
    @NotEmpty
    public String mongohost;

    @JsonProperty
    public int mongoport;

    @JsonProperty
    @NotEmpty
    public String mongodb;

    @JsonProperty
    public String articlesCollection;

    @JsonProperty
    public String topicsCollection;

    public String getMongohost() {
        return mongohost;
    }

    public int getMongoport() {
        return mongoport;
    }

    public void setMongoport(int mongoport) {
        this.mongoport = mongoport;
    }

    public String getMongodb() {
        return mongodb;
    }

    public void setMongodb(String mongodb) {
        this.mongodb = mongodb;
    }

    public void setMongohost(String mongohost) {
        this.mongohost = mongohost;
    }

    public String getArticlesCollection() {
        return articlesCollection;
    }

    public void setArticlesCollection(String articlesCollection) {
        this.articlesCollection = articlesCollection;
    }

    public String getTopicsCollection() {
        return topicsCollection;
    }

    public void setTopicsCollection(String topicsCollection) {
        this.topicsCollection = topicsCollection;
    }

}
