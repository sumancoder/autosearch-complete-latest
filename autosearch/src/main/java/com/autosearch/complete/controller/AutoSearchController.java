package com.autosearch.complete.controller;

import com.autosearch.complete.dto.AutoSearchPostRequest;
import com.autosearch.complete.dto.AutoSearchResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;


@RequestMapping(value="autosearch/")
@Api(value = "autosearch")
public interface AutoSearchController {

    @ApiResponses(value={
            @ApiResponse(code=200,message = "Successful operation", response = AutoSearchResponse.class, responseContainer = "List"),
            @ApiResponse(code=404,message = "Data not found "),
            @ApiResponse(code=400,message = "Incorrect input")
    })
    @GetMapping(value="/get/{inputString}")
    public AutoSearchResponse getSuggestions(@PathVariable String inputString);


    @ApiResponses(value={
            @ApiResponse(code=200,message = "Successful operation", response = String.class ),
            @ApiResponse(code=404,message = "Data not found "),
            @ApiResponse(code=400,message = "Incorrect input")
    })
    @PostMapping(value="/create")
    public String createSuggestions(@RequestBody AutoSearchPostRequest autoSearchPostRequest);

}
