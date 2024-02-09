package presentation.main

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import common.AppConstants
import domain.repo.MainRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainScreenModel(
    private val mainRepository: MainRepository
) : ScreenModel {

    private val _locale = MutableStateFlow("")
    val locale = _locale.asStateFlow()

    init {
        restoreLocale()
    }

    private fun restoreLocale() {
        screenModelScope.launch {
            val locale = runCatching {
                mainRepository.restoreLocale(AppConstants.EN_LOCAL)
            }.getOrDefault(AppConstants.EN_LOCAL)
            _locale.value = locale
        }
    }
}
