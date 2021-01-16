package com.bluegiant.task.util;

import com.bluegiant.task.dto.FormDataDto;
import com.bluegiant.task.model.FormData;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class ConverterUtilTest {

    @Test
    public void toFormDataTest(){
        FormDataDto dataDto = new FormDataDto();
        String adres = "adres";
        dataDto.setAdres(adres);

        FormData formData = ConverterUtil.toFormData(dataDto);

        Assert.isTrue(formData != null && formData.getAdres() != null && formData.getAdres().equals(adres), "Not Equal");
    }
}
