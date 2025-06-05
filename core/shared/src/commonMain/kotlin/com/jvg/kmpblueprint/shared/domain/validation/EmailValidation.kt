package com.jvg.kmpblueprint.shared.domain.validation

import com.jvg.kmpblueprint.resources.generated.resources.Res
import com.jvg.kmpblueprint.resources.generated.resources.email_empty
import com.jvg.kmpblueprint.resources.generated.resources.email_invalid_format
import com.jvg.kmpblueprint.resources.generated.resources.email_too_long
import org.jetbrains.compose.resources.StringResource

object EmailValidator {
    // RFC 5322 compliant (simplified)
    private val rfc5322Regex = Regex(
        """^[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?$"""
    )

    // Stricter pattern for most use cases
    private val strictEmailRegex = Regex(
        """^[a-zA-Z0-9][a-zA-Z0-9._%+-]{0,63}@(?:[a-zA-Z0-9-]{1,63}\.)+[a-zA-Z]{2,}$"""
    )

    fun validate(email: String, strict: Boolean = true): EmailValidationResult {
        val trimmed = email.trim()

        if (trimmed.isEmpty()) {
            return EmailValidationResult.Invalid(Res.string.email_empty)
        }

        if (trimmed.length > 254) {
            return EmailValidationResult.Invalid(Res.string.email_too_long)
        }

        val regex = if (strict) strictEmailRegex else rfc5322Regex

        return if (regex.matches(trimmed)) {
            EmailValidationResult.Valid
        } else {
            EmailValidationResult.Invalid(Res.string.email_invalid_format)
        }
    }

    fun isValid(email: String): Boolean {
        return validate(email) is EmailValidationResult.Valid
    }
}

sealed interface EmailValidationResult {
    data object Valid : EmailValidationResult
    data class Invalid(val reason: StringResource) : EmailValidationResult
}

fun String.isValidEmail(): Boolean {
    return EmailValidator.isValid(this)
}

fun String.validateEmail(): EmailValidationResult {
    return EmailValidator.validate(this)
}
