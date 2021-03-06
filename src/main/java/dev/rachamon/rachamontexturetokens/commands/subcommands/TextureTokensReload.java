package dev.rachamon.rachamontexturetokens.commands.subcommands;

import dev.rachamon.api.sponge.implement.command.*;
import dev.rachamon.api.sponge.util.TextUtil;
import dev.rachamon.rachamontexturetokens.RachamonTextureTokens;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.args.CommandElement;

import javax.annotation.Nonnull;

/**
 * The type Texture tokens reload.
 */
@ICommandDescription("reload the plugin")
@ICommandAliases({"reload"})
@ICommandPermission("rachamontexturetokens.command.reload")
public class TextureTokensReload implements ICommand, IParameterizedCommand {
    @Nonnull
    @Override
    public CommandResult execute(@Nonnull CommandSource source, @Nonnull CommandContext args) throws CommandException {

        try {
            RachamonTextureTokens.getInstance().getPluginManager().reload();

            RachamonTextureTokens
                    .getInstance()
                    .sendMessage(source, RachamonTextureTokens
                            .getInstance()
                            .getLanguage()
                            .getCommandCategory()
                            .getSuccessfullyReloadedConfig());
            return CommandResult.success();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CommandResult.empty();
    }

    @Override
    public CommandElement[] getArguments() {
        return new CommandElement[]{};
    }
}
