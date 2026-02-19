package telegramm.work_today.bot.comfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.meta.generics.TelegramClient;
import telegramm.work_today.bot.MainBot;

@Configuration
public class TelegramConfig {

    @Bean
    public TelegramClient telegramClient(MainBot mainBot){
        return new OkHttpTelegramClient(mainBot.getBotToken());
    }

}
