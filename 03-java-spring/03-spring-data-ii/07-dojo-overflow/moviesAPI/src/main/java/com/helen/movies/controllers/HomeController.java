package com.helen.movies.controllers;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@Controller
public class HomeController {
	static String url = "http://www.omdbapi.com/?apikey=120ea430&";
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	
	
	@GetMapping("/search")
	public String search(Model viewModel,@RequestParam("search") String search) {
		try {
			//t for tile
//			HttpResponse<JsonNode>  request = Unirest.get(url+ "t={name}")
			//s for search in http://www.omdbapi.com/   see usage
			HttpResponse<JsonNode>  request = Unirest.get(url+ "s={name}")
					
					.routeParam("name", search)
					.asJson();
				
		 JSONObject resultsObject = request.getBody().getObject();
		 System.out.print(resultsObject);
		 
		 //"Search" has to match the one in the response object
		 JSONArray searchResults = resultsObject.getJSONArray("Search");
		 ArrayList<JSONObject> resultsForPage = new ArrayList<JSONObject>();
		 for(int i = 0; i < searchResults.length(); i++) {
			 resultsForPage.add(searchResults.getJSONObject(i));
		 }
		 viewModel.addAttribute("total",resultsObject.get("totalResults"));
		 viewModel.addAttribute("results",resultsForPage);
		 viewModel.addAttribute("search", search);
		 
		} catch(UnirestException e) {
			//ToDo Auto-generated catch block
			e.printStackTrace();
		}
		return "results.jsp";
	}
}	
