package com.bluegiant.task.service;

import com.bluegiant.task.BlueGiantTaskProjectApplication;
import com.bluegiant.task.model.FormData;
import com.bluegiant.task.service.FormDataService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Rollback()
@SpringBootTest(classes = BlueGiantTaskProjectApplication.class)
@Transactional
public class FormDataServiceTest {

    @Autowired
    FormDataService formDataService;

    @Test
    public void findAllFormDataTest(){
        List<FormData> formDataList = formDataService.findAllFormData();

        Assert.notNull(formDataList, "Empty List");
    }

    @Test
    public void saveFormDataTest(){
        FormData fData = saveFormData();
        Assert.notNull(fData.getId(), "No Id");
    }

    private FormData saveFormData() {
        FormData formData = new FormData();
        formData.setAd("Ad");
        formData.setSoyad("Soyad");
        formData.setAdres("Adres");
        return formDataService.saveFormData(formData);
    }

    @Test
    public void deleteTest(){
        FormData fData = saveFormData();
        Assert.notNull(fData.getId(), "No Id");
        formDataService.deleteById(fData.getId());
    }

}
