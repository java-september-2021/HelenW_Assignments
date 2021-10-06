package com.events.belt.models;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity

@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Size(min=2,max=200,message="First Name should be between 2~200")
    private String firstName;
    private String lastName;
    
    @NotBlank
    private String location;
    private String state;
 


	//validation
    @Email
    private String email;
    @Size(min=2,max=200,message="Password should be between 2~200")
    private String password;
    @NotBlank  
    @Transient
    private String passwordConfirmation;
    public List<Message> getMessages() {
		return messages;
	}




	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    //one user can leave many messages
    @OneToMany(mappedBy="messageOwner", fetch = FetchType.LAZY)
    private List<Message> messages;
    
    //one user can create many events
    @OneToMany(mappedBy="eventCreator", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Event> eventsCreated;
    
    //a user can join many events, and an event can be joined by many users
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    		name = "user_events",
    		joinColumns = @JoinColumn(name = "user_id"),
    		inverseJoinColumns = @JoinColumn(name="event_id")
    		)
    private List<Event> EventsToBeJoined;
    
    public User() {
    }
    
    
    // other getters and setters removed for brevity
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}


	public List<Event> getEventsCreated() {
		return eventsCreated;
	}


	public void setEventsCreated(List<Event> eventsCreated) {
		this.eventsCreated = eventsCreated;
	}


	public List<Event> getEventsToBeJoined() {
		return EventsToBeJoined;
	}


	public void setEventsToBeJoined(List<Event> eventsToBeJoined) {
		EventsToBeJoined = eventsToBeJoined;
	}


	public Long getId() {
		return id;
	}
	   public String getLocation() {
			return location;
		}


		public void setLocation(String location) {
			this.location = location;
		}


		public String getState() {
			return state;
		}


		public void setState(String state) {
			this.state = state;
		}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}


	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
    
    
}
