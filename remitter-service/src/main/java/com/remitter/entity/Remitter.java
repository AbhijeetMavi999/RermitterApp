package com.remitter.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Remitter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer remitterId;

    private String name;
    private String emailId;
    private String password;
    private String address;

    @CreationTimestamp
    private Date instDate;

    @CreationTimestamp
    private Date updDate;
}
