package com.garagu.swapi.data.mappers;

/**
 * Created by garagu.
 */
interface Mapper<T, U> {

    U mapEntityToModel(T entity);

}