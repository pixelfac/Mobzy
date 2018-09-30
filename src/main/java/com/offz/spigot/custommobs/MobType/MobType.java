package com.offz.spigot.custommobs.MobType;

import com.offz.spigot.custommobs.Mobs.MobBehaviour;
import org.bukkit.entity.Entity;

import java.util.HashMap;
import java.util.Map;

public interface MobType {
    Map<MobTypeKey, MobType> registeredMobs = new HashMap<>();

    String getName();

    short getModelID();

    MobBehaviour getBehaviour();

    static void registerMobType(MobType type) {
        registeredMobs.put(type.getKey(), type);
    }

    static void unregisterAllMobs() {
        registeredMobs.clear();
    }

    static MobType getRegisteredMobType(Entity e) {
        String name = e.getCustomName();
        if (!e.getScoreboardTags().contains("customMob")) {
            return null;
        }
        return getRegisteredMobType(name);
    }

    static MobType getRegisteredMobType(String name) {
        return getRegisteredMobType(new MobTypeKey(name));
    }

    static MobType getRegisteredMobType(MobTypeKey key) {
        return registeredMobs.get(key);
    }

    default MobTypeKey getKey() {
        return new MobTypeKey(getName());
    }


    class MobTypeKey {
        private String name;
//        private short modelID; //May add this back later, but it's not too good of a way to identify mobs

        public MobTypeKey (String name) {
            this.name = name;
        }

        @Override
        public int hashCode() {
            return name.hashCode() /*^ modelID.hashCode()*/;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof MobTypeKey))
                return false;
            MobTypeKey other = (MobTypeKey) o;
            return /*this.modelID.equals(other.modelID) &&*/ this.name.equals(other.name);
        }
    }
}
