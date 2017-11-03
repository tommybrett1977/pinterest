package de.tb.showroom.pinterest.repositories;

import de.tb.showroom.pinterest.model.Pinboard;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class TestdataProvider implements ApplicationListener<ContextRefreshedEvent> {

    private Logger logger = Logger.getLogger(TestdataProvider.class.getName());

    private PinboardRepository pinboardRepository;

    public TestdataProvider(PinboardRepository pinboardRepository) {
        if (pinboardRepository == null) {
            throw new IllegalArgumentException("PinboardRepository cannot be null");
        }
        this.pinboardRepository = pinboardRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        logger.info("setup testdata...");
        Pinboard pinboard = new Pinboard("Delicious vegetables for any occasion!");
        pinboard.addPin("https://i.imgur.com/rKHj4bl.jpg", "Lovely Keisha...");
        pinboard.addPin("https://i.pinimg.com/originals/e1/cc/96/e1cc969111be56bab422369a0b8210c3.jpg");
        pinboard.addPin("http://i.imgur.com/w2Blryu.jpg", "Say hello to those boobies");
        pinboard.addPin("http://pre14.deviantart.net/d711/th/pre/f/2015/140/9/d/cosplay07896_keisha_grey_by_cruelroin-d8u1u25.jpg", "All good things are three!");
        pinboardRepository.save(pinboard);
    }
}
