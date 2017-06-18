package com.gundam.services;

import com.gundam.services.model.ArticleModel;
import com.gundam.services.model.TopicModel;
import com.gundam.services.mongo.MongoConfiguration;
import com.gundam.services.mongo.MongoHealthCheck;
import com.gundam.services.mongo.MongoManaged;
import com.gundam.services.resource.ArticleResource;
import com.gundam.services.resource.TopicResource;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import net.vz.mongodb.jackson.JacksonDBCollection;

/**
 * Created by moorthy on 6/14/2017.
 */
public class AnimeService extends Service<MongoConfiguration> {

    public static void main(String[] args) throws Exception {
        new AnimeService().run(args);
    }

    @Override
    public void initialize(Bootstrap<MongoConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/apidocs", "/apidocs", "index.html"));
        bootstrap.setName("mongo");
    }

    @Override
    public void run(MongoConfiguration configuration, Environment environment) throws Exception {

        //Create Mongo instance
        Mongo mongo = new Mongo(configuration.mongohost, configuration.mongoport);

        //Add Managed for managing the Mongo instance
        MongoManaged mongoManaged = new MongoManaged(mongo);
        environment.manage(mongoManaged);

        //Add Health check for Mongo instance. This will be used from the Health check admin page
        environment.addHealthCheck(new MongoHealthCheck(mongo));

        //Create DB instance and wrap it in a Jackson DB collection
        DB db = mongo.getDB(configuration.mongodb);

        //ORM Mapping for Article UGC content from Anime
        JacksonDBCollection<ArticleModel, String> articleJacksonDBCollection = JacksonDBCollection.wrap(db.getCollection(configuration.articlesCollection), ArticleModel.class, String.class);
        environment.addResource(new ArticleResource(articleJacksonDBCollection));

        //ORM Mapping for Topics product content from Anime
        JacksonDBCollection<TopicModel, String> topicsJacksonDBCollection = JacksonDBCollection.wrap(db.getCollection(configuration.topicsCollection), TopicModel.class, String.class);
        environment.addResource(new TopicResource(topicsJacksonDBCollection));
    }
}
