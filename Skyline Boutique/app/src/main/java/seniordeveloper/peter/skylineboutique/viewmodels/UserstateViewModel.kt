package seniordeveloper.peter.skylineboutique.viewmodels

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import seniordeveloper.peter.skylineboutique.closetModel.ClosetData
import seniordeveloper.peter.skylineboutique.models.appState.ScreenState


class UserStateViewModel : ViewModel() {
    var isLoggedIn by mutableStateOf(false)
    var isBusy by mutableStateOf(false)
    var isLoginError by mutableStateOf(false)
    var isLoadingProgressBar by mutableStateOf(false)

    suspend fun signIn(email: String, password: String) {
        isBusy = true
        delay(2000)
        isLoggedIn = true
        isBusy = false
    }

    suspend fun signOut() {
        isBusy = true
        delay(2000)
        isLoggedIn = false
        isBusy = false
    }
}

val UserState = compositionLocalOf<UserStateViewModel> { error("User State Context Not Found!") }

class SkylineBoutiqueViewModel : ViewModel() {
    private val _screenState = MutableLiveData<ScreenState<ClosetData>>()
    val screenState: LiveData<ScreenState<ClosetData>> = _screenState



    fun fetchData() {
        // Set loading state
        _screenState.value = ScreenState.Loading

        // Perform your data fetching operation here
        // On success, set the Success state with the data
        // On error, set the Error state with an error message
    }
}
