package com.garagu.swapi.data.mappers;

import com.garagu.swapi.data.entities.CharacterEntity;
import com.garagu.swapi.domain.Character;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by garagu.
 */
public class CharacterMapper implements Mapper<CharacterEntity, Character> {

    @Override
    public Character mapEntityToModel(CharacterEntity entity) {
        return new Character.Builder()
                .withId(mapUrlToId(entity.getUrl()))
                .withName(entity.getName())
                .withHeight(entity.getHeight())
                .withMass(entity.getMass())
                .withFilms(mapFilmsUrlsToFilmsIds(entity.getFilmsUrls()))
                .build();
    }

    private int mapUrlToId(String url) {
        String strId = url.replace("http://swapi.co/api/people/", "").replace("/", "");
        return Integer.valueOf(strId);
    }

    private List<String> mapFilmsUrlsToFilmsIds(String[] filmsUrls) {
        List<String> filmsIds = new ArrayList<>();
        for (String url : filmsUrls) {
            String strId = url.replace("http://swapi.co/api/films/", "").replace("/", "");
            filmsIds.add(strId);
        }
        return filmsIds;
    }

    @SuppressWarnings("Convert2streamapi") // minSdkVersion < 24
    public List<Character> mapList(List<CharacterEntity> entities) {
        List<Character> modelList = new ArrayList<>();
        for (CharacterEntity entity : entities) {
            modelList.add(mapEntityToModel(entity));
        }
        return modelList;
    }

}