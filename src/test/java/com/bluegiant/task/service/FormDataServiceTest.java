//package com.bluegiant.task.service;
//
//import com.bluegiant.task.BlueGiantTaskProjectApplication;
////import com.bluegiant.task.model.FormData;
////import com.bluegiant.task.service.FormDataService;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.util.Assert;
//
//import java.util.List;
//
//@Rollback()
//@SpringBootTest(classes = BlueGiantTaskProjectApplication.class)
//@Transactional
//public class FormDataServiceTest {
//
//    @Autowired
//    FormDataService formDataService;
//
//
//    @Test
//    public void findAllFormDataTest(){
//        List<FormData> formDataList = formDataService.findAllFormData();
//
//        Assert.notNull(formDataList, "Empty List");
//    }
//
//    @Test
//    public void saveFormDataTest(){
//        FormData fData = saveFormData("ad"," soyad", "adres");
//        Assert.notNull(fData.getId(), "No Id");
//    }
//
//    @Test
//    public void findAllFormDataByNameAndSurName(){
//        String ad = "GOKCE";
//        String soyad = "YILMAZ";
//        saveFormData(ad,soyad, "adres");
//        List<FormData> list = formDataService.findAllFormDataByNameAndSurName(ad, soyad);
//        Assert.notEmpty(list, "Liste Boş");
//    }
//
//    private FormData saveFormData(String ad, String soyad, String adres) {
//        FormData formData = new FormData();
//        formData.setAd(ad);
//        formData.setSoyad(soyad);
//        formData.setAdres(adres);
//        FormData savedData = formDataService.saveFormData(formData);
//
//        return savedData;
//    }
//
//    @Test
//    public void validateNameSurname(){
//        String ad = "NUR";
//        String soyad = "YILMAZ";
//        saveFormData(ad,soyad, "adres");
//        Assertions.assertThatThrownBy(() ->  saveFormData(ad,soyad, "adres"))
//                .hasMessage("Aynı Ad ve Soyad ile kayıt yapılmamalıdır");
//    }
//
//    @Test
//    public void deleteTest(){
//        FormData fData = saveFormData("ad", "soyad", "adres");
//        Assert.notNull(fData.getId(), "No Id");
//        formDataService.deleteById(fData.getId());
//    }
//
//}
