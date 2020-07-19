package learn.kafka.stream.spring.cloud.stream.producer;

import learn.kafka.stream.spring.cloud.stream.messaging.WordCountChannelBindings;
import learn.kafka.stream.spring.cloud.stream.model.PageViewEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class WordsProducer {

    @Autowired
    WordCountChannelBindings wordCountChannelBindings;

    @Scheduled(fixedDelay = 1000)
    public void wordsProducer() {
        /*List<String> wordsList = Stream.of("How are you", "Learning Kafka Streams", "It is great", "repeat words repeat words")
                .collect(Collectors.toList());

        String words = wordsList.get(ThreadLocalRandom.current().nextInt(1, wordsList.size() - 1));*/

        List<String> names = Arrays.asList("mfisher", "dyser", "schacko", "abilan", "ozhurakousky", "grussell");
        List<String> pages = Arrays.asList("blog", "sitemap", "initializr", "news", "colophon", "about");

        String rPage = pages.get(new Random().nextInt(pages.size()));
        String rName = pages.get(new Random().nextInt(names.size()));
        PageViewEvent pageViewEvent = new PageViewEvent(rName, rPage, Math.random() > .5 ? 10 : 1000);

        // Publish the words into the OUTPUT Topic
        this.wordCountChannelBindings._wordsOutput().send(
                MessageBuilder.withPayload(pageViewEvent)
                        .build());

        log.info("Words published - {}", pageViewEvent);
    }

}
