package dev.rachamon.rachamontexturetokens.listeners;

import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
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


/**
 * The type Pokemon token interact.
 */
public class PokemonTokenInteract {

    /**
     * On token pokemon interact.
     *
     * @param event  the event
     * @param player the player
     */
    @Listener
    public void onTokenPokemonInteract(InteractEntityEvent event, @Root Player player) {
        Optional<EntityType> _pixelmon = Sponge.getRegistry().getAllOf(EntityType.class).stream().filter(entity -> entity.getId().equals(event.getTargetEntity().getType().getId())).findFirst();
        if (!_pixelmon.isPresent()) {
            RachamonTextureTokens.getInstance().getLogger().info("No Pixelmon Entity");
            return;
        }

        EntityType pixelmon = _pixelmon.get();


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
//
//        if (pixelmon.getPokemonData().getOwnerPlayerUUID() == null || pixelmon.getPokemonData().getOwnerPlayerUUID() != player.getUniqueId()) {
//            return;
//        }

        event.setCancelled(true);


    }
}
