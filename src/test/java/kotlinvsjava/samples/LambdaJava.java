package kotlinvsjava.samples;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class LambdaJava {

    private final int chunkSize = 15;
    private final FileRepositoryJava repository = new FileRepositoryImplJava();

    public List<String> getFileNamesAndUrlsByIds(List<FileReference> ids) {
        return ids.stream()
                .map(FileReference::getEntityId)
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> {
                            return list.stream()
                                    .collect(Collectors.groupingBy(
                                            id -> list.indexOf(id) / chunkSize
                                    )).values().stream();
                        }
                ))
                .flatMap(chunk -> repository.findAllById(chunk).stream())
                .sorted(Comparator.comparing((File file) -> file.getUrl() == null || file.getUrl().isBlank())
                        .thenComparing(File::getSortOrder))
                .map(file -> file.getFileName() != null ? file.getFileName() : file.getUrl())
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
// data classes
record FileReferenceJava(Long entityId) {}

record FileJava(Long id, String fileName, String url, int sortOrder) {

    public FileJava copy(String newFileName) {
        return new FileJava(this.id, newFileName, this.url, this.sortOrder);
    }
}

interface FileRepositoryJava {
    List<File> findAllById(List<Long> ids);
}

class FileRepositoryImplJava implements FileRepositoryJava {
    @Override
    public List<File> findAllById(List<Long> ids) {
        return List.of(); // Return an empty list
    }
}
