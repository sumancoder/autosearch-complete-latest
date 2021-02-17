package com.autosearch.complete.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutoSearchPostRequest {

    @JsonProperty("suggestions")
    public List<String> suggestionList=null;

}
