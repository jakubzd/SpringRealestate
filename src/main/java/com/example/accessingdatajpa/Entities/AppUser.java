package com.example.accessingdatajpa.Entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class AppUser extends Userr {
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "appuser")
    private List<Preferences> preferences;
    private String nickname;
    @OneToMany
    private List<POI> pois;

    public List<POI> getPois() {
        return pois;
    }

    public void setPois(List<POI> pois) {
        this.pois = pois;
    }



    public List<Preferences> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<Preferences> preferences) {
        this.preferences = preferences;
    }



    public AppUser() {
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }
}


