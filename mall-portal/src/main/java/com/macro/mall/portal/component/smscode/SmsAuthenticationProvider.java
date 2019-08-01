package com.macro.mall.portal.component.smscode;
import com.macro.mall.model.UmsMember;
import com.macro.mall.portal.service.UmsMemberService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

public class SmsAuthenticationProvider implements AuthenticationProvider {

    private UmsMemberService memberService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        SmsAuthenticationToken authenticationToken = (SmsAuthenticationToken) authentication;
        UmsMember umsMember = memberService.getByUsername((String) authenticationToken.getPrincipal());

        if (umsMember == null)
            throw new InternalAuthenticationServiceException("未找到与该手机号对应的用户");

        SmsAuthenticationToken authenticationResult = new SmsAuthenticationToken(umsMember, umsMember.getAuthorities());

        authenticationResult.setDetails(authenticationToken.getDetails());

        return authenticationResult;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return SmsAuthenticationToken.class.isAssignableFrom(aClass);
    }

    public UmsMemberService getUmsMemberService() {
        return memberService;
    }

    public void setUmsMemberService(UmsMemberService memberService) {
        this.memberService = memberService;
    }
}
