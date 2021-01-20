package com.bluegiant.task.util;

import com.bluegiant.task.dto.FormDataDto;
import com.bluegiant.task.model.FormData;
import org.springframework.beans.BeanUtils;

public class ConverterUtil {

    public static FormData toFormData(FormDataDto formDataDto) {
        FormData formData = new FormData();
        BeanUtils.copyProperties(formDataDto, formData);
        return formData;
    }

    public static FormDataDto toFormDataDto(FormData formData) {
        FormDataDto formDataDto = new FormDataDto();
        BeanUtils.copyProperties(formData, formDataDto);
        return formDataDto;
    }

}
