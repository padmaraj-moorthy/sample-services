package com.gundam.services.resource;

import com.gundam.services.model.ArticleModel;
import net.vz.mongodb.jackson.JacksonDBCollection;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by moorthy on 6/19/2017.
 */
public class ArticleResourceTest {

    private ArticleResource articleResource;
    private JacksonDBCollection<ArticleModel, String> collection;

    @Before
    public void setUp(){
        // Before each test, we re-instantiate our resource.It is good practice when dealing with a class that
        // contains mutable data to reset it so tests can be ran independently of each other.
        JacksonDBCollection<ArticleModel, String> collection = null;
        articleResource = new ArticleResource(collection);
    }
    @Test
    public void fetchArticleData() throws Exception {


    }

    @Test
    public void publishArticleData() throws Exception {

    }
}