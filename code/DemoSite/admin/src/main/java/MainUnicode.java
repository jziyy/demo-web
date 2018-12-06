import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;

public class MainUnicode {

  public static void main(String[] args){
    java.util.Properties properties = new java.util.Properties();
    java.util.Properties outProperties = new java.util.Properties();
    try {

      properties.load(new InputStreamReader(new BufferedInputStream(new FileInputStream("D:\\codes\\IdeaProjects\\DemoSite\\admin\\src\\main\\resources\\messages.properties")),"utf-8"));
      Set<Object> keySet = properties.keySet();
      for(Object keyo : keySet){
        String value = properties.getProperty(keyo.toString());
        String cnValue = unicode(value);
        outProperties.setProperty(keyo.toString(), value);
        System.out.println(keyo.toString() + ":" + value+":"+cnValue);
      }
      outProperties.store(new OutputStreamWriter(new FileOutputStream("d://aa.properties",false), "utf-8"),"中文转unicode");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static String unicode(String source){
    StringBuffer sb = new StringBuffer();
    char [] source_char = source.toCharArray();
    String unicode = null;
    for (int i=0;i<source_char.length;i++) {
      unicode = Integer.toHexString(source_char[i]);
      if (unicode.length() <= 2) {
        unicode = "00" + unicode;
      }
      sb.append("\\u" + unicode);
    }

    return sb.toString();
  }
}
