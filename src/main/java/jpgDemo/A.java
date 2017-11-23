package jpgDemo;

import java.nio.file.*;

public class A {
    
    public static void main(String[] args){
        
        try{
            WatchService watchService;
            Path folder = Paths.get("C:/temp/roaming_notification/");
            watchService = FileSystems.getDefault().newWatchService();
            folder.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
            while (true) {
                WatchKey watchKey = watchService.take();
                for (WatchEvent<?> event : watchKey.pollEvents()) {
                    WatchEvent<Path> watchEvent = (WatchEvent<Path>) event;
                    WatchEvent.Kind<?> kind = watchEvent.kind();
                    if (kind == StandardWatchEventKinds.OVERFLOW) {
                        System.out.println("OVERFLOW");
                    } else if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {
                        
                        System.out.println("ENTRY_MODIFY");
                    }
                        
                }
            }
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
