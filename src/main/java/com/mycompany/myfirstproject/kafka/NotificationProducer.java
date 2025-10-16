package com.mycompany.myfirstproject.kafka;

import com.mycompany.myfirstproject.dto.MovieRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import static org.springframework.kafka.support.KafkaHeaders.TOPIC;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationProducer {

    private final KafkaTemplate<String, MovieRequestDto> kafkaTemplate;


    public void sendMovie(MovieRequestDto requestDto){
        log.info("Sending movie to the database using kafka");
        Message<MovieRequestDto> message = MessageBuilder
                .withPayload(requestDto)
                .setHeader(TOPIC, "movie-topic")
                .build();
        kafkaTemplate.send(message);
        log.info("Successfully sent to kafka");
    }
}
