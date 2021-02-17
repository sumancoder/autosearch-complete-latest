package com.autosearch.complete.service;

import com.autosearch.complete.dto.AutoSearchPostRequest;
import com.autosearch.complete.dto.AutoSearchResponse;
import com.autosearch.complete.exception.InvalidDataException;
import com.autosearch.complete.service.impl.AutoSearchServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Arrays;
import java.util.Set;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@TestPropertySource(properties = {"search.min.character=2"})
public class AutoSearchServiceTest {


    private static AutoSearchServiceImpl autoSearchService;

    private static AutoSearchServiceImpl autoSearchServiceForFailureCase;

    @BeforeAll
    public static void init(){
        autoSearchService= new AutoSearchServiceImpl();
        autoSearchServiceForFailureCase = new AutoSearchServiceImpl();
        Set<String> getStorageSet = autoSearchService.getStorageSet;
        Set<String> getStorageSetForFailureCase = autoSearchServiceForFailureCase.getStorageSet;
        getStorageSet.add("baby pants");
        getStorageSet.add("baby shirts");
        getStorageSet.add("Men pants");
        getStorageSet.add("Woman pants");

        getStorageSetForFailureCase.add("baby pants");
        getStorageSetForFailureCase.add("baby shirts");
        getStorageSetForFailureCase.add("Men pants");
        getStorageSetForFailureCase.add("Woman pants");

        ReflectionTestUtils.setField(autoSearchService,"minCharacter","2");

        ReflectionTestUtils.setField(autoSearchServiceForFailureCase,"minCharacter","3");


    }

    @Test
    public void testCreateSuggestion(){
        AutoSearchPostRequest autoSearchPostRequest = new AutoSearchPostRequest();
        autoSearchPostRequest.setSuggestionList(Arrays.asList("Test","Test Data"));
        String stringMono = autoSearchService.postSuggestion(autoSearchPostRequest);
        Assertions.assertEquals("Data saved successfully",stringMono);
    }

    @Test
    public void testGetSuggestionPositiveTestCase(){
        AutoSearchResponse autoSearchResponseExpected = new AutoSearchResponse();
        autoSearchResponseExpected.setSuggestions(Arrays.asList("baby pants","baby shirts"));
        AutoSearchResponse autoSearchResponseActual  = autoSearchService.getSuggestions("baby");
        Assertions.assertEquals(autoSearchResponseExpected,autoSearchResponseActual);
    }

    @Test
    public void testGetSuggestionPositiveFailedCase(){
        AutoSearchResponse autoSearchResponseExpected = new AutoSearchResponse();
        autoSearchResponseExpected.setSuggestions(Arrays.asList("baby pants","baby shirts"));
        Assertions.assertThrows(InvalidDataException.class,()->autoSearchServiceForFailureCase.getSuggestions("ba"));
    }

}
