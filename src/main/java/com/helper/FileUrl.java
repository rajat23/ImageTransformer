package com.helper;

public class FileUrl {

    public String getFileExtension(String url) {
        return url.substring(url.lastIndexOf(".") + 1);
    }
}
