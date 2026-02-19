package telegramm.work_today.bot.commands;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

@Component
public class PublishCommand implements Command {
    private final TelegramClient telegramClient;

    public PublishCommand(TelegramClient telegramClient) {
        this.telegramClient = telegramClient;
    }

    @Override
    public boolean canHandle(Update update) {
        if(!update.hasMessage()||update.getMessage().hasText()){
            return false;
        }
        return update.getMessage().getText().equals("/publish");
    }

    @Override
    public void handle(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
            String message_text = update.getMessage().getText();
            long ChatId = update.getMessage().getChatId();

            SendMessage message = SendMessage // Create a message object
                    .builder()
                    .chatId(ChatId)
                    .text("Обьяление опубликовано!")
                    .build();
            try {
                telegramClient.execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public String getCommand() {
        return CommandName.PUBLISH.getName();
    }
}
