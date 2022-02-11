package dev.rachamon.rachamontexturetokens.commands.subcommands;

import dev.rachamon.api.sponge.implement.command.*;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.args.CommandElement;

import javax.annotation.Nonnull;

@ICommandDescription("reload the plugin")
@ICommandAliases({"reload"})
@ICommandPermission("rachamontexturetokens.command.reload")
public class TextureTokensReload implements ICommand, IParameterizedCommand {
    @Nonnull
    @Override
    public CommandResult execute(@Nonnull CommandSource source, @Nonnull CommandContext args) throws CommandException {
        return CommandResult.success();
    }

    @Override
    public CommandElement[] getArguments() {
        return new CommandElement[]{};
    }
}
