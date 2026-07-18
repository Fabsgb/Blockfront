package de.jcm.discordgamesdk.activity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/activity/Activity.class */
public class Activity implements AutoCloseable {
    private Long applicationId;
    private String name;
    private int type;
    private String state;
    private String details;
    private boolean instance;
    private List<ActivityButton> buttons;
    private ActivitySecrets secrets;
    private final ActivityTimestamps timestamps = new ActivityTimestamps();
    private final ActivityAssets assets = new ActivityAssets();
    private final ActivityParty party = new ActivityParty();
    private final transient ActivitySecrets secretsBak = new ActivitySecrets();
    private final transient List<ActivityButton> buttonsBak = new ArrayList();

    public Activity() {
        setActivityButtonsMode(ActivityButtonsMode.SECRETS);
    }

    public long getApplicationId() {
        return this.applicationId.longValue();
    }

    public String getName() {
        return this.name;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDetails() {
        return this.details;
    }

    public void setType(ActivityType type) {
        this.type = type.ordinal();
    }

    public ActivityType getType() {
        return ActivityType.values()[this.type];
    }

    public ActivityTimestamps timestamps() {
        return this.timestamps;
    }

    public ActivityAssets assets() {
        return this.assets;
    }

    public ActivityParty party() {
        return this.party;
    }

    public ActivitySecrets secrets() {
        return this.secrets;
    }

    public void setInstance(boolean instance) {
        this.instance = instance;
    }

    public boolean getInstance() {
        return this.instance;
    }

    @Override // java.lang.AutoCloseable
    @Deprecated
    public void close() {
    }

    public List<ActivityButton> getButtons() {
        return Collections.unmodifiableList(this.buttonsBak);
    }

    public void addButton(ActivityButton button) {
        if (this.buttonsBak.size() == 2) {
            throw new IllegalStateException("Buttons can't be more than 2");
        }
        this.buttonsBak.add(button);
    }

    public boolean removeButton(ActivityButton button) {
        return this.buttons.remove(button);
    }

    public void setActivityButtonsMode(ActivityButtonsMode mode) {
        switch (mode) {
            case BUTTONS:
                this.buttons = this.buttonsBak;
                this.secrets = null;
                break;
            case SECRETS:
                this.secrets = this.secretsBak;
                this.buttons = null;
                break;
        }
    }

    public ActivityButtonsMode getActivityButtonsMode() {
        if (this.secrets != null) {
            return ActivityButtonsMode.SECRETS;
        }
        if (this.buttons != null) {
            return ActivityButtonsMode.BUTTONS;
        }
        return null;
    }

    public String toString() {
        return "Activity{applicationId=" + this.applicationId + ", name='" + this.name + "', type=" + this.type + ", state='" + this.state + "', details='" + this.details + "', instance=" + this.instance + ", buttons=" + this.buttons + ", timestamps=" + this.timestamps + ", assets=" + this.assets + ", party=" + this.party + ", secrets=" + this.secrets + "}";
    }
}
