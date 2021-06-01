package com.example.demo.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService ;

    @RequestMapping("/topics")
    public List<Topic> returnTopics() {
        return topicService.getAlltopics();
    }

    @RequestMapping("topics/{id}")
    public Optional<Topic> getTopic(@PathVariable String id) {
        return topicService.getTopic(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public String addTopic(@RequestBody Topic topic) {
        if(topicService.addTopic(topic))
            return "Successfully Added" ;
        return "Failed to add the Topic" ;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public String updateTopic(@RequestBody Topic topic, @PathVariable String id) {
        if(topicService.updateTopic(topic, id)) {
            return "Updated" ;
        }
        return "Error while Updating" ;
    }

    @RequestMapping(method = RequestMethod.DELETE , value = "/topics/{id}")
    public void deleteTopic(@PathVariable String id) {
        topicService.deleteTopic(id)  ;
        return  ;

    }
}
