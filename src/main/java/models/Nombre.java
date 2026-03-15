/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 *
 * @author demib
 */
@Embeddable
public class Nombre {
    private String nombre;
    @Column(name = "ap_pat")
    private String apPat;
    @Column(name = "ap_mat")
    private String apMat;
}
