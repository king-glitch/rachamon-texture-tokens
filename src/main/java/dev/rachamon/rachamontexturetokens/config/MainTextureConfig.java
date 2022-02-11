package dev.rachamon.rachamontexturetokens.config;

import com.google.common.collect.ImmutableMap;
import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * The type Main texture config.
 */
@ConfigSerializable
public class MainTextureConfig {


    /**
     * The Tokens.
     */
    @Setting(value = "tokens", comment = "All Textures Tokens Key")
    protected Map<String, TextureToken> tokens = ImmutableMap.of("SpecialPikachu", new TextureToken());

    /**
     * The type Texture token.
     */
    @ConfigSerializable
    public static class TextureToken {
        /**
         * The Item id.
         */
        @Setting(value = "item-id")
        protected String itemId = "minecraft:stick";
        /**
         * The Item display name.
         */
        @Setting(value = "item-display-name")
        protected String itemDisplayName = "&b&lPokemon Special Texture Token";
        /**
         * The Item lore.
         */
        @Setting(value = "item-lore")
        protected List<String> itemLore = Arrays.asList("&eAllowed Pokemon&7 : &6Pikachu", "&eRight click on &6&n&lPikachu&e to apply texture.");
        /**
         * The Pokemon allowed.
         */
        @Setting(value = "pokemon-allowed")
        protected String pokemonAllowed = "Pikachu";
        /**
         * The Custom texture.
         */
        @Setting(value = "custom-texture")
        protected String customTexture = "special";

        /**
         * Instantiates a new Texture token.
         */
        public TextureToken() {
        }

        /**
         * Instantiates a new Texture token.
         *
         * @param itemId          the item id
         * @param itemDisplayName the item display name
         * @param itemLore        the item lore
         * @param pokemonAllowed  the pokemon allowed
         * @param customTexture   the custom texture
         */
        public TextureToken(String itemId, String itemDisplayName, List<String> itemLore, String pokemonAllowed, String customTexture) {
            this.itemId = itemId;
            this.itemLore = itemLore;
            this.itemDisplayName = itemDisplayName;
            this.pokemonAllowed = pokemonAllowed;
            this.customTexture = customTexture;
        }

        /**
         * Gets item id.
         *
         * @return the item id
         */
        public String getItemId() {
            return itemId;
        }

        /**
         * Gets item display name.
         *
         * @return the item display name
         */
        public String getItemDisplayName() {
            return itemDisplayName;
        }

        /**
         * Gets item lore.
         *
         * @return the item lore
         */
        public List<String> getItemLore() {
            return itemLore;
        }

        /**
         * Gets pokemon allowed.
         *
         * @return the pokemon allowed
         */
        public String getPokemonAllowed() {
            return pokemonAllowed;
        }

        /**
         * Gets custom texture.
         *
         * @return the custom texture
         */
        public String getCustomTexture() {
            return customTexture;
        }
    }


    /**
     * Gets tokens.
     *
     * @return the tokens
     */
    public Map<String, TextureToken> getTokens() {
        return tokens;
    }

}
