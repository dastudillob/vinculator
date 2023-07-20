/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Nacho
 */
public class Categoria {
    private String cod_cat;
    private String nom_cat;
    public Categoria(String cod_cat, String nom_cat) {
        this.cod_cat = cod_cat;
        this.nom_cat = nom_cat;
} 
    

public void setCod_cat(String cod_cat) {
this.cod_cat = cod_cat;
}

public void setNom_cat(String nom_cat) {
this.nom_cat = nom_cat;
}

    public String getCod_Cat() {
          return cod_cat;  
    }

    public String getNom_Cat() {
    return nom_cat;
    }



}
