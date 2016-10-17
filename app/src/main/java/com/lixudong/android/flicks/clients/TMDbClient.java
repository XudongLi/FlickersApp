package com.lixudong.android.flicks.clients;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestHandle;

public class TMDbClient extends AsyncHttpClient {
    private static final String TMDB_API_URL = "https://api.themoviedb.org/3/movie/";
    private static final String API_KEY = "api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";

    public RequestHandle getPopularMovie(int page, JsonHttpResponseHandler handler) {
        String apiName = "popular";
        return get(constructAPICallUrl(apiName, page), handler);
    }

    private String constructAPICallUrl(String apiName, int page) {
        String pageParameter = String.format("page=%d", page);
        return TMDB_API_URL + apiName + "?" + API_KEY + "&" + pageParameter;
    }
}
