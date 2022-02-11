package dev.rachamon.rachamontexturetokens.config;

import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

@ConfigSerializable
public class MainLanguage {

    public MainLanguage() {
    }

    protected GeneralCategory generalCategory = new GeneralCategory();
    protected CommandCategory commandCategory = new CommandCategory();

    public static class GeneralCategory {
        @Setting(value = "pokemon-doesnt-have-texture", comment = "Message when apply token on wrong pokemon\n" +
                "variables:\n" +
                " - {token}: token name\n" +
                " - {pokemon}: pokemon name")
        protected String pokemonDoesntHaveTexture = "You can't apply this {token} on this {pokemon}\n" +
                "variables:\n" +
                " - {token}: token name\n" +
                " - {pokemon}: pokemon name";
        @Setting(value = "pokemon-already-has-texture", comment = "Message when apply token key with same pokemon with the same texture")
        protected String pokemonAlreadyHasTexture = "This pokemon already has this texture!";
        @Setting(value = "successfully-apply-texture-on-pokemon", comment = "Message when apply token successfully\n+" +
                "variables:\n" +
                " - {token}: token name\n" +
                " - {pokemon}: pokemon name")
        protected String successfullyApplyTextureOnPokemon = "Successfully apply {token} token on {pokemon}";
        @Setting(value = "successfully-retrieve-token", comment = "message when retrieved token\n" +
                "variables:\n" +
                " - {token}: token name")
        protected String successfullyRetrieveToken = "You successfully retrieved {token} token!";
        @Setting(value = "successfully-send-token", comment = "message when token was sent to another player\n" +
                "variables:\n" +
                " - {token}: token name\n" +
                " - {player}: player name")
        protected String successfullySendToken = "You successfully sent {token} token to {player}";
        @Setting(value = "invalid-token-usage", comment = "Message token was wrongly used.")
        protected String invalidTokenUsage = "Invalid Token Usage";
        @Setting(value = "invalid-token-key", comment = "Message wrong token key")
        protected String invalidTokenKey = "Invalid token key, please check the config key name";
        @Setting(value = "token-no-longer-valid", comment = "Message when token is invalid")
        protected String tokenNoLongerValid = "This token is no longer valid";
        @Setting(value = "player-is-not-online-or-invalid", comment = "Message player is not online or invalid")
        protected String playerIsNotOnlineNorInvalid = "Invalid Player, please make sure they're online.";
        @Setting(value = "cant-use-on-shiny-pokemon", comment = "Message when apply token on shiny pokemon")
        protected String cantUseOnShinyPokemon = "This pokemon is shiny, you can't apply this texture to a shiny";

        public String getPokemonDoesntHaveTexture() {
            return pokemonDoesntHaveTexture;
        }

        public String getPokemonAlreadyHasTexture() {
            return pokemonAlreadyHasTexture;
        }

        public String getSuccessfullyApplyTextureOnPokemon() {
            return successfullyApplyTextureOnPokemon;
        }

        public String getSuccessfullyRetrieveToken() {
            return successfullyRetrieveToken;
        }

        public String getSuccessfullySendToken() {
            return successfullySendToken;
        }

        public String getInvalidTokenUsage() {
            return invalidTokenUsage;
        }

        public String getInvalidTokenKey() {
            return invalidTokenKey;
        }

        public String getTokenNoLongerValid() {
            return tokenNoLongerValid;
        }

        public String getPlayerIsNotOnlineNorInvalid() {
            return playerIsNotOnlineNorInvalid;
        }

        public String getCantUseOnShinyPokemon() {
            return cantUseOnShinyPokemon;
        }
    }

    static class CommandCategory {

        @Setting(value = "successfully-reloaded-config", comment = "Message reloaded configs")
        protected String successfullyReloadedConfig = "Successfully reloaded Configs";

        public String getSuccessfullyReloadedConfig() {
            return successfullyReloadedConfig;
        }

    }

    public GeneralCategory getGeneralCategory() {
        return generalCategory;
    }

    public CommandCategory getCommandCategory() {
        return commandCategory;
    }

}
