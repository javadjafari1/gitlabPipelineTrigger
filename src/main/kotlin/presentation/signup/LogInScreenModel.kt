package presentation.signup

import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.launch
import presentation.common.BaseScreenModel
import presentation.signup.LogInEffect.NavigateToSelectProject
import presentation.signup.LogInNonUiAction.SigIn
import presentation.signup.LogInNonUiAction.UpdateAddressTextInput
import presentation.signup.LogInNonUiAction.UpdateTokenTextInput

class LogInScreenModel : BaseScreenModel<LogInScreenState, LogInNonUiAction, LogInEffect>(
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
                addressFieldHasError = state.address.length < 5,
                tokenFieldHasError = state.token.length < 5,
            )
        }

        if (
            state.address.length > 5 &&
            state.token.length > 5
        ) {
            login()
        }
    }

    private fun login() {
        screenModelScope.launch {
            sendEffect(NavigateToSelectProject)
        }
    }
}
