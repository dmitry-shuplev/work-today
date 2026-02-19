package telegramm.work_today.bot.commands;

public enum CommandName {
    ABOUT("ABOUT_COMMAND"),
    PUBLISH("PUBLISH_COMMAND");

    private final String name;

    CommandName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
