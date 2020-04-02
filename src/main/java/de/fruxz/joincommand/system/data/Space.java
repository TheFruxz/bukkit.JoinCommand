package de.fruxz.joincommand.system.data;

import de.fruxz.joincommand.system.configuration.Preference;

import java.util.Collections;
import java.util.List;

public class Space {

    public static final String permission_admin = "joincommand.admin";
    public static final String permission_bypass = "joincommand.bypass";

    public static Preference<List<String>> list_joinCommands = new Preference<>("system.joinCommands", Collections.emptyList());
    public static Preference<List<String>> list_firstJoinCommands = new Preference<>("system.fistJoinCommands", Collections.emptyList());

}
