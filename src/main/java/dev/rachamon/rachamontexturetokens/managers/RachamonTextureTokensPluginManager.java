package dev.rachamon.rachamontexturetokens.managers;

import dev.rachamon.api.sponge.config.SpongeAPIConfigFactory;
import dev.rachamon.api.sponge.exception.AnnotatedCommandException;
import dev.rachamon.api.sponge.implement.plugin.IRachamonPluginManager;
import dev.rachamon.rachamontexturetokens.RachamonTextureTokens;
import dev.rachamon.rachamontexturetokens.RachamonTextureTokensModule;
import dev.rachamon.rachamontexturetokens.commands.TextureTokensMainCommand;
import dev.rachamon.rachamontexturetokens.config.MainConfig;
import dev.rachamon.rachamontexturetokens.config.MainLanguage;
import dev.rachamon.rachamontexturetokens.config.MainTextureConfig;
import dev.rachamon.rachamontexturetokens.listeners.PokemonTokenInteract;
import org.spongepowered.api.Sponge;

/**
 * The type Rachamon texture tokens plugin manager.
 */
public class RachamonTextureTokensPluginManager implements IRachamonPluginManager {
    private final RachamonTextureTokens plugin = RachamonTextureTokens.getInstance();

    @Override
    public void initialize() {
        this.plugin.setComponents(new RachamonTextureTokens.Components());
        this.plugin.setPluginInjector(this.plugin
                .getSpongeInjector()
                .createChildInjector(new RachamonTextureTokensModule()));
        this.plugin.getSpongeInjector().injectMembers(this.plugin.getComponents());
        Sponge.getEventManager().registerListeners(this.plugin, new PokemonTokenInteract());
        this.plugin.setInitialized(true);
    }

    @Override
    public void preInitialize() {
    }

    @Override
    public void postInitialize() {
        this.configureConfigs();
        this.registerCommands();
    }

    @Override
    public void start() {
    }

    @Override
    public void reload() {
        try {
            this.configureConfigs();
            this.registerCommands();
        } catch (Exception ignored) {

        }
    }

    /**
     * Configure configs.
     */
    public void configureConfigs() {

        SpongeAPIConfigFactory<RachamonTextureTokens, MainConfig> config = new SpongeAPIConfigFactory<>(this.plugin, "main.conf");
        SpongeAPIConfigFactory<RachamonTextureTokens, MainLanguage> language = new SpongeAPIConfigFactory<>(this.plugin, "language.conf");
        SpongeAPIConfigFactory<RachamonTextureTokens, MainTextureConfig> textures = new SpongeAPIConfigFactory<>(this.plugin, "textures.conf");

        this.plugin.setMainConfig(config);
        this.plugin.setMainLanguage(language);
        this.plugin.setMainTextures(textures);

        this.plugin.setConfig(config
                .setHeader("Main Config")
                .setClazz(new MainConfig())
                .setClazzType(MainConfig.class)
                .build());

        this.plugin.setLanguage(language
                .setHeader("Language Config")
                .setClazz(new MainLanguage())
                .setClazzType(MainLanguage.class)
                .build());

        this.plugin.setTextures(textures
                .setHeader("Pokemon Textures Config")
                .setClazz(new MainTextureConfig())
                .setClazzType(MainTextureConfig.class)
                .build());
    }

    /**
     * Register commands.
     */
    public void registerCommands() {
        try {
            this.plugin.getCommandService().register(new TextureTokensMainCommand(), this.plugin);
        } catch (AnnotatedCommandException e) {
            e.printStackTrace();
        }
    }
}
