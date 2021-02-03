package ee.bcs.valiit.tasks.tasks;

import ee.bcs.valiit.tasks.tasks.solution.service.BankService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private BankService2 bankRepository2;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        String password = bankRepository2.findPasswordByUserName(userName);
        return User.withUsername(userName)
                .password(password)
                .roles("USER").build();
    }

}
