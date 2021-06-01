package com.example.demo.topic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository ;
    private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("1","Fin-Tech","Finance Tech Related"),
            new Topic("2","Supply","Takes Care Of all Supply"),
            new Topic("3", "Ordering", "Takes Care of all Orders")) );

    public List<Topic> getAlltopics()
    {
        //return topics ;
        List<Topic> topics = new ArrayList<>() ;
        topicRepository.findAll().forEach(topics::add);
        return topics ;
    }

    public Optional<Topic> getTopic(String id) {
        return topicRepository.findById(id) ;
    }

    public Boolean addTopic(Topic topic) {
        topicRepository.save(topic) ;
        return true ;
    }

    public boolean updateTopic(Topic topic, String id) {
        topicRepository.save(topic) ;
        return true ;
    }
    public void deleteTopic(String id) {
       topicRepository.deleteById(id);
    }

}
