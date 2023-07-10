package seniordeveloper.peter.skylineboutique.models


sealed class Result<out T> {
    object Loading : Result<Nothing>()
    data class Success<T>(val data: T) : Result<T>()
    data class Error(val errorMessage: String) : Result<Nothing>()
}

fun performOperation(): Result<String> {
    try {
        val loadingResult: Result<Nothing> = Result.Loading
//        return loadingResult
        // Perform the operation
        // Example: fetching data from an API
        // Simulating a loading state
        // You can replace this with your actual loading logic
        Thread.sleep(2000)

        // Simulating a success state with a result
        return Result.Success("Operation completed successfully")
    } catch (e: Exception) {
        // Return an error state with the error message
        return Result.Error("An error occurred: ${e.message}")
    }
}

