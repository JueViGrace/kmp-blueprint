package com.jvg.sample1.auth.domain.rules

import com.jvg.kmpblueprint.resources.generated.resources.Res
import com.jvg.kmpblueprint.resources.generated.resources.password_empty
import com.jvg.kmpblueprint.resources.generated.resources.username_empty
import com.jvg.kmpblueprint.shared.domain.validation.ValidationResult
import com.jvg.sample1.types.auth.LogInForm
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.jetbrains.compose.resources.StringResource

internal object LoginValidator {
    fun validate(form: LogInForm): Flow<LoginValidation> = flow {
        var validation = LoginValidation()

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

        emit(validation)
    }.flowOn(Dispatchers.Default)
}

data class LoginValidation(
    val usernameError: StringResource? = null,
    val passwordError: StringResource? = null,
) : ValidationResult {
    override fun valid(): Boolean {
        return usernameError == null && passwordError == null
    }
}
