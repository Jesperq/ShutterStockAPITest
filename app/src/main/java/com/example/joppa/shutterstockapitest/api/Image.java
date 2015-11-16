package com.example.joppa.shutterstockapitest.api;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Jesper on 2015-11-14.
 */
public class Image {
    @SerializedName("id")
    private String mId;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("assets")
    private ImageAssets mAssets;

    public String getDescription() {
        return mDescription;
    }

    public String getId() {
        return mId;
    }

    public String getLargeThumbnail(){
        return mAssets.mLargeThumb.mURL;
    }

    private class ImageAssets{
        @SerializedName("preview")
        private Thumbnail mPreview;
        @SerializedName("small_thumb")
        private Thumbnail mSmallThumb;
        @SerializedName("large_thumb")
        private Thumbnail mLargeThumb;
    }

    private class Thumbnail {
        @SerializedName("url")
        private String mURL;
    }

}
