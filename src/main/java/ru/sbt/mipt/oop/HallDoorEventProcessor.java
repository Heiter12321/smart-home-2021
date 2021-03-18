package ru.sbt.mipt.oop;


public class HallDoorEventProcessor implements EventProcess {
    private final SmartHome smartHome;

    public HallDoorEventProcessor(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    public void setLightOffAroundHome() {
        for (Room homeRoom : smartHome.getRooms()) {
            for (Light light : homeRoom.getLights()) {
                light.setOn(false);
                SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                CommandSender sender = new CommandSenderImpl();
                sender.sendCommand(command);
            }
        }
    }

    @Override
    public void processingEvent() {
        setLightOffAroundHome();
    }
}
