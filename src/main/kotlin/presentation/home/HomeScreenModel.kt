package presentation.home

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import domain.repo.MainRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeScreenModel(
    private val mainRepository: MainRepository
) : ScreenModel {

    private val _token = MutableStateFlow("")
    val token = _token.asStateFlow()

    init {
        restoreToken()
    }

    fun updateToken(token: String) {
        _token.value = token
    }

    private fun restoreToken() {
        screenModelScope.launch {
            val savedToken = runCatching {
                mainRepository.restoreToken("")
            }.getOrDefault("")
            _token.emit(savedToken)
        }
    }

    private fun saveToken() {
        screenModelScope.launch {
            runCatching {
                mainRepository.saveToken(token.value)
            }.getOrElse {
                println("error in saving token $it")
            }
        }
    }

    override fun onDispose() {
        super.onDispose()
        saveToken()
    }
}
