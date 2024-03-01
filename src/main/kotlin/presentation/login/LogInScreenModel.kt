package presentation.login

import cafe.adriel.voyager.core.model.screenModelScope
import domain.repo.MainRepository
import kotlinx.coroutines.launch
import presentation.common.BaseScreenModel
import presentation.common.Result
import presentation.common.getErrorMessage
import presentation.login.LogInEffect.NavigateToSelectProject
import presentation.login.LogInEffect.ShowSnackbar
import presentation.login.LogInNonUiAction.SigIn
import presentation.login.LogInNonUiAction.UpdateAddressTextInput
import presentation.login.LogInNonUiAction.UpdateTokenTextInput

class LogInScreenModel(
    private val repository: MainRepository
) : BaseScreenModel<LogInScreenState, LogInNonUiAction, LogInEffect>(
    initialState = LogInScreenState()
) {

    override fun onEachAction(action: LogInNonUiAction) {
        when (action) {
            is UpdateAddressTextInput -> {
                updateState {
                    copy(address = action.input)
                }
            }

            is UpdateTokenTextInput -> {
                updateState {
                    copy(token = action.input)
                }
            }

            SigIn -> validate()
        }
    }

    private fun validate() {
        val state = getCurrentState()
        updateState {
            copy(
                addressFieldHasError = state.address.length < MINIMUM_ADDRESS_LENGTH,
                tokenFieldHasError = state.token.length < MINIMUM_TOKEN_LENGTH,
            )
        }

        if (
            state.address.length > MINIMUM_ADDRESS_LENGTH &&
            state.token.length > MINIMUM_TOKEN_LENGTH
        ) {
            login()
        }
    }

    private fun login() {
        screenModelScope.launch {
            runCatching {
                updateState { copy(loginResult = Result.Loading()) }
                val state = getCurrentState()
                repository.getUserDetail(
                    address = state.address,
                    token = state.token
                )
            }.onSuccess {
                updateState { copy(loginResult = Result.Success(Unit)) }
                sendEffect(NavigateToSelectProject)
            }.onFailure {
                updateState { copy(loginResult = Result.Fail(it)) }
                sendEffect(
                    ShowSnackbar(
                        message = it.getErrorMessage()
                    )
                )
            }

        }
    }

    companion object {
        private const val MINIMUM_ADDRESS_LENGTH = 5
        private const val MINIMUM_TOKEN_LENGTH = 5
    }
}
