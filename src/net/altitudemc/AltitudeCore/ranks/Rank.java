package net.altitudemc.AltitudeCore.ranks;

/*******************
 * Created by Anml *
 *******************/

public enum Rank {

    ADMIN(8, "&cAdmin", "Administrator", "&c[ADMIN] %s"),
    MOD(7, "&2Mod", "Moderator", "&2[MOD] %s"),
    HELPER(6, "&9Helper", "&9[HELPER] %s"),

    YOUTUBER(5, "&6Youtuber", "YT", "&6[YT] %s"),

    MVPPLUS(4, "&bMVP&c+", "MVP+", "&b[MVP&c+&b] %s"),
    MVP(3, "&bMVP", "&b[MVP] %s"),
    VIPPLUS(2, "&aVIP&6+", "VIP+", "&a[VIP&6+&a] %s"),
    VIP(1, "&aVIP", "&a[VIP] %s"),

    MEMBER(0, "&7Member", "&7(Member) %s");

    private final int id;
    private final String name;
    private final String alias;
    private final String tag;

    Rank(int id, String name, String tag) {
        this.id = id;
        this.name = name;
        this.alias = this.name();
        this.tag = tag;
    }

    Rank(int id, String name, String alias, String tag) {
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public String getAlias() {
        return alias;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}