//package com.bluegiant.task.service.base;
//
//import com.bluegiant.task.config.ApplicationContextHolder;
//import com.bluegiant.task.exception.TaskException;
//import com.bluegiant.task.model.base.BaseEntity;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//public abstract class AbstractService<E extends BaseEntity, D extends JpaRepository> {
//
//    private Class<E> entityClass;
//    private Class<D> jpaDaoClass;
//
//    private D jpaDao;
//
//    public AbstractService(Class<E> entityClass, Class<D> jpaDaoClass){
//        if(entityClass == null){
//            throw new TaskException("Entiyu bilgisi boş bırakılmamalıdır");
//        }
//
//        if(jpaDaoClass == null){
//            throw new TaskException("Dao bilgisi boş bırakılmamalıdır");
//        }
//
//        this.entityClass = entityClass;
//
//        if(jpaDaoClass != null){
//            this.jpaDaoClass = jpaDaoClass;
//            jpaDao = ApplicationContextHolder.getApplicationContext().getBean(jpaDaoClass);
//        }
//    }
//
//
//    public D getJpaDao() {
//        return ApplicationContextHolder.getApplicationContext().getBean(jpaDaoClass);
//    }
//
//    public Class<E> getEntityClass() {
//        return entityClass;
//    }
//
//    public Class<D> getJpaDaoClass() {
//        return jpaDaoClass;
//    }
//
//}
