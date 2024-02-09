package presentation.home

import cafe.adriel.voyager.core.model.ScreenModel
import domain.repo.MainRepository
import kotlinx.coroutines.flow.MutableStateFlow

class HomeScreenModel(
    private val mainRepository: MainRepository
) : ScreenModel {

    val flow = MutableStateFlow(0)
}