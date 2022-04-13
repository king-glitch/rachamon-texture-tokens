package dev.rachamon.rachamontexturetokens.listeners;

import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import dev.rachamon.rachamontexturetokens.RachamonTextureTokens;
import org.spongepowered.api.data.DataQuery;
import org.spongepowered.api.data.type.HandTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.Order;
import org.spongepowered.api.event.entity.InteractEntityEvent;
import org.spongepowered.api.event.filter.cause.Root;
import org.spongepowered.api.item.inventory.ItemStack;

import java.util.Optional;

/**
 * The type Pokemon token interact.
 */

public class PokemonTokenInteract {

    private final RachamonTextureTokens plugin = RachamonTextureTokens.getInstance();

    /**
     * On token pokemon interact.
     *
     * @param event the event
     */

    @Listener(order = Order.EARLY)
    public void onTokenPokemonInteract(InteractEntityEvent.Secondary.MainHand event, @Root Player player) {

        if (!(event.getTargetEntity() instanceof EntityPixelmon)) {
            return;
        }


        EntityPixelmon pixelmon = (EntityPixelmon) event.getTargetEntity();
        Optional<ItemStack> itemStack = player.getItemInHand(HandTypes.MAIN_HAND);

        if (!itemStack.isPresent()) {
            return;
        }

        if (!itemStack.get().toContainer().get(DataQuery.of("UnsafeData", "ModType")).isPresent()) {
            this.plugin.getLogger().debug("no item unsafe mod type");
            return;
        }

        if (!itemStack
                .get()
                .toContainer()
                .get(DataQuery.of("UnsafeData", "ModType"))
                .get()
                .toString()
                .equals("RachamonTextureTokens")) {
            this.plugin.getLogger().debug("not token item stack");
            return;
        }

        event.setCancelled(true);

        if (pixelmon.getPokemonData().getOwnerPlayerUUID() == null) {
            this.plugin.getLogger().debug("no owner player uuid");
            return;
        }

        if (!pixelmon.getPokemonData().getOwnerPlayerUUID().equals(player.getUniqueId())) {
            this.plugin.getLogger().debug("not owner player uuid");
            return;
        }

        Optional<Object> tokenName = itemStack
                .get()
                .toContainer()
                .get(DataQuery.of("UnsafeData", "TextureTokens", "texture"));

        Optional<Object> tokenPokemon = itemStack
                .get()
                .toContainer()
                .get(DataQuery.of("UnsafeData", "TextureTokens", "pokemon"));


        if (!tokenName.isPresent() || !tokenPokemon.isPresent()) {
            this.plugin.getLogger().debug("no token name nor token Pokemon");
            return;
        }

        RachamonTextureTokens
                .getInstance()
                .getLogger()
                .debug(tokenPokemon.get() + " " + pixelmon.getSpecies().getPokemonName());

        if (!tokenPokemon
                .get()
                .toString()
                .toLowerCase()
                .contains(pixelmon.getSpecies().getPokemonName().toLowerCase())) {

            RachamonTextureTokens
                    .getInstance()
                    .sendMessage(player, RachamonTextureTokens
                            .getInstance()
                            .getLanguage()
                            .getGeneralCategory()
                            .getInvalidTokenUsage());
            return;
        }

        if (pixelmon.getPokemonData().getCustomTexture().equalsIgnoreCase(tokenName.get().toString())) {
            RachamonTextureTokens
                    .getInstance()
                    .sendMessage(player, RachamonTextureTokens
                            .getInstance()
                            .getLanguage()
                            .getGeneralCategory()
                            .getPokemonAlreadyHasTexture());
            return;
        }

        if (pixelmon.getPokemonData().isShiny() && !RachamonTextureTokens
                .getInstance()
                .getConfig()
                .getRoot()
                .getMainCategorySetting()
                .isAllowOnShiny()) {
            RachamonTextureTokens
                    .getInstance()
                    .sendMessage(player, RachamonTextureTokens
                            .getInstance()
                            .getLanguage()
                            .getGeneralCategory()
                            .getCantUseOnShinyPokemon());
            return;
        }


        if (pixelmon.getPokemonData().isShiny()) {
            pixelmon.getPokemonData().setShiny(false);
            pixelmon.resetDataWatchers();
        }

        pixelmon.getPokemonData().setCustomTexture(tokenName.get().toString());
        itemStack.get().setQuantity(itemStack.get().getQuantity() - 1);
        RachamonTextureTokens
                .getInstance()
                .sendMessage(player, RachamonTextureTokens
                        .getInstance()
                        .getLanguage()
                        .getGeneralCategory()
                        .getSuccessfullyApplyTextureOnPokemon()
                        .replaceAll("\\{pokemon}", pixelmon.getPokemonName())
                        .replaceAll("\\{token}", tokenName.get().toString()));


    }
}
