package com.example.backofficeVoiture.repos;

import com.example.backofficeVoiture.domain.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {
    @Query(value = "insert into photo(text, id_annonce) values :param", nativeQuery = true)
    void insertMultiplePhoto(@Param("param") String param);
}
