package dev.rachamon.rachamontexturetokens.config;

import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

/**
 * The type Main language.
 */
@ConfigSerializable
public class MainLanguage {

    /**
     * Instantiates a new Main language.
     */
    public MainLanguage() {
    }

    /**
     * The General category.
     */
    protected GeneralCategory generalCategory = new GeneralCategory();
    /**
     * The Command category.
     */
    protected CommandCategory commandCategory = new CommandCategory();

    /**
     * The type General category.
     */
    public static class GeneralCategory {


        /**
         * The Prefix.
         */
        @Setting(value = "prefix", comment = "message prefix")
        protected String prefix = "&8[&cRachamonTextureTokens&8]&8:&7 ";

        /**
         * The Pokemon doesnt have texture.
         */
        @Setting(value = "pokemon-doesnt-have-texture", comment = "Message when apply token on wrong pokemon\n" + "variables:\n" + " - {token}: token name\n" + " - {pokemon}: pokemon name")
        protected String pokemonDoesntHaveTexture = "&cYou can't apply this &4&l{token}&c on this &4&l{pokemon}";
        /**
         * The Pokemon already has texture.
         */
        @Setting(value = "pokemon-already-has-texture", comment = "Message when apply token key with same pokemon with the same texture")
        protected String pokemonAlreadyHasTexture = "&cThis pokemon already has this texture!";
        /**
         * The Successfully apply texture on Pokemon.
         */
        @Setting(value = "successfully-apply-texture-on-pokemon", comment = "Message when apply token successfully\n+" + "variables:\n" + " - {token}: token name\n" + " - {pokemon}: pokemon name")
        protected String successfullyApplyTextureOnPokemon = "&aSuccessfully apply &2&l{token}&a token on &2&l{pokemon}";
        /**
         * The Successfully retrieve token.
         */
        @Setting(value = "successfully-retrieve-token", comment = "message when retrieved token\n" + "variables:\n" + " - {token}: token name")
        protected String successfullyRetrieveToken = "&aYou successfully retrieved &2&l{token}&a token!";

        /**
         * The Invalid token usage.
         */
        @Setting(value = "invalid-token-usage", comment = "Message token was wrongly used.")
        protected String invalidTokenUsage = "&cInvalid Token Usage. This Token can't use on this pokemon.";
        /**
         * The Invalid token key.
         */
        @Setting(value = "invalid-token-key", comment = "Message wrong token key")
        protected String invalidTokenKey = "&cInvalid token key, please check the config key name";
        /**
         * The Token no longer valid.
         */
        @Setting(value = "token-no-longer-valid", comment = "Message when token is invalid")
        protected String tokenNoLongerValid = "&cThis token is no longer valid";
        /**
         * The Player is not online nor invalid.
         */
        @Setting(value = "player-is-not-online-or-invalid", comment = "Message player is not online or invalid")
        protected String playerIsNotOnlineNorInvalid = "&cInvalid Player, please make sure they're online.";
        /**
         * The Cant use on shiny pokemon.
         */
        @Setting(value = "cant-use-on-shiny-pokemon", comment = "Message when apply token on shiny pokemon")
        protected String cantUseOnShinyPokemon = "&cThis pokemon is shiny, you can't apply this texture to a shiny";

        /**
         * Gets pokemon doesnt have texture.
         *
         * @return the pokemon doesn't have texture
         */
        public String getPokemonDoesntHaveTexture() {
            return pokemonDoesntHaveTexture;
        }

        /**
         * Gets pokemon already has texture.
         *
         * @return the pokemon already has texture
         */
        public String getPokemonAlreadyHasTexture() {
            return pokemonAlreadyHasTexture;
        }

        /**
         * Gets successfully apply texture on pokemon.
         *
         * @return the successfully apply texture on pokemon
         */
        public String getSuccessfullyApplyTextureOnPokemon() {
            return successfullyApplyTextureOnPokemon;
        }

        /**
         * Gets successfully retrieve token.
         *
         * @return the successful retrieve token
         */
        public String getSuccessfullyRetrieveToken() {
            return successfullyRetrieveToken;
        }

        /**
         * Gets prefix.
         *
         * @return the prefix
         */
        public String getPrefix() {
            return prefix;
        }

        /**
         * Gets invalid token usage.
         *
         * @return the invalid token usage
         */
        public String getInvalidTokenUsage() {
            return invalidTokenUsage;
        }

        /**
         * Gets invalid token key.
         *
         * @return the invalid token key
         */
        public String getInvalidTokenKey() {
            return invalidTokenKey;
        }

        /**
         * Gets token no longer valid.
         *
         * @return the token no longer valid
         */
        public String getTokenNoLongerValid() {
            return tokenNoLongerValid;
        }

        /**
         * Gets player is not online nor invalid.
         *
         * @return the player is not online nor invalid
         */
        public String getPlayerIsNotOnlineNorInvalid() {
            return playerIsNotOnlineNorInvalid;
        }

        /**
         * Gets cant use on shiny pokemon.
         *
         * @return the cant use on shiny pokemon
         */
        public String getCantUseOnShinyPokemon() {
            return cantUseOnShinyPokemon;
        }
    }

    /**
     * The type Command category.
     */
    public static class CommandCategory {

        /**
         * The Successfully reloaded config.
         */
        @Setting(value = "successfully-reloaded-config", comment = "Message reloaded configs")
        protected String successfullyReloadedConfig = "&aSuccessfully reloaded Configs";

        /**
         * The Successfully send token.
         */
        @Setting(value = "successfully-send-token", comment = "message when token was sent to another player\n" + "variables:\n" + " - {token}: token name\n" + " - {player}: player name")
        protected String successfullySendToken = "&aYou successfully sent &2&l{token}&a token to &2&l{player}";

        /**
         * Gets successfully reloaded config.
         *
         * @return the successfully reloaded config
         */
        public String getSuccessfullyReloadedConfig() {
            return successfullyReloadedConfig;
        }

        /**
         * Gets successfully send token.
         *
         * @return the successfully send token
         */
        public String getSuccessfullySendToken() {
            return successfullySendToken;
        }

    }

    /**
     * Gets general category.
     *
     * @return the general category
     */
    public GeneralCategory getGeneralCategory() {
        return generalCategory;
    }

    /**
     * Gets command category.
     *
     * @return the command category
     */
    public CommandCategory getCommandCategory() {
        return commandCategory;
    }

}
