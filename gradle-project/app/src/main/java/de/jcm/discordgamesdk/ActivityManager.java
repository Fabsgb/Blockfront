package de.jcm.discordgamesdk;

import de.jcm.discordgamesdk.activity.Activity;
import de.jcm.discordgamesdk.activity.ActivityActionType;
import de.jcm.discordgamesdk.activity.ActivityJoinRequestReply;
import de.jcm.discordgamesdk.impl.Command;
import de.jcm.discordgamesdk.impl.commands.ActivityInviteUser;
import de.jcm.discordgamesdk.impl.commands.SendActivityJoinInvite;
import de.jcm.discordgamesdk.impl.commands.SetActivity;
import java.util.function.Consumer;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/ActivityManager.class */
public class ActivityManager {
    private final Core.CorePrivate core;

    ActivityManager(Core.CorePrivate core) {
        this.core = core;
    }

    public Result registerCommand(String command) {
        throw new RuntimeException("not implemented");
    }

    public Result registerSteam(int steamId) {
        throw new RuntimeException("not implemented");
    }

    public void updateActivity(Activity activity) {
        updateActivity(activity, Core.DEFAULT_CALLBACK);
    }

    public void updateActivity(Activity activity, Consumer<Result> callback) {
        this.core.sendCommand(Command.Type.SET_ACTIVITY, new SetActivity.Args(this.core.pid, activity), c -> {
            callback.accept(this.core.checkError(c));
        });
    }

    public void clearActivity() {
        clearActivity(Core.DEFAULT_CALLBACK);
    }

    public void clearActivity(Consumer<Result> callback) {
        updateActivity(null);
    }

    public void sendRequestReply(long userId, ActivityJoinRequestReply reply) {
        sendRequestReply(userId, reply, Core.DEFAULT_CALLBACK);
    }

    public void sendRequestReply(long userId, ActivityJoinRequestReply reply, Consumer<Result> callback) {
        if (reply == ActivityJoinRequestReply.YES) {
            this.core.sendCommand(Command.Type.SEND_ACTIVITY_JOIN_INVITE, new SendActivityJoinInvite.Args(Long.toString(userId)), c -> {
                callback.accept(this.core.checkError(c));
            });
        } else {
            this.core.sendCommand(Command.Type.CLOSE_ACTIVITY_JOIN_REQUEST, new SendActivityJoinInvite.Args(Long.toString(userId)), c2 -> {
                callback.accept(this.core.checkError(c2));
            });
        }
    }

    public void sendInvite(long userId, ActivityActionType type, String content) {
        sendInvite(userId, type, content, Core.DEFAULT_CALLBACK);
    }

    public void sendInvite(long userId, ActivityActionType type, String content, Consumer<Result> callback) {
        this.core.sendCommand(Command.Type.ACTIVITY_INVITE_USER, new ActivityInviteUser.Args(type.nativeValue(), Long.toString(userId), content, this.core.pid), c -> {
            callback.accept(this.core.checkError(c));
        });
    }

    public void acceptRequest(long userId) {
        acceptRequest(userId, Core.DEFAULT_CALLBACK);
    }

    public void acceptRequest(long userId, Consumer<Result> callback) {
        throw new RuntimeException("not implemented");
    }
}
