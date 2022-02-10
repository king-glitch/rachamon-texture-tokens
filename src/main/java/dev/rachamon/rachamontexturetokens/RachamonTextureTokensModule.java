package dev.rachamon.rachamontexturetokens;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import dev.rachamon.rachamontexturetokens.managers.RachamonTextureTokensPluginManager;

public class RachamonTextureTokensModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(RachamonTextureTokensPluginManager.class).in(Scopes.SINGLETON);
    }
}