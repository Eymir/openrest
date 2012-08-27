package com.openrest.v1_1;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetBlobUploadUrlRequest extends Request {
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetBlobUploadUrlRequest() {}
    
    public GetBlobUploadUrlRequest(String accessToken, String organizationId, String itemId, String blobType) {
    	this.accessToken = accessToken;
    	this.organizationId = organizationId;
    	this.itemId = itemId;
    	this.blobType = blobType;
    }
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String accessToken;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String organizationId;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String itemId;

    /** One of Organization.ALL_BLOB_TYPES */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String blobType;
}