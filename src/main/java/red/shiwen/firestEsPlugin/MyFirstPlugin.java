package red.shiwen.firestEsPlugin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.plugins.Plugin;

public class MyFirstPlugin extends Plugin{  
    private final static Logger LOGGER = LogManager.getLogger(MyFirstPlugin.class);  
    public MyFirstPlugin() {  
        super();  
        LOGGER.warn("This is my fisrt Plugin");  
    }  
}  
