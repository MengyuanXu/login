package com.example.login;

public class Location {
    private int locationID;
    private float latitude;
    private float longitude;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String room;

    //seven parameter Location constructor
    public Location(float latitude, float longitude, String address, String city, String state,
                    String zip, String room)
    {
        //set values
        try{setLatitude(latitude);}
        catch(NullPointerException e){setLatitude(0.0f);}

        try{setLongitude(longitude);}
        catch(NullPointerException e){setLongitude(0.0f);}

        try{setAddress(address);}
        catch(NullPointerException e){setAddress("");}

        try{setCity(city);}
        catch(NullPointerException e){setCity("");}

        try{setState(state);}
        catch(NullPointerException e){setState("");}

        try{setZip(zip);}
        catch(NullPointerException e){setZip("");}

        try{setRoom(room);}
        catch(NullPointerException e){setRoom("");}

        //TODO create sql to insert into db

        //TODO retrieve unique dq id for location id

    }

    private void setLatitude(float latitude){
        this.latitude = latitude;
    }

    public float getLatitude(){
        return this.latitude;
    }

    private void setLongitude(float longitude){
        this.longitude = longitude;
    }

    public float getLongitude(){
        return this.longitude;
    }

    private void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return this.address;
    }

    private void setCity(String city){
        this.city = city;
    }

    public String getCity(){
        return this.city;
    }

    private void setState (String state){
        this.state = state;
    }

    public String getState(){
        return this.state;
    }

    private void setZip(String zip){
        this.zip = zip;
    }

    public String getZip(){
        return this.zip;
    }

    private void setRoom(String room){
        this.room = room;
    }

    public String getRoom(){
        return this.room;
    }

}
