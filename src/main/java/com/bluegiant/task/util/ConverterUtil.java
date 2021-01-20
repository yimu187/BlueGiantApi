package com.bluegiant.task.util;

import com.bluegiant.task.dto.FormDataDto;
import com.bluegiant.task.model.FormData;

public class ConverterUtil {

    public static FormData toFormData(FormDataDto formDataDto) {
        FormData formData = new FormData();
        formData.setId(formDataDto.getId());
        formData.setAd(trimIfNecessary(formDataDto.getAd()));
        formData.setSoyad(trimIfNecessary(formDataDto.getSoyad()));
        formData.setAdres(trimIfNecessary(formDataDto.getAdres()));
        formData.setDogumYeri(trimIfNecessary(formDataDto.getDogumYeri()));

        return formData;
    }

    public static FormDataDto toFormDataDto(FormData formData) {
        FormDataDto formDataDto = new FormDataDto();
        formDataDto.setId(formData.getId());
        formDataDto.setAd(trimIfNecessary(formData.getAd()));
        formDataDto.setSoyad(trimIfNecessary(formData.getSoyad()));
        formDataDto.setAdres(trimIfNecessary(formData.getAdres()));
        formDataDto.setDogumYeri(trimIfNecessary(formData.getDogumYeri()));
        return formDataDto;
    }

    private static String trimIfNecessary(String txt) {
        return txt != null ? txt.trim() : "";
    }
}
