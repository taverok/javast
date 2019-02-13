package com.taverok.javast.domain.v3;

public class Vast extends com.taverok.javast.domain.base.Vast {
    {
        version="3.0";
    }

    public com.taverok.javast.domain.base.Vast noAds(){
        setError("No ads");

        return this;
    }

}
