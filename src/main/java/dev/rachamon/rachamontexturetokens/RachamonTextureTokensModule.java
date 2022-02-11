package dev.rachamon.rachamontexturetokens;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import dev.rachamon.rachamontexturetokens.managers.RachamonTextureTokenManager;

/**
 * The type Rachamon texture tokens module.
 */
public class RachamonTextureTokensModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(RachamonTextureTokenManager.class).in(Scopes.SINGLETON);
    }
}