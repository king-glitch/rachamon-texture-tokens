package dev.rachamon.rachamontexturetokens.config;

import com.google.common.collect.ImmutableMap;
import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@ConfigSerializable
public class MainTextureConfig {


    @Setting(value = "tokens", comment = "All Textures Tokens Key")
    protected Map<String, TextureToken> tokens = ImmutableMap.of("SpecialPikachu", new TextureToken());

    @ConfigSerializable
    public static class TextureToken {
        @Setting(value = "item-id")
        protected String itemId;
        @Setting(value = "item-display-name")
        protected String itemDisplayName = "&b&lPokemon Special Texture Token";
        @Setting(value = "item-lore")
        protected List<String> itemLore = Arrays.asList("&eAllowed Pokemon&7 : &6Pikachu", "&eRight click on &6&n&lPikachu&e to apply texture.");
        @Setting(value = "pokemon-allowed")
        protected String pokemonAllowed = "Pikachu";
        @Setting(value = "custom-texture")
        protected String customTexture = "special";

        public TextureToken() {
        }

        public TextureToken(String itemId, String itemDisplayName, List<String> itemLore, String pokemonAllowed, String customTexture) {
            this.itemId = itemId;
            this.itemLore = itemLore;
            this.itemDisplayName = itemDisplayName;
            this.pokemonAllowed = pokemonAllowed;
            this.customTexture = customTexture;
        }

        public String getItemId() {
            return itemId;
        }

        public String getItemDisplayName() {
            return itemDisplayName;
        }

        public List<String> getItemLore() {
            return itemLore;
        }

        public String getPokemonAllowed() {
            return pokemonAllowed;
        }

        public String getCustomTexture() {
            return customTexture;
        }
    }


    public Map<String, TextureToken> getTokens() {
        return tokens;
    }

}
