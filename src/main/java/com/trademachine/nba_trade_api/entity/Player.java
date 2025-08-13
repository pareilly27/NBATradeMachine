
package com.trademachine.nba_trade_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Player")
public class Player {
	
		
		@Id
		@Column(name = "idPlayer")  
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Column(name = "PlayerName")
	    private String name;

	    @Column(name = "TeamName")
	    private String franchise;

	    @Column(name = "Athleticism")
	    private double athleticism;

	    @Column(name = "Height")
	    private double height;

	    @Column(name = "Shooting")
	    private double shooting;

	    @Column(name = "PostDefense")
	    private double postDefense;

	    @Column(name = "perimeterDefense")
	    private double perimeterDefense;

	    @Column(name = "passing")
	    private double passing;

	    @Column(name = "ballHandling")
	    private double ballHandling;

	    @Column(name = "rebounding")
	    private double rebounding;

	    @Column(name = "Age")
	    private double age;
	    
	    @Column(name = "image_id")
	    private Integer imageId;

	    public Integer getImageId() {
	        return imageId;
	    }

	    public void setImageId(Integer imageId) {
	        this.imageId = imageId;
	    }
	    
	    public Player() {
	        this.athleticism = 50;
	        this.height = 50;
	        this.shooting = 50;
	        this.postDefense = 50;
	        this.perimeterDefense = 50;
	        this.passing = 50;
	        this.ballHandling = 50;
	        this.rebounding = 50;
	        this.age = 50;
	    }
	    
	    public void setAthleticism(double athleticism) {
	        this.athleticism = athleticism;
	    }

	    public double getAthleticism() {
	        return athleticism;
	    }
		
	    // ID
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    // Name
	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    // Franchise
	    public String getFranchise() {
	        return franchise;
	    }

	    public void setFranchise(String franchise) {
	        this.franchise = franchise;
	    }

	    // Height
	    public double getHeight() {
	        return height;
	    }

	    public void setHeight(double height) {
	        this.height = height;
	    }

	    // Shooting
	    public double getShooting() {
	        return shooting;
	    }

	    public void setShooting(double shooting) {
	        this.shooting = shooting;
	    }

	    // Post Defense
	    public double getPostDefense() {
	        return postDefense;
	    }

	    public void setPostDefense(double postDefense) {
	        this.postDefense = postDefense;
	    }

	    // Perimeter Defense
	    public double getPerimeterDefense() {
	        return perimeterDefense;
	    }

	    public void setPerimeterDefense(double perimeterDefense) {
	        this.perimeterDefense = perimeterDefense;
	    }

	    // Passing
	    public double getPassing() {
	        return passing;
	    }

	    public void setPassing(double passing) {
	        this.passing = passing;
	    }

	    // Ball Handling
	    public double getBallHandling() {
	        return ballHandling;
	    }

	    public void setBallHandling(double ballHandling) {
	        this.ballHandling = ballHandling;
	    }

	    // Rebounding
	    public double getRebounding() {
	        return rebounding;
	    }

	    public void setRebounding(double rebounding) {
	        this.rebounding = rebounding;
	    }

	    // Age
	    public double getAge() {
	        return age;
	    }

	    public void setAge(double age) {
	        this.age = age;
	    }

}
