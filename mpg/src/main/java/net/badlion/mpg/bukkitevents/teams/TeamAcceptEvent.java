package net.badlion.mpg.bukkitevents.teams;

import net.badlion.mpg.MPGPlayer;
import net.badlion.mpg.MPGTeam;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class TeamAcceptEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled = false;

    private MPGPlayer mpgPlayer;
    private MPGTeam mpgTeam;

    public TeamAcceptEvent(MPGPlayer mpgPlayer) {
        this.mpgPlayer = mpgPlayer;
        this.mpgTeam = this.mpgPlayer.getInvitedTeam();
    }

    public MPGPlayer getMPGPlayer() {
        return this.mpgPlayer;
    }

    public MPGTeam getMpgTeam() {
        return mpgTeam;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

}
