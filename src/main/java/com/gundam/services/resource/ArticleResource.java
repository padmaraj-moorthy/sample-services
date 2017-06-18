package com.gundam.services.resource;


import com.gundam.services.model.ArticleModel;
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

@Path("/articles")
public class ArticleResource {

    private JacksonDBCollection<ArticleModel, String> collection;

    public ArticleResource(JacksonDBCollection<ArticleModel, String> collection) {
        this.collection = collection;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Timed
    public List<ArticleModel> fetchArticleData(@QueryParam("userId") String userid) {

        List<ArticleModel> articles = new ArrayList<>();
        if(userid != null && !userid.isEmpty()){
            BasicDBObject articleByUserIDQuery = new BasicDBObject();
            articleByUserIDQuery.put("userID", userid);
            DBCursor<ArticleModel> dbCursor = collection.find(articleByUserIDQuery);
            while (dbCursor.hasNext()) {
                ArticleModel article = dbCursor.next();
                articles.add(article);
            }
        } else{
            DBCursor<ArticleModel> dbCursor = collection.find();
            while (dbCursor.hasNext()) {
                ArticleModel article = dbCursor.next();
                articles.add(article);
            }
        }
        return articles;
    }

/*    @GET
    @Path("/{userId}")
    @Produces(value = MediaType.APPLICATION_JSON)
    @Timed
    public List<ArticleModel> fetchArticlesByUserId(@PathParam("userId") String userid) {
        BasicDBObject articleByUserIDQuery = new BasicDBObject();
        articleByUserIDQuery.put("userID", userid);
        DBCursor<ArticleModel> dbCursor = collection.find(articleByUserIDQuery);
        List<ArticleModel> datas = new ArrayList<>();
        while (dbCursor.hasNext()) {
            ArticleModel data = dbCursor.next();
            datas.add(data);
        }
        return datas;
    }*/

    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Timed
    public Response publishArticleData(@Valid ArticleModel data) {
        collection.insert(data);
        return Response.ok().entity("\"Success\"").type(MediaType.APPLICATION_JSON).build();
    }
}