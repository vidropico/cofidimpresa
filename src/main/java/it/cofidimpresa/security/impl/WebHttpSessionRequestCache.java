package it.cofidimpresa.security.impl;

import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebHttpSessionRequestCache implements RequestCache {
	
    
    public void saveRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

    }

    public SavedRequest getRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return null;
    }

    public HttpServletRequest getMatchingRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return null;
    }

    public void removeRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

    }
}
