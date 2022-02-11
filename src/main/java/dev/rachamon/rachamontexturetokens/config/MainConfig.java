package dev.rachamon.rachamontexturetokens.config;

import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

/**
 * The type Main config.
 */
@ConfigSerializable
public class MainConfig {
    @Setting(value = "general", comment = "General Settings")
    private final GeneralCategorySetting mainCategorySetting = new GeneralCategorySetting();

    /**
     * Gets main category setting.
     *
     * @return the main category setting
     */
    public GeneralCategorySetting getMainCategorySetting() {
        return mainCategorySetting;
    }

    /**
     * The type General category setting.
     */
    @ConfigSerializable
    public static class GeneralCategorySetting {
        /**
         * The Is debug.
         */
        @Setting(comment = "is logging", value = "is-debug")
        protected boolean isDebug = true;

        /**
         * Is debug boolean.
         *
         * @return the boolean
         */
        public boolean isDebug() {
            return isDebug;
        }
    }
}
