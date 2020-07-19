package learn.kafka.stream.spring.cloud.stream.consumer;

import learn.kafka.stream.spring.cloud.stream.messaging.WordCountChannelBindings;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.KTable;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class WordsCountConsumer {

    @StreamListener
    public void wordsCountConsumer(@Input(WordCountChannelBindings._countInput) KTable<String, Long> wordsCountDetails) {
        log.info("Consumed Result - {}", wordsCountDetails);
    }

}
