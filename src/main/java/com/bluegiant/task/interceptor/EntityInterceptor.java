package com.bluegiant.task.interceptor;

import com.bluegiant.task.model.base.BaseEntity;
import com.bluegiant.task.service.impl.UserDetailsImpl;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

@Component
public class EntityInterceptor extends EmptyInterceptor {

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {

        if (entity instanceof BaseEntity) {

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetailsImpl user = (UserDetailsImpl)authentication.getPrincipal();
            Long userId = user.getId();

            Date currentDate = Calendar.getInstance().getTime();

            for (int i = 0; i < propertyNames.length; i++) {
                if ("saveTime".equals(propertyNames[i]) && state[i] == null) {
                    state[i] = currentDate;
                }
                if ("saveUserId".equals(propertyNames[i])) {
                    state[i] = userId;
                }
                if ("updateTime".equals(propertyNames[i])) {
                    state[i] = currentDate;
                }
                if ("updateUserId".equals(propertyNames[i])) {
                    state[i] = userId;
                }
            }

        }
        return true;
    }

    @Override
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
        if (entity instanceof BaseEntity) {

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetailsImpl user = (UserDetailsImpl)authentication.getPrincipal();
            Long userId = user.getId();

            Date currentDate = Calendar.getInstance().getTime();

            for (int i = 0; i < propertyNames.length; i++) {
                if ("updateTime".equals(propertyNames[i])) {
                    currentState[i] = currentDate;
                }
                if ("updateUserId".equals(propertyNames[i])) {
                    currentState[i] = userId;
                }
            }

        }
        return true;
    }
}
