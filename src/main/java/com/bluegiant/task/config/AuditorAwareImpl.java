package com.bluegiant.task.config;

import com.bluegiant.task.service.impl.UserDetailsImpl;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditorAwareImpl")
public class AuditorAwareImpl implements AuditorAware<Long> {
    @Override
    public Optional<Long> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Optional<Long> idOpt = authentication.getPrincipal() instanceof UserDetailsImpl ? Optional.of(((UserDetailsImpl)authentication.getPrincipal()).getId()) : Optional.empty();
        return idOpt;
    }
}
