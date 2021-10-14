package com.helen.overflow.models;



import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.persistence.JoinColumn;

@Entity
@Table(name="questions")
public class Question {
	   @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Long id;
	   @NotBlank
	   private String questionContent;
	   
	   @Transient
	   private String tempTags;
	   
	    @Column(updatable=false)
	    private Date createdAt;
	    private Date updatedAt;
	    
	    //one question has many answers
	    @OneToMany(mappedBy="answerOwner", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	    private List<Answer> answersForQuestion;
	    
	    //same question can have many tags
	    @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	    		name = "quesion_tags",
	    		joinColumns = @JoinColumn(name = "question_id"),
	    		inverseJoinColumns = @JoinColumn(name="tag_id")
	    		)
	    private List<Tag> tagsForQuestion;
	    
	    
	   
	    @PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
	    
	    
	
		public String getTempTags() {
			return tempTags;
		}
		public void setTempTags(String tempTags) {
			this.tempTags = tempTags;
		}
		public String getQuestionContent() {
			return questionContent;
		}
		public void setQuestionContent(String questionContent) {
			this.questionContent = questionContent;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
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
		
		
		public List<Answer> getAnswersForQuestion() {
			return answersForQuestion;
		}
		public void setAnswersForQuestion(List<Answer> answersForQuestion) {
			this.answersForQuestion = answersForQuestion;
		}
		public List<Tag> getTagsForQuestion() {
			return tagsForQuestion;
		}
		public void setTagsForQuestion(List<Tag> tagsForQuestion) {
			this.tagsForQuestion = tagsForQuestion;
		}
		public Question() {
		}
	    
	    
}
