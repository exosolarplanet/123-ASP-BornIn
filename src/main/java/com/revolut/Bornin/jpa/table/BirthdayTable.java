package com.revolut.Bornin.jpa.table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name="birthday")
public class BirthdayTable {

    @Id
    @Column(name="username", nullable = false)
    private String username;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    public BirthdayTable() {}

    public BirthdayTable(String username, LocalDate birthday) {
        this.username = username;
        this.birthday = birthday;
    }

    public LocalDate getBirthday() { return birthday; }

}
