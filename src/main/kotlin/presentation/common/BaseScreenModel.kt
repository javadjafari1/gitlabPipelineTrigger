package presentation.common

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.flow.receiveAsFlow

abstract class BaseScreenModel<State, Action, Effect>(
    initialState: State
) : ScreenModel {

    private val _state = MutableStateFlow(initialState)
    val state = _state.asStateFlow()

    private val _effect = Channel<Effect>()
    val effect = _effect.receiveAsFlow()

    protected abstract fun onEachAction(action: Action)

    fun sendAction(action: Action) = onEachAction(action)

    protected fun updateState(function: State.() -> State) {
        _state.getAndUpdate(function)
    }

    protected fun getCurrentState(): State = state.value

    protected suspend fun sendEffect(effect: Effect) {
        _effect.send(effect)
    }
}
