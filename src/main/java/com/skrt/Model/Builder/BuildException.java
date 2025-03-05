package com.skrt.Model.Builder;

public class BuildException extends RuntimeException {
    public BuildException(String clothComponent, Object value) {
        super (clothComponent + " got an invalid value of: " + value);
    }
    public BuildException(String clothComponent, String value) {
        super (clothComponent + " Exception: {" + value + "} Missing required fields!");
    }
}
