package com.spit.spy.objects;

import java.sql.ResultSet;

/**
 * Created by admin on 6/1/2016.
 */
public interface ResultSetConvertible<T> {
    public T convert(ResultSet resultSet);
}
