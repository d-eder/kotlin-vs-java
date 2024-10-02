package kotlinvsjava.samples

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

sealed class NetworkResult<out T>

data class Success<T>(val data: T) : NetworkResult<T>()
data class Error(val exception: Throwable) : NetworkResult<Nothing>()
data object Loading : NetworkResult<Nothing>()
//data object Timeout : NetworkResult<Nothing>()

class SealedTest {
    val success = Success("Kotlin")
    @Test
    fun test() {
        assertThat(getDescription(success)).isEqualTo("Data received: Kotlin")
    }
}

private fun getDescription(result: NetworkResult<String>): String {
    // exhaustive when
    return when (result) {
        is Success -> {
            "Data received: ${result.data}"
        }

        is Error -> {
            "Error occurred: ${result.exception.message}"
        }

        is Loading -> {
            "Loading..."
        }
    }
}