package com.gundam.services.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotBlank;

import java.util.UUID;

/**
 * Created by moorthy on 6/15/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticleModel {

    private String id = UUID.randomUUID().toString();

    @NotBlank
    private String userID;

    private ArticleDetailsModel articleDetailsModel;

    public ArticleModel() {

    }

    public ArticleModel(String userID, ArticleDetailsModel articleDetailsModel) {
        this.userID = userID;
        this.articleDetailsModel = articleDetailsModel;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public ArticleDetailsModel getArticleDetailsModel() {
        return articleDetailsModel;
    }

    public void setArticleDetailsModel(ArticleDetailsModel articleDetailsModel) {
        this.articleDetailsModel = articleDetailsModel;
    }
}
