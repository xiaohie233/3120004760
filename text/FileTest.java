package text;

import com.util.CheckPaper;
import com.util.FilesUtil;
import org.junit.Test;

import java.io.UnsupportedEncodingException;


public class FileTest {
    /**
     * 测试读取文件方法
     */
    @Test
    public void testFileReader() {
        String ans = FilesUtil.readTxt("D:\\text\\or.txt");
        System.out.println(ans);
    }
    /**
     * 测试写入文件方法
     */
    @Test
    public void testFileWriter(){
        double content = 0.89;
        FilesUtil.writeTxt("D:\\text\\ans.txt", Double.toString(content));
    }

    /**
     * 测试句子相似度算法
     */
    @Test
    public void testGetSimilarity(){
        String sentence1 = "今天也许大概是星期天，天气晴，今天晚上我要去看电影。";
        String sentence2 = "今天不是周天，天气晴朗，我晚上要去看电影。";
        double ans = CheckPaper.getSimilarity(sentence1,sentence2);
        System.out.println(ans);
    }
    /**
     * 获取文件路径测试
     */
    @Test
    public void testPath() throws UnsupportedEncodingException {
        //String path = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
        String path = this.getClass().getProtectionDomain().getCodeSource().getLocation().getFile();
        path = java.net.URLDecoder.decode(path, "UTF-8");
        System.out.println(path);

    }

}
