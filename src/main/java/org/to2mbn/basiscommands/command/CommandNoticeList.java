package org.to2mbn.basiscommands.command;

import cn.nukkit.command.CommandSender;
import org.to2mbn.basiscommands.BasisCommands;
import org.to2mbn.basiscommands.i18n.I18n;
import org.to2mbn.basiscommands.util.PluginUtils;
import org.to2mbn.basiscommands.util.command.CommandArgumentTemplet;
import org.to2mbn.basiscommands.util.command.CommandArguments;

import java.util.Iterator;

public class CommandNoticeList implements Command {
    @Override
    public String getName() {
        return "noticelist";
    }

    @Override
    public boolean canExecute(CommandSender sender) {
        return true;
    }

    @Override
    public CommandArgumentTemplet<?>[] getArgumentTemplets() {
        return new CommandArgumentTemplet<?>[0];
    }

    @Override
    public void execute(CommandSender sender, CommandArguments args) {
        PluginUtils.sendMessage(sender, I18n.translate("command.noticelist.notices"));
        PluginUtils.sendMessage(sender, I18n.translate("command.noticelist.notices_header"));
        Iterator<String> iterator = BasisCommands.getAutoNoticeHandler().getNoticeList().iterator();

        int id = 0;
        while (iterator.hasNext()) {
            PluginUtils.sendMessage(sender, (id++) + "  " + iterator.next());
        }
    }
}
