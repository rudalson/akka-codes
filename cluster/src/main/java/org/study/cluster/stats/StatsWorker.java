package org.study.cluster.stats;

import akka.actor.AbstractActor;

import java.util.HashMap;
import java.util.Map;

public class StatsWorker extends AbstractActor {

    Map<String, Integer> cache = new HashMap<>();

    @Override
    public AbstractActor.Receive createReceive() {
        return receiveBuilder()
                .match(String.class, word -> {
                    Integer length = cache.get(word);
                    if (length == null) {
                        length = word.length();
                        cache.put(word, length);
                    }
                    sender().tell(length, self());
                })
                .build();
    }
}
