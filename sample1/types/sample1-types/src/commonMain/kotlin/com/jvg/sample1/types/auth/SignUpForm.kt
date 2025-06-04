package com.jvg.sample1.types.auth

import com.jvg.sample1.network.auth.dto.SignUpDto

data class SignUpForm(
    val firstName: String = "",
    val lastName: String = "",
    val username: String = "",
    val alias: String = "",
    val email: String = "",
    val password: String = "",
    val phoneNumber: String = "",
) {
    fun toDto(): SignUpDto {
        return SignUpDto(
            firstName = firstName,
            lastName = lastName,
            username = username,
            alias = alias,
            email = email,
            password = password,
            phoneNumber = phoneNumber,
        )
    }
}
