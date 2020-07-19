package learn.kafka.stream.spring.cloud.stream.processor;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WordCount {
    private String word;
    private long count;
}