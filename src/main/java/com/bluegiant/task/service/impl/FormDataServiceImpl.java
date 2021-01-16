package com.bluegiant.task.service.impl;

import com.bluegiant.task.dao.FormDataDao;
import com.bluegiant.task.model.FormData;
import com.bluegiant.task.service.FormDataService;
import com.bluegiant.task.service.base.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class FormDataServiceImpl extends AbstractService implements FormDataService {

    public FormDataServiceImpl() {
        super(FormData.class, FormDataDao.class);
    }

    @Override
    public List<FormData> findAllFormData(){
        return getJpaDao().findAll();
    }

    @Override
    public FormData saveFormData(FormData formData) {
        return (FormData) getJpaDao().save(formData);
    }

    @Override
    public void deleteById(Long formId) {
        getJpaDao().deleteById(formId);
    }
}
