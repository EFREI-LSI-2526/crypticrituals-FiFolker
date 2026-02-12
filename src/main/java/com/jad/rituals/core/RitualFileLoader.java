package com.jad.rituals.core;

import com.jad.rituals.model.Ritual;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class RitualFileLoader {
    private final RitualTranslator translator = new RitualTranslator();

    public List<Ritual> loadFromResources(String resourceName) throws IOException, URISyntaxException {
        Path file = Path.of(Objects.requireNonNull(this.getClass().getClassLoader().getResource(resourceName)).toURI());
        return this.load(file);
    }

    public List<Ritual> load(Path file) throws IOException {
        return Files.readAllLines(file).stream()
                .map(String::trim)
                .filter(line -> !line.isEmpty())
                .filter(line -> !line.startsWith("#"))
                .map(this.translator::translate)
                .toList();
    }
}
