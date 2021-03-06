package dev.rachamon.rachamontexturetokens.commands.elements;

import dev.rachamon.rachamontexturetokens.RachamonTextureTokens;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.ArgumentParseException;
import org.spongepowered.api.command.args.CommandArgs;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.args.CommandElement;
import org.spongepowered.api.text.Text;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The type Get textures key command element.
 */
public class GetTexturesKeyCommandElement extends CommandElement {
    /**
     * Instantiates a new Get textures key command element.
     *
     * @param key the key
     */
    public GetTexturesKeyCommandElement(@Nullable Text key) {
        super(key);
    }

    @Nullable
    @Override
    protected String parseValue(@Nonnull CommandSource source, @Nonnull CommandArgs args) throws ArgumentParseException {

        return args.next();
    }

    @Nonnull
    @Override
    public List<String> complete(@Nonnull CommandSource src, @Nonnull CommandArgs args, @Nonnull CommandContext context) {
        Set<String> keys = RachamonTextureTokens.getInstance().getTextures().getRoot().getTokens().keySet();
        try {
            String next = args.next();
            return keys
                    .stream()
                    .filter(key -> key.toLowerCase().startsWith(next.toLowerCase()))
                    .collect(Collectors.toList());
        } catch (ArgumentParseException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(keys);
    }
}
