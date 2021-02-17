package com.autosearch.complete.service.impl;

import com.autosearch.complete.constants.ErrorResponseConstants;
import com.autosearch.complete.dto.AutoSearchPostRequest;
import com.autosearch.complete.dto.AutoSearchResponse;
import com.autosearch.complete.exception.InvalidDataException;
import com.autosearch.complete.service.AutoSearchService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Service Implementation Class
 */
@Service
public class AutoSearchServiceImpl implements AutoSearchService {

    @Value("${search.min.character}")
    private String minCharacter;

    public Set<String> getStorageSet;

    public AutoSearchServiceImpl(){
        getStorageSet= new HashSet<>();
    }


    @Override
    public AutoSearchResponse getSuggestions(String inputString) {
        // Step 1: checking the length of the suggestion
        if(inputString.length() < Integer.parseInt(minCharacter)) throw new InvalidDataException(ErrorResponseConstants.INVALID_DATA_EXCEPTION);
        // Step 2 : Finding the suggestions based on the input string
        List<String> resultList=getStorageSet.stream().filter(suggestion->suggestion.contains(inputString)).collect(Collectors.toList());
        return AutoSearchResponse.builder().suggestions(resultList).build();
    }

    @Override
    public String  postSuggestion(AutoSearchPostRequest autoSearchPostRequest) {
        getStorageSet.addAll(autoSearchPostRequest.getSuggestionList());
        return "Data saved successfully";
    }
}
