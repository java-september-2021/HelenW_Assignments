package com.events.belt.models;

import java.text.SimpleDateFormat;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="events")
public class Event {
	   @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Long id;
	   
	   @NotBlank
	   private String eventName;
		@Future

		@DateTimeFormat(pattern ="yyyy-MM-dd")
	   private Date eventDate;
		@NotBlank
	   private String location;
	   private String state;
	   
	   @Column(updatable=false)
	    private Date createdAt;
	    private Date updatedAt;
	    
	    //one event may have many messages, CascadeType.REMOVE is added here suggested by Reena for an event that has messages,
	    //without this "CascadeType.remove", an event that has undeleted messages can not get deleted by Delete operation in dashboard page.
	    //or can use "CascadeType.ALL" which Matt has used in his lecture code "Album" too. All includes remove.
	    @OneToMany(mappedBy="eventHasMessages", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	    private List<Message> messagesForEvent;
	    
	    //one user can create many events
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="user_id")
	    private User eventCreator;
	    
	    //same event can be joined by many users
	    @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	    		name = "user_events",
	    		joinColumns = @JoinColumn(name = "event_id"),
	    		inverseJoinColumns = @JoinColumn(name="user_id")
	    		)
	    private List<User> usersJoined;
	    
	    
	    @PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
	    
	    
		public Event() {
		}
		
		  public String getEventDateFormatted() {
		    	SimpleDateFormat df = new SimpleDateFormat("dd,MM,YYYY");
		    	return df.format(this.eventDate);
		    }
		
		
		public List<User> getUsersJoined() {
			return usersJoined;
		}
		public void setUsersJoined(List<User> usersJoined) {
			this.usersJoined = usersJoined;
		}
		public List<Message> getMessagesForEvent() {
			return messagesForEvent;
		}
		public void setMessagesForEvent(List<Message> messagesForEvent) {
			this.messagesForEvent = messagesForEvent;
		}
		public User getEventCreator() {
			return eventCreator;
		}
		public void setEventCreator(User eventCreator) {
			this.eventCreator = eventCreator;
		}
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getEventName() {
			return eventName;
		}
		public void setEventName(String eventName) {
			this.eventName = eventName;
		}
		public Date getEventDate() {
			return eventDate;
		}
		public void setEventDate(Date eventDate) {
			this.eventDate = eventDate;
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
