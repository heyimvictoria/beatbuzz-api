package org.launchcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("search")
public class SearchController {

    @GetMapping
    public String displaySearchForm() {
        // display search form
        return "search/form";
    }

    @PostMapping
    public String processSearchQuery(@RequestParam("query") String query) {
        // process search query
        return "search/results";
    }
}