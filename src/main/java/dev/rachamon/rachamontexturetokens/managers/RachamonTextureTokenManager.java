package dev.rachamon.rachamontexturetokens.managers;

import dev.rachamon.api.sponge.util.TextUtil;
import dev.rachamon.rachamontexturetokens.RachamonTextureTokens;
import dev.rachamon.rachamontexturetokens.config.MainTextureConfig;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataQuery;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.entity.Hotbar;
import org.spongepowered.api.item.inventory.entity.MainPlayerInventory;
import org.spongepowered.api.item.inventory.query.QueryOperationTypes;
import org.spongepowered.api.item.inventory.transaction.InventoryTransactionResult;
import org.spongepowered.api.text.Text;

import java.util.ArrayList;
import java.util.Optional;

public class RachamonTextureTokenManager {

    private final RachamonTextureTokens plugin = RachamonTextureTokens.getInstance();


    public MainTextureConfig.TextureToken getTokenOrThrow(String key) throws Exception {
        MainTextureConfig.TextureToken token = this.plugin.getTextures().getRoot().getTokens().get(key);
        if (token == null) {
            throw new Exception(this.plugin.getLanguage().getGeneralCategory().getInvalidTokenKey());
        }
        return token;
    }

    public ItemType getItemTypeOrThrow(String id) throws Exception {
        Optional<ItemType> item = Sponge.getRegistry().getType(ItemType.class, id);
        if (!item.isPresent()) {
            throw new Exception("Invalid Item Type");
        }
        return item.get();
    }

    public void giveTokens(Player source, String key, int amount) throws Exception {

        MainTextureConfig.TextureToken token = this.getTokenOrThrow(key);
        ItemStack stack = ItemStack.of(getItemTypeOrThrow(token.getItemId()), amount);
        stack.offer(Keys.DISPLAY_NAME, TextUtil.toText(token.getItemDisplayName()));
        stack.offer(Keys.ITEM_DURABILITY, 1000);

        ArrayList<Text> realLore = new ArrayList<>();

        for (String line : token.getItemLore()) {
            realLore.add(TextUtil.toText(line));
        }

        stack.offer(Keys.ITEM_LORE, realLore);

        DataContainer container = stack.toContainer();
        container.set(DataQuery.of("UnsafeData", "TextureTokens", "pokemonAllowed"), token.getPokemonAllowed());

        stack = ItemStack.builder().fromContainer(container).build();

        InventoryTransactionResult result = source.getInventory()
                .query(QueryOperationTypes.INVENTORY_TYPE.of(Hotbar.class))
                .union(source.getInventory().query(QueryOperationTypes.INVENTORY_TYPE.of(MainPlayerInventory.class))).offer(stack);

        if (result.getType() != InventoryTransactionResult.Type.SUCCESS) {
            this.plugin.getLogger().info("Can't send Item stack");
            return;
        }

        this.plugin.getLogger().info("Successfully sent Item to player");

    }

}