package org.matsim.run;

import org.apache.commons.lang3.event.EventUtils;
import org.matsim.core.events.EventsUtils;

import java.net.SocketOption;
import java.util.Map;

public class StartAnalysis {

    public static void main(String[] args) {
        
        var handler = new LinkCounterHandler ();
        var histogramHandler = new HistogramHandler();
        var manager = EventsUtils.createEventsManager();
        manager.addHandler(handler);
        manager.addHandler(histogramHandler);
        EventsUtils.readEvents(manager, "/Users/lindasteinhauser/Documents/Uni/Master/Semester/Masterarbeit/matsim-serengeti-park-hodenhagen/scenarios/serengeti-park-v1.0/output/output-serengeti-park-v1.0-run1/serengeti-park-v1.0-run1.output_events.xml.gz");

        System.out.println(handler.counter);

        for (var stringIntegerEntry : histogramHandler.histogram.entrySet()) {
            System.out.println(stringIntegerEntry.getKey() + ":" + stringIntegerEntry.getValue());
        }

    }
}
