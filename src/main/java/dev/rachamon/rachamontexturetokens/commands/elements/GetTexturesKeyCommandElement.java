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

public class GetTexturesKeyCommandElement extends CommandElement {
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
        return new ArrayList<>(RachamonTextureTokens.getInstance().getTextures().getRoot().getTokens().keySet());
    }
}
