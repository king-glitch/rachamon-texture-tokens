package dev.rachamon.rachamontexturetokens.listeners;

import dev.rachamon.rachamontexturetokens.RachamonTextureTokens;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataQuery;
import org.spongepowered.api.data.type.HandTypes;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.entity.InteractEntityEvent;
import org.spongepowered.api.event.filter.cause.Root;
import org.spongepowered.api.item.inventory.ItemStack;

import java.util.Optional;

public class PokemonTokenInteract {

    @Listener
    public void onTokenPokemonInteract(InteractEntityEvent event, @Root Player player) {
        RachamonTextureTokens.getInstance().getLogger().info(event.getTargetEntity().toString());

        Optional<EntityType> _pixelmon = Sponge.getRegistry().getAllOf(EntityType.class).stream().filter(entity -> entity.getId().equals(event.getTargetEntity().getType().getId())).findFirst();

        RachamonTextureTokens.getInstance().getLogger().info(_pixelmon.toString());

        if (!_pixelmon.isPresent()) {
            RachamonTextureTokens.getInstance().getLogger().info("No Pixelmon Entity");
            return;
        }

        EntityType pixelmon = _pixelmon.get();

        RachamonTextureTokens.getInstance().getLogger().info(pixelmon.toString());

        Optional<ItemStack> itemStack = player.getItemInHand(HandTypes.MAIN_HAND);
        try {
            RachamonTextureTokens.getInstance().getLogger().info(itemStack.get().toContainer().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!itemStack.isPresent()) {
            return;
        }

        if (!itemStack.get().toContainer().get(DataQuery.of("RachamonTextureToken")).isPresent()) {
            return;
        }

//        if (pixelmon.getPokemonData().getOwnerPlayerUUID() == null || pixelmon.getPokemonData().getOwnerPlayerUUID() != player.getUniqueId()) {
//            return;
//        }

        event.setCancelled(true);


    }
}
