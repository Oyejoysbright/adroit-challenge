/*
 * This file is generate by Joysbright for Adroit
 */
package org.adroit.challenge.models;

import java.util.ArrayList;
import lombok.Data;

/**
 *
 * @author Ayomide Joysbright Oyediran
 */
@Data
public class Person {
    private long id;
    private long assocId;
    private String ex;
    private String type;
    private String action;
    private String dateAction;
    private String gender;
    private String activeStatus;
    private String deceased;
    private String birthplace;
    private String addressLine;
    private String addressCity;
    private String addressCountry;
    private String firstName;
    private String middleName;
    private String surname;
    
    private ArrayList<Person> associates = new ArrayList<>();
    private ArrayList<Country> countries = new ArrayList<>();
    private ArrayList<Date> dates = new ArrayList<>();
    private ArrayList<Description> descriptions = new ArrayList<>();
    private ArrayList<Number> numbers = new ArrayList<>();
    private ArrayList<Role> roles = new ArrayList<>();
    private ArrayList<Sanction> sanctions = new ArrayList<>();
    private ArrayList<File> files = new ArrayList<>();
}
