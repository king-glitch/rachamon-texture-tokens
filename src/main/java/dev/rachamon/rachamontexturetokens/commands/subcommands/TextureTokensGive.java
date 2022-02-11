package dev.rachamon.rachamontexturetokens.commands.subcommands;

import dev.rachamon.api.sponge.implement.command.*;
import dev.rachamon.rachamontexturetokens.RachamonTextureTokens;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.args.CommandElement;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;

import javax.annotation.Nonnull;
import java.util.Optional;

@ICommandDescription("give player tokens")
@ICommandAliases({"give"})
@ICommandPermission("rachamontexturetokens.command.give")
public class TextureTokensGive implements ICommand, IParameterizedCommand {
    @Nonnull
    @Override
    public CommandResult execute(@Nonnull CommandSource source, @Nonnull CommandContext args) throws CommandException {

        Optional<String> _token = args.getOne("token");
        Optional<Player> _player = args.getOne("name");
        Optional<Integer> _amount = args.getOne("amount");

        if (!_token.isPresent()) {
            return CommandResult.empty();
        }

        String token = _token.get();
        Player player = _player.orElseGet(() -> (Player) source);
        int amount = _amount.orElse(1);

        try {
            RachamonTextureTokens.getInstance().getRachamonTextureTokenManager().giveTokens(player, token, amount);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return CommandResult.success();
    }

    @Override
    public CommandElement[] getArguments() {
        return new CommandElement[]{
                GenericArguments.string(Text.of("token")),
                GenericArguments.optional(GenericArguments.player(Text.of("name"))),
                GenericArguments.optional(GenericArguments.integer(Text.of("amount")))
        };
    }
}
