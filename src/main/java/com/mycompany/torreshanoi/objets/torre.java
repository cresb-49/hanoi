package com.mycompany.torreshanoi.objets;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class torre {

    private static final String v0 = " ";
    private static final String v1 = "▇";
    private static final String v2 = "▇▇▇";
    private static final String v3 = "▇▇▇▇▇";
    private static final String v4 = "▇▇▇▇▇▇▇";
    private static final String v5 = "▇▇▇▇▇▇▇▇▇";

    private String[] aros;

    public torre() {
    }

    public String[] torreAsignada(String n) {
        String[] temp;
        switch (n) {
            case "1":
                String[] tm = {v0, v0, v0, v0, v1};
                temp = tm;
                break;
            case "2":
                String[] tm2 = {v0, v0, v0, v1, v2};
                temp = tm2;
                break;
            case "3":
                String[] tm3 = {v0, v0, v1, v2, v3};
                temp = tm3;
                break;
            case "4":
                String[] tm4 = {v0, v1, v2, v3, v4};
                temp = tm4;
                break;
            case "5":
                String[] tm5 = {v1, v2, v3, v4, v5};
                temp = tm5;
                break;
            default:
                String[] tm6 = {v1, v2, v3, v4, v5};
                temp = tm6;
                break;
        }
        return temp;
    }

    public boolean movimiento(JList torreOrigen, JList torreDestino) {
        boolean aceptacion = false;
        String[] t1 = obtener(torreOrigen);
        String[] t2 = obtener(torreDestino);
        //Guardado por error de movimiento
        String[] tm1 = t1;
        String[] tm2 = t2;
        ////////////////////////////////
        String pieza1 = " ";
        String pieza2 = "x";
        for (int i = 0; i < 5; i++) {
            if (!tm1[i].equals(" ")) {
                pieza1 = tm1[i];
                tm1[i] = " ";
                System.out.println("Pieza1: "+pieza1);
                break;
            }
        }
        System.out.println("-Pieza1: "+pieza1);
        
        if (!pieza1.equals(" ")) {
            for (int i = 4; i >= 0; i--) {
                if (tm2[i].equals(" ")) {
                    if (i == 4) {
                        tm2[i] = pieza1;
                        pieza2="y";
                    } else {
                        if(tm2[i+1].length()>pieza1.length()){
                            tm2[i]=pieza1;
                            pieza2="y";
                        }
                    }
                    break;
                }
            }
            if(pieza2.equals("y")){
                torreOrigen.setListData(tm1);
                torreDestino.setListData(tm2);
                aceptacion=true;
            }
        }
        return aceptacion;
    }
    
    public String[] obtener(JList torre) {
        String[] tmp = new String[5];

        int tamano = torre.getModel().getSize();

        for (int i = 0; i < tamano; i++) {
            tmp[i] = String.valueOf(torre.getModel().getElementAt(i));
        }
        return tmp;
    }
    
    public int calculoMovimientos(int altura){
        int temp =0;
        temp = ((int) Math.pow(2, altura))-1;
        return temp;
    }
}
