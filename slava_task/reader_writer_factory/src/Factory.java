

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public final class Factory {

    private ReaderWriter readerWriter = new ReaderWriter();
    private static Factory factory = null;
    private static int count = 0;

    private Factory() {
        count++;
        if (count == 2) throw new LimitObjectsException("the limit of objects of this type has been exceeded");
    }

    public static Factory getFactory()  {
        if (factory == null){
            factory = new Factory();
        }
        return factory;
    }

    public void writerPerson(List<String> recordingList, File file){
        readerWriter.writerPerson(recordingList, file);
    }
    public void readerPerson(List<Person> listPerson, File file)  {
        readerWriter.readerPerson(listPerson, file);
    }
}

