package ru.sbt.mipt.oop;

public class HallHandler implements Handler{
    private final SmartHome home;
    private final CommandSender commandSender;

    HallHandler(SmartHome home, CommandSender commandSender) {
        this.home = home;
        this.commandSender = commandSender;
    }

    private void disableLights() {
        for (Room room : home.getRooms()) {
            for (Light light : room.getLights()) {
                light.setOn(false);
                SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                commandSender.sendCommand(command);
            }
        }
    }

    public void handle(SensorEvent event) {
        if (event.getType() == SensorEventType.DOOR_CLOSED) {
            for (Room room : home.getRooms()) {
                for (Door door : room.getDoors()) {
                    if (door.getId().equals(event.getObjectId())) {
                        door.setOpen(false);
                        if (room.getName().equals("hall")) {
                            disableLights();
                        }
                    }
                }
            }
        }
    }
}
