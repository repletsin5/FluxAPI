package dev.crmodders.flux.engine;

import dev.crmodders.flux.FluxRegistries;
import dev.crmodders.flux.localization.TranslationKey;

import java.util.ArrayList;
import java.util.List;

public class LoadStage {

    public GameLoader loader;
    public TranslationKey title;

    public void initialize(GameLoader loader) {
        this.loader = loader;
        try {
            FluxRegistries.EVENT_BUS.register(this);
        } catch (Exception ignored) {}
    }

    public void doStage() {
        loader.setupProgressBar(loader.progressBar2, 0);
        loader.setupProgressBar(loader.progressBar3, 0);
    }

    public List<Runnable> getGlTasks() {
        return new ArrayList<>();
    }

}
