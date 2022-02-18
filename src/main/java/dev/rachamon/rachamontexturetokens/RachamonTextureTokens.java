package dev.rachamon.rachamontexturetokens;

import com.google.inject.Inject;
import com.google.inject.Injector;
import dev.rachamon.api.sponge.command.SpongeCommandService;
import dev.rachamon.api.sponge.config.SpongeAPIConfigFactory;
import dev.rachamon.api.sponge.implement.plugin.IRachamonPlugin;
import dev.rachamon.api.sponge.implement.plugin.IRachamonPluginManager;
import dev.rachamon.api.sponge.util.LoggerUtil;
import dev.rachamon.api.sponge.util.TextUtil;
import dev.rachamon.rachamontexturetokens.config.MainConfig;
import dev.rachamon.rachamontexturetokens.config.MainLanguage;
import dev.rachamon.rachamontexturetokens.config.MainTextureConfig;
import dev.rachamon.rachamontexturetokens.managers.RachamonTextureTokenManager;
import dev.rachamon.rachamontexturetokens.managers.RachamonTextureTokensPluginManager;
import ninja.leaping.configurate.objectmapping.GuiceObjectMapperFactory;
import org.spongepowered.api.Game;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.config.ConfigDir;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.Order;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GamePostInitializationEvent;
import org.spongepowered.api.event.game.state.GamePreInitializationEvent;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Dependency;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;

import java.nio.file.Path;

/**
 * The type Rachamon texture tokens.
 */
@Plugin(id = "rachamontexturetokens", name = "RachamonTextureTokens", description = "Simple Pixelmon Texture applier.", authors = {"Rachamon"}, dependencies = {@Dependency(id = "after:pixelmon")})
public class RachamonTextureTokens implements IRachamonPlugin {
    private Components components;
    @Inject
    private Game game;
    @Inject
    private GuiceObjectMapperFactory factory;
    @Inject
    private Injector injector;
    @Inject
    private Injector pluginInjector;
    @Inject
    @ConfigDir(sharedRoot = false)
    private Path directory;
    @Inject
    private PluginContainer container;
    private LoggerUtil logger;
    private static RachamonTextureTokens instance;
    private boolean isInitialized = false;
    private RachamonTextureTokensPluginManager pluginManager;

    private SpongeAPIConfigFactory<RachamonTextureTokens, MainConfig> config;
    private SpongeAPIConfigFactory<RachamonTextureTokens, MainLanguage> language;
    private SpongeAPIConfigFactory<RachamonTextureTokens, MainTextureConfig> textures;

    /**
     * On pre initialize.
     *
     * @param event the event
     */
    @Listener
    public void onPreInitialize(GamePreInitializationEvent event) {
        instance = this;
        this.pluginManager = new RachamonTextureTokensPluginManager();
        this.setLogger(new LoggerUtil(Sponge.getServer()));
        this.getLogger().info("On Pre Initialize YanamiBot...");
    }

    /**
     * On initialize.
     *
     * @param event the event
     */
    @Listener(order = Order.EARLY)
    public void onInitialize(GameInitializationEvent event) {
        getInstance().getLogger().info("On Initialize YanamiBot...");
        getInstance().getPluginManager().initialize();
    }

    /**
     * On start.
     *
     * @param event the event
     */
    @Listener
    public void onStart(GameStartedServerEvent event) {
        if (!this.isInitialized()) return;
        getInstance().getLogger().info("On Start YanamiBot...");
        getInstance().getPluginManager().start();
    }

    /**
     * On post initialize.
     *
     * @param event the event
     */
    @Listener
    public void onPostInitialize(GamePostInitializationEvent event) {
        getInstance().getLogger().info("On Post Initialize YanamiBot");
        getInstance().getPluginManager().postInitialize();
    }

    @Override
    public LoggerUtil getLogger() {
        return this.logger;
    }

    @Override
    public void setLogger(LoggerUtil logger) {
        this.logger = logger;
    }

    @Override
    public GuiceObjectMapperFactory getFactory() {
        return this.factory;
    }

    @Override
    public Injector getSpongeInjector() {
        return this.injector;
    }

    @Override
    public Game getGame() {
        return this.game;
    }

    @Override
    public Path getDirectory() {
        return this.directory;
    }

    @Override
    public PluginContainer getContainer() {
        return this.container;
    }

    @Override
    public SpongeCommandService getCommandService() {
        return SpongeCommandService.getInstance();
    }

    @Override
    public IRachamonPluginManager getPluginManager() {
        return this.pluginManager;
    }

    @Override
    public boolean isInitialized() {
        return this.isInitialized;
    }

    @Override
    public void setInitialized(boolean isInitialized) {
        this.isInitialized = isInitialized;
    }

    @Override
    public void setPluginInjector(Injector injector) {
        this.injector = injector;
    }

    @Override
    public Injector getPluginInjector() {
        return this.pluginInjector;
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static RachamonTextureTokens getInstance() {
        return instance;
    }

    /**
     * Gets components.
     *
     * @return the components
     */
    public Components getComponents() {
        return components;
    }

    /**
     * Sets components.
     *
     * @param components the components
     */
    public void setComponents(Components components) {
        this.components = components;
    }

    /**
     * Gets config.
     *
     * @return the config
     */
    public SpongeAPIConfigFactory<RachamonTextureTokens, MainConfig> getConfig() {
        return config;
    }

    /**
     * Sets config.
     *
     * @param config the config
     */
    public void setConfig(MainConfig config) {
        this.config.setClazz(config);
    }

    /**
     * Sets language.
     *
     * @param language the language
     */
    public void setLanguage(MainLanguage language) {
        this.language.setClazz(language);
    }

    /**
     * Gets language.
     *
     * @return the language
     */
    public MainLanguage getLanguage() {
        return this.language.getRoot();
    }

    /**
     * Sets textures.
     *
     * @param config the config
     */
    public void setTextures(MainTextureConfig config) {
        this.textures.setClazz(config);
    }

    /**
     * Sets main config.
     *
     * @param config the config
     */
    public void setMainConfig(SpongeAPIConfigFactory<RachamonTextureTokens, MainConfig> config) {
        this.config = config;
    }

    /**
     * Gets language manager.
     *
     * @return the language manager
     */
    public SpongeAPIConfigFactory<RachamonTextureTokens, MainLanguage> getLanguageManager() {
        return language;
    }

    /**
     * Sets main language.
     *
     * @param language the language
     */
    public void setMainLanguage(SpongeAPIConfigFactory<RachamonTextureTokens, MainLanguage> language) {
        this.language = language;
    }

    /**
     * Gets textures.
     *
     * @return the textures
     */
    public SpongeAPIConfigFactory<RachamonTextureTokens, MainTextureConfig> getTextures() {
        return textures;
    }

    /**
     * Sets main textures.
     *
     * @param textures the textures
     */
    public void setMainTextures(SpongeAPIConfigFactory<RachamonTextureTokens, MainTextureConfig> textures) {
        this.textures = textures;
    }

    /**
     * Gets rachamon texture token manager.
     *
     * @return the rachamon texture token manager
     */
    public RachamonTextureTokenManager getRachamonTextureTokenManager() {
        return this.getComponents().textureTokensManager;
    }

    public void sendMessage(CommandSource source, String message) {
        source.sendMessage(TextUtil.toText(RachamonTextureTokens
                .getInstance()
                .getLanguage()
                .getGeneralCategory()
                .getPrefix() + message));
    }

    /**
     * The type Components.
     */
    public static class Components {
        @Inject
        private RachamonTextureTokenManager textureTokensManager;
    }
}
