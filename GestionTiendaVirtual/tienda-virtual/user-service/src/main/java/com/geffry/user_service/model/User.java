package com.geffry.user_service.model;

import lombok.Data;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Data
@Entity
@Table(name = "tbl_users")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userId;
    @Column(name = "user_name")
    String userName;
    @Column(name = "user_email")
    String userEmail;
    @Column(name = "user_password")
    String userPassword;
    @Column(name = "user_active")
    Boolean userActive;
    @Column(name = "user_created_at")
    Instant userCreatedAt;
    @Column(name = "user_updated_at")
    Instant userUpdatedAt;
}
