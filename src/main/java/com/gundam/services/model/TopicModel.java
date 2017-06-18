package com.gundam.services.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by moorthy on 6/18/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TopicModel {

    @NotBlank
    private String topicID;

    @NotBlank
    private String topicCategory;

    private int topicCount;

    public String getTopicID() {
        return topicID;
    }

    public void setTopicID(String topicID) {
        this.topicID = topicID;
    }

    public String getTopicCategory() {
        return topicCategory;
    }

    public void setTopicCategory(String topicCategory) {
        this.topicCategory = topicCategory;
    }

    public int getTopicCount() {
        return topicCount;
    }

    public void setTopicCount(int topicCount) {
        this.topicCount = topicCount;
    }

    public TopicModel() {

    }

    public TopicModel(String topicID, String topicCategory, int topicCount) {
        this.topicID = topicID;
        this.topicCategory = topicCategory;
        this.topicCount = topicCount;
    }

}
