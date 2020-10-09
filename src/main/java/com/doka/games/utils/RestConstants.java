package com.doka.games.utils;

public final class RestConstants {

    private RestConstants() {
    }

    public static final String V1 = "";


    public static final String ADD = "/add";
    public static final String ALL = "/all";
    public static final String ID = "/{id}";
    public static final String LOGIN = "/login";
    public static final String LIST = "list";

    //Response headers
    public static final String MESSAGE = "message";
    //Success Messages
    public static final String SS = "Successfully Saved!";
    public static final String SD = "Successfully Deleted!";
    public static final String SG = "Successfully Fetched!";
    public static final String SU = "Successfully Updated!"; 
    //Response Status code
    public static final int OK = 1;
    public static final int ERROR = 0;
    //Exception Messages
    public static final String IDG0 = "id must be greater than 0";
    public static final String RNF = "Record Not Found!";
    public static final String INVALID_API = "Invalid API Inputs";
    public static final String UNKNOWN = "Unknow Error!";
    public static final String IAE = "Illegal Argument Found";
    public static final String EL = "List is Empty!";
    public static final String NO = "Null object received.";
    public static final String RNAE = "Role Name Already Exit!";
 
    //default values
    public static final String ROLE="ROLE";
}
