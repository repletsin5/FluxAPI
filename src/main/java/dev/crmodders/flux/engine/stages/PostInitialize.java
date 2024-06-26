package dev.crmodders.flux.engine.stages;

import dev.crmodders.flux.FluxRegistries;
import dev.crmodders.flux.engine.GameLoader;
import dev.crmodders.flux.engine.LoadStage;
import dev.crmodders.flux.localization.TranslationKey;
import dev.crmodders.flux.registries.AccessableRegistry;
import dev.crmodders.flux.tags.Identifier;

public class PostInitialize extends LoadStage {
    @Override
    public void initialize(GameLoader loader) {
        super.initialize(loader);
        title = new TranslationKey("fluxapi:loading_menu.initializing");
    }

    @Override
    public void doStage() {
        super.doStage();

        AccessableRegistry<Runnable> mods = FluxRegistries.ON_POST_INITIALIZE.access();
        Identifier[] modIds = mods.getRegisteredNames();
        loader.setupProgressBar(loader.progressBar2, modIds.length, "Initializing Mods: PostInit");
        for(Identifier modId : modIds) {
            loader.incrementProgress(loader.progressBar2, modId.name);
            Runnable runnable = mods.get(modId);
            runnable.run();
        }

    }
}
