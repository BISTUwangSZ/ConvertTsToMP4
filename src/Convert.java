import java.util.List;
import java.util.Scanner;

public class Convert {
    public static void main(String[] args) {
        OnlineM3U8 m3u8 = new OnlineM3U8();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入存储文件路径（例如 E:/onlineM3U8）");
        String dir = scanner.nextLine();
        System.out.println("请输入待下载视频的M3U8地址（腾讯视频）");
        String m3u8Path = scanner.nextLine();
        String fileName = m3u8.getFileName(m3u8Path);
        String filePath = m3u8.downloadM3U8FromLine(m3u8Path,dir+"\\m3u8",fileName);
        //读取解析m3u8文件，拼接url
        String tsPrePath  = m3u8.getTsPrePath(m3u8Path);
        List<String> tsUrls = m3u8.getTSUrlList(filePath,tsPrePath);
        //下载TS文件
        String tsPath = dir+"\\ts";
        System.out.println("请输入剧集名称(须以‘.mp4’结尾)");
        String tsFileName = scanner.nextLine();
//        String tsFileName = "陈情令第一集.mp4";
        m3u8.downloadTs(tsUrls,tsPath,tsFileName);


    }
}

