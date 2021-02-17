package com.autosearch.complete.service;

import com.autosearch.complete.dto.AutoSearchPostRequest;
import com.autosearch.complete.dto.AutoSearchResponse;


public interface AutoSearchService {
    AutoSearchResponse getSuggestions(String inputString);

    String postSuggestion(AutoSearchPostRequest autoSearchPostRequest);
}
