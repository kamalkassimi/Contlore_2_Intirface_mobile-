package com.elmernissi.myrestufinder.model;

import java.io.Serializable;

public class Magasin  implements Serializable {
    private String name ;
    private String Addrese;
    private  String telephone ;

    public Magasin(String name, String addrese, String telephone) {
        this.name = name;
        this.Addrese = addrese;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public String getAddrese() {
        return Addrese;
    }

    public String getTelephone() {
        return telephone;
    }
}
