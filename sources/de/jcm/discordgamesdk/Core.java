package de.jcm.discordgamesdk;

import com.google.gson.Gson;
import de.jcm.discordgamesdk.impl.Command;
import de.jcm.discordgamesdk.impl.ConnectionState;
import de.jcm.discordgamesdk.impl.Error;
import de.jcm.discordgamesdk.impl.EventHandler;
import de.jcm.discordgamesdk.impl.Events;
import de.jcm.discordgamesdk.impl.HandshakeMessage;
import de.jcm.discordgamesdk.impl.channel.DiscordChannel;
import de.jcm.discordgamesdk.impl.channel.UnixDiscordChannel;
import de.jcm.discordgamesdk.impl.channel.WindowsDiscordChannel;
import de.jcm.discordgamesdk.impl.commands.Subscribe;
import de.jcm.discordgamesdk.impl.events.OverlayUpdateEvent;
import de.jcm.discordgamesdk.impl.events.VoiceSettingsUpdate2Event;
import de.jcm.discordgamesdk.user.DiscordUser;
import de.jcm.discordgamesdk.user.Relationship;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/Core.class */
public class Core implements AutoCloseable {
    public static final Consumer<Result> DEFAULT_CALLBACK = result -> {
        if (result != Result.OK) {
            throw new GameSDKException(result);
        }
    };
    public static final BiConsumer<LogLevel, String> DEFAULT_LOG_HOOK = (level, message) -> {
        System.out.printf("[%s] %s\n", level, message);
    };
    private DiscordChannel channel;
    private ConnectionState state;
    private final Gson gson;
    private long nonce;
    private final Map<String, Consumer<Command>> handlers;
    private final Events events;
    private final DiscordEventAdapter eventAdapter;
    private boolean suppressExceptions;
    private final CorePrivate corePrivate;
    private final CreateParams createParams;
    private final ActivityManager activityManager;
    private final ApplicationManager applicationManager;
    private final UserManager userManager;
    private final OverlayManager overlayManager;
    private final RelationshipManager relationshipManager;
    private final ImageManager imageManager;
    private final VoiceManager voiceManager;
    private BiConsumer<LogLevel, String> logHook = DEFAULT_LOG_HOOK;
    private LogLevel minLogLevel = LogLevel.VERBOSE;
    private final AtomicBoolean open = new AtomicBoolean(true);

    public static final DiscordChannel getDiscordChannel() throws IOException {
        if (System.getProperty("os.name").toLowerCase(Locale.ROOT).contains("windows")) {
            return new WindowsDiscordChannel();
        }
        return new UnixDiscordChannel();
    }

    public Core(CreateParams params) {
        this.createParams = params;
        this.suppressExceptions = ((this.createParams.flags & 1) == 0 && (this.createParams.flags & 2) == 0) ? false : true;
        this.state = ConnectionState.HANDSHAKE;
        this.gson = new Gson();
        this.nonce = 0L;
        this.handlers = new HashMap();
        this.corePrivate = new CorePrivate();
        this.events = new Events(this.corePrivate);
        this.eventAdapter = this.createParams.eventAdapter;
        try {
            this.channel = getDiscordChannel();
            sendHandshake();
            runCallbacks();
            this.channel.configureBlocking(false);
        } catch (IOException e) {
            if (!this.suppressExceptions) {
                throw new RuntimeException(e);
            }
        }
        this.activityManager = new ActivityManager(this.corePrivate);
        this.applicationManager = new ApplicationManager(this.corePrivate);
        this.overlayManager = new OverlayManager(this.corePrivate);
        this.userManager = new UserManager(this.corePrivate);
        this.relationshipManager = new RelationshipManager(this.corePrivate);
        this.imageManager = new ImageManager(this.corePrivate);
        this.voiceManager = new VoiceManager(this.corePrivate);
        this.suppressExceptions = (this.createParams.flags & 2) != 0;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/Core$CorePrivate.class */
    public class CorePrivate {
        public DiscordUser currentUser;
        private static final DiscordEventAdapter NULL_ADAPTER = new DiscordEventAdapter() { // from class: de.jcm.discordgamesdk.Core.CorePrivate.1
            C13061() {
            }
        };
        public Queue<Runnable> workQueue = new ArrayDeque();
        public int pid = (int) ProcessHandle.current().pid();
        public Map<Long, Relationship> relationships = new HashMap();
        public OverlayUpdateEvent.Data overlayData = new OverlayUpdateEvent.Data();
        public VoiceSettingsUpdate2Event.Data voiceData = new VoiceSettingsUpdate2Event.Data();

        private CorePrivate() {
        }

        /* JADX INFO: renamed from: de.jcm.discordgamesdk.Core$CorePrivate$1 */
        /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/Core$CorePrivate$1.class */
        class C13061 extends DiscordEventAdapter {
            C13061() {
            }
        }

        public DiscordEventAdapter getEventAdapter() {
            return (DiscordEventAdapter) Optional.ofNullable(Core.this.eventAdapter).orElse(NULL_ADAPTER);
        }

        public void ready() {
            Core.this.state = ConnectionState.CONNECTED;
            Core.this.registerEvents();
        }

        public Core getCore() {
            return Core.this;
        }

        public void sendCommand(Command.Type type, Object args, Consumer<Command> responseHandler) {
            Command command = new Command();
            command.setCmd(type);
            command.setArgs(Core.this.gson.toJsonTree(args).getAsJsonObject());
            Core core = Core.this;
            long j = core.nonce + 1;
            core.nonce = j;
            command.setNonce(Long.toString(j));
            Core.this.sendCommand(command, responseHandler);
        }

        public void sendCommandNoResponse(Command.Type type, Object args, Consumer<Command> responseHandler) {
            if (Core.this.channel == null) {
                if (Core.this.suppressExceptions) {
                    return;
                } else {
                    throw new GameSDKException(Result.NOT_RUNNING);
                }
            }
            Command command = new Command();
            command.setCmd(type);
            command.setArgs(Core.this.gson.toJsonTree(args).getAsJsonObject());
            command.setNonce(Long.toString(0L));
            try {
                Core.this.sendString(Core.this.gson.toJson(command));
                Core.this.corePrivate.workQueue.add(() -> {
                    Command c = new Command();
                    c.setEvt(null);
                    c.setNonce(Long.toString(0L));
                    c.setCmd(type);
                    c.setData(null);
                    responseHandler.accept(c);
                });
            } catch (IOException e) {
                if (Core.this.suppressExceptions) {
                } else {
                    throw new RuntimeException(e);
                }
            }
        }

        public Gson getGson() {
            return Core.this.gson;
        }

        public void log(LogLevel level, String message) {
            if (level.compareTo(Core.this.minLogLevel) <= 0) {
                Core.this.logHook.accept(level, message);
            }
        }

        public Result checkError(Command c) {
            if (c.getEvent() == Command.Event.ERROR) {
                Error error = (Error) Core.this.gson.fromJson(c.getData(), Error.class);
                log(LogLevel.ERROR, error.getMessage());
                return Result.fromCode(error.getCode());
            }
            return Result.OK;
        }
    }

    private void sendString(String message) throws IOException {
        byte[] bytes = message.getBytes(StandardCharsets.UTF_8);
        ByteBuffer buf = ByteBuffer.allocate(bytes.length + 8);
        buf.order(ByteOrder.LITTLE_ENDIAN);
        buf.putInt(this.state.ordinal());
        buf.putInt(bytes.length);
        buf.put(bytes);
        this.channel.write(buf.flip());
        this.corePrivate.log(LogLevel.VERBOSE, "Sent string \"" + message + "\" at state " + this.state);
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/Core$Res.class */
    private static class Res {
        public ConnectionState result;
        public String data;

        public Res(ConnectionState result, String data) {
            this.result = result;
            this.data = data;
        }
    }

    private Res receiveString() throws IOException {
        ByteBuffer header = ByteBuffer.allocate(8);
        this.channel.read(header);
        header.flip();
        header.order(ByteOrder.LITTLE_ENDIAN);
        if (header.remaining() == 0) {
            return null;
        }
        int status = header.getInt();
        int length = header.getInt();
        ByteBuffer data = ByteBuffer.allocate(length);
        int read = 0;
        do {
            read += (int) this.channel.read(new ByteBuffer[]{data}, 0, 1);
        } while (read < length);
        String s = new String(data.flip().array());
        ConnectionState state1 = ConnectionState.values()[status];
        this.corePrivate.log(LogLevel.VERBOSE, "Received string \"" + s + "\" at state " + state1);
        return new Res(state1, s);
    }

    private void sendCommand(Command command, Consumer<Command> responseHandler) {
        if (this.channel == null) {
            if (this.suppressExceptions) {
                return;
            } else {
                throw new GameSDKException(Result.NOT_RUNNING);
            }
        }
        try {
            sendString(this.gson.toJson(command));
            this.handlers.put(command.getNonce(), responseHandler);
        } catch (IOException e) {
            if (this.suppressExceptions) {
            } else {
                throw new RuntimeException(e);
            }
        }
    }

    private void sendHandshake() throws IOException {
        HandshakeMessage handshakeMessage = new HandshakeMessage(Long.toString(this.createParams.getClientID()));
        sendString(this.gson.toJson(handshakeMessage));
    }

    private void registerEvents() {
        for (Map.Entry<Command.Event, EventHandler<?>> e : this.events.getEventTypes()) {
            Command.Event event = e.getKey();
            EventHandler<?> handler = e.getValue();
            if (handler.shouldRegister()) {
                Command command = new Command();
                command.setCmd(Command.Type.SUBSCRIBE);
                command.setEvt(event);
                command.setArgs(this.gson.toJsonTree(handler.getRegisterArgs()));
                long j = this.nonce + 1;
                this.nonce = j;
                command.setNonce(Long.toString(j));
                sendCommand(command, o -> {
                    this.corePrivate.log(LogLevel.DEBUG, "Registered event " + ((Subscribe.Response) this.gson.fromJson(o.getData(), Subscribe.Response.class)).getEvent());
                });
            }
        }
    }

    private Command receiveCommand() throws IOException {
        Res r = receiveString();
        if (r == null) {
            return null;
        }
        return (Command) this.gson.fromJson(r.data, Command.class);
    }

    private void handleCommand(Command command) {
        if (command.isError()) {
            this.corePrivate.log(LogLevel.ERROR, command.getCmd().toString() + ": " + this.corePrivate.getGson().fromJson(command.getData(), Error.class));
        }
        if (command.getNonce() != null) {
            this.handlers.remove(command.getNonce()).accept(command);
        } else if (command.getEvent() != null) {
            EventHandler<?> handler = this.events.forEvent(command.getEvent());
            Object data = this.gson.fromJson(command.getData(), handler.getDataClass());
            handler.handleObject(command, data);
        }
    }

    public ActivityManager activityManager() {
        return this.activityManager;
    }

    public ApplicationManager applicationManager() {
        return this.applicationManager;
    }

    public UserManager userManager() {
        return this.userManager;
    }

    public OverlayManager overlayManager() {
        return this.overlayManager;
    }

    public RelationshipManager relationshipManager() {
        return this.relationshipManager;
    }

    public ImageManager imageManager() {
        return this.imageManager;
    }

    public VoiceManager voiceManager() {
        return this.voiceManager;
    }

    public void runCallbacks() {
        while (true) {
            Runnable r = this.corePrivate.workQueue.poll();
            if (r == null) {
                break;
            } else {
                r.run();
            }
        }
        if (this.channel == null) {
            if (this.suppressExceptions) {
                return;
            } else {
                throw new GameSDKException(Result.NOT_RUNNING);
            }
        }
        try {
            Command c = receiveCommand();
            if (c != null) {
                handleCommand(c);
            }
        } catch (IOException e) {
            if (!this.suppressExceptions) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean isDiscordRunning() {
        return this.channel != null && this.channel.isAvailable();
    }

    public void setLogHook(LogLevel minLevel, BiConsumer<LogLevel, String> logHook) {
        this.logHook = logHook;
        this.minLogLevel = minLevel;
    }

    public boolean isOpen() {
        return this.open.get();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        try {
            if (this.channel != null) {
                this.channel.close();
            }
        } catch (IOException e) {
            if (!this.suppressExceptions) {
                throw new RuntimeException(e);
            }
        }
    }
}
