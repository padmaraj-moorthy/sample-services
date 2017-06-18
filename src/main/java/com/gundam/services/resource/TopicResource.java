package com.gundam.services.resource;


import com.gundam.services.model.TopicModel;
import com.mongodb.BasicDBObject;
import com.yammer.metrics.annotation.Timed;
import net.vz.mongodb.jackson.DBCursor;
import net.vz.mongodb.jackson.JacksonDBCollection;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by moorthy on 6/15/2017.
 */

@Path("/topics")
public class TopicResource {

    private JacksonDBCollection<TopicModel, String> collection;

    public TopicResource(JacksonDBCollection<TopicModel, String> collection) {
        this.collection = collection;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Timed
    public List<TopicModel> fetchTopics() {
        DBCursor<TopicModel> dbCursor = collection.find();
        List<TopicModel> datas = new ArrayList<>();
        while (dbCursor.hasNext()) {
            TopicModel data = dbCursor.next();
            datas.add(data);
        }
        return datas;
    }

    @GET
    @Path("/{topicId}")
    @Produces(value = MediaType.APPLICATION_JSON)
    @Timed
    public List<TopicModel> fetchTopicsById(@PathParam("topicId") String userid) {
        BasicDBObject topicsByIDQuery = new BasicDBObject();
        topicsByIDQuery.put("topicID", userid);
        DBCursor<TopicModel> dbCursor = collection.find(topicsByIDQuery);
        List<TopicModel> datas = new ArrayList<>();
        while (dbCursor.hasNext()) {
            TopicModel data = dbCursor.next();
            datas.add(data);
        }
        return datas;
    }

    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Timed
    public Response publishTopic(@Valid TopicModel data) {
        collection.insert(data);
        return Response.ok().entity("\"Success\"").type(MediaType.APPLICATION_JSON).build();
    }
}