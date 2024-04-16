package dev.crmodders.flux.loading;

import dev.crmodders.flux.api.gui.ProgressBarElement;
import dev.crmodders.flux.localization.TranslationKey;

import java.util.concurrent.ExecutorService;

public class LoadStage {

    public GameLoader loader;

    public TranslationKey title;

    public void initialize(GameLoader loader) {
        this.loader = loader;
    }

    public void doStage() {
        loader.setupProgressBar(loader.progress2, 0);
        loader.setupProgressBar(loader.progress3, 0);
    }

}