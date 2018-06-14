package com.example.base.core.api.posts;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Carlos Cornejo (@icarloscornejo) on 15/5/2018.
 * https://www.linkedin.com/in/icarloscornejo
 */
public class PostModel implements Parcelable {

    private String id;
    private String body;
    private String title;
    private String userId;

    public PostModel() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "PostModel{" +
                "id='" + id + '\'' +
                ", body='" + body + '\'' +
                ", title='" + title + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.body);
        dest.writeString(this.title);
        dest.writeString(this.userId);
    }

    protected PostModel(Parcel in) {
        this.id = in.readString();
        this.body = in.readString();
        this.title = in.readString();
        this.userId = in.readString();
    }

    public static final Parcelable.Creator<PostModel> CREATOR = new Parcelable.Creator<PostModel>() {
        @Override
        public PostModel createFromParcel(Parcel source) {
            return new PostModel(source);
        }

        @Override
        public PostModel[] newArray(int size) {
            return new PostModel[size];
        }
    };
}
