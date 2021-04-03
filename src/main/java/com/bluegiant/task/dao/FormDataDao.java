//package com.bluegiant.task.dao;
//
//import com.bluegiant.task.model.FormData;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import java.util.List;
//
//public interface FormDataDao extends JpaRepository<FormData, Long> {
//
//    @Query("select formData from FormData formData where formData.ad = :ad and formData.soyad = :soyad ")
//    List<FormData> findAllFormDataByNameAndSurName(@Param("ad") String ad, @Param("soyad") String soyad);
//
//}
