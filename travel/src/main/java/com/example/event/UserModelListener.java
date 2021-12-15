package com.example.event;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.example.model.User;
import com.example.service.SequenceGeneratorService;


@Component
public class UserModelListener extends AbstractMongoEventListener<User> {

    private SequenceGeneratorService sequenceGenerator;

    @Autowired
    public UserModelListener(SequenceGeneratorService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    public void onBeforeConvert(BeforeConvertEvent<User> event) {
    	if(null != event.getSource().getUserId()) {
    		    
        if ((null !=event.getSource().getUserId()) || (event.getSource().getUserId() < 1)) {
        	System.out.println(sequenceGenerator.generateSequence(User.SEQUENCE_NAME));
            event.getSource().setUserId(sequenceGenerator.generateSequence(User.SEQUENCE_NAME));
        }
    	}
    }


}