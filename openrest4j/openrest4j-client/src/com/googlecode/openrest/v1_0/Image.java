package com.googlecode.openrest.v1_0;

/**
 * A raw image.
 * @author DL
 */
public class Image {
    public Image(String contentType, byte[] content) {
        this.contentType = contentType;
        this.content = content;
    }

    public String contentType() {
        return contentType;
    }

    public byte[] content() {
        return content;
    }

    private final String contentType;
    private final byte[] content;
}