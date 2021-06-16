package com.jet.finalproyect.Models;

import com.google.gson.annotations.SerializedName;

public class Characters {

    @SerializedName("char_id")
    private String characterId;

    @SerializedName("name")
    private String CharacterName;

    @SerializedName("status")
    private String CharacterStatus;

    @SerializedName("nickname")
    private  String characterNickName;

    public String getCharacterId() {
        return characterId;
    }

    public void setCharacterId(String characterId) {
        this.characterId = characterId;
    }

    public String getCharacterName() {
        return CharacterName;
    }

    public void setCharacterName(String characterName) {
        CharacterName = characterName;
    }

    public String getCharacterStatus() {
        return CharacterStatus;
    }

    public void setCharacterStatus(String characterStatus) {
        CharacterStatus = characterStatus;
    }

    public String getCharacterNickName() {
        return characterNickName;
    }

    public void setCharacterNickName(String characterNickName) {
        this.characterNickName = characterNickName;
    }
}
