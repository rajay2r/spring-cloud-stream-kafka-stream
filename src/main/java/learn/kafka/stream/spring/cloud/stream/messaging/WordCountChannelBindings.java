package learn.kafka.stream.spring.cloud.stream.messaging;

import learn.kafka.stream.spring.cloud.stream.model.PageViewEvent;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface WordCountChannelBindings {

    // Channel to PUBLISH and FETCH 'words'
    String _wordsOutput = "words_output_channel";
    String _wordsInput = "words_input_channel";

    // Channel to PUBLISH and FETCH 'words-count' details
    String _countOutput = "counts_output_channel";
    String _countInput = "counts_input_channel";

    // Source
    @Output(_wordsOutput)
    MessageChannel _wordsOutput();

    // Sink
    @Input(_wordsInput)
    KStream<String, PageViewEvent> _wordsInput();

    // Source
    @Output(_countOutput)
    KStream<String, Long> _countOutput();

    // Sink
    @Input(_countInput)
    KTable<String, Long> _countInput();
}
