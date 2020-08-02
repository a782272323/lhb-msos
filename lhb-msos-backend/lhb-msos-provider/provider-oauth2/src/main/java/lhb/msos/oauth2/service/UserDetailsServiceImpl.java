package lhb.msos.oauth2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Description  登录校验逻辑实现类
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/3
 * @time 01:26
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // todo 暂时模拟用户登录
        String password = passwordEncoder.encode("123456");
        log.trace("password = {}", password);
        UserDetails userDetails =
                User.withUsername("lhb")
                        .password(password).authorities("ppp").build();
        return userDetails;
    }

}
