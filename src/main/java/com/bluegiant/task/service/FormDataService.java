package com.bluegiant.task.service;

import com.bluegiant.task.model.FormData;

import java.util.List;

public interface FormDataService {

    List<FormData> findAllFormData();

    FormData saveFormData(FormData formData);

    void deleteById(Long formId);

    List<FormData> findAllFormDataByNameAndSurName(String ad, String soyad);
}
