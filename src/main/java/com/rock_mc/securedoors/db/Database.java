package com.rock_mc.securedoors.db;

public abstract class Database {

    public abstract void load();

    public abstract void addBanedPlayer(String playerUUID, String reason, long expireTime);

    public abstract String getCodeCreateDate(String code);

    public abstract boolean contains(String code);

    public abstract void markCode(String code, boolean used);

    public abstract void addAllowedPlayer(String playerUUID);

    public abstract void removeAllowedPlayer(String playerUUID);

    public abstract boolean isPlayerAllowed(String playerUUID);

    public abstract void removeCode(String code);

    public abstract int getFailedAttempts(String playerUUID);

    public abstract long getBannedExpireTime(String playerUUID);

    public abstract void removeBanedPlayer(String playerUUID);

    public abstract String getBannedReason(String playerUUID);

    public abstract String getBannedCreateAt(String playerUUID);

    public abstract void save();

    public abstract void close();

    public abstract void addCode(String code);

    public abstract void addPlayerInfo(String playerUUID, String playerName);

    public abstract void updateFailedAttempts(String playerUUID, int failedAttempts);

}
