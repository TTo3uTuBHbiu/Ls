
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class Tests {
    File file = new File("C:\\Users\\z\\IdeaProjects\\Is\\input.txt");

    @Test
    public void encode() throws IOException {
        assertEquals("File1  \tфайл\tПрава доступа - 111\tДата последнего изменения - Tue Jun 20 18:50:47 GMT+03:00 2017\tРазмер файла - 85 бит\n" +
                        "File2  \tфайл\tПрава доступа - 111\tДата последнего изменения - Tue Jun 20 17:44:15 GMT+03:00 2017\tРазмер файла - 170 бит\n" +
                        "File3  \tфайл\tПрава доступа - 111\tДата последнего изменения - Thu Jun 22 16:35:04 GMT+03:00 2017\tРазмер файла - 113610 бит\n" +
                        "Files\tкаталог\tПрава доступа - 111\tДата последнего изменения - Thu Jun 22 17:10:59 GMT+03:00 2017\tРазмер файла - 0 бит\n",
                Is.longOutput(file));

        assertEquals("File1  \tфайл\tПрава доступа:Доступен для выполнения,чтения,изменения\tДата последнего изменения - Tue Jun 20 18:50:47 GMT+03:00 2017\tРазмер файла - 10 байт\n" +
                        "File2  \tфайл\tПрава доступа:Доступен для выполнения,чтения,изменения\tДата последнего изменения - Tue Jun 20 17:44:15 GMT+03:00 2017\tРазмер файла - 21 байт\n" +
                        "File3  \tфайл\tПрава доступа:Доступен для выполнения,чтения,изменения\tДата последнего изменения - Thu Jun 22 16:35:04 GMT+03:00 2017\tРазмер файла - 13 килобайт\n" +
                        "Files\tкаталог\tПрава доступа:Доступен для выполнения,чтения,изменения\tДата последнего изменения - Thu Jun 22 17:10:59 GMT+03:00 2017\tФайл пуст \n",
                Is.humanOutput(file));
        assertEquals("Files\tкаталог\tПрава доступа:Доступен для выполнения,чтения,изменения\tДата последнего изменения - Thu Jun 22 17:10:59 GMT+03:00 2017\tФайл пуст \n" +
                        "File3  \tфайл\tПрава доступа:Доступен для выполнения,чтения,изменения\tДата последнего изменения - Thu Jun 22 16:35:04 GMT+03:00 2017\tРазмер файла - 13 килобайт\n" +
                        "File2  \tфайл\tПрава доступа:Доступен для выполнения,чтения,изменения\tДата последнего изменения - Tue Jun 20 17:44:15 GMT+03:00 2017\tРазмер файла - 21 байт\n" +
                        "File1  \tфайл\tПрава доступа:Доступен для выполнения,чтения,изменения\tДата последнего изменения - Tue Jun 20 18:50:47 GMT+03:00 2017\tРазмер файла - 10 байт\n",
                Is.reverse(file));

    }

}
