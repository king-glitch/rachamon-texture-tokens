package dev.rachamon.rachamontexturetokens.managers;

import dev.rachamon.api.sponge.implement.plugin.IRachamonPluginManager;
import dev.rachamon.rachamontexturetokens.RachamonTextureTokens;

public class RachamonTextureTokensPluginManager implements IRachamonPluginManager {
    private final RachamonTextureTokens plugin = RachamonTextureTokens.getInstance();

    @Override
    public void initialize() {
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
