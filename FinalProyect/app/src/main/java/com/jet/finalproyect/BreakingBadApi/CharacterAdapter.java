package com.jet.finalproyect.BreakingBadApi;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jet.finalproyect.Models.Characters;
import com.jet.finalproyect.R;

import java.util.List;

public class CharacterAdapter extends BaseAdapter {

    protected Activity activity;
    protected List<Characters> myCharacters;

    public CharacterAdapter(Activity activity, List<Characters> myCharacters) {
        this.activity = activity;
        this.myCharacters = myCharacters;
    }

    @Override
    public int getCount() {
        return myCharacters.size();
    }

    @Override
    public Object getItem(int position) {
        return myCharacters.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if(convertView == null){
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.characteritem, null);
        }
        Characters character = myCharacters.get(position);
        TextView id = v.findViewById(R.id.idCharacter);
        TextView name = v.findViewById(R.id.nameCharacter);
        TextView status = v.findViewById(R.id.statusCharacter);
        TextView nickName = v.findViewById(R.id.nickNameCharacter);

        id.setText(character.getCharacterId());
        name.setText(character.getCharacterName());
        status.setText(character.getCharacterStatus());
        nickName.setText(character.getCharacterNickName());
        return v;

    }
}
