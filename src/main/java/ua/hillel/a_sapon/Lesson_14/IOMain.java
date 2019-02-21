package ua.hillel.a_sapon.Lesson_14;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.commons.io.IOUtils;
import ua.hillel.a_sapon.Lesson_12.model.Course;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.crypto.Data;
import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class IOMain {
    public static void main(String args[]) throws IOException {

        //System.in
        //System.out
        //System.err

        File file = new File( "test.txt");
        System.out.println(file.exists());
        try {
            boolean newFile = file.createNewFile(); //checked exception
            //All methods through checked exception
            System.out.println(newFile);
        }
        catch (IOException ioexception){
            System.out.println("Creation of the file was not accomplished");
            //System.out.println();
            ioexception.printStackTrace();
        };
        System.out.println(file.exists());
        System.out.println(file.getAbsoluteFile());

        File file1 = new File ("C:\\Users\\HYS\\IdeaProjects\\HomeTasks");
        System.out.println(file1.isDirectory());
        System.out.println("\n------------------DIRECTORY via LIST-----------------");
        String[] fileList = file1.list();
        for (String s : fileList){
            System.out.println(s);
        }



        System.out.println("\n------------------DIRECTORY via walkFileTree-----------------");
        Files.walkFileTree(
                Paths.get("C:\\Users\\HYS\\IdeaProjects\\HomeTasks"),
                new SimpleFileVisitor<>(){
                    @Override
                    public FileVisitResult visitFile (Path file, BasicFileAttributes attributes)
                        throws IOException{
                        System.out.println(file);
                        //FileVisitResult
                        return super.visitFile(file,attributes);
                    }
                }
        );

        Path path1 = Paths.get("C:\\Users\\HYS\\IdeaProjects\\HomeTasks");
        System.out.println("\n------------------READ ALL SUBDIRECTORIES-----------------");
        System.out.println("C:\\Users\\HYS\\IdeaProjects\\HomeTasks");
        Iterator<Path> iterator = path1.iterator();
        do {
            Path next = iterator.next();
            System.out.println(next.toString());
        }while(iterator.hasNext());



        WatchService watcher = FileSystems.getDefault().newWatchService();
        Path path2 = Paths.get("C:\\Users\\HYS\\IdeaProjects\\HomeTasks");
        WatchKey register = path2.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);
        /*try{
            WatchKey watchKey = watcher.take();
            System.out.println(watchKey);
            List<WatchEvent<?>> x = watchKey.pollEvents(); //<?> - wild card. Defines that it can be any
            for(WatchEvent<?> watchEvent : x){
                System.out.println(watchEvent);
            }
            System.out.println(x);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        System.out.println("\n------------------BYTE File COPY-----------------");
        byteCopy();

        System.out.println("\n------------------CHAR File COPY-----------------");
        charCopy();

        System.out.println("\n-------------BUFFERED CHAR File COPY-------------");
        byteBufferedCopy();

        System.out.println("\n-----------------Line File COPY------------------");
        lineCopy();

        System.out.println("\n--------------------Scanner----------------------");
        /*Scanner scanner = new Scanner(
                new BufferedInputStream(
                        new FileReader("C:\\Users\\HYS\\IdeaProjects\\HomeTasks\\src\\main\\java\\ua\\hillel\\a_sapon\\Lesson_14\\resources\initial.txt"));
                while (){}

        )*/

        //To convert ByteReader to CharReader and via verse
        /*InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out);
        */

        System.out.println("\n--------------------DATAStream----------------------");
        dataStream();

        System.out.println("\n----------------URL Stream READER-_-----------------");
        url();

        System.out.println("\n--------------------ZIP Stream ---------------------");
        zipStream();

        System.out.println("\n--------------------OBJ Stream ---------------------");
        ObjSerialize();

        System.out.println("\n--------------------ioUtils Stream ---------------------");
        ioUtils();
        System.out.println("\n--------------------JAXB Stream ---------------------");
        try {
            jaxB();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        System.out.println("\n--------------------JACKSON_XML Stream ---------------------");
        jacksonXml();

        System.out.println("\n--------------------JACKSON_JASON Stream ---------------------");
        jacksonJSON();

        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;



    }

    private static void byteCopy() throws IOException{

        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

    try{
        inputStream = new FileInputStream("C:\\Users\\HYS\\IdeaProjects\\HomeTasks\\src\\main\\java\\ua\\hillel\\a_sapon\\Lesson_14\\resources\\Initial.txt");
        outputStream = new FileOutputStream("C:\\Users\\HYS\\IdeaProjects\\HomeTasks\\src\\main\\java\\ua\\hillel\\a_sapon\\Lesson_14\\resources\\Byte_Copy.txt");
        int c;

        while ( ((c = inputStream.read())) != -1 ){
            outputStream.write(c);
            //System.out.print((char)c);
        }
    }
    catch (FileNotFoundException e){ e.printStackTrace();}
    catch (IOException e){e.printStackTrace();}
    finally {
        if (inputStream != null){ inputStream.close();}
        if (inputStream != null){ outputStream.close();}
        System.out.println("FILE Copy is created!");
    }
    }

    private static void byteBufferedCopy() throws IOException{

        BufferedInputStream inputStream = null;
        BufferedOutputStream outputStream = null;

        try{
            inputStream = new BufferedInputStream( new FileInputStream("C:\\Users\\HYS\\IdeaProjects\\HomeTasks\\src\\main\\java\\ua\\hillel\\a_sapon\\Lesson_14\\resources\\Initial.txt"));
            outputStream = new BufferedOutputStream( new FileOutputStream("C:\\Users\\HYS\\IdeaProjects\\HomeTasks\\src\\main\\java\\ua\\hillel\\a_sapon\\Lesson_14\\resources\\Buffered_Byte_Copy.txt"));
            //decorator. -> BufferedInputStream
            //decorator. -> BufferedOutputStream
            // since its decorator file output will be created and stream FileOutputStream will be closed as well
            int c;

            while ( ((c = inputStream.read())) != -1 ){
                outputStream.write(c);
                //System.out.print((char)c);
            }
        }
        catch (FileNotFoundException e){ e.printStackTrace();}
        catch (IOException e){e.printStackTrace();}
        finally {
            if (inputStream != null){ inputStream.close();}
            if (inputStream != null){ outputStream.close();}
            System.out.println("FILE Copy is created!");
        }
    }


    private static void lineCopy() throws IOException{

        BufferedReader inputStream = null;
        BufferedWriter outputStream = null;

        try{
            inputStream = new BufferedReader( new FileReader("C:\\Users\\HYS\\IdeaProjects\\HomeTasks\\src\\main\\java\\ua\\hillel\\a_sapon\\Lesson_14\\resources\\Initial.txt"));
            outputStream = new BufferedWriter( new FileWriter("C:\\Users\\HYS\\IdeaProjects\\HomeTasks\\src\\main\\java\\ua\\hillel\\a_sapon\\Lesson_14\\resources\\Line_Copy.txt"));
            //decorator. -> BufferedInputStream
            //decorator. -> BufferedOutputStream
            // since its decorator file output will be created and stream FileOutputStream will be closed as well
            String c;

            while ( ((c = inputStream.readLine())) != null ){
                outputStream.write(c);
                outputStream.write(System.lineSeparator());
                //System.out.print((char)c);
            }
        }
        catch (FileNotFoundException e){ e.printStackTrace();}
        catch (IOException e){e.printStackTrace();}
        finally {
            if (inputStream != null){ inputStream.close();}
            if (inputStream != null){ outputStream.close();}
            System.out.println("FILE Copy is created!");
        }
    }



    private static void charCopy() throws IOException{

        Reader inputStream = null;
        Writer outputStream = null;

        try{
            inputStream = new FileReader("C:\\Users\\HYS\\IdeaProjects\\HomeTasks\\src\\main\\java\\ua\\hillel\\a_sapon\\Lesson_14\\resources\\Initial.txt");
            outputStream = new FileWriter("C:\\Users\\HYS\\IdeaProjects\\HomeTasks\\src\\main\\java\\ua\\hillel\\a_sapon\\Lesson_14\\resources\\Char_Copy.txt");
            int c;

            while ( ((c = inputStream.read())) != -1 ){
                outputStream.write(c);
                //System.out.print((char)c);
            }
        }
        catch (FileNotFoundException e){ e.printStackTrace();}
        catch (IOException e){e.printStackTrace();}
        finally {
            if (inputStream != null){ inputStream.close();}
            if (inputStream != null){ outputStream.close();}
            System.out.println("FILE Copy is created!");
        }
    }

    private static void dataStream() throws IOException{

        DataOutputStream dataOutputStream = new DataOutputStream(
                new FileOutputStream("C:\\Users\\HYS\\IdeaProjects\\HomeTasks\\src\\main\\java\\ua\\hillel\\a_sapon\\Lesson_14\\resources\\DataStream.dat")
        );

        dataOutputStream.writeInt(123);
        dataOutputStream.writeDouble(123.11);
        dataOutputStream.writeUTF("TEST");
        dataOutputStream.writeBoolean(true);

        dataOutputStream.flush();
        dataOutputStream.close();

        DataInputStream dataInputStream = new DataInputStream(
                new FileInputStream("C:\\Users\\HYS\\IdeaProjects\\HomeTasks\\src\\main\\java\\ua\\hillel\\a_sapon\\Lesson_14\\resources\\DataStream.dat")
        );

        int i = dataInputStream.readInt();
        double d = dataInputStream.readDouble();
        String s = dataInputStream.readUTF();
        boolean b = dataInputStream.readBoolean();


        System.out.println("Int: " + i + "\nDouble: " + d + "\nString: " + s + "\nBoolean " + b);
    }


    private static void url() throws IOException{

        String url = "https://www.youtube.com";

        try(InputStream inURL = new URL(url).openStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inURL);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            BufferedWriter bufferedWriter = new BufferedWriter( new FileWriter("C:\\Users\\HYS\\IdeaProjects\\HomeTasks\\src\\main\\java\\ua\\hillel\\a_sapon\\Lesson_14\\resources\\Youtube.html"))
        ){
            String s;
            List<String> strings = new ArrayList<>();
            while ( (s = bufferedReader.readLine()) != null ){
                strings.add(s);
                bufferedWriter.write(s);
            }
            strings.forEach(System.out::println);

        }
        catch(IOException e){
            throw new IOException("Exception when open your URL" + url);
        }
    }

    private static void zipStream() throws IOException{

        String fileName = "C:\\Users\\HYS\\IdeaProjects\\HomeTasks\\src\\main\\java\\ua\\hillel\\a_sapon\\Lesson_14\\resources\\initial.txt";

        try(ZipOutputStream zout =
                new ZipOutputStream(new FileOutputStream("C:\\Users\\HYS\\IdeaProjects\\HomeTasks\\src\\main\\java\\ua\\hillel\\a_sapon\\Lesson_14\\resources\\ZipInitial.zip"));
            FileInputStream fileInputStream = new FileInputStream(fileName)
        ){
            ZipEntry zipEntry = new ZipEntry("initial.txt");
            zout.putNextEntry(zipEntry);
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            zout.write(buffer);
            zout.closeEntry();
            zout.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    //read

        /*long MILLS_IN_DAY = 24 * 60 * 60 * 1000;
        try(FileInputStream fileInputStream = new FileInputStream(fileName);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            ZipInputStream zipInputStream = new ZipInputStream(bufferedInputStream))
        {
            ZipEntry zipEntry;

            while( (zipEntry = zipInputStream.getNextEntry()) != null )
            {
                System.out.format("File: $s Size: %s Last Modified: %s",
                        zipEntry.getName(), zipEntry.getSize(),
                        LocalDate.ofEpochDay(zipEntry.getTime() /MILLS_IN_DAY ) ) ;
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
*/

    }

    private static void ObjSerialize() throws IOException
    {

        System.out.println("WRITING Object");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream( "C:\\Users\\HYS\\IdeaProjects\\HomeTasks\\src\\main\\java\\ua\\hillel\\a_sapon\\Lesson_14\\resources\\objectSerializable.dat")
        );

        TeslaCar obj = new TeslaCar(1, List.of( new Weel(15), new Weel(15), new Weel(15), new Weel(15), new Weel(18) ));
        System.out.println(obj);
        objectOutputStream.writeObject(obj);

        objectOutputStream.flush();
        objectOutputStream.close();


        System.out.println("READING Object");
        Object object = null;
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("C:\\Users\\HYS\\IdeaProjects\\HomeTasks\\src\\main\\java\\ua\\hillel\\a_sapon\\Lesson_14\\resources\\objectSerializable.dat")
        );
        try {
            object = objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        System.out.println(object);

    }

    private static void ioUtils() throws IOException{
        FileInputStream inputStream = new FileInputStream("C:\\Users\\HYS\\IdeaProjects\\HomeTasks\\src\\main\\java\\ua\\hillel\\a_sapon\\Lesson_14\\resources\\initial.txt");
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\HYS\\IdeaProjects\\HomeTasks\\src\\main\\java\\ua\\hillel\\a_sapon\\Lesson_14\\resources\\ioUtils_Out.txt");
        BufferedInputStream bufferedInputStream = IOUtils.buffer(inputStream);
        BufferedOutputStream bufferedOutputStream = IOUtils.buffer(outputStream);
        IOUtils.copy(inputStream,outputStream);

        String someText = "Something to be added";
        InputStream inputStringStream = IOUtils.toInputStream( someText, Charset.defaultCharset());
        IOUtils.copy(inputStringStream, new FileOutputStream("C:\\Users\\HYS\\IdeaProjects\\HomeTasks\\src\\main\\java\\ua\\hillel\\a_sapon\\Lesson_14\\resources\\ioUtils_Out_2.txt") );

        bufferedOutputStream.flush();
    }

    private static void jaxB() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Car.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        Car newCar = new Car(1);

        marshaller.marshal(newCar, new File("C:\\Users\\HYS\\IdeaProjects\\HomeTasks\\src\\main\\java\\ua\\hillel\\a_sapon\\Lesson_14\\resources\\Marshaller.xml"));

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Object obj = unmarshaller.unmarshal(new File("C:\\Users\\HYS\\IdeaProjects\\HomeTasks\\src\\main\\java\\ua\\hillel\\a_sapon\\Lesson_14\\resources\\Marshaller.xml"));
        System.out.println(obj);
        System.out.println("-----initial object------");
        System.out.println(newCar);
    }

    private static void jacksonXml() throws IOException{

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());
        xmlMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        Car car = new Car(1);

        xmlMapper.writeValue(new File("C:\\Users\\HYS\\IdeaProjects\\HomeTasks\\src\\main\\java\\ua\\hillel\\a_sapon\\Lesson_14\\resources\\XMLJackson.xml"), car);
        Car car1 = xmlMapper.readValue(new File("C:\\Users\\HYS\\IdeaProjects\\HomeTasks\\src\\main\\java\\ua\\hillel\\a_sapon\\Lesson_14\\resources\\XMLJackson.xml"), Car.class);
        System.out.println(car1);

    }

    private static void jacksonJSON() throws IOException{

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        Car car = new Car(1);

        objectMapper.writeValue(new File("C:\\Users\\HYS\\IdeaProjects\\HomeTasks\\src\\main\\java\\ua\\hillel\\a_sapon\\Lesson_14\\resources\\JSONJackson.txt"), car);
        Car car1 = objectMapper.readValue(new File("C:\\Users\\HYS\\IdeaProjects\\HomeTasks\\src\\main\\java\\ua\\hillel\\a_sapon\\Lesson_14\\resources\\JSONJackson.txt"), Car.class);
        System.out.println(car1);

    }

}

@XmlRootElement
 class Car implements Serializable{ // if class is realized inside other method with static it will ba called Inner or Nested class

    int id;
    List<Weel> weels;
    //transient List<Weel> weels; - does mean that field wont be serialized
    //static context do not serialize


     public Car() {
         this.id = 0;
         this.weels =  new ArrayList<>(List.of( new Weel(1), new Weel(1)));
     }

    public Car(int id) {
         this();
        this.id = id;
    }


    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", weels=" + weels +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWeels(List<Weel> weels) {
        this.weels = weels;
    }

    public Car(int id, List<Weel> weels) {
         this.id = id;
         this.weels = weels;
     }

    public int getId() {
        return id;
    }

    public List<Weel> getWeels() {
        return weels;
    }
}

class Weel implements Serializable, Externalizable
{

    double radius;
    double width;
    String vendor;

    public Weel() {
        this.radius = 15;
        this.width = 20;
        this.vendor = "BLIZZLIKE";
    }

    public Weel(double radius) {
        this.radius = radius;
        this.width = 20;
        this.vendor = "BLIZZLIKE";
    }

    public double getRadius() {
        return radius;
    }

    public double getWidth() {
        return width;
    }

    public String getVendor() {
        return vendor;
    }

    @Override
    public String toString() {
        return "Weel{" +
                "radius=" + radius +
                '}';
    }
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeDouble(this.radius);
        out.writeDouble(this.width);
        out.writeUTF(this.vendor);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        double integer = in.readDouble();
        double integer1 = in.readDouble();
        String string = in.readUTF();
        radius = integer;
        width = integer1;
        vendor = string;
        System.out.println("readExternal RADIUS: " + radius + " WIDTH: " + width + " VENDOR:" + vendor );
    }

    public void writeObject(ObjectOutput out) throws IOException {
        out.writeDouble(this.radius);
        out.writeDouble(this.width);
        out.writeUTF(this.vendor);
    }

    public void readObject(ObjectInput in) throws IOException, ClassNotFoundException {
        double integer = in.readDouble();
        double integer1 = in.readDouble();
        String string = in.readUTF();
        radius = integer;
        width = integer1;
        vendor = string;
        System.out.println("readExternal RADIUS: " + radius + " WIDTH: " + width + " VENDOR:" + vendor );
    }


}

class TeslaCar extends Car implements Serializable, Cloneable {

    public TeslaCar(int i, List<Weel> weels) {
        new Car(i,weels);
    }
    // if Car wont be implementing Serializable then TeslaCar will miss all description

    @Override
    public String toString() {
        return "TeslaCar{" +
                "id=" + id +
                ", weels=" + weels +
                '}';
    }

    //shellow COPY
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

