package com.example.taskfourkfd.security

import com.example.taskfourkfd.repository.dao.UsersDao
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig (
    private val usersDao: UsersDao
) {

    @Bean
    fun userDetailsService(): CustomUserDetailsService = CustomUserDetailsService(usersDao)

    @Bean
    fun daoAuthProvider(): AuthenticationProvider {
        val authProvider = DaoAuthenticationProvider()
        authProvider.setUserDetailsService(userDetailsService())
        authProvider.setPasswordEncoder(getEncoder())
        return authProvider
    }

    @Bean
    fun configureFirst(http: HttpSecurity): SecurityFilterChain {
        http.csrf { csrf -> csrf.disable() }
        http.authorizeHttpRequests  {auth -> auth
            .requestMatchers("api/v1/admin/**").hasAuthority("ADMIN")
            .requestMatchers("api/v1/user/**").hasAnyAuthority("USER", "ADMIN")
            .requestMatchers("api/v1/users").permitAll()
            .anyRequest().denyAll()
        }

        http.httpBasic(Customizer.withDefaults())
        http.formLogin(Customizer.withDefaults())

        return http.build()
    }

    @Bean
    fun getEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

}