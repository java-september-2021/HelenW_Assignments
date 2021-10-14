package com.helen.overflow.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="tags")
public class Tag {
	   @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Long id;
	   @NotBlank
	   @Size(max=255)
	   private String subject;
	   
	    @Column(updatable=false)
	    private Date createdAt;
	    private Date updatedAt;
	    
	    //same question may belong to one tag
	    @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	    		name = "quesion_tags",
	    		joinColumns = @JoinColumn(name = "tag_id"),
	    		inverseJoinColumns = @JoinColumn(name="question_id")
	    		)
	    private List<Question> questionsForTag;
	   
	    @PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
	    
	    
		public List<Question> getQuestionsForTag() {
			return questionsForTag;
		}
		public void setQuestionsForTag(List<Question> questionsForTag) {
			this.questionsForTag = questionsForTag;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
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
		public Tag() {
		}
		public Tag(String subject) {
			this.subject = subject;
		}
}
