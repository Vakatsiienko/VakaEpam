package com.vaka.epam.homework.week4.task16;

/**
 * Created by Iaroslav on 11/20/2016.
 */
public class CoordinatesParseException extends Exception {
    public CoordinatesParseException() {
    }

    public CoordinatesParseException(String message) {
        super(message);
    }

    public CoordinatesParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public CoordinatesParseException(Throwable cause) {
        super(cause);
    }
}
