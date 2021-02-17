package com.autosearch.complete.controller;

import com.autosearch.complete.dto.AutoSearchPostRequest;
import com.autosearch.complete.dto.AutoSearchResponse;
import com.autosearch.complete.service.AutoSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest Controller
 */

@RestController
public class AutoSearchControllerImpl implements AutoSearchController {

    @Autowired
    AutoSearchService autoSearchService;


    public AutoSearchResponse getSuggestions(String inputString){
        return autoSearchService.getSuggestions(inputString);
    }

    @Override
    public String createSuggestions(AutoSearchPostRequest autoSearchPostRequest) {
        return autoSearchService.postSuggestion(autoSearchPostRequest);
    }
}
