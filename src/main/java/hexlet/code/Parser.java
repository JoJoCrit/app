package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

// need to check?
public class Parser {
    public static Map<String, Object> parser(String filePath) throws IOException {
        String fileType = FilenameUtils.getExtension(filePath);
        ObjectMapper objectMapper = switch (fileType.toLowerCase()) {
            case "json" -> new ObjectMapper();
            case "yml", "yaml" -> new ObjectMapper(new YAMLFactory());
            default -> throw new RuntimeException(fileType + "Формат не поддерживается");
        };

        return objectMapper.readValue(new File(filePath), new TypeReference<>() {
        });
    }
}

