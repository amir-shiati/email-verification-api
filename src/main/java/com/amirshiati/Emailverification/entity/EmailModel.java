package com.amirshiati.Emailverification.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "email")
public class EmailModel {

    @Id
    @GeneratedValue
    private UUID id;
    private String address;
    private String code;
    private LocalDateTime sendTime;
    private LocalDateTime validTime;

}
