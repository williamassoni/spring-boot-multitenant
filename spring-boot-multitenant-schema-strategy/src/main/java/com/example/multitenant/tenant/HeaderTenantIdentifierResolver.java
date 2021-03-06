package com.example.multitenant.tenant;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

@Component
public class HeaderTenantIdentifierResolver implements CurrentTenantIdentifierResolver {

	@Value("${multitenant.tenantKey}")
    private String tenantKey;

    @Value("${multitenant.defaultTenant}")
    private String defaultTenant;
	
	@Override
	public String resolveCurrentTenantIdentifier() {
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        
		if (requestAttributes != null) {
            String tenantId = (String) requestAttributes.getAttribute(tenantKey, RequestAttributes.SCOPE_REQUEST);
            if (tenantId != null) {
                return tenantId;
            }
        }

        return defaultTenant;
	}

    @Override
    public boolean validateExistingCurrentSessions() {
        return Boolean.TRUE;
    }
}