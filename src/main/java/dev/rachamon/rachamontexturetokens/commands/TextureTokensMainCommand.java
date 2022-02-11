package dev.rachamon.rachamontexturetokens.commands;


import dev.rachamon.api.sponge.implement.command.*;
import dev.rachamon.rachamontexturetokens.commands.subcommands.TextureTokensGive;
import dev.rachamon.rachamontexturetokens.commands.subcommands.TextureTokensReload;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;

import javax.annotation.Nonnull;

/**
 * The type Texture tokens main command.
 */
@ICommandChildren({
        TextureTokensGive.class,
        TextureTokensReload.class
})
@ICommandAliases({"texturetokens", "texturetoken", "texture"})
@ICommandHelpText(title = "Main Texture Tokens Help", command = "help")
@ICommandPermission("rachamontexturetokens.command.base")
public class TextureTokensMainCommand implements ICommand {
    @Nonnull
    @Override
    public CommandResult execute(@Nonnull CommandSource source, @Nonnull CommandContext args) throws CommandException {
        return CommandResult.success();
    }
}
