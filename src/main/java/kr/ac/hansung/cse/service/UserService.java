package kr.ac.hansung.cse.service;

import kr.ac.hansung.cse.dao.LoginDao;
import kr.ac.hansung.cse.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private LoginDao loginDao;

    public boolean authenticateUser(String username, String password) {
        boolean result = loginDao.validateUser(username, password);
        if(!result) {
            SecurityContextHolder.clearContext();
            return false;
        }

        Authentication auth = new UsernamePasswordAuthenticationToken(username, password, AuthorityUtils.createAuthorityList("ROLE_USER"));


        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(auth);

        SecurityContextHolder.setContext(context);
        return true;
    }
}
