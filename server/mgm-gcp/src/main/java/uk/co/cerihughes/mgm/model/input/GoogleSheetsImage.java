package uk.co.cerihughes.mgm.model.input;

import com.google.gson.annotations.SerializedName;

import java.util.Optional;

public class GoogleSheetsImage {
    @SerializedName("size")
    private Integer size;
    @SerializedName("url")
    private String url;

    public Integer getSize() {
        return size;
    }

    public String getUrl() {
        return url;
    }
}
