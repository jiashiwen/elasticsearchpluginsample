package red.shiwen.firestEsPlugin;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.common.Nullable;
import org.elasticsearch.plugins.Plugin;
import org.elasticsearch.plugins.ScriptPlugin;
import org.elasticsearch.script.AbstractDoubleSearchScript;
import org.elasticsearch.script.ExecutableScript;
import org.elasticsearch.script.NativeScriptFactory;

public class MyNativeScriptPlugin extends Plugin implements ScriptPlugin {
    private final static Logger LOGGER = LogManager.getLogger(MyFirstPlugin.class);

    public MyNativeScriptPlugin() {
        super();
        LOGGER.warn("This is MyNativeScriptPlugin");
    }
    
    @Override
    public List<NativeScriptFactory> getNativeScripts() {
        return Collections.singletonList(new MyNativeScriptFactory());
    }

    public static class MyNativeScriptFactory implements NativeScriptFactory {
        @Override
        public ExecutableScript newScript(@Nullable Map<String, Object> params) {

//            return new MyNativeScript();
            return new AbstractDoubleSearchScript(){

                @Override
                public double runAsDouble() {
                    int b=0;
                    if(params.get("add")!=null){
                        b= (int) params.get("add");
                    }

                    String s =  source().get("last").toString();
                    double a = s.length()+b;
                    return a;                }
            };
        }

        @Override
        public boolean needsScores() {
            return false;
        }

        @Override
        public String getName() {
            return "my_script";
        }
    }

//    public static class MyNativeScript extends AbstractDoubleSearchScript {
//        @Override
//        public double runAsDouble() {
//
//            String s =  source().get("last").toString();
//            double a = s.length();
//            return a;
//        }
//    }

}
