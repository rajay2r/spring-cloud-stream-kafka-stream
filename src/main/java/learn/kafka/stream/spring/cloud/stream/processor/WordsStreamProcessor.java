package learn.kafka.stream.spring.cloud.stream.processor;

import learn.kafka.stream.spring.cloud.stream.messaging.WordCountChannelBindings;
import learn.kafka.stream.spring.cloud.stream.model.PageViewEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Materialized;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class WordsStreamProcessor {

    @StreamListener
    @SendTo(WordCountChannelBindings._countOutput)
    public KStream<String, Long> process(@Input(WordCountChannelBindings._wordsInput) KStream<String, PageViewEvent> input) {
        log.info("Process data - {}", input);
        return input.filter((key, value) -> value.getDuration() > 10)
                .map((key, value) -> new KeyValue<>(value.getPage(), "0"))
                .groupByKey()
                .count(Materialized.as("wordscount"))
                .toStream();
    }

}