package com.bluegiant.task.controller;

import com.bluegiant.task.dto.FormDataDto;
import com.bluegiant.task.model.FormData;
import com.bluegiant.task.service.FormDataService;
import com.bluegiant.task.util.ConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/formData")
public class FormDataController {

    @Autowired
    FormDataService formDataService;

    @GetMapping("/getAll")
    public ModelMap getAllFormData(){
        ModelMap result = new ModelMap();

        List<FormData> formDataList = formDataService.findAllFormData();
        result.put("success", true);
        result.put("list", formDataList);

        return result;
    }

    @PostMapping("/save")
    public ModelMap saveFormData(@RequestBody FormDataDto formDataDto){
        ModelMap result = new ModelMap();

        FormData formData = ConverterUtil.toFormData(formDataDto);

        formData = formDataService.saveFormData(formData);
        FormDataDto dataDto = ConverterUtil.toFormDataDto(formData);
        result.put("success", true);
        result.put("dto", dataDto);
        result.put("message", "İşlem Başarılı");

        return result;
    }

    @PostMapping("/delete")
    public ModelMap deleteFormData(@RequestBody FormDataDto formDataDto){
        ModelMap result = new ModelMap();

        FormData formData = ConverterUtil.toFormData(formDataDto);

        formDataService.deleteById(formData.getId());
        result.put("success", true);
        result.put("message", "İşlem Başarılı");

        return result;
    }
}

