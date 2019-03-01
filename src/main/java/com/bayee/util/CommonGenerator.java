package com.bayee.util;

/*
 * Created by renhongjiang on 2018/10/18.
 */

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/10/18 14:53
 */
public class CommonGenerator<T> implements Generator<T> {

    private Class<T> type;

    public CommonGenerator(Class<T> type) {
        this.type = type;
    }

    @Override
    public T next() {
        try {
            return type.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> Generator<T> create(Class<T> type) {
        return new CommonGenerator<T>(type);
    }


}