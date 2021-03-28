package com.twb.entity.discriminator;

import com.twb.config.TenantContext;
import com.twb.service.discriminator.CityService;
import org.aspectj.lang.JoinPoint;
import org.hibernate.Session;

//@Aspect
//@Component
public class CityServiceAspect {
    //@Before("execution(* com.twb.service.discriminator.CityService.*(..))&& target(cityService) ")
    public void aroundExecution(JoinPoint pjp, CityService cityService) throws Throwable {
        org.hibernate.Filter filter = cityService.entityManager.unwrap(Session.class).enableFilter("tenantFilter");
        filter.setParameter("tenantId", TenantContext.getCurrentTenant());
        filter.validate();
    }
}
