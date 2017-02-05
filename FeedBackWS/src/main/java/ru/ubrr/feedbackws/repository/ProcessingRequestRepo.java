package ru.ubrr.feedbackws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ubrr.feedbackws.model.ProcessingRequest;

import java.util.List;

/**
 * Created by elgin on 29.01.17.
 */
public interface ProcessingRequestRepo extends JpaRepository<ProcessingRequest, Long> {

    //List<ProcessingRequest> findNewMessage


}
