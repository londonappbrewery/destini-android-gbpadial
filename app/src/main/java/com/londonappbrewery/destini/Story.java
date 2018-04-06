package com.londonappbrewery.destini;

public class Story {

    private String story;
    private String answerTop;
    private String answerBottom;

    Story(String story, String answerTop, String answerBottom) {
        this.story = story;
        this.answerTop = answerTop;
        this.answerBottom = answerBottom;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getAnswerTop() {
        return answerTop;
    }

    public void setAnswerTop(String answerTop) {
        this.answerTop = answerTop;
    }

    public String getAnswerBottom() {
        return answerBottom;
    }

    public void setAnswerBottom(String answerBottom) {
        this.answerBottom = answerBottom;
    }
}
