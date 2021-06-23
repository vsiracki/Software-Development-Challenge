package com.assignment.spring.repository;

import com.assignment.spring.dto.response.CoordResponseDto;
import com.assignment.spring.models.CoordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CoordRepository extends JpaRepository<CoordEntity, Integer> {

    @Query("SELECT new com.assignment.spring.dto.response.CoordResponseDto(c.lon, c.lat) FROM CoordEntity c where c.weather.id = :weatherId")
    CoordResponseDto getCordByWeatherId(@Param("weatherId") Integer weatherId);

    @Query("DELETE from CoordEntity c where c.weather.id = :weatherId")
    @Modifying
    void deleteCoordByWeatherId(@Param("weatherId") Integer weatherId);
}
