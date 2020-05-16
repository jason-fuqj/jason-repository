package com.jason.book.config;

import com.jason.book.constants.Constants;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * TODO: 权限认证配置
 * <p>
 * Created by Jason.Fu on 2020/5/11.
 */
@Configuration
public class ShiroConfig {

    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAAP = new DefaultAdvisorAutoProxyCreator();
        defaultAAP.setProxyTargetClass(true);
        return defaultAAP;
    }

    //将自己的验证方式加入容器
    @Bean
    public ShiroRealm myShiroRealm() {
        ShiroRealm shiroRealm = new ShiroRealm();
        shiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return shiroRealm;
    }

    //权限管理，配置主要是Realm的管理认证
    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }

    //Filter工厂，设置对应的过滤条件和跳转条件
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //登录
        shiroFilterFactoryBean.setLoginUrl("/login");
        //首页
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //认证不通过跳转到登录页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/login");

        LinkedHashMap<String, String> filtersMap = new LinkedHashMap<>();
        // 添加过滤swagger页面
        filtersMap.put("/swagger-ui.html", "anon");
        filtersMap.put("/swagger-resources/**", "anon");
        filtersMap.put("/v2/api-docs", "anon");
        filtersMap.put("/webjars/springfox-swagger-ui/**", "anon");
        //登出
        filtersMap.put("/logout", "logout");
        //对所有用户认证
        filtersMap.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filtersMap);
        return shiroFilterFactoryBean;
    }

    //设置默认加密方式
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        // 使用md5 算法进行加密
        hashedCredentialsMatcher.setHashAlgorithmName(Constants.ALGORITHM_NAME_MD5);
        // 设置散列次数： 意为加密几次
        hashedCredentialsMatcher.setHashIterations(Constants.HASH_ITERATIONS);
        return hashedCredentialsMatcher;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
