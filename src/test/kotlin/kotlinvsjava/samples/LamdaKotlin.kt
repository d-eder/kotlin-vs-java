package kotlinvsjava.samples

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

//Lambda expressions and inline functions
class LambdaKotlin {

    private val chunkSize = 15
    private val repository = FileRepositoryImpl()

    fun getFileNamesAndUrlsByIds(ids: List<FileReference>): List<String> {
        return ids.asSequence()
            .map { it.entityId }
            .chunked(chunkSize) { chunkedIds -> repository.findAllById(chunkedIds) }
            .flatten()
            .sortedWith(compareBy<File> { it.url.isNullOrBlank() }.thenBy { it.sortOrder })
            .mapNotNull { it.fileName ?: it.url }.toList()
    }

    @Test
    fun testCopy() {
        val file = File(1L, "profile.png", "http://image.at/profile.png", 1)
        val copied = file.copy(fileName = "newProfile.png")
        assertThat(copied.fileName).isEqualTo("newProfile.png")
    }
}

// data classes
data class FileReference(val entityId: Long)
data class File(val id: Long, val fileName: String?, val url: String?, val sortOrder: Int)

interface FileRepository {
    fun findAllById(ids: List<Long>): List<File>
}

class FileRepositoryImpl : FileRepository {
    override fun findAllById(ids: List<Long>): List<File> {
        return emptyList()
    }
}