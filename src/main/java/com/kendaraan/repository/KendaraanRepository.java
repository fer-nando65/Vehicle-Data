package com.kendaraan.repository;

import com.kendaraan.entity.Kendaraan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KendaraanRepository extends JpaRepository<Kendaraan, String> {
    @Query("""
            SELECT kend
            FROM Kendaraan kend
            WHERE kend.id LIKE %:id%
            AND kend.ownerName LIKE %:ownerName%
            """)
    List<Kendaraan> getAll(String id, String ownerName);
}
