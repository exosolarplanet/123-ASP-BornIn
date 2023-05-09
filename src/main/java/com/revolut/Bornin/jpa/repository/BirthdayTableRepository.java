package com.revolut.Bornin.jpa.repository;

import com.revolut.Bornin.jpa.table.BirthdayTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BirthdayTableRepository extends JpaRepository<BirthdayTable, String> {

    BirthdayTable findByUsername(String username);
}
