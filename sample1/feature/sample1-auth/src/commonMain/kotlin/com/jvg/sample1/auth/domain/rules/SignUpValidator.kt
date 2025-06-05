package com.jvg.sample1.auth.domain.rules

import com.jvg.kmpblueprint.resources.generated.resources.Res
import com.jvg.kmpblueprint.resources.generated.resources.first_name_empty
import com.jvg.kmpblueprint.resources.generated.resources.last_name_empty
import com.jvg.kmpblueprint.resources.generated.resources.password_empty
import com.jvg.kmpblueprint.resources.generated.resources.phone_number_empty
import com.jvg.kmpblueprint.resources.generated.resources.privacy_policy_not_accepted
import com.jvg.kmpblueprint.resources.generated.resources.terms_and_conditions_not_accepted
import com.jvg.kmpblueprint.resources.generated.resources.username_empty
import com.jvg.kmpblueprint.shared.domain.validation.EmailValidationResult
import com.jvg.kmpblueprint.shared.domain.validation.EmailValidator
import com.jvg.kmpblueprint.shared.domain.validation.ValidationResult
import com.jvg.kmpblueprint.shared.domain.validation.isValidEmail
import com.jvg.sample1.types.auth.SignUpForm
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.jetbrains.compose.resources.StringResource

internal object SignUpValidator {
    fun validate(form: SignUpForm): Flow<SignUpValidation> = flow {
        var validation = SignUpValidation()

        if (form.firstName.isEmpty()) {
            validation = validation.copy(
                firstNameError = Res.string.first_name_empty
            )
        }

        if (form.lastName.isEmpty()) {
            validation = validation.copy(
                lastNameError = Res.string.last_name_empty
            )
        }

        if (!form.email.isValidEmail()) {
            val valid = EmailValidator.validate(form.email) as EmailValidationResult.Invalid
            validation = validation.copy(
                emailError = valid.reason
            )
        }

        if (form.username.isEmpty()) {
            validation = validation.copy(
                usernameError = Res.string.username_empty
            )
        }

        if (form.password.isEmpty()) {
            validation = validation.copy(
                passwordError = Res.string.password_empty
            )
        }

        // todo: validate phone number
        if (form.phoneNumber.isEmpty()) {
            validation = validation.copy(
                phoneNumberError = Res.string.phone_number_empty
            )
        }

        if (!form.termsAndConditions) {
            validation = validation.copy(
                termsAndConditionsError = Res.string.terms_and_conditions_not_accepted
            )
        }

        if (!form.privacyPolicy) {
            validation = validation.copy(
                privacyPolicyError = Res.string.privacy_policy_not_accepted
            )
        }

        emit(validation)
    }.flowOn(Dispatchers.Default)
}

data class SignUpValidation(
    val firstNameError: StringResource? = null,
    val lastNameError: StringResource? = null,
    val usernameError: StringResource? = null,
    val aliasError: StringResource? = null,
    val emailError: StringResource? = null,
    val passwordError: StringResource? = null,
    val phoneNumberError: StringResource? = null,
    val termsAndConditionsError: StringResource? = null,
    val privacyPolicyError: StringResource? = null,
) : ValidationResult {
    override fun valid(): Boolean {
        return firstNameError == null &&
                lastNameError == null &&
                usernameError == null &&
                aliasError == null &&
                emailError == null &&
                passwordError == null &&
                phoneNumberError == null &&
                termsAndConditionsError == null &&
                privacyPolicyError == null
    }
}
