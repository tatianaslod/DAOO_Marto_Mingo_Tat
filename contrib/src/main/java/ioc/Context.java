package ioc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

public class Context {
    private MsgEncoder encoder;
    private TaskExecutor executor;

    public void init(String configurationPath) {
        final Map<String, String> implementations = new HashMap<>();
        loadConfiguration(configurationPath, implementations);
        try {
            encoder = loadMsgEncoder(implementations.get("encoder"));
            executor = loadTaskExecutor(implementations.get("executor"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setEncoder(MsgEncoder encoder) {
        this.encoder = encoder;
    }

    public void setExecutor(TaskExecutor executor) {
        this.executor = executor;
    }

    private void loadConfiguration(String configurationPath, Map<String, String> implementations) {
        final FileReader fr;
        try {
            fr = new FileReader(configurationPath);
            final BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] conf = line.split(":");
                implementations.put(conf[0], conf[1]);
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private TaskExecutor loadTaskExecutor(String executorName) throws Exception {
//        if (executorName.equals("dummy")) {
//            return MockFactory.getExecutor();
//        }

        final ServiceLoader<TaskExecutor> loader = ServiceLoader.load(TaskExecutor.class);
        for (TaskExecutor taskExecutor : loader) {
            if (taskExecutor.getClass().getName().equals(executorName)) {
                return taskExecutor;
            }
        }
        throw new Exception("No such Executor found");
    }

    private MsgEncoder loadMsgEncoder(String encoderName) throws Exception {
//        if (encoderName.equals("dummy")) {
//            return MockFactory.getMsgEncoder();
//        }

        final ServiceLoader<MsgEncoder> loader = ServiceLoader.load(MsgEncoder.class);
        for (MsgEncoder msgEncoder : loader) {
            if (msgEncoder.getClass().getName().equals(encoderName)) {
                return msgEncoder;
            }
        }

        throw new Exception("No such Encoder found");
    }

    public MsgEncoder getMsgEncoder() throws Exception {
        if(encoder == null) throw new Exception("Not initialized context");
        return encoder;
    }

    public TaskExecutor getTaskExecutor() throws Exception {
        if(executor == null) throw new Exception("Not initialized context");
        return executor;
    }
}
