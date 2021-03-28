//package com.twb.config.multitenant;
//
//import com.twb.config.TenantContext;
//import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
//import org.springframework.stereotype.Component;
//
////@Component
//public class TenantSchemaResolver implements CurrentTenantIdentifierResolver{
//
//    private String defaultTenant ="public";
//
//    @Override
//    public String resolveCurrentTenantIdentifier() {
//        String t =  TenantContext.getCurrentTenant();
//        if(t!=null){
//            return t;
//        } else {
//            return defaultTenant;
//        }
//    }
//
//    @Override
//    public boolean validateExistingCurrentSessions() {
//        return true;
//    }
//}