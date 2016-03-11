package com.example.vladimirkarassouloff.projetter.customlistener;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.vladimirkarassouloff.projetter.R;
import com.example.vladimirkarassouloff.projetter.myelementsproduction.Production;
import com.example.vladimirkarassouloff.projetter.myelementsproduction.variable.ProductionVariable;
import com.example.vladimirkarassouloff.projetter.myelementsproduction.variable.ProductionVariableInstanciation;
import com.example.vladimirkarassouloff.projetter.myviews.prompt.PromptTypeVariableView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Vladimir on 16/02/2016.
 */
public class ValidationDialogVariable extends ValidationDialogProduction{

    protected EditText et;
    protected PromptTypeVariableView ptv;

    public ValidationDialogVariable(Dialog dialog, View promptsView,Production p) {
        super(dialog, promptsView,p);
        et = (EditText) promptsView.findViewById(R.id.editTextVariableInput);
        ptv = (PromptTypeVariableView) promptsView.findViewById(R.id.promptviewtypevariable);
    }

    @Override
    public void checkValid() throws Exception{
        if(et.getText().length() == 0){
            throw new Exception("Donnez un nom a la variable !");
        }
        else if(Character.isDigit(et.getText().charAt(0))){
            throw new Exception("La premiere lettre ne peut pas etre un nombre");
        }
        else if(!isNameCorrect(et.getText().toString())){
            throw new Exception("Symbole interdits");
        }
    }

    protected boolean isNameCorrect(String s){
        for(int i = 0 ; i < s.length() ; i++){
            if(!Character.isDigit(s.charAt(i)) && !Character.isAlphabetic(s.charAt(i))){
                return false;
            }
        }
        return true;
    }

    @Override
    public void onValid() {
        ProductionVariableInstanciation pv = (ProductionVariableInstanciation) this.production;
        pv.setType(ptv.getType());
        pv.setName(et.getText().toString());
        pv.refreshText();
        Intent intent = new Intent("newVariable");
        intent.putExtra("variable", et.getText().toString());
        LocalBroadcastManager.getInstance(promptsView.getContext()).sendBroadcast(intent);
    }
}