package com.bluegiant.task.util;

import com.bluegiant.task.dto.FormDataDto;
import com.bluegiant.task.model.FormData;

public class ConverterUtil {

    public static FormData toFormData(FormDataDto formDataDto) {
        FormData formData = new FormData();
        formData.setId(formDataDto.getId());
        formData.setAd(formDataDto.getAd());
        formData.setSoyad(formDataDto.getSoyad());
        formData.setAdres(formDataDto.getAdres());
        return formData;
    }

    public static FormDataDto toFormDataDto(FormData formData) {
        FormDataDto formDataDto = new FormDataDto();
        formDataDto.setId(formData.getId());
        formDataDto.setAd(formData.getAd());
        formDataDto.setSoyad(formData.getSoyad());
        formDataDto.setAdres(formData.getAdres());
        return formDataDto;
    }
}
