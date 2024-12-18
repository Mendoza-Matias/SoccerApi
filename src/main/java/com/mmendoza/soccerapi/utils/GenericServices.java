package com.mmendoza.soccerapi.utils;

import com.mmendoza.soccerapi.domain.exception.SoccerApiException;

public abstract class GenericServices<T, Y> {

    protected abstract Y execute(T request);

    public Y run(T request) {
        try {
            return execute(request);
        } catch (RuntimeException e) { /* return the exception created */
            throw e;
        } catch (Exception e) {
            throw new SoccerApiException("The application does not work correctly");
        }
    }

}
