package com.example.integrationservice.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Statistics {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int mark;

    @ManyToOne
    @JoinColumn(nullable=false)
    private UserCollege user;
}
