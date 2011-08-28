package com.googlecode.openrest;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClubMembers implements Serializable {
    public ClubMembers(List<ClubMember> clubMembers) {
        this.clubMembers = clubMembers;
    }

    /** Default constructor for JSON deserialization. */
    public ClubMembers() {}

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public List<ClubMember> clubMembers = Collections.emptyList();

    private static final long serialVersionUID = 1L;
}
