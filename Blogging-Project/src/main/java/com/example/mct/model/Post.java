package com.example.mct.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    @Column(nullable = false)
    private LocalDateTime createdDate;


    @Column(nullable = false)
    @NotEmpty
    private String postData;

    private String postCaption;

    //add regex here
    private String location;


    @ManyToOne(fetch = FetchType.LAZY)// remove this ...not needed...why ??
    @JoinColumn(nullable = false , name = "fk_user_ID")
    private User user;

}
