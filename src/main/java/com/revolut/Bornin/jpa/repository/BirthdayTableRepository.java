package com.revolut.Bornin.jpa.repository;

import com.revolut.Bornin.jpa.table.BirthdayTable;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface BirthdayTableRepository extends JpaRepository<BirthdayTable, String> {

    BirthdayTable findByUsername(String username);
}
