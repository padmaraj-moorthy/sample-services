package com.gundam.services.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by moorthy on 6/15/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticleDetailsModel {

    @NotBlank
    private String articleID;

    private String articleDescription;

    @NotBlank
    private String articlePath;

    private String articleViewedDate;

    @NotBlank
    private String articlePreviewUrl;

    public ArticleDetailsModel() {

    }

    public ArticleDetailsModel(String articleID, String articleDescription, String articlePath, String articleViewedDate, String articlePreviewUrl) {
        this.articleID = articleID;
        this.articleDescription = articleDescription;
        this.articlePath = articlePath;
        this.articleViewedDate = articleViewedDate;
        this.articlePreviewUrl = articlePreviewUrl;
    }

    public String getArticleID() {
        return articleID;
    }

    public void setArticleID(String articleID) {
        this.articleID = articleID;
    }

    public String getArticleDescription() {
        return articleDescription;
    }

    public void setArticleDescription(String articleDescription) {
        this.articleDescription = articleDescription;
    }

    public String getArticlePath() {
        return articlePath;
    }

    public void setArticlePath(String articlePath) {
        this.articlePath = articlePath;
    }

    public String getArticleViewedDate() {
        return articleViewedDate;
    }

    public void setArticleViewedDate(String articleViewedDate) {
        this.articleViewedDate = articleViewedDate;
    }

    public String getArticlePreviewUrl() {
        return articlePreviewUrl;
    }

    public void setArticlePreviewUrl(String articlePreviewUrl) {
        this.articlePreviewUrl = articlePreviewUrl;
    }

}
