/**
 * CitizensCMD - Add-on for Citizens
 * Copyright (C) 2018 Mateus Moreira
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package me.mattmoreira.citizenscmd.Listeners;

import me.mattmoreira.citizenscmd.CitizensCMD;
import me.mattmoreira.citizenscmd.utility.Path;
import me.rayzr522.jsonmessage.JSONMessage;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static me.mattmoreira.citizenscmd.utility.Util.HEADER;
import static me.mattmoreira.citizenscmd.utility.Util.color;

public class UpdateEvent implements Listener {

    @EventHandler (priority = EventPriority.NORMAL)
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (CitizensCMD.getPlugin().getUpdateStatus() && event.getPlayer().hasPermission("citizenscmd.update")) {
            JSONMessage.create(color(HEADER)).send(event.getPlayer());
            JSONMessage.create(color(CitizensCMD.getPlugin().getLang().getUncoloredMessage(Path.NEW_VERSION) + CitizensCMD.getPlugin().getNewVersion())).send(event.getPlayer());
            JSONMessage.create(color(CitizensCMD.getPlugin().getLang().getUncoloredMessage(Path.DOWNLOAD_AT) + " spigotmc.org/resources/citizens-CMD.30224/")).openURL("https://spigotmc.org/resources/citizens-CMD.30224/").send(event.getPlayer());
        }
    }

}
