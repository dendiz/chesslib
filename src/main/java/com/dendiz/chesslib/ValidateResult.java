package com.dendiz.chesslib;

import java.io.Serializable;

/**
 * Created by dendiz on 25/07/15.
 */
public class ValidateResult implements Serializable {
    public boolean valid = false;
    public int error_number;
    public String error;

    public ValidateResult(boolean valid, int error_number, String error) {
        this.valid = valid;
        this.error_number = error_number;
        this.error = error;
    }
}
