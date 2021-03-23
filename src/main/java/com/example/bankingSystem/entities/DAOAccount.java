package com.example.bankingSystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.persistence.*;

/**
 * Created by mandeep.singh on 10:49 AM 23/03/21 Tuesday
 */

@Entity
@Table(name = "account")
public class DAOAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @Indexed
    private String customerId;

    @Column
    private AccountType accountType;

    @Column
    @JsonIgnore
    private String type; // ADMIN or EMPLOYEE

}