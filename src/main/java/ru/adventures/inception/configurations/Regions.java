package ru.adventures.inception.configurations;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import ru.adventures.adventures.Adventures;
import ru.adventures.adventures.operations.Logger;

import java.io.File;
import java.io.IOException;

public class Regions {
    static File file;
    static FileConfiguration regions;

    public static void setup() {
        file = new File(Adventures.instance().getDataFolder(), "regions.yml");
        regions = YamlConfiguration.loadConfiguration(file);
        if (!file.exists()) {
            try {
                regions.set("Regions","spawn");
                regions.set("spawn.permission","spawn.region");
                regions.set("spawn.no-permission-message","");
                regions.set("spawn.world","world");
                regions.set("spawn.x-coordinate","0");
                regions.set("spawn.z-coordinate","0");
                regions.set("spawn.protection-radius","100");
                regions.set("spawn.area-restrictions","");
                regions.set("spawn.damage-restrictions","");
                regions.save(file);
            } catch (IOException e) {
                Logger.error(e.getMessage());
            }

        }
    }

    public static FileConfiguration get() {
        return regions;
    }

    public static void save() {
        try {
            regions.save(file);
        } catch (IOException e) {
            Logger.error(e.getMessage());
        }
    }

    public static void reload(){
        regions = YamlConfiguration.loadConfiguration(file);
    }

}
