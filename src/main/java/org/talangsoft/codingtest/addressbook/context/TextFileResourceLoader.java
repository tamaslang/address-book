package org.talangsoft.codingtest.addressbook.context;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public final class TextFileResourceLoader {

    private TextFileResourceLoader() {
        // utility class
    }

    public static List<String> loadLines(ResourceLoader resLoader, String resPath) throws IOException {
        Resource res = resLoader.getResource(resPath);
        try (InputStream in = res.getInputStream()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            return reader.lines().collect(Collectors.toList());
        }
    }
}
