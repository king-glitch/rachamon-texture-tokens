package dev.rachamon.rachamontexturetokens.managers;

import dev.rachamon.api.sponge.implement.plugin.IRachamonPluginManager;
import dev.rachamon.rachamontexturetokens.RachamonTextureTokens;
import dev.rachamon.rachamontexturetokens.RachamonTextureTokensModule;

public class RachamonTextureTokensPluginManager implements IRachamonPluginManager {
    private final RachamonTextureTokens plugin = RachamonTextureTokens.getInstance();

    @Override
    public void initialize() {
        this.plugin.setComponents(new RachamonTextureTokens.Components());
        this.plugin.setPluginInjector(this.plugin.getSpongeInjector().createChildInjector(new RachamonTextureTokensModule()));
        this.plugin.getSpongeInjector().injectMembers(this.plugin.getComponents());
        this.plugin.setInitialized(true);
    }

    @Override
    public void preInitialize() {

    }

    @Override
    public void postInitialize() {

    }

    @Override
    public void start() {

    }

    @Override
    public void reload() {

    }
}
