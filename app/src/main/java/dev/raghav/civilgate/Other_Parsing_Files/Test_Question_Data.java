package dev.raghav.civilgate.Other_Parsing_Files;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Test_Question_Data {
    @SerializedName("id")

    @Expose
    private String id;
    @SerializedName("sub_id")
    @Expose
    private String subId;
    @SerializedName("Que")
    @Expose
    private String que;
    @SerializedName("Ans_1")
    @Expose
    private String ans1;
    @SerializedName("Ans_2")
    @Expose
    private String ans2;
    @SerializedName("Ans_3")
    @Expose
    private String ans3;
    @SerializedName("Ans_4")
    @Expose
    private String ans4;
    @SerializedName("Ans")
    @Expose
    private String ans;
    @SerializedName("minusmark")
    @Expose
    private String minusmark;
    @SerializedName("marks")
    @Expose
    private String marks;
    @SerializedName("solution")
    @Expose
    private String solution;
    @SerializedName("multiple_ans")
    @Expose
    private String multipleAns;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("video")
    @Expose
    private String video;
    @SerializedName("video_url")
    @Expose
    private String videoUrl;
    @SerializedName("Createdate")
    @Expose
    private String createdate;

    public Test_Question_Data(String id, String subId, String que, String ans1, String ans2, String ans3, String ans4, String ans, String minusmark, String marks, String solution, String multipleAns, String status) {
        this.id = id;
        this.subId = subId;
        this.que = que;
        this.ans1 = ans1;
        this.ans2 = ans2;
        this.ans3 = ans3;
        this.ans4 = ans4;
        this.ans = ans;
        this.minusmark = minusmark;
        this.marks = marks;
        this.solution = solution;
        this.multipleAns = multipleAns;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public String getQue() {
        return que;
    }

    public void setQue(String que) {
        this.que = que;
    }

    public String getAns1() {
        return ans1;
    }

    public void setAns1(String ans1) {
        this.ans1 = ans1;
    }

    public String getAns2() {
        return ans2;
    }

    public void setAns2(String ans2) {
        this.ans2 = ans2;
    }

    public String getAns3() {
        return ans3;
    }

    public void setAns3(String ans3) {
        this.ans3 = ans3;
    }

    public String getAns4() {
        return ans4;
    }

    public void setAns4(String ans4) {
        this.ans4 = ans4;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public String getMinusmark() {
        return minusmark;
    }

    public void setMinusmark(String minusmark) {
        this.minusmark = minusmark;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getMultipleAns() {
        return multipleAns;
    }

    public void setMultipleAns(String multipleAns) {
        this.multipleAns = multipleAns;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }
}
