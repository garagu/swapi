package com.garagu.swapi.data.net;

import com.garagu.swapi.BuildConfig;
import com.garagu.swapi.data.entities.FilmEntity;
import com.garagu.swapi.data.entities.PeopleEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by garagu.
 */
public interface StarWarsAPI {

    String BASE_URL = BuildConfig.STAR_WARS_API;

    @GET("people/")
    Observable<PeopleEntity> getPeople(@Query("page") int page);

    @GET("films/{id}/")
    Observable<FilmEntity> getFilm(@Path("id") String id);

}