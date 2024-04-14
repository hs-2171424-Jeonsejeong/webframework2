package kr.ac.hansung.cse.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
public class UserUtils {
    public static String getName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return authentication.getName();
    }

    public static Boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication==null) {
            return false;
        }
        if(authentication.isAuthenticated()) {
            if(authentication.getName().equals("anonymousUser")) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}