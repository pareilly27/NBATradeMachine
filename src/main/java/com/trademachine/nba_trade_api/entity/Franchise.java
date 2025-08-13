package com.trademachine.nba_trade_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Teams")  // matches your existing table name
public class Franchise {
    
    @Id
    @Column(name = "idTeam")  
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "valuesAthleticism")
    private double valuesAthleticism;

    @Column(name = "valuesHeight")
    private double valuesHeight;

    @Column(name = "valuesShooting")
    private double valuesShooting;

    @Column(name = "valuesPostDefense")
    private double valuesPostDefense;

    @Column(name = "valuesPerimeterDefense")
    private double valuesPerimeterDefense;

    @Column(name = "valuesPassing")
    private double valuesPassing;

    @Column(name = "valuesBallHandling")
    private double valuesBallHandling;

    @Column(name = "valuesRebounding")
    private double valuesRebounding;

    @Column(name = "valuesYouth")
    private int valuesYouth;

    // Default constructor
    public Franchise() {
        this.valuesAthleticism = 1;
        this.valuesHeight = 1;
        this.valuesShooting = 1;
        this.valuesPostDefense = 1;
        this.valuesPerimeterDefense = 1;
        this.valuesPassing = 1;
        this.valuesBallHandling = 1;
        this.valuesRebounding = 1;
        this.valuesYouth = 1;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getValuesAthleticism() {
        return valuesAthleticism;
    }

    public double getValuesHeight() {
        return valuesHeight;
    }

    public double getValuesShooting() {
        return valuesShooting;
    }

    public double getValuesPostDefense() {
        return valuesPostDefense;
    }

    public double getValuesPerimeterDefense() {
        return valuesPerimeterDefense;
    }

    public double getValuesPassing() {
        return valuesPassing;
    }

    public double getValuesBallHandling() {
        return valuesBallHandling;
    }

    public double getValuesRebounding() {
        return valuesRebounding;
    }

    public int getValuesYouth() {
        return valuesYouth;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValuesAthleticism(double valuesAthleticism) {
        this.valuesAthleticism = valuesAthleticism;
    }

    public void setValuesHeight(double valuesHeight) {
        this.valuesHeight = valuesHeight;
    }

    public void setValuesShooting(double valuesShooting) {
        this.valuesShooting = valuesShooting;
    }

    public void setValuesPostDefense(double valuesPostDefense) {
        this.valuesPostDefense = valuesPostDefense;
    }

    public void setValuesPerimeterDefense(double valuesPerimeterDefense) {
        this.valuesPerimeterDefense = valuesPerimeterDefense;
    }

    public void setValuesPassing(double valuesPassing) {
        this.valuesPassing = valuesPassing;
    }

    public void setValuesBallHandling(double valuesBallHandling) {
        this.valuesBallHandling = valuesBallHandling;
    }

    public void setValuesRebounding(double valuesRebounding) {
        this.valuesRebounding = valuesRebounding;
    }

    public void setValuesYouth(int valuesYouth) {
        this.valuesYouth = valuesYouth;
    }
}