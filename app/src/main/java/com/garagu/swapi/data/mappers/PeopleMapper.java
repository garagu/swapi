package com.garagu.swapi.data.mappers;

import com.garagu.swapi.data.entities.CharacterEntity;
import com.garagu.swapi.data.entities.PeopleEntity;
import com.garagu.swapi.domain.Character;
import com.garagu.swapi.domain.PaginatedList;

import java.util.List;

/**
 * Created by garagu.
 */
public class PeopleMapper implements Mapper<PeopleEntity, PaginatedList<Character>> {

    @SuppressWarnings("unchecked")
    @Override
    public PaginatedList<Character> mapEntityToModel(PeopleEntity entity) {
        return new PaginatedList.Builder()
                .withItems(mapListEntityToModel(entity.getResults()))
                .withHasMore((entity.getNext() != null) && !entity.getNext().isEmpty())
                .withPage(mapUrlToPage(entity.getNext()))
                .build();
    }

    private List<Character> mapListEntityToModel(List<CharacterEntity> entityList) {
        return new CharacterMapper().mapList(entityList);
    }

    private int mapUrlToPage(String url) {
        if (url != null) {
            String strPage = url.replace("http://swapi.co/api/people/?page=", "");
            return Integer.valueOf(strPage);
        }
        return -1;
    }

}