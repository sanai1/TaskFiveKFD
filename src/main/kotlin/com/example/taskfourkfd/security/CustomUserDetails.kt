package com.example.taskfourkfd.security

import com.example.taskfourkfd.repository.model.Users
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class CustomUserDetails(
    private val user: Users
): UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return user.role.split(", ").map { SimpleGrantedAuthority(it) }.toMutableList()
    }

    override fun getPassword(): String = user.password

    override fun getUsername(): String = user.login

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true

}