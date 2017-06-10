package com.example.multitenant.tenant;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HeaderTenantIdentifierResolver implements CurrentTenantIdentifierResolver {

	private @Autowired HttpServletRequest request;
	
	@Override
	public String resolveCurrentTenantIdentifier() {
		return request.getHeader("X-TENANT-ID");
	}

    @Override
    public boolean validateExistingCurrentSessions() {
        return Boolean.TRUE;
    }
}